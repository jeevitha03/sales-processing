package com.message.sales.salesprocessing;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.message.sales.salesprocessing.exceptions.SalesProcessingException;
import com.message.sales.salesprocessing.model.Product;
import com.message.sales.salesprocessing.model.SaleMessage;
import com.message.sales.salesprocessing.sales.AdjustmentType;
import com.message.sales.salesprocessing.sales.MultipleSale;
import com.message.sales.salesprocessing.sales.SaleWithAdjustment;
import com.message.sales.salesprocessing.sales.SingleSale;

/**
 * This is the processor class which handles reading sample message, processing that read message,
 * update as per adjustment, print saled units  
 * @author Jeevitha Govindasamy
 * @version 1.0.0
 */
public class SalesProcessor {

	private String filePath;
	private final Set<Product> allSaleMessages;
	private final static int MAX_MESSAGE_PROCESSING_CAPACITY = 50;
	private final static int SALES_REPORT_LOGGING_MODCOUNT = 10;
	private final static String SAMPLEDATA_FILENAME = "testdata.json";
	private int processedMsg = 0;

	final Logger LOG = LoggerFactory.getLogger(SalesProcessor.class);

	/*
	 * default constructor
	 */
	public SalesProcessor() {
		this.allSaleMessages = new HashSet<>();
	}

	/**
	 * Fetch JSON data from sample test file and returns the list of existing sales messages
	 *
	 * @return List of sales messages
	 */
	public List<SingleSale> readSalesMessages()
	{
		LOG.info("Reading sales messages");
		final ObjectMapper mapper = new ObjectMapper();
		try
		{
			final File file = new ClassPathResource(SAMPLEDATA_FILENAME).getFile();
			final List<SingleSale> saleMsgs = mapper.readValue(file, new TypeReference<List<SingleSale>>()
			{});
			return saleMsgs;
		} catch (final IOException e) {
			LOG.error("Unable to process the data file. {}", e.getMessage());
		}
		return Collections.emptyList();
	}


	/**
	 * Process the list of sales messages received
	 *
	 * @param salesMsgs
	 * @throws SalesProcessingException
	 */
	public void processSalesMessages(final List<SingleSale> salesMsgs) throws SalesProcessingException
	{
		salesMsgs.forEach(salesMsg ->
		{
			processMessage(salesMsg);
			processedMsg++;

			LOG.info("Processing message number {}", processedMsg);

			if (processedMsg % SALES_REPORT_LOGGING_MODCOUNT == 0)
			{
				printReport();
			}

			if (processedMsg == MAX_MESSAGE_PROCESSING_CAPACITY)
			{
				updateAdjustment();
				LOG.info("Product adjustment has been completed. {}", processedMsg);
				throw new SalesProcessingException();
			}

		});
	}


	/**
	 * @param msg
	 */
	public void processMessage(final SingleSale msg) {

		final Product product = new Product(msg.getProductType(), msg.getProductPrice());
		final Product processedProduct = allSaleMessages.stream()
				.filter(saleMsg -> saleMsg.equals(product))
				.findAny().orElse(product);
		final List<SaleMessage> salesList = processedProduct.getSales();

		if(!allSaleMessages.contains(processedProduct)) {
			allSaleMessages.add(processedProduct);
		}
		if(msg instanceof SaleWithAdjustment) {
			final SaleWithAdjustment ms = (SaleWithAdjustment) msg;
			processedProduct.getAdj().add(ms);
		}	 else if(msg instanceof MultipleSale) {
			final MultipleSale ms = (MultipleSale) msg;
			processedProduct.setUnitsSaled(processedProduct.getUnitsSaled() + ms.getProductQuantity());
			final SaleMessage slmsg = new SaleMessage(ms.getProductQuantity(),processedProduct.getProductPrice());
			salesList.add(slmsg);
		} else if(msg instanceof SingleSale) {
			processedProduct.setUnitsSaled(processedProduct.getUnitsSaled()+1);
			final SaleMessage slmsg = new SaleMessage(Double.valueOf(1),processedProduct.getProductPrice());
			salesList.add(slmsg);
		}
	}

	/**
	 * Print the product type and total units saled
	 */
	public void printReport() {

		allSaleMessages.forEach(salesMsg ->
		{
			LOG.info("Product Type {} of {}  has saled for units {}", salesMsg.getProductType(), salesMsg.getProductPrice(), salesMsg.getUnitsSaled());
		});
	}

	/**
	 * FIXME
	 */
	public void updateAdjustment() {
		for(final Product pro :allSaleMessages) {
			final List<SaleWithAdjustment> adjustments = pro.getAdj();
			for(final SaleWithAdjustment adjustment: adjustments) {
				final AdjustmentType type = adjustment.getAdjustmentType();
				final List<SaleMessage> allsales = pro.getSales();
				switch (type)
				{
					case ADD:
						for(final SaleMessage sale :allsales) {
							sale.setPrice(sale.getPrice()+adjustment.getProductPrice());
						}
						break;
					case MULTIPLY:
						for(final SaleMessage sale :allsales) {
							sale.setPrice(sale.getPrice()*adjustment.getProductPrice());
						}
						break;
					case SUBTRACT:
						for(final SaleMessage sale :allsales) {
							if(sale.getPrice()>adjustment.getProductPrice()) {
								sale.setPrice(sale.getPrice()-adjustment.getProductPrice());
							}
						}
						break;
					default:
						LOG.info("Invalid Adjustment type record");
						break;
				}
			}			
			LOG.info("{} adjustment processed for {}",pro.getAdj().size(),pro);
			pro.getProcessedAdj().addAll(adjustments);
			pro.getAdj().clear();			
		}
	}

	/**
	 * @return filePath
	 */
	public String getFilePath()
	{
		return filePath;
	}

	/**
	 * @param filePath
	 */
	public void setFilePath(final String filePath)
	{
		this.filePath = filePath;
	}

	/**
	 * @return processedMsg
	 */
	public int getProcessedMsg()
	{
		return processedMsg;
	}

	/**
	 * @param processedMsg
	 */
	public void setProcessedMsg(final int processedMsg)
	{
		this.processedMsg = processedMsg;
	}
}
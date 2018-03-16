package com.message.sales.salesprocessing;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.message.sales.salesprocessing.exceptions.SalesProcessingException;
import com.message.sales.salesprocessing.sales.AdjustmentType;
import com.message.sales.salesprocessing.sales.MultipleSale;
import com.message.sales.salesprocessing.sales.SaleWithAdjustment;
import com.message.sales.salesprocessing.sales.SingleSale;


/**
 * Unit test for {@link SalesProcessor}
 */

@RunWith(MockitoJUnitRunner.class)
@SuppressWarnings(
{ "javadoc" })
public class SalesProcessorTest
{
	@InjectMocks
	private final SalesProcessor sut = new SalesProcessor();

	private List<SingleSale> salesMsgsFull;
	private List<SingleSale> salesMsgs;


	@SuppressWarnings("serial")
	@Before
	public void setUp()
	{
		salesMsgsFull = Arrays.asList(
				new SingleSale("Mango", Double.valueOf(10.50)), new MultipleSale("Mango", Double.valueOf(10.50), Double.valueOf(10)),
				new SingleSale("Mango", Double.valueOf(10.50)), new MultipleSale("Mango", Double.valueOf(10.50), Double.valueOf(10)),
				new SingleSale("Mango", Double.valueOf(10.50)), new MultipleSale("Mango", Double.valueOf(10.50), Double.valueOf(10)),
				new SingleSale("Mango", Double.valueOf(10.50)), new MultipleSale("Mango", Double.valueOf(10.50), Double.valueOf(10)),
				new SingleSale("Mango", Double.valueOf(10.50)), new MultipleSale("Mango", Double.valueOf(10.50), Double.valueOf(10)),
				new SingleSale("Mango", Double.valueOf(10.50)), new MultipleSale("Mango", Double.valueOf(10.50), Double.valueOf(10)),
				new SingleSale("Mango", Double.valueOf(10.50)), new MultipleSale("Mango", Double.valueOf(10.50), Double.valueOf(10)),
				new SingleSale("Mango", Double.valueOf(10.50)), new MultipleSale("Mango", Double.valueOf(10.50), Double.valueOf(10)),
				new SingleSale("Mango", Double.valueOf(10.50)), new MultipleSale("Mango", Double.valueOf(10.50), Double.valueOf(10)),
				new SingleSale("Mango", Double.valueOf(10.50)), new MultipleSale("Mango", Double.valueOf(10.50), Double.valueOf(10)),
				new SingleSale("Mango", Double.valueOf(10.50)), new MultipleSale("Mango", Double.valueOf(10.50), Double.valueOf(10)),
				new SingleSale("Mango", Double.valueOf(10.50)), new MultipleSale("Mango", Double.valueOf(10.50), Double.valueOf(10)),
				new SingleSale("Mango", Double.valueOf(10.50)), new MultipleSale("Mango", Double.valueOf(10.50), Double.valueOf(10)),
				new SingleSale("Mango", Double.valueOf(10.50)), new MultipleSale("Mango", Double.valueOf(10.50), Double.valueOf(10)),
				new SingleSale("Mango", Double.valueOf(10.50)), new MultipleSale("Mango", Double.valueOf(10.50), Double.valueOf(10)),
				new SaleWithAdjustment("Mango", Double.valueOf(10.50), AdjustmentType.ADD),
				new SaleWithAdjustment("Mango", Double.valueOf(10.50), AdjustmentType.ADD),
				new SaleWithAdjustment("Mango", Double.valueOf(10.50), AdjustmentType.ADD),
				new SaleWithAdjustment("Mango", Double.valueOf(10.50), AdjustmentType.ADD),
				new SaleWithAdjustment("Mango", Double.valueOf(10.50), AdjustmentType.ADD),
				new SaleWithAdjustment("Mango", Double.valueOf(10.50), AdjustmentType.ADD),
				new SaleWithAdjustment("Mango", Double.valueOf(10.50), AdjustmentType.ADD),
				new SaleWithAdjustment("Mango", Double.valueOf(10.50), AdjustmentType.ADD),
				new SaleWithAdjustment("Mango", Double.valueOf(10.50), AdjustmentType.ADD),
				new SaleWithAdjustment("Mango", Double.valueOf(10.50), AdjustmentType.ADD),
				new SaleWithAdjustment("Mango", Double.valueOf(10.50), AdjustmentType.ADD),
				new SaleWithAdjustment("Mango", Double.valueOf(10.50), AdjustmentType.ADD),
				new SaleWithAdjustment("Mango", Double.valueOf(10.50), AdjustmentType.ADD),
				new SaleWithAdjustment("Mango", Double.valueOf(10.50), AdjustmentType.ADD),
				new SaleWithAdjustment("Mango", Double.valueOf(10.50), AdjustmentType.ADD),
				new SaleWithAdjustment("Mango", Double.valueOf(10.50), AdjustmentType.ADD),
				new SaleWithAdjustment("Mango", Double.valueOf(10.50), AdjustmentType.ADD),
				new SaleWithAdjustment("Mango", Double.valueOf(10.50), AdjustmentType.ADD),
				new SaleWithAdjustment("Mango", Double.valueOf(10.50), AdjustmentType.ADD),
				new SaleWithAdjustment("Mango", Double.valueOf(10.50), AdjustmentType.ADD),
				new SaleWithAdjustment("Mango", Double.valueOf(10.50), AdjustmentType.ADD),
				new SaleWithAdjustment("Mango", Double.valueOf(10.50), AdjustmentType.ADD),
				new SingleSale("Mango", Double.valueOf(10.50)), new MultipleSale("Mango", Double.valueOf(10.50), Double.valueOf(10)),
				new SingleSale("Mango", Double.valueOf(10.50)), new MultipleSale("Mango", Double.valueOf(10.50), Double.valueOf(10)),
				new SingleSale("Mango", Double.valueOf(10.50)), new MultipleSale("Mango", Double.valueOf(10.50), Double.valueOf(10)),
				new SingleSale("Mango", Double.valueOf(10.50)), new MultipleSale("Mango", Double.valueOf(10.50), Double.valueOf(10))
		);


		salesMsgs = Arrays.asList(
				new SingleSale("Mango", Double.valueOf(10.50)), new MultipleSale("Mango", Double.valueOf(10.50), Double.valueOf(10)),
				new SingleSale("Mango", Double.valueOf(10.50)), new MultipleSale("Mango", Double.valueOf(10.50), Double.valueOf(10)));
	}


	@Test
	public void testReadSalesMessages()
	{
		sut.readSalesMessages();
	}

	@Test
	public void testProcessSalesMessages()
	{
		sut.processSalesMessages(salesMsgs);
		Assert.assertEquals(Integer.valueOf(4), Integer.valueOf(sut.getProcessedMsg()));
	}

	@Test(expected = SalesProcessingException.class)
	public void testProcessSalesMessagesWithException()
	{
		sut.processSalesMessages(salesMsgsFull);
	}
}

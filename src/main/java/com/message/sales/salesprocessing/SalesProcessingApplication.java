package com.message.sales.salesprocessing;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.message.sales.salesprocessing.sales.SingleSale;


/**
 * This is main class which is to start spring boot application
 * @author Jeevitha Govindasamy
 * @version 1.0.0
 */
@SpringBootApplication
public class SalesProcessingApplication {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		SpringApplication.run(SalesProcessingApplication.class, args);
		simulateMessageCommunication();
	}

	/*
	 * This method is used for simulating message communication from spring boot
	 * for Sale processing application
	 */
	private static void simulateMessageCommunication()
	{
		final SalesProcessor processor = new SalesProcessor();
		final List<SingleSale> msgs = processor.readSalesMessages();
		processor.processSalesMessages(msgs);
	}
}
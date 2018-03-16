package com.message.sales.salesprocessing.model;

/**
 * POJO class for holding sale for a particular product type with its unit and price 
 * @author Jeevitha Govindasamy
 * @version 1.0.0
 */
public class SaleMessage {

	private Double unitsSaled;
	private Double price;

	/**
	 * @param unitsSaled
	 * @param price
	 */
	public SaleMessage(final Double unitsSaled,final Double price) {
		super();
		this.price = price;
	}

	/**
	 * @return unitsSaled
	 */
	public Double getUnitsSaled() {
		return unitsSaled;
	}

	/**
	 * @param unitsSaled
	 */
	public void setUnitsSaled(final Double unitsSaled) {
		this.unitsSaled = unitsSaled;
	}

	/**
	 * @return price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price
	 */
	public void setPrice(final Double price) {
		this.price = price;
	}
}
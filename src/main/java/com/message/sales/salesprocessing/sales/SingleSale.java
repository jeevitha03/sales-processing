package com.message.sales.salesprocessing.sales;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * POJO class for holding sale information of single unit with its type
 * and price from json file - Message Type 1 
 * @author Jeevitha Govindasamy
 * @version 1.0.0
 */
@JsonTypeInfo(
		use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "saleType")
@JsonSubTypes({
		@JsonSubTypes.Type(value = MultipleSale.class, name = "MultipleSale"),
		@JsonSubTypes.Type(value = SaleWithAdjustment.class, name = "SaleWithAdjustment")
})
public class SingleSale {

	private String productType;
	private Double productPrice;

	/**
	 * default  Constructor
	 */
	public SingleSale() {
	}

	/**
	 * @param productType
	 * @param productPrice
	 */
	public SingleSale(final String productType, final Double productPrice) {
		super();
		this.productType = productType;
		this.productPrice = productPrice;
	}

	/**
	 * @return productType
	 */
	public String getProductType() {
		return productType;
	}

	/**
	 * @param productType
	 */
	public void setProductType(final String productType) {
		this.productType = productType;
	}

	/**
	 * @return productPrice
	 */
	public Double getProductPrice() {
		return productPrice;
	}

	/**
	 * @param productPrice
	 */
	public void setProductPrice(final Double productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "SingleSale [productType=" + productType + ", productPrice=" + productPrice + "]";
	}
}
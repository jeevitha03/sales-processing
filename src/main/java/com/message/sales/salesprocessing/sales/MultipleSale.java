package com.message.sales.salesprocessing.sales;

/**
 * POJO class for holding sale information of multiple unit with its type,
 *  price and quantity from json file - Message Type 2
 * @author Jeevitha Govindasamy
 * @version 1.0.0
 */
public class MultipleSale extends SingleSale {
	private Double productQuantity;

	/**
	 * default Constructor
	 */
	public MultipleSale() {
		super();
	}

	/**
	 * @param productType
	 * @param productPrice
	 * @param productQuantity
	 */
	public MultipleSale(final String productType, final Double productPrice,final Double productQuantity) {
		super(productType, productPrice);
		this.productQuantity = productQuantity;
	}

	/**
	 * @param productQuantity
	 */
	public MultipleSale(final Double productQuantity) {
		this.productQuantity = productQuantity;
	}

	/**
	 * @return productQuantity
	 */
	public Double getProductQuantity() {
		return productQuantity;
	}

	/**
	 * @param productQuantity
	 */
	public void setProductQuantity(final Double productQuantity) {
		this.productQuantity = productQuantity;
	}

	@Override
	public String toString() {
		return "MultipleSale [productQuantity=" + this.productQuantity + ", getProductType()=" + getProductType()
				+ ", getProductPrice()=" + getProductPrice() + "]";
	}
}
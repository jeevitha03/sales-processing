package com.message.sales.salesprocessing.sales;

/**
 * POJO class for holding sale information of adjustment with adjustment type based on
 * product type and price from json file - Message Type 3
 * @author Jeevitha Govindasamy
 * @version 1.0.0
 */
public class SaleWithAdjustment extends SingleSale {

	AdjustmentType adjustmentType;

	/**
	 * FIXME : Constructor
	 */
	public SaleWithAdjustment() {
	}

	/**
	 * @param productType
	 * @param productPrice
	 * @param adjustmentType
	 */
	public SaleWithAdjustment(final String productType, final Double productPrice,final AdjustmentType adjustmentType) {
		super(productType, productPrice);
		this.adjustmentType = adjustmentType;
	}

	/**
	 * @param adjustmentType
	 */
	public SaleWithAdjustment(final AdjustmentType adjustmentType) {
		this.adjustmentType = adjustmentType;
	}

	/**
	 * @return adjustmentType
	 */
	public AdjustmentType getAdjustmentType() {
		return adjustmentType;
	}

	/**
	 * @param adjustmentType
	 */
	public void setAdjustmentType(final AdjustmentType adjustmentType) {
		this.adjustmentType = adjustmentType;
	}

	@Override
	public String toString() {
		return "SaleWithAdjustment [adjustmentType=" + this.adjustmentType + ", getProductType()=" + getProductType()
				+ ", getProductPrice()=" + getProductPrice() + "]";
	}
}
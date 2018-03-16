package com.message.sales.salesprocessing.model;

import java.util.ArrayList;
import java.util.List;

import com.message.sales.salesprocessing.sales.SaleWithAdjustment;


/**
 * POJO class for holding product type, price with its sale information and adjustment 
 * @author Jeevitha Govindasamy
 * @version 1.0.0
 */
public class Product {

	private String productType;
	private Double productPrice;
	private Double unitsSaled=0d;
	private List<SaleWithAdjustment> adj;
	private List<SaleWithAdjustment> processedAdj;
	private List<SaleMessage> sales;

	/**
	 * @param productType
	 * @param productPrice
	 */
	public Product(final String productType, final Double productPrice) {
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
	 * @return list of Adjustments
	 */
	public List<SaleWithAdjustment> getAdj() {
		if(adj==null) {
			this.adj = new ArrayList<>();
		}
		return adj;
	}

	/**
	 * @param adj
	 */
	public void setAdj(final List<SaleWithAdjustment> adj) {
		this.adj = adj;
	}

	/**
	 * @return list of processed Adjusments
	 */
	public List<SaleWithAdjustment> getProcessedAdj() {
		if(processedAdj == null) {
			this.processedAdj=new ArrayList<>();
		}
		return processedAdj;
	}

	/**
	 * @param processedAdj
	 */
	public void setProcessedAdj(final List<SaleWithAdjustment> processedAdj) {
		this.processedAdj = processedAdj;
	}

	/**
	 * @return List of sales message
	 */
	public List<SaleMessage> getSales() {
		if(sales == null) {
			this.sales=new ArrayList<>();
		}
		return sales;
	}

	/**
	 * @param sales
	 */
	public void setSales(final List<SaleMessage> sales) {
		this.sales = sales;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productPrice == null) ? 0 : productPrice.hashCode());
		result = prime * result + ((productType == null) ? 0 : productType.hashCode());
		return result;
	}
	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		final Product other = (Product) obj;
		if (productPrice == null) {
			if (other.productPrice != null)
			{
				return false;
			}
		} else if (!productPrice.equals(other.productPrice))
		{
			return false;
		}
		if (productType == null) {
			if (other.productType != null)
			{
				return false;
			}
		} else if (!productType.equals(other.productType))
		{
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Product [productType=" + this.productType + ", productPrice=" + this.productPrice + ", adj=" + this.adj + "]";
	}
}
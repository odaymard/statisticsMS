package com.sales.statistics.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatisticsResponse {

	private double totalSalesAmount;

	private double averageAmount;

	public StatisticsResponse(double totalSalesAmount, double averageAmount) {
		super();
		this.totalSalesAmount = totalSalesAmount;
		this.averageAmount = averageAmount;
	}

	@JsonProperty("total_sales_amount")
	public double getTotalSalesAmount() {
		return totalSalesAmount;
	}


	@JsonProperty("average_amount")
	public double getAverageAmount() {
		return averageAmount;
	}
}
package com.sales.statistics.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Sales {


    private double salesAmount;


    @JsonCreator
    public Sales(@JsonProperty("sales_amount") double salesAmount) {
        super();
        this.setSalesAmount((salesAmount));
    }



    public double getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(double salesAmount) {
        this.salesAmount = salesAmount;
    }


}
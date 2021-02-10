package com.sales.statistics.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sales.statistics.models.Sales;
import com.sales.statistics.services.StatisticsService;


@RestController
@RequestMapping("/api/v1")
public class SalesController {
    
	@Autowired
	private StatisticsService statisticsService;

    @PostMapping("/sales")
    public ResponseEntity<Object> postSales(@RequestBody Sales sale) {
    	statisticsService.addSales(sale);
    	
    	return ResponseEntity.accepted().build();
    }
}
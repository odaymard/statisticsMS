package com.sales.statistics.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sales.statistics.dto.StatisticsResponse;
import com.sales.statistics.models.Statistics;
import com.sales.statistics.services.StatisticsService;


@RestController
@RequestMapping("/api/v1")
public class StatisticsController {
	
	@Autowired
	private StatisticsService statisticsService;
    

    @GetMapping(value = "/statistics")
    public ResponseEntity<StatisticsResponse> getStatistics() {
    	Statistics statistics = statisticsService.getStatistics();
    	
    	StatisticsResponse responseEntity = new StatisticsResponse(statistics.getSum(), statistics.getAverage());
        
        return ResponseEntity.ok(responseEntity);
    }
}
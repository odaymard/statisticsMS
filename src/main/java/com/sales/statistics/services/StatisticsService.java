package com.sales.statistics.services;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.sales.statistics.models.Sales;
import com.sales.statistics.models.Statistics;

@Service
public class StatisticsService {

	private final int WINDOW_TIME = 60;

	private final Statistics[] statisticsArray = new Statistics[WINDOW_TIME];

	private long startWindowTime = 0;

	private void updateSumAndCount(Statistics[] statistics, int index, Sales sale, long requestTime) {

		statistics[index].setSum(sale.getSalesAmount() + statistics[index].getSum());
		statistics[index].setCount(statistics[index].getCount() + 1);
		statistics[index].setTime(requestTime);
	}

	public void addSales(Sales sale) {
		long requestTime = Instant.now().toEpochMilli() / 1000;

		if (statisticsArray[0] == null) {
			statisticsArray[0] = new Statistics(1, sale.getSalesAmount(), requestTime);
			startWindowTime = requestTime; // it holds the request time for the first request and we use it to compare
											// with the time of the coming requests
			// so we can get the corresponding index for the request tme
		} else {
			int correspondingIndexTime;
			correspondingIndexTime = (int) (requestTime - startWindowTime); // The corresponding index for the request
																			// time
			if (correspondingIndexTime < WINDOW_TIME) { // The request time is still in the window size which is 60
														// seconds from the start time.
				if (statisticsArray[correspondingIndexTime] == null) { // Create a new record for the sales amount
					statisticsArray[correspondingIndexTime] = new Statistics(1, sale.getSalesAmount(), requestTime);
				} else { // it means many requests received at the same second so we have to Update the
							// record with the accumulated sales for the current second.

					updateSumAndCount(statisticsArray, correspondingIndexTime, sale, requestTime);

				}
			} else { // start a new window range since 60s is passed and save the starting time for
						// later usage
				statisticsArray[0] = new Statistics(1, sale.getSalesAmount(), requestTime);
				startWindowTime = requestTime;
			}

		}
	}
	
	public Statistics getStatistics() {
		int totalCount = 0;
        double totalSum = 0;
        long requestTime = Instant.now().toEpochMilli() / 1000; //Get time in second
        

        for (int i = 0; i < WINDOW_TIME; i++) {
            if (statisticsArray[i] != null && (requestTime - statisticsArray[i].getTime()) < WINDOW_TIME) { // Accumulate the sales sum and count during the last 60 seconds
                totalSum = totalSum + statisticsArray[i].getSum();
                totalCount = totalCount + statisticsArray[i].getCount();
            }
        }
        
        return new Statistics(totalCount, totalSum);
	}
}

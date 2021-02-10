package com.sales.statistics.models;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsTest {

    @org.junit.jupiter.api.Test
    void averageReturnnZeroWhenCountIsZero() {
        double someNumber = 1234.00;
        int count = 0;
        Statistics statistics = new Statistics(count,someNumber);
        double response = statistics.getAverage();
        assertEquals(0,response);
    }

    @org.junit.jupiter.api.Test
    void averageReturnTheCorrectAverage() {
        Statistics statistics = new Statistics(2,4);
        double response = statistics.getAverage();
        assertEquals(2,response);
    }
}
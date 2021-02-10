package com.sales.statistics.models;

public class Statistics {

	private int count;
	
	private double sum;
	
	private long time;

	public Statistics(int count, double sum) {
		super();
		this.setCount(count);
		this.setSum(sum);
	}

	public Statistics(int count, double sum, long time) {
		this(count, sum);
		this.setTime(time);
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public double getAverage() {
		if (count == 0) {
			return 0;
		}
		return sum / count;
	}

}
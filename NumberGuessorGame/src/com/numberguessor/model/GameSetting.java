package com.numberguessor.model;

public class GameSetting {

	private int minRange;
	private int maxRange;
	private int maxAttempts;

	public GameSetting(int minRange, int maxRange, int maxAttempts) {
		super();

		if (minRange >= maxRange) {
			throw new IllegalArgumentException("Minimum range must be less than maximum range.");
		}
		if (maxAttempts <= 0) {
			throw new IllegalArgumentException("Maximum attempts must be greater than zero.");
		}

		this.minRange = minRange;
		this.maxRange = maxRange;
		this.maxAttempts = maxAttempts;
	}

	public int  getMinRange() {
		return minRange;
	}

	public int getMaxRange() {
		return maxRange;
	}

	public int getMaxAttempts() {
		return maxAttempts;
	}

}

package com.carrental.services;

import com.carrental.interfaces.CostCalculator;

public class SimpleCostCalculator implements CostCalculator {
    public double calculate(int days, double pricePerDay) {
        return days * pricePerDay;
    }
}

package com.carrental.interfaces;

import com.carrental.models.Car;

public interface InvoiceGenerator {
    void generateInvoice(Car car, int days, double cost);
}

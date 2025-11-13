package com.carrental.services;

import com.carrental.interfaces.InvoiceGenerator;
import com.carrental.models.Car;

public class ConsoleInvoiceGenerator implements InvoiceGenerator {
    public void generateInvoice(Car car, int days, double cost) {
        System.out.println("\n------- INVOICE -------");
        System.out.println("Car: " + car.getModel());
        System.out.println("Days: " + days);
        System.out.println("Total Cost: ₹" + cost);
        System.out.println("------------------------\n");
    }
}

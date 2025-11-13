package com.carrental.services;

import com.carrental.interfaces.CarRepository;
import com.carrental.interfaces.CostCalculator;
import com.carrental.interfaces.InvoiceGenerator;
import com.carrental.models.Car;

public class RentalService {

    private CarRepository repo;
    private CostCalculator calculator;
    private InvoiceGenerator invoice;

    public RentalService(CarRepository repo, CostCalculator calculator, InvoiceGenerator invoice) {
        this.repo = repo;
        this.calculator = calculator;
        this.invoice = invoice;
    }

    public void rentCar(int id, int days) {

        com.carrental.models.Car car = repo.getCarById(id);

        if (car == null) {
            System.out.println("❌ Car not found!");
            return;
        }

        if (!car.isAvailable()) {
            System.out.println("❌ Car is already rented!");
            return;
        }

        double cost = calculator.calculate(days, car.getPricePerDay());
        car.setAvailable(false);

        invoice.generateInvoice(car, days, cost);
    }

    public void returnCar(int id) {

        Car car = repo.getCarById(id);

        if (car == null) {
            System.out.println("❌ Invalid car ID!");
            return;
        }

        if (car.isAvailable()) {
            System.out.println("❌ This car is not rented!");
            return;
        }

        car.setAvailable(true);
        System.out.println("✔ Car returned successfully!");
    }
}

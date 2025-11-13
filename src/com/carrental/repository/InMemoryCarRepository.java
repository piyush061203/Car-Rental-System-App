package com.carrental.repository;

import com.carrental.interfaces.CarRepository;
import com.carrental.models.Car;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCarRepository implements CarRepository {

    private List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public Car getCarById(int id) {
        return cars.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void displayAllCars() {
        System.out.println("\nAvailable Cars:");

        for (Car c : cars) {
            String status = c.isAvailable() ? "Available" : "Rented";
            System.out.println(c.getId() + " - " + c.getModel() + " - ₹" + c.getPricePerDay() + "/day (" + status + ")");
        }
    }
}

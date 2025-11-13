package com.carrental.interfaces;

import com.carrental.models.Car;

public interface CarRepository {
    void addCar(Car car);
    Car getCarById(int id);
    void displayAllCars();
}

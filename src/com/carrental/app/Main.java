package com.carrental.app;

import com.carrental.interfaces.*;
import com.carrental.models.Car;
import com.carrental.repository.InMemoryCarRepository;
import com.carrental.services.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CarRepository repo = new InMemoryCarRepository();
        CostCalculator calc = new SimpleCostCalculator();
        InvoiceGenerator invoice = new ConsoleInvoiceGenerator();

        RentalService service = new RentalService(repo, calc, invoice);

        repo.addCar(new Car(1, "Honda City", 1200));
        repo.addCar(new Car(2, "Swift", 800));
        repo.addCar(new Car(3, "Creta", 1500));

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== CAR RENTAL MENU =====");
            System.out.println("1. View All Cars");
            System.out.println("2. Rent Car");
            System.out.println("3. Return Car");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    repo.displayAllCars();
                    break;

                case 2:
                    System.out.print("Enter Car ID: ");
                    int rentId = sc.nextInt();
                    System.out.print("Enter Days: ");
                    int days = sc.nextInt();
                    service.rentCar(rentId, days);
                    break;

                case 3:
                    System.out.print("Enter Car ID to return: ");
                    int returnId = sc.nextInt();
                    service.returnCar(returnId);
                    break;

                case 4:
                    System.out.println("Thank you for using Car Rental System!");
                    System.exit(0);

                default:
                    System.out.println("❌ Invalid choice!");
            }
        }
    }
}

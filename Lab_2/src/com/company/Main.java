package com.company;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        String carsJsonPathOne = "D:\\3 year\\CPP_JAVA\\Projects\\Lab_2\\Cars_1.json";
        String carsJsonPathTwo = "D:\\3 year\\CPP_JAVA\\Projects\\Lab_2\\Cars_2.json";

        boolean continueLoop = true;

        while (continueLoop)
        {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter 1 to print map with n first cars.");
            System.out.println("Enter 2 to remove cars by model.");
            System.out.println("Enter 3 to read data from 2 files and find cars with from-to price.");
            System.out.println("Enter 0 to exit.");

            int command = scanner.nextInt();

            switch (command)
            {
                case 1:
                    printMapWithNFirstCars(scanner, carsJsonPathOne);
                    break;
                case 2:
                    removeCarsByModel(scanner, carsJsonPathOne);
                    break;
                case 3:
                    findCarsWithFromToPrice(scanner, carsJsonPathOne, carsJsonPathTwo);
                    break;
                case 0:
                    continueLoop = false;
                    break;
            }
        }
    }

    private static void printMapWithNFirstCars(Scanner scanner, String jsonFilePath) throws IOException {
        Map<Integer, ArrayList<CarInfo>> cars = JsonParser.getCarsMapFromJson(jsonFilePath);

        System.out.println("Enter count of cars to print:");

        int carsToPrintCount = scanner.nextInt();

        for (Integer key: cars.keySet()) {
            System.out.println("\nKey: " + key);

            int printedCarsCount = 0;

            System.out.println("Value:");
            for (CarInfo carInfo : cars.get(key))
            {
                if (printedCarsCount < carsToPrintCount) {
                    System.out.println(carInfo);

                    ++printedCarsCount;
                }
            }
        }
    }

    private static void removeCarsByModel(Scanner scanner, String jsonFilePath) throws IOException {
        Map<Integer, ArrayList<CarInfo>> cars = JsonParser.getCarsMapFromJson(jsonFilePath);

        System.out.println("Enter car models to remove:");

        scanner.nextLine();
        String carModelsStringToParse = scanner.nextLine();

        List<String> carModelsToRemove = Arrays.asList(carModelsStringToParse.split("[,]", 0));

        for (Integer key: cars.keySet()) {
            System.out.println("Key: " + key);

            System.out.println("Value after remove:");

            cars.get(key).removeIf(carInfo -> carModelsToRemove.contains(carInfo.getModel()));

            for (CarInfo carInfo : cars.get(key))
            {
                System.out.println(carInfo);
            }
        }
    }

    private static void findCarsWithFromToPrice(Scanner scanner, String jsonFilePathOne, String jsonFilePathTwo) throws IOException {
        ArrayList<CarInfo> cars = JsonParser.getCarsArrayListFromJson(jsonFilePathOne);
        cars.addAll(JsonParser.getCarsArrayListFromJson(jsonFilePathTwo));

        int priceFrom;
        int priceTo;

        System.out.println("Enter price from:");
        priceFrom = scanner.nextInt();

        System.out.println("Enter price to:");
        priceTo = scanner.nextInt();

        Comparator<CarInfo> byModelName =
                Comparator.comparing(CarInfo::getModel);

        cars.sort(Collections.reverseOrder(byModelName));

        System.out.println("All cars(sorted):");
        for (CarInfo carInfo : cars)
        {
            System.out.println(carInfo);
        }

        long countOfCars =
                cars.stream()
                        .filter(carInfo -> Integer.parseInt(carInfo.getPrice()) >= priceFrom
                                && Integer.parseInt(carInfo.getPrice()) <= priceTo).count();

        System.out.println("Cars count with price from " + priceFrom + " to " + priceTo + ": " + countOfCars);
    }
}

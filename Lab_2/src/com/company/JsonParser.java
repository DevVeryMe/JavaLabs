package com.company;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class JsonParser {
    public static Map<Integer, ArrayList<CarInfo>> getCarsMapFromJson(String fileName) throws IOException {
        String carInfoJson= new String(Files.readAllBytes(Paths.get(fileName)));
        Gson gson = new Gson();
        CarInfo[] carsArray = gson.fromJson(carInfoJson, CarInfo[].class);

        Map<Integer, ArrayList<CarInfo>> maxSpeedCarsMap = new HashMap<>();

        ArrayList<CarInfo> carInfoArrayList = new ArrayList<>(Arrays.asList(carsArray));

        for (CarInfo carInfo : carInfoArrayList)
        {
            maxSpeedCarsMap.put(Integer.parseInt(carInfo.getMaxSpeed()), carInfoArrayList);
        }

        return maxSpeedCarsMap;
    }

    public static ArrayList<CarInfo> getCarsArrayListFromJson(String fileName) throws IOException {
        String carInfoJson= new String(Files.readAllBytes(Paths.get(fileName)));
        Gson gson = new Gson();
        CarInfo[] carsArray = gson.fromJson(carInfoJson, CarInfo[].class);

        ArrayList<CarInfo> carInfoArrayList = new ArrayList<>(Arrays.asList(carsArray));

        return carInfoArrayList;
    }
}

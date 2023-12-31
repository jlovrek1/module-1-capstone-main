package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ImportFile {
    List <StuffedAnimal> productList = new ArrayList<>();

    public List<StuffedAnimal> importList (){
        Scanner userInput = new Scanner(System.in);
        File vendingMachine = new File("C:/Users/Student/workspace/java-minicapstonemodule1-team4/capstone/vendingmachine.csv");

        if (!vendingMachine.exists()) {
            System.out.println("File not found.");
            System.exit(1);
        } else if (!vendingMachine.isFile()) {
            System.out.println("Is not a file.");
            System.exit(1);
        }

        try (Scanner reader = new Scanner(vendingMachine)) {
            while (reader.hasNextLine()) {
                String[] itemArr = reader.nextLine().split("\\|");
                StuffedAnimal product = new StuffedAnimal(itemArr[0], itemArr[1], Double.parseDouble(itemArr[2]), itemArr[3]);
                productList.add(product);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }
        return productList;
    }

    public void displayProducts() {
        System.out.println("Item List");
        for (StuffedAnimal product : productList) {
            System.out.println(product.toString());
        }
    }
}
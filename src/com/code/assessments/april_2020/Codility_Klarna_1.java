package com.nayan.code.assessments.april_2020;

import java.util.*;

/**
 *
 * Functional Smooothies Inc. is releasing a new smoothie machine that will make the best icy fruit beverages of all time. According to Wikipedia:
 *
 * A smoothie (occasionally spelled smoothee or smoothy) is a thick, cold beverage made from pureed raw fruit blended with ice cream or frozen yogurt along with other ingredients such as crushed ice, fruit juice, sweeteners, dairy products, nuts, seeds, etc.
 *
 * In order to sell the machine to smoothie vendors all over the world, Functional Smooothies needs to ensure that the machine takes all dietary preferences and allergies into account. They have hired you to write the software for the machine.
 *
 * The software has a menu of standard smoothie options, including the ingredients for each drink. When a customer places their order, they supply a list of zero or more dietary restrictions that must be honoured. Your software will print out a list of the ingredients that the smoothie operator needs to put into the machine.
 *
 * Menu
 * The menu options, along with the ingredients needed for each are as follows.
 *
 * Classic: strawberry, banana, pineapple, mango, peach, honey
 * Freezie: blackberry, blueberry, black currant, grape juice, frozen yogurt
 * Greenie: green apple, lime, avocado, spinach, ice, apple juice
 * Just Desserts: banana, ice cream, chocolate, peanut, cherry
 * Input
 * You should write a function called ingredients, which takes as input a string containing item from the menu and optionally one or more ingredients to omit from the smoothie, separated by commas.
 *
 * Restricted ingredients have to be preceded by - sign, as opposed to the ones that should be added. Note that:
 *
 * It is valid to have the allergens not present in the ordered smoothie. Those ingredients will just be ignored and no exception should be thrown.
 * As adding new ingredients is not supported yet, any input with additional ingredients is considered invalid and an IllegalArgumentException should be thrown.
 * In very rare cases of the user input processor mechanical failures, their order might be lost or arrive empty to the software.
 *
 * Output
 * The function should return a string listing the ingredients that the operator needs to put in. To make it more convenient for the operator, the ingredients should be listed in alphabetical order and separated by commas in the string returned from the function.
 *
 * A smoothie with no ingredients is represented as "". In case of input being invalid, an IllegalArgumentException should be thrown.
 *
 * Examples
 * if a customer orders a Classic but is allergic to strawberry and peanuts, your function will be called with the argument "Classic,-strawberry,-peanut" and should return "banana,honey,mango,peach,pineapple". Note that peanut was ignored as it is not a part of the Classic menu.
 * Requesting Classic with additional chocolate "Classic,chocolate" should result in IllegalArgumentException being thrown.
 * Same result should apply for requesting a smoothie that is not present in the menu "Vitamin smoothie".
 *
 * */
public class Codility_Klarna_1 {

    public static void main(String[] args) {
        Map<String, String> menu = getMenu();

        String order = "Just Desserts,-banana,-ice cream,-chocolate,-peanut,-cherry";

        if(Objects.isNull(order)) {
            throw new RuntimeException("Please provide order to get smoothie");
        }

        String[] splitTheOrder = order.split(",");
        String optionSmoothie = menu.get(splitTheOrder[0]);

        if(Objects.isNull(optionSmoothie)) {
            throw new IllegalArgumentException("Your smoothie not found. Please try something else!!!");
        }

        if(splitTheOrder.length == 1)
            sortTheIngredients(optionSmoothie);

        for (int x = 1 ; x < splitTheOrder.length; x++) {

            if (!splitTheOrder[x].contains("-") && !optionSmoothie.contains(splitTheOrder[x].substring(1))) {
                throw new IllegalArgumentException();
            }
            if (splitTheOrder[x].contains("-") && optionSmoothie.contains(splitTheOrder[x].substring(1))) {
                   optionSmoothie =  optionSmoothie.replace(splitTheOrder[x].substring(1) + ",", "").replace(", "+splitTheOrder[x].substring(1), "");
            }

        }
        System.out.println(sortTheIngredients(optionSmoothie));
    }

    private static Map<String, String> getMenu() {
        Map<String, String> menu = new HashMap<>();
        menu.put("Classic", "strawberry, banana, pineapple, mango, peach, honey");
        menu.put("Freezie", "blackberry, blueberry, black currant, grape juice, frozen yogurt");
        menu.put("Greenie", "green apple, lime, avocado, spinach, ice, apple juice");
        menu.put("Just Desserts", "banana, ice cream, chocolate, peanut, cherry");
        return menu;
    }

    private static String sortTheIngredients(String optionSmoothie) {
        String sortMe[] = optionSmoothie.split(",");
        Arrays.sort(sortMe);
        String ingredients = String.join(",", sortMe);;
        return ingredients;
    }

}

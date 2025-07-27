package interviews;

import java.util.*;

/**
 * Leetcode: https://leetcode.com/problems/smallest-common-region/description/
 * ---------------------------------------------------------------------------
 * Region Hierarchy Problem – Find the Smallest Common Region
 * <p>
 * You're given a world map represented as a hierarchy of regions.
 * Each list contains a parent region followed by its immediate sub-regions.
 * <p>
 * Example structure:
 * <p>
 * "Earth"
 * ├── "North America"
 * │   ├── "Mexico"
 * │   │   ├── "Oaxaca"
 * │   │   └── "Puebla"
 * │   ├── "United States"
 * │   │   ├── "California"
 * │   │   └── "New York"
 * │   └── "Canada"
 * ├── "Ontario"
 * │   │   └── "Quebec"
 * └── "South America"
 * ├── "Argentina"
 * └── "Chile"
 * <p>
 * Your task is to write a function that finds the ** smallest region ** (i.e., closest common parent)
 * that contains ** two given regions **.
 * ---------------------------------------------------------------------------
 * For example:
 * - smallestCommonRegion("California", "Mexico") → "North America"
 * - smallestCommonRegion("Chile", "Puebla") → "Earth"
 * - smallestCommonRegion("Ontario", "Quebec") → "Canada"
 * <p>
 * Input:
 * A list of lists where:
 * - The first element is a **parent region**
 * - The rest are its **sub-regions**
 * <p>
 * Goal:
 * Implement a method that takes this input and two region names,
 * and returns the **lowest common region** that includes both.
 * <p>
 * Think of it as finding the lowest common ancestor in a family tree.
 */

public class AirbnbAltimetrikSmallestCommonRegion {
    public static String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        Map<String, String> countryByRegion = new HashMap<>();

        // Step 1: Build the child → parent map
        for (int i = 0; i < regions.size(); i++) {
            String region = regions.get(i).get(0);

            for (int j = 1; j < regions.get(i).size(); j++) {
                countryByRegion.put(regions.get(i).get(j), region);
            }
        }

        List<String> path1 = new ArrayList<>();
        String currentRegion = region1;

        // Step 2: Build path from region1 to root
        while (currentRegion != null) {
            path1.add(currentRegion);
            currentRegion = countryByRegion.get(currentRegion);
        }

        List<String> path2 = new ArrayList<>();
        currentRegion = region2;

        // Step 3: Build path from region2 to root
        while (currentRegion != null) {
            path2.add(currentRegion);
            currentRegion = countryByRegion.get(currentRegion);
        }

        // Step 3: Traverse path1 to root comparing with path2 until a common ancestor is found
//        for (String country: path1){
//            if(path2.contains(country))
//                return country;
//        }
        return path1.stream().filter(path2::contains).findFirst().get();

//        return "";
    }


    public static void main(String[] args) {
        List<List<String>> regions = Arrays.asList(
                Arrays.asList("Earth", "North America", "South America"),
                Arrays.asList("North America", "Mexico", "United States", "Canada"),
                Arrays.asList("South America", "Argentina", "Brazil", "Chile"),
                Arrays.asList("Mexico", "Oaxaca", "Puebla"),
                Arrays.asList("United States", "California", "Wyoming", "New York"),
                Arrays.asList("Canada", "Ontario", "Quebec", "Saskatchewan")
        );

        // Test cases
        System.out.println(findSmallestRegion(regions, "California", "Mexico")); // North America
        System.out.println(findSmallestRegion(regions, "Chile", "Puebla"));      // Earth
        System.out.println(findSmallestRegion(regions, "Ontario", "Quebec"));    // Canada
        System.out.println(findSmallestRegion(regions, "California", "New York")); // United States
        System.out.println(findSmallestRegion(regions, "Oaxaca", "Puebla"));       // Mexico
    }
}

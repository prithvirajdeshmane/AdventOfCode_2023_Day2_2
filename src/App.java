/**	
 * @author: Prithviraj Deshmane
 * 
 * Problem Source:
 * Site: https://adventofcode.com
 * Year: 2023
 * Day: 2
 * Problem: #2
 * Problem Statement: https://adventofcode.com/2023/day/2 (part 2)
 */

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This class reads game data from an input file and finds the minimum counts 
 * of red, green, and blue balls needed to complete each game.
 * The power of the game is calculated as the product of the counts of each respective color.
 * The puzzle answer is the sum of the powers of each game.
 */
public class App {
    
    // Constants representing the indices for RGB values in an array
    private static final int INDEX_RED = 0;
    private static final int INDEX_GREEN = 1;
    private static final int INDEX_BLUE = 2;

    /**
     * The main method that serves as the entry point of the program.
     * It reads game data from an input file, processes it, and prints the total sum.
     */
    public static void main() {
    	// Variable to store the total sum of the powers of each game
        int totalSum = 0; 

        try (Scanner sc = new Scanner(new File("input.txt"))) {
        	// Loop to read each line in the file
            while (sc.hasNextLine()) { 
            	// Split the line into game number and description of that game
                String[] gameDescription = sc.nextLine().split(":"); 
                
                // Analyze each game, and calculate the max numbers of each color needed
                int[] maxRGB = examineGame(gameDescription[1].trim()); 
                
                // Add power of the game to the current sum
                totalSum += maxRGB[INDEX_RED] * maxRGB[INDEX_GREEN] * maxRGB[INDEX_BLUE];
            }
        } catch (FileNotFoundException e) { // Catch block for handling missing file
            System.out.println("File not found: " + e.getMessage()); // Print error message if file is not found
        }

        // Print the final total sum after processing the file
        System.out.println("Total sum: " + totalSum);
    }

    /**
     * Examines the game details to find the maximum counts of red, blue, and green balls.
     * 
     * @param gameDetails A string containing the details of the game with ball counts and colors
     * @return An array containing the maximum counts for red, green, and blue balls
     */
    private static int[] examineGame(String gameDetails) {
    	// Array to store maximum counts for red, green, and blue
        int[] maxRGB = new int[3]; 
        
        // Split game details by semicolon to get each hand
        for (String hand : gameDetails.split(";")) { 
        	
        	// Split each hand by comma to get individual draws
            for (String draw : hand.trim().split(",")) { 
            	
            	// Split draw details into count and color
                String[] drawDetails = draw.trim().split(" "); 
                
                // Parse the ball count as an integer
                int ballCount = Integer.parseInt(drawDetails[0]);
                
                // Determine color of the balls drawn
                String ballColor = drawDetails[1].toLowerCase(); 

                // Update the maximum count for the corresponding color
                switch (ballColor) {
                    case "red":
                        maxRGB[INDEX_RED] = Math.max(maxRGB[INDEX_RED], ballCount);
                        break;
                    case "green":
                        maxRGB[INDEX_GREEN] = Math.max(maxRGB[INDEX_GREEN], ballCount);
                        break;
                    case "blue":
                        maxRGB[INDEX_BLUE] = Math.max(maxRGB[INDEX_BLUE], ballCount);
                        break;
                    default:
                        break; // Ignore any color that is not red, green, or blue
                }
            }
        }

        // Print the maximum RGB values for debugging
        //System.out.println("RGB array: " + Arrays.toString(maxRGB));
        return maxRGB; // Return the array with max counts for each color
    }
}

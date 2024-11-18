# Advent of Code 2023 - Day 2 Solution

## Overview
This repository contains a Java solution for Day 2 (part 2) of the Advent of Code 2023 challenge.

## Problem Statement: Day 2 (part 2)

The program reads a file named `input.txt` containing game data and calculates the minimum counts of red, green, and blue balls needed to complete each game. The power of a game is determined by the product of these counts, and the solution outputs the total sum of the powers of all games.

## Problem Details
The task involves reading and analyzing lines from an input file, where each line represents a game:

- Each line in the input file is formatted as: `Game X: [hand1]; [hand2]; ...`
- Each hand contains a series of draws, such as `3 blue, 4 red`, where the first part indicates the number of balls drawn and the second part indicates the color
- The power of a game as the product of the minimum number of red, green, and blue balls needed to complete all hands of that game
- The final answer is the sum of the respective powers of every game

## Example
Given an input file `input.txt` with the following content:

```
Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green
```

### Analysis:
- **Game 1** has the minimum counts `4 red`, `2 green`, and `6 blue` (power: 4 * 2 * 6 = 48).
- **Game 2** has the minimum counts `1 red`, `3 green`, and `4 blue` (power: 1 * 3 * 4 = 12).
- **Game 3** has the minimum counts `20 red`, `13 green`, and `6 blue` (power: 20 * 13 * 6 = 1560).
- **Game 4** has the minimum counts `14 red`, `3 green`, and `15 blue` (power: 14 * 3 * 15 = 630).
- **Game 5** has the minimum counts `6 red`, `3 green`, and `2 blue` (power: 6 * 3 * 2 = 36).

**Total Sum of Powers**: 48 + 12 + 1560 + 630 + 36 = 2286

## Installation and Setup
1. Clone the repository:
   ```
   git clone https://github.com/prithvirajdeshmane/AdventOfCode_2023_Day2_2.git
   ```
2. Ensure Java (Java 8 or higher) is installed on your system.
3. Place your input file named `input.txt` in the root directory.

## Usage
To compile and run the program:

```bash
javac App.java
java App
```

## Input File
The program reads from an input file named `input.txt`, which should be located in the same directory as `App.java`. Ensure the file contains the game data as per the problem requirements.

### Sample Input Format
```
Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
```

## Explanation of the Code
- The `App` class reads and parses the input file.
- The `main` method reads each line, extracts the game number, and calculates the power of each game using the `examineGame` method.
- The `examineGame` method finds the maximum counts for red, green, and blue balls.
- The program computes the total sum of powers across all games and prints it.

## Error Handling
If the input file is not found, the program will display an error message:

```
File not found: input.txt (No such file or directory)
```

## Author
Prithviraj Deshmane

This project is part of the Advent of Code 2023 series. For more details, visit [Advent of Code](https://adventofcode.com).

## License
This project is licensed under the GNU General Public License v3.0 - see the LICENSE file for details.


import java.util.Random;
import java.util.Scanner;

/**
 * This program gets the number of sides on a die from the user, then rolls a
 * pair of dice and returns the results.
 * 
 * @author Yasmin
 *
 */
public class DiceRoll {

	/**
	 * Controls the main flow of the program by calling methods to get a number from
	 * the user, validate the number, roll the dice, and verify if the user wants to
	 * continue.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numOfSides = 0;
		int rollNumber = 1;
		boolean keepGoing = true;
		boolean valid = false;

		System.out.println("Welcome to the Grand Circus Casino!");

		while (keepGoing) {

			while (!valid) {
				System.out.println("How many sides should each die have?");
				numOfSides = getNumber(scan);
				valid = isGreaterThan0(numOfSides);
			}

			rollDice(numOfSides, rollNumber);
			rollNumber++;

			scan.nextLine(); // flush the scanner
			keepGoing = wantToContinue("Roll again? (y/n): ", scan);
		}

		System.out.println("Goodbye!");
	}

	/**
	 * Prompts the user for a number until a valid number is entered.
	 * 
	 * @param scan
	 *            the scanner to collect input from
	 * @return an integer
	 */
	public static int getNumber(Scanner scan) {
		while (!scan.hasNextInt()) {
			System.out.println("You must enter a number. Please try again.");
			scan.next();
		}
		return scan.nextInt();
	}

	/**
	 * Verifies that a number is greater than 0.
	 * 
	 * @param input
	 *            the number
	 * @return true if greater than 0, false otherwise
	 */
	public static boolean isGreaterThan0(int input) {
		if (input <= 0) {
			System.out.println("You must enter a number greater than 0. Please try again.");
		}
		return input > 0;
	}

	/**
	 * Verifies if the user wants to continue.
	 * 
	 * @param prompt
	 *            the user prompt
	 * @param scan
	 *            the scanner to collect input from
	 * @return true if they enter y, false otherwise
	 */
	public static boolean wantToContinue(String prompt, Scanner scan) {
		String response = "";
		boolean valid = false;

		System.out.println(prompt);
		do {

			response = scan.next().toLowerCase();

			if (response.equals("y") || response.equals("n")) {
				valid = true;
			} else {
				System.out.println("You must enter y or n. Please try again.");
			}

		} while (!valid);

		return response.equals("y");
	}

	/**
	 * Roll two dice by generating a random number based on the number of sides
	 * specified by the user. Print the results of the roll.
	 * 
	 * @param sides
	 *            number of sides for each die
	 * @param rollNum
	 *            the roll number
	 */
	public static void rollDice(int sides, int rollNum) {
		Random random = new Random();
		int die1 = 0;
		int die2 = 0;

		die1 = random.nextInt(sides) + 1;
		die2 = random.nextInt(sides) + 1;

		System.out.println("Roll " + rollNum + ":");
		System.out.println(die1);
		System.out.println(die2);
	}
}

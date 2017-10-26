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
	 * Obtains the number of sides from the user and calls the method to roll the
	 * dice.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numOfSides = 0;
		int rollNumber = 1;
		boolean keepGoing = true;
		String userResponse = "";

		System.out.println("Welcome to the Grand Circus Casino!");

		while (keepGoing) {
			System.out.println("How many sides should each die have?");
			while (!scan.hasNextInt()) {
				System.out.println("You must enter a number.");
				scan.next();
			}
			numOfSides = scan.nextInt();
			// TODO: Validate that the number is greater than 0

			rollDice(numOfSides, rollNumber);
			rollNumber++;

			System.out.println("Roll again? (y/n): ");
			if (scan.next().toLowerCase().equals("n")) {
				keepGoing = false;
			}
		}

		System.out.println("Goodbye!");
	}

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

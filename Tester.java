/**
 * French Conjugation Project
 *
 * Tester.java
 *
 * This is my test class for my WordPicker class. It allows
 * me to run the program as long as i want and allowing any
 * number of guesses for each pair as well as allowing to
 * continuously generate again.
 *
 * @author Steve O'Keefe
 */

// Import Classes
import java.util.Scanner;

public class Tester{

	// Main class
	public static void main(String[] args){
		WordPicker p = new WordPicker();
		Scanner in = new Scanner(System.in);
		boolean quit = false;
		System.out.println("Welcome to Stephen's random word pair!");
		
		// Main program loop. Program is finished once this ends.
		while (!quit){
			boolean correct = false;
			System.out.println("Your word pair is:\n" + p.wordPair());
			String correctAnswer = p.getAnswer();
			
			// Asnwer checking loop
			while (!correct){
				System.out.print("Your answer is: ");
				String answer = in.next();
				if (answer.equalsIgnoreCase(correctAnswer)){
					System.out.println("You are correct!");
					correct = true;
				}
				else {
					System.out.println("Incorrect!");
					while(true){
						System.out.print("Would you like to try again?(Y/N): ");
						String again = in.next();
						if (again.equalsIgnoreCase("N")){
							correct = true;
							break;
						}
						else if (!again.equalsIgnoreCase("Y")){
							System.out.println("Sorry please select Y or N.");
							continue;
						}
						else {
							break;
						}
					}
				}
			}
			
			// Try again or quit loop
			while (true){
				System.out.print("Would you like another word pair?(Y/N):  ");
				String exit = in.next();
				if (exit.equalsIgnoreCase("N")){
					quit = true;
					break;
				}
				else if (!exit.equalsIgnoreCase("Y")){
					System.out.println("Sorry please select Y or N.");
					continue;
				}
				else {
					System.out.println("\n\n\n\n");
					break;
				}
			}
		}
		System.out.println("Thank you for using Stephen's random word pair!\nCome again soon.");
	}
}

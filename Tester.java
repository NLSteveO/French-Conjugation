import java.util.Scanner;

public class Tester{

	public static void main(String[] args){
		WordPicker p = new WordPicker();
		Scanner in = new Scanner(System.in);
		boolean quit = false;
		System.out.println("Welcome to Stephen's random word pair!");
		while (!quit){
			boolean correct = false;
			System.out.println("Your word pair is:\n" + p.wordPair());
			String correctAnswer = p.getAnswer();
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

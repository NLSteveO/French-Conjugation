import java.util.Scanner;

public class Tester{

	public static void main(String[] args){
		WordPicker p = new WordPicker();
		Scanner in = new Scanner(System.in);
		boolean quit = false;
		System.out.println("Welcome to Stephen's random word pair!");
		while (!quit){
			System.out.println("Your word pair is:\n" + p.wordPair());
			while (true){
				System.out.print("Would you like another word pair?(Y/N):  ");
				String answer = in.next();
				if (answer.equalsIgnoreCase("N")){
					quit = true;
					break;
				}
				else if (!answer.equalsIgnoreCase("Y")){
					System.out.println("Sorry please select Y or N.");
					continue;
				}
				else {
					break;
				}
			}
		}
		System.out.println("Thank you for using Stephen's random word pair!\nCome again soon.");
	}
}

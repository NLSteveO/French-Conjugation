/**
 * French Conjugation Project
 *
 * WordPicker.java
 *
 * This program takes two list files and generates
 * three arrays of lists. it can then call a word
 * pair which will be two randomly selected words
 * from the first two arrays and can call the
 * correct answer for checking from the third array.
 *
 * @author Steve O'Keefe
 */
 
// Import classes
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class WordPicker{

	// Variables
	private String[] list1;
	private String[] list2;
	private String[] list3;
	private int list1Size;
	private int list2Size;
	private int list3Size;
	private int num1;
	private int num2;
	
	// Constructor
	public WordPicker(){
		loadWords();
	}
	
	/**
	 * Loads the two list files containing
	 * the needed words and creates three
	 * array word lists.
	 */
	public void loadWords(){
		try {
			Scanner in1 = new Scanner(new File("list1"));
			Scanner in2 = new Scanner(new File("list2"));
			ArrayList<String> tmpList = new ArrayList<String>();
			ArrayList<String> tmpList2 = new ArrayList<String>();
			while (in1.hasNextLine()){
				tmpList.add(in1.nextLine());
			}
			listSwap(1, tmpList);
			int c = 0;
			while (in2.hasNextLine()){
				String line = in2.nextLine();
				String[] list = line.split("-");
				tmpList.add(list[0]);
				tmpList2.add(list[1]);
			}
			listSwap(2, tmpList);
			listSwap(3, tmpList2);
		}
		catch (Exception e){
			System.out.println("error: " + e);
		}
	}
	
	/**
	 * Takes an arraylist and given a list
	 * number transfers the values from the
	 * arraylist into the appropriate array.
	 */
	public void listSwap(int num, ArrayList<String> oldList){
		if (num == 1){
			list1Size = oldList.size();
			list1 = new String[list1Size];
			for (int i = 0; i < list1Size; i++){
				list1[i] = oldList.remove(0);
			}
		}
		else if (num == 2){
			list2Size = oldList.size();
			list2 = new String[list2Size];
			for (int i = 0; i < list2Size; i++){
				list2[i] = oldList.remove(0);
			}
		}
		else if (num == 3){
			list3Size = oldList.size();
			list3 = new String[list3Size];
			for (int i = 0; i < list3Size; i++){
				list3[i] = oldList.remove(0);
			}
		}
	}
	
	/**
	 * Returns a random integer given the list size.
	 * Also designed to prevent repeat pairs.
	 */
	public int randomNum(int s){
		int num = (int)(Math.random()*s);
		while (num == num2){
			num = (int)(Math.random()*s);
		}
		return num;
	}
	
	/**
	 * Returns a string of two words one randomly
	 * selected from each list.
	 */
	public String wordPair(){
		num1 = randomNum(list1Size);
		num2 = randomNum(list2Size);
		return list1[num1] + "-" + list2[num2];
	}
	
	/**
	 * Returns the correct answer corresponding
	 * to the other two words.
	 */
	public String getAnswer(){
		String[] tmp = list3[num2].split(",");
		return tmp[num1];
	}
	
	/**
	 * Used for testing purposes to print out the
	 * two lists loaded. Will remove in future.
	 */
	public void printLists(){
		System.out.println("\nlist1:");
		for (String w : list1){
			System.out.println(w);
		}
		System.out.println("\nlist2:");
		for (String w : list2){
			System.out.println(w);
		}
	}

}

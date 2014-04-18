import java.util.Scanner;
import java.io.File;

public class WordPicker{

	private String[] list1;
	private String[] list2;
	
	public WordPicker(){
		list1 = new String[10];
		list2 = new String[10];
		loadWords();
	}
	
	public void loadWords(){
		try {
			Scanner in1 = new Scanner(new File("list1"));
			Scanner in2 = new Scanner(new File("list2"));
			int c = 0;
			while (in1.hasNextLine() && in2.hasNextLine()){
				list1[c] = in1.nextLine();
				list2[c] = in2.nextLine();
				c++;
			}
		}
		catch (Exception e){
			System.out.println(e);
		}
	}
	
	public int randomNum(){
		return (int)(Math.random()*10);
	}
	
	public String wordPair(){
		return list1[randomNum()] + "-" + list2[randomNum()];
	}
			
	public void printLists(){
		System.out.println("list1:");
		for (String w : list1){
			System.out.println(w);
		}
		System.out.println("list2:");
		for (String w : list2){
			System.out.println(w);
		}
	}

}

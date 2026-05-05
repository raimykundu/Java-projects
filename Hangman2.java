import java.util.*;
public class Hangman2 {
	public static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		String response;
		String responseLower;
		do {
			String word = getWord();
			System.out.println("Play hangman!");
			playHangman(word);
			System.out.println("Do you want to play again? y/n: ");
			response = input.nextLine();
			responseLower = response.toLowerCase();
		} while (responseLower.equals("y"));
		
		
	}
	public static String getWord() {
		String[] words = { "horse", "snake", "shoe", "calculator", "computer", "balloon", "flag", "egg", "pencil", "tree", "ladder", "glue", "rain", "fire"
				, "bell", "ice", "pin", "matchstick", "radio", "cat", "hamburger", "nose", "magic", "bushes", "lunchroom", "pollution", "eyes"
				, "dimple", "drizzle", "stair", "fairy"}; 

		int index = (int)(Math.random()* words.length);
		return words[index];

		}
	public static void playHangman(String w) {
		String[] word = new String[w.length()];
		for (int i = 0; i< word.length; i++) {
			word[i] = w.substring(i, i+1);
		}
		// assign * to each index
		String[] display = new String[w.length()];
		for (int i = 0; i< word.length; i++ ) {
			display[i] = "*";
		}
		// print out *s
		for(int i = 0; i < display.length; i++) {
			System.out.print(display[i]);
		}
		System.out.println();
		int miss = 0;
		while (miss<7 && !Arrays.equals(display,word)) {
			System.out.println("Enter a letter in word: ");
			String letter = input.nextLine();
			String lowerCase = letter.toLowerCase();
			int hit = 0;
			//count if it matches
			for (int i = 0; i < word.length; i++) 
			{
				//System.out.println("word[i]" + (word[i]));
				if (word[i].equals(lowerCase)) 
				{	
					hit++;
					display[i] = lowerCase;
				}
				
			}
			//miss count
			if(hit == 0) {
				miss++;
				System.out.println(letter + " is not in the word");
				System.out.println("You missed " + miss + " times");
			}
			for(int i = 0; i < display.length; i++) {
				System.out.print(display[i]);
			}
			System.out.println();
			}
		System.out.println("The word is: " + w + "- You missed " + miss + " times");
		//word matches up all the way
		if(Arrays.equals(display,word)) {
			System.out.println("You got it!");
		}
		// all misses used up
		if (miss == 7) {
			System.out.print("You used up all your chances");
		}
		
	}
	
}
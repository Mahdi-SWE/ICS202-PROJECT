import java.util.Scanner;

import javax.sound.sampled.Line;

public class menu {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		String[] menu = {"1.	Insert a new word with its meanings", "2.	Search for a word", "3.	Delete a word and its meanings",
				"4.	Modify the meanings of a word", "5.	Print all words with a given prefix and their meanings", 
				"6.	Print the contents of the dictionary sorted in lexicographic order", "7.	Exit"};

		DICTIONARY<String> dictionary = new DICTIONARY<String>("C:\\Users\\mahoo\\Desktop\\university\\ics202\\project\\dictionary.txt");

		String line;
		String word;
		String meaning;
		int modify = 0;

		while (true) {

			for (int i = 0; i < menu.length; i++) {
				System.out.println(menu[i]);
			}

			System.out.println("Enter your choice: ");			
			String choice = input.next();

			if(choice.equals("1")) {
				System.out.println("Enter the word: ");
				word = input.next();
				System.out.println("Enter the meaning: ");
				input.nextLine();
				meaning = input.nextLine();
				System.out.println(dictionary.insert(new WordPair<String>(word,meaning)));
				modify++;
			}

			else if(choice.equals("2")) {
				System.out.println("Enter a word to search about it: ");
				line = input.nextLine();
				line = input.nextLine();
				WordPair<String> node = dictionary.find(line);

				if(node == null) {
					System.out.println("Word not in dictionary");
				}
				else {
					System.out.println(node);
				}
			}
			else if(choice.equals("3")) {
				System.out.println("Enter a word to delete it: ");
				word = input.next();
				System.out.println(dictionary.delete(word));
				modify++;
			}
			else if(choice.equals("4")) {
				System.out.println("Enter a word to modify it: ");
				word = input.next();
				System.out.println("Enter the new meaning: ");
				input.nextLine();
				line = input.nextLine();
				System.out.println(dictionary.modifyWord(word,line));
				modify++;
			}
			else if(choice.equals("5")) {
				System.out.println("Enter the prefix you want: ");
				word = input.next();
				dictionary.printAll(word);
			}
			else if(choice.equals("6")) {
				dictionary.printSorted();
			}
			else if(choice.equals("7")) {
				if(modify>0) {
					dictionary.exit();
					break;
				}
				else {
					break;
				}				
			}
			else {
				System.out.println("Invalid choice");
			}
		}
	}
}

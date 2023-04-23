import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class DICTIONARY<T> extends DLL{

	DLL<String> dictionary = new DLL<String>();
	Scanner input = new Scanner(System.in);
	String Path;
	public DICTIONARY(String path) {
		Path = path;
		File file = new File(path);		
		String line;

		try {
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				line = scan.nextLine();
				dictionary.addToTail(line.substring(0, line.indexOf(' ')), line.substring(line.indexOf(' ') + 1));
			}

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}

	public boolean isEmpty() {
		return dictionary.isEmpty();
	}

	public int getSize() {
		return dictionary.size();
	}

	public boolean insert(WordPair<String> newWord) {

		for (int i = 0; i < dictionary.size(); i++) {
			if(dictionary.contains((newWord.word.toLowerCase()))) {
				return false;
			}
		}
		dictionary.addToTail(newWord.word, newWord.wordMeanings);
		return true;
	}

	public WordPair find(String word){
		if(dictionary.isEmpty()) {
			return null;
		}
		WordPair<String> tmp = dictionary.head;
		while(tmp != null){
			if(tmp.word.equals(word.toLowerCase())) {
				return tmp;
			}
			tmp = tmp.next;
		}
		return null;
	}

	public boolean delete(String word) {

		if(!dictionary.isEmpty()) {
			if(dictionary.head.word.equals(word.toLowerCase())) {
				dictionary.deleteFromHead();
				return true;
			}
			else if(dictionary.tail.word.equals(word.toLowerCase())) {
				dictionary.deleteFromTail();
				return true;
			}

			WordPair<String> tmp = dictionary.head;
			while(tmp.next != null){
				if(tmp.next.word.equals(word.toLowerCase())) {
					tmp.next = tmp.next.next;
					return true;
				}
				tmp = tmp.next;
			}
		}
		return false;
	}

	public boolean modifyWord(String word, String newMeanings){
		if(!dictionary.isEmpty()) {
			if(dictionary.head.word.equals(word.toLowerCase())) {
				dictionary.head.wordMeanings = newMeanings.toLowerCase();
				return true;
			}
			else if(dictionary.tail.word.equals(word.toLowerCase())) {
				dictionary.tail.wordMeanings = newMeanings.toLowerCase();
				return true;
			}

			WordPair<String> tmp = dictionary.head.next;
			while(tmp != null){
				if(tmp.word.equals(word.toLowerCase())) {
					tmp.wordMeanings = newMeanings.toLowerCase();
					return true;
				}
				tmp = tmp.next;
			}
		}
		return false;
	}

	public void printAll(String prefix){
		if(!dictionary.isEmpty()) {
			WordPair<String> tmp = dictionary.head;
			while(tmp != null){
				if((tmp.word.substring(0, prefix.length())).equals(prefix.toLowerCase())) {
					System.out.println(tmp);
				}
				tmp = tmp.next;
			}
		}
	}

	public void printSorted() {
		if(dictionary.head != null) {
			String[] list = new String[getSize()];
			WordPair<String> tmp = dictionary.head;
			int i = 0; 
			while (tmp != null) {
				list[i] = tmp.word + ": " + tmp.wordMeanings;
				i++;
				tmp = tmp.next;
			}
			Arrays.sort(list);
			for (int j = 0; j < list.length; j++) {
				System.out.println(list[j]);
			}			
		}
	}

	public void exit() {
		try {
			PrintWriter output = new PrintWriter(Path);
			WordPair<String> tmp = dictionary.head;
			while (tmp != null) {
				output.print(tmp.word + " " + tmp.wordMeanings + "\n");
				tmp = tmp.next;
			}
			output.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public String toString() {
		return dictionary.toString();
	}
}

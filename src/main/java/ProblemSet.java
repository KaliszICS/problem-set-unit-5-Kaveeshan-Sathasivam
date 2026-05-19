/*Author: Kaveeshan Sathasivam
File: Problem Set Unit 5
Date Created: May 15, 2026
Date Last Modified: May 19, 2026*/

// Import Scanner, HashMap, Map and ArrayList
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class ProblemSet {

	// MAIN METHOD
	public static void main(String args[]) {

		// Create Scanner
		Scanner input = new Scanner(System.in);

		// Welcome message
		System.out.println("Welcome to the Text Analyzer.");
		System.out.println();

		// Ask user for input
		System.out.print("Please enter a sentence or paragraph: ");

		// Store text
		String text = input.nextLine();

		// BASIC STATISTICS
		int totalCharacters = text.length();
		int totalSpaces = countSpaces(text);
		int totalVowels = countVowels(text);
		int totalSentences = countSentences(text);

		// Remove punctuation and lowercase text
		text = removePunctuation(text.toLowerCase());

		// Split text into words
		String words[] = text.split(" ");

		// Variables for word statistics
		int totalWords = 0;
		int totalWordLength = 0;

		// HashMap for word frequency
		HashMap<String, Integer> frequency =
				new HashMap<String, Integer>();

		// Variables for longest and shortest words
		int longestLength = 0;
		int shortestLength = 999999;

		// ArrayLists for longest and shortest words
		ArrayList<String> longestWords =
				new ArrayList<String>();

		ArrayList<String> shortestWords =
				new ArrayList<String>();

		// LOOP THROUGH WORDS
		for (int i = 0; i < words.length; i++) {

			// Store current word
			String word = words[i];

			// Ignore empty words
			if (word.length() == 0) {

				continue;

			}

			// Increase total words
			totalWords++;

			// Add word length
			totalWordLength += word.length();

			// Add words to frequency HashMap
			addFrequency(word, frequency);

			// FIND LONGEST WORDS
			if (word.length() > longestLength) {

				longestLength = word.length();

				longestWords.clear();

				longestWords.add(word);

			}
			else if (word.length() == longestLength) {

				// Avoid duplicates
				if (!longestWords.contains(word)) {

					longestWords.add(word);

				}
			}

			// FIND SHORTEST WORDS
			if (word.length() < shortestLength) {

				shortestLength = word.length();

				shortestWords.clear();

				shortestWords.add(word);

			}
			else if (word.length() == shortestLength) {

				// Avoid duplicates
				if (!shortestWords.contains(word)) {

					shortestWords.add(word);

				}
			}
		}

		// Calculate average word length
		double averageWordLength =
				(double) totalWordLength / totalWords;

		// OUTPUT RESULTS
		System.out.println();
		System.out.println("Total Characters: " +
							totalCharacters);

		System.out.println("Total Words: " +
							totalWords);

		System.out.println("Total Vowels: " +
							totalVowels);

		System.out.println("Total Spaces: " +
							totalSpaces);

		// WORD FREQUENCY
		System.out.println();
		System.out.println("Word Frequency:");
		System.out.println();

		// Print HashMap
		printFrequency(frequency);

		// ADVANCED STATISTICS
		System.out.println();

		// Print longest words
		System.out.print("Longest Word: ");
		printList(longestWords);

		// Print shortest words
		System.out.print("Shortest Word: ");
		printList(shortestWords);

		// Print average word length
		System.out.println("Average Word Length: " +
							averageWordLength);

		// Print number of sentences
		System.out.println("Number of Sentences: " +
							totalSentences);

		// Print unique words
		System.out.println("Unique Words: " +
							frequency.size());

		// Close Scanner
		input.close();
	}

	// METHOD TO COUNT SPACES
	public static int countSpaces(String text) {

		int spaces = 0;

		for (int i = 0; i < text.length(); i++) {

			if (text.charAt(i) == ' ') {

				spaces++;

			}
		}

		return spaces;
	}

	// METHOD TO COUNT VOWELS
	public static int countVowels(String text) {

		int vowels = 0;

		for (int i = 0; i < text.length(); i++) {

			char ch =
				Character.toLowerCase(text.charAt(i));

			if (ch == 'a' ||
				ch == 'e' ||
				ch == 'i' ||
				ch == 'o' ||
				ch == 'u') {

				vowels++;

			}
		}

		return vowels;
	}

	// METHOD TO COUNT SENTENCES
	public static int countSentences(String text) {

		int sentences = 0;

		for (int i = 0; i < text.length(); i++) {

			char ch = text.charAt(i);

			if (ch == '.' ||
				ch == '!' ||
				ch == '?') {

				sentences++;

			}
		}

		return sentences;
	}

	// METHOD TO REMOVE PUNCTUATION
	public static String removePunctuation(String text) {

		text = text.replace(".", "");
		text = text.replace(",", "");
		text = text.replace("!", "");
		text = text.replace("?", "");
		text = text.replace(";", "");
		text = text.replace(":", "");
		text = text.replace("\"", "");
		text = text.replace("(", "");
		text = text.replace(")", "");

		return text;
	}

	// METHOD TO ADD WORDS TO HASHMAP
	public static void addFrequency(
			String word,
			HashMap<String, Integer> frequency) {

		// Ignore common words
		if (word.equals("the") ||
			word.equals("a") ||
			word.equals("an") ||
			word.equals("and") ||
			word.equals("is")) {

			return;

		}

		// Check if word already exists
		if (frequency.containsKey(word)) {

			frequency.put(word,
					frequency.get(word) + 1);

		}
		else {

			frequency.put(word, 1);

		}
	}

	// METHOD TO PRINT WORD FREQUENCY
	public static void printFrequency(
			HashMap<String, Integer> frequency) {

		// Loop through HashMap
		for (Map.Entry<String, Integer> entry :
				frequency.entrySet()) {

			// Print word and frequency
			System.out.println(entry.getKey() +
								" - " +
								entry.getValue());
		}
	}

	// METHOD TO PRINT ARRAYLISTS
	public static void printList(
			ArrayList<String> list) {

		for (int i = 0; i < list.size(); i++) {

			System.out.print(list.get(i));

			if (i < list.size() - 1) {

				System.out.print(", ");

			}
		}

		System.out.println();
	}
}
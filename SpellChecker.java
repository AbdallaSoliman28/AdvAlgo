package task2;
// task 6
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SpellChecker {
    private Set<String> dictionary;
// This declare a public constructor that takes a parameter of type Set<String> and assigns it to the instance variable named dictionary.
    public SpellChecker(Set<String> dictionary) {
    	// Assign the parameter passed to the constructor to the instance variable named dictionary.
        this.dictionary = dictionary;
    }

    public List<String> check(String input) {
        List<String> result = new ArrayList<>();
        // This split the input string into an array of strings using whitespace as a delimiter and assign it to an array named words.
        String[] words = input.split("\\s+");
        // Loop through each string in the array named words.
        for (String word : words) {
        	// Check if the instance variable named dictionary does not contain the current string in the loop.
            if (!dictionary.contains(word)) {
                result.addAll(getSuggestions(word));
            } else {
                result.add(word);
            }
        }
        return result;
    }

    private List<String> getSuggestions(String word) {
        List<String> suggestions = new ArrayList<>();
        suggestions.addAll(getDeletions(word));
        suggestions.addAll(getInsertions(word));
        suggestions.addAll(getReplacements(word));
        return suggestions;
    }
// This method generates all possible words that can be generated by deleting one character from the input word. 
// It does this by looping through each character in the input word and deleting it one at a time. 
// It then adds the resulting string to a set of strings named deletions. Finally, it returns the set of strings.
    private Set<String> getDeletions(String word) {
        Set<String> deletions = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            StringBuilder sb = new StringBuilder(word);
            sb.deleteCharAt(i);
            deletions.add(sb.toString());
        }
        return deletions;
    }
//    This method generates all possible words that can be generated by inserting one character into the input word. 
//    It does this by looping through each position in the input word and each letter of the alphabet. 
//    It then inserts each letter of the alphabet at each position in the input word and adds the resulting string to a set of strings named insertions.
//    Finally, it returns the set of strings.
    private Set<String> getInsertions(String word) {
        Set<String> insertions = new HashSet<>();
        for (int i = 0; i <= word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                StringBuilder sb = new StringBuilder(word);
                sb.insert(i, c);
                insertions.add(sb.toString());
            }
        }
        return insertions;
    }
// This method generates all possible words that can be generated by replacing one character in the input word with another letter of the alphabet. 
// It does this by looping through each position in the input word and each letter of the alphabet. 
// It then replaces each character in the input word with each letter of the alphabet and adds the resulting string to a set of strings named replacements. 
// Finally, it returns the set of strings.
    private Set<String> getReplacements(String word) {
        Set<String> replacements = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                StringBuilder sb = new StringBuilder(word);
                sb.setCharAt(i, c);
                replacements.add(sb.toString());
            }
        }
        return replacements;
    }

    public static void main(String[] args) {
// This line creates a new set of strings named dictionary and initializes it with four strings: "the", "goat", "is", and "messi". 
// These are the words that the spell checker will use as its dictionary.
        Set<String> dictionary = new HashSet<>(Arrays.asList("the", "goat", "is", "messi"));
// This line creates a new instance of the SpellChecker class and passes the dictionary set to its constructor.
        SpellChecker spellChecker = new SpellChecker(dictionary);
// This line creates a new string named input and initializes it with the misspelled words "th", "got", "si", and "messy".
        String input = "th got si messy";
// This line calls the check method of the SpellChecker instance created earlier and passes it the input string. 
// The method returns a list of suggested corrections for each misspelled word in the input string, which is assigned to a list named result.      
        List<String> result = spellChecker.check(input);
        System.out.println(result);
    }
}

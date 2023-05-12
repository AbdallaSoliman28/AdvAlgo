package task2;
// task 6
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SpellChecker {
    private Set<String> dictionary;

    public SpellChecker(Set<String> dictionary) {
        this.dictionary = dictionary;
    }

    public List<String> check(String input) {
        List<String> result = new ArrayList<>();
        String[] words = input.split("\\s+");
        for (String word : words) {
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

    private Set<String> getDeletions(String word) {
        Set<String> deletions = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            StringBuilder sb = new StringBuilder(word);
            sb.deleteCharAt(i);
            deletions.add(sb.toString());
        }
        return deletions;
    }

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
        Set<String> dictionary = new HashSet<>(Arrays.asList("the", "goat", "is", "messi"));
        SpellChecker spellChecker = new SpellChecker(dictionary);
        String input = "th got si messy";
        List<String> result = spellChecker.check(input);
        System.out.println(result);
    }
}
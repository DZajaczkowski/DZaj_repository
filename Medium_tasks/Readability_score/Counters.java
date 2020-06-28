package readability;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Counters {
    static int sentenceCounter(String input) {
        String[] array = input.split("[!\\.\\?]\\s*");
        return array.length;
    }

    static int wordCounter(String input) {
        String[] array = input.split("[ \\s]+");
        return array.length;
    }

    static int charactersCounter(String input) {
        input = input.replaceAll("\\s", "");
        String[] array = input.split("");
        return array.length;
    }

    static int syllablesCounter(String input) {
        String[] array = input.split("[ \\s]+");
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            counter += syllablesCounterForWord(array[i]);
        }
        return counter;
    }

    static int polysyllablesCounter(String input) {
        String[] array = input.split("[ \\s]+");
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (syllablesCounterForWord(array[i]) > 2) {
                counter++;
            }
        }
        return counter;
    }

    static int syllablesCounterForWord(String word) {
        String i = "(?i)[aiouy][aeiouy]*|e(?!d?\\b)[aeiouy]*";
        Matcher m = Pattern.compile(i).matcher(word);
        int count = 0;
        while (m.find()) {
            count++;
        }
        return Math.max(count, 1);
    }
}

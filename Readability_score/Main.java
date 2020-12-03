package readability;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pathToFile = "D:\\DOMINIK\\Dokumenty\\in.txt";
        File file = new File(pathToFile);
        String input = "";
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                input += scanner.nextLine() + " ";
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + pathToFile);
        }
        int words = Counters.wordCounter(input);
        int sentences = Counters.sentenceCounter(input);
        int characters = Counters.charactersCounter(input);
        int syllables = Counters.syllablesCounter(input);
        int polysyllables = Counters.polysyllablesCounter(input);
        String textAnalysis = String.format("The text is:%n%s%n%nWords: %d%nSentences: %d%nCharacters: %d%nSyllables: %d%nPolysyllables: %d%nEnter the score you want to calculate (ARI, FK, SMOG, CL, all: ", input, words, sentences, characters, syllables, polysyllables);
        System.out.println(textAnalysis);
        Scores.printChosenScores(sc.nextLine(), words, sentences, characters, syllables, polysyllables);
    }
}
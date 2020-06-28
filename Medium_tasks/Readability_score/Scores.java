package readability;

public class Scores {

    static String ari(int words, int sentences, int characters) {
        double score = (4.71 * ((double) characters / words)) + (0.5 * ((double) words / sentences)) - 21.43;
        int score2 = (int) Math.round(score);
        String age = checkAge(score2);
        return String.format("Automated Readability Index: %.2f (about %s year olds).", score, age);
    }

    static String fk(int words, int sentences, int syllables) {
        double score = (0.39 * ((double) words / sentences)) + 11.8 * ((double) syllables / words) - 15.59;
        int score2 = (int) Math.round(score);
        String age = checkAge(score2);
        return String.format("Flesch–Kincaid readability tests: %.2f (about %s year olds).", score, age);
    }

    static String smog(int sentences, int polysyllables) {
        double score = 1.043 * Math.sqrt(polysyllables * (30 / (double) sentences)) + 3.1291;
        int score2 = (int) Math.round(score);
        String age = checkAge(score2);
        return String.format("Simple Measure of Gobbledygook: %.2f (about %s year olds).", score, age);
    }

    static String cl(int words, int sentences, int characters) {
        double s = (double) sentences / words * 100;
        double l = (double) characters / words * 100;
        double score = 0.0588 * l - 0.296 * s - 15.8;
        int score2 = (int) Math.round(score);
        String age = checkAge(score2);
        return String.format("Coleman–Liau index: %.2f (about %s year olds).", score, age);
    }

    static String checkAge(int score) {
        String age = "";
        switch (score) {
            case 1:
                age = "6";
                break;
            case 2:
                age = "7";
                break;
            case 3:
                age = "9";
                break;
            case 4:
                age = "10";
                break;
            case 5:
                age = "11";
                break;
            case 6:
                age = "12";
                break;
            case 7:
                age = "13";
                break;
            case 8:
                age = "14";
                break;
            case 9:
                age = "15";
                break;
            case 10:
                age = "16";
                break;
            case 11:
                age = "17";
                break;
            case 12:
                age = "18";
                break;
            case 13:
                age = "24";
                break;
            case 14:
                age = "24+";
                break;
        }
        return age;
    }

    static void printChosenScores(String decision, int words, int sentences, int characters, int syllables, int polysyllables) {
        String scoreARI = ari(words, sentences, characters);
        String scoreFK = fk(words, sentences, syllables);
        String scoreSMOG = smog(sentences, polysyllables);
        String scoreCL = cl(words, sentences, characters);
        switch (decision) {
            case "ARI":
                System.out.println();
                System.out.println(scoreARI);
                break;
            case "FK":
                System.out.println();
                System.out.println(scoreFK);
                break;
            case "SMOG":
                System.out.println();
                System.out.println(scoreSMOG);
                break;
            case "CL":
                System.out.println();
                System.out.println(scoreCL);
                break;
            case "all":
                System.out.println();
                System.out.println(scoreARI);
                System.out.println(scoreFK);
                System.out.println(scoreSMOG);
                System.out.println(scoreCL);
                break;
            default:
                System.out.println();
                System.out.println("Wrong input.");
        }
    }
}

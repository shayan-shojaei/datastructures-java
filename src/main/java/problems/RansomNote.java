package problems;

import java.util.HashMap;

public class RansomNote {
    public static void main(String[] args) {
//  INCORRECT
        String magazineTest1 = "This week in hollywood celebrities children have been kidnapped";
        String letterTest1 = "I've kidnapped your children";

//  CORRECT
        String magazineTest2 = "this punk should be giving me his money I'd Give him my money if he asks for it";
        String letterTest2 = "Give me my money punk";


//        naive methods
        System.out.println(matchNaive(magazineTest1, letterTest1));
        System.out.println(matchNaive(magazineTest2, letterTest2));

//        non-naive methods
        System.out.println(match(magazineTest1, letterTest1));
        System.out.println(match(magazineTest2, letterTest2));


    }

// M : count of words in the magazine
// L : count of words in the letter
//    assuming M > L

    //    time complexity = O(M * L)
    public static boolean matchNaive(String magazine, String letter) {
        for (String word : letter.split(" ")) {
            boolean foundMatch = false;
            for (String toMatch : magazine.split(" ")) {
                if (word.equals(toMatch)) {
                    foundMatch = true;
                    magazine = magazine.replaceFirst(toMatch, "");
                    break;
                }
            }
            if (!foundMatch) {
                return false;
            }
        }
        return true;
    }

    //    time complexity = O(M)
    public static boolean match(String magazine, String letter) {
        HashMap<String, Integer> magCount = new HashMap<>();
        HashMap<String, Integer> letterCount = new HashMap<>();
        for (String word : magazine.split(" ")) {
            magCount.put(word, magCount.getOrDefault(word, 0) + 1);
        }
        for (String word : letter.split(" ")) {
            letterCount.put(word, letterCount.getOrDefault(word, 0) + 1);
        }
        for (String word : letter.split(" ")) {
            if (magCount.getOrDefault(word, 0) < letterCount.get(word)) {
                return false;
            }
        }
        return true;
    }
}

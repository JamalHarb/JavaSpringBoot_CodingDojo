import java.util.Random;
import java.util.ArrayList;

public class PuzzleJava {
    public ArrayList<Integer> getTenRolls(int numOfRandIntegers, int min, int max) {
        Random r = new Random();
        ArrayList<Integer> tenRandomNumbers = new ArrayList<Integer>();
        for(int i = 0; i < numOfRandIntegers; i++){
            int randomNumber = r.ints(1, min, max + 1).findFirst().getAsInt();
            tenRandomNumbers.add(randomNumber);
        }
        return tenRandomNumbers;
    }
    public char getRandomLetter() {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        Random r = new Random();
        int randomNumber = r.nextInt(26);
        return alphabet[randomNumber];
    }
    public String generatePassword() {
        PuzzleJava master = new PuzzleJava();
        String pw = "";
        for(int i=0; i<8; i++){
            pw += master.getRandomLetter();
        }
        return pw;
    }
    public ArrayList<String> getNewPasswordSet(int length) {
        PuzzleJava master = new PuzzleJava();
        ArrayList<String> pwSet = new ArrayList<String>();
        for(int i=0; i<length; i++){
            pwSet.add(master.generatePassword());
        }
        return pwSet;
    }
}
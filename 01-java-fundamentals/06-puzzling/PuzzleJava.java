import java.util.Random;
import java.util.ArrayList;
public class PuzzleJava {
    public ArrayList getTenRolls() {
        ArrayList<Integer> array = new ArrayList<Integer>();
        Random rnd = new Random();
        for (int i = 1; i < 11; i++) {
            array.add(rnd.nextInt(21));
        }
        // System.out.println(array);
        return array;
    }

    public char getRandomLetter() {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char x;
        Random rnd = new Random();
        x = alphabet[rnd.nextInt(26)];
        // System.out.println(x);
        return x;
    }

    public String generatePassword() {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        Random rnd = new Random();
        StringBuilder x = new StringBuilder();
        for (int i = 1; i < 9; i++) {
            x.append(alphabet[rnd.nextInt(26)]);
        }
        String password = x.toString();
        // System.out.println(password);
        return password;
    }

    public ArrayList getNewPasswordSet(int length) {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        Random rnd = new Random();
        ArrayList<String> passwordArray = new ArrayList<String>();
        for (int y = 0; y < length; y++) {
            StringBuilder x = new StringBuilder();
            for (int i = 1; i < 9; i++) {
                x.append(alphabet[rnd.nextInt(26)]);
            }
            passwordArray.add(x.toString());
        }
        // System.out.println(passwordArray);
        return passwordArray;
    }
}
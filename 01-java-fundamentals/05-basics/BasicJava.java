import java.util.ArrayList;
public class BasicJava {
    public String oneToTwoFiveFive() {
        for (int i = 1; i < 256; i++) {
            System.out.println(Integer.toString(i));
        }
        return null;
    }

    public String oddOneToTwoFiveFive() {
        for (int i = 1; i < 256; i++) {
            if (i % 2 != 0) {
                System.out.println(Integer.toString(i));
            }
        }
        return null;
    }

    public Integer sumOneToTwoFiveFive() {
        Integer sum = 0;
        for (int i = 1; i < 256; i++) {
                sum = sum + i;
        }
        return sum;
    }

    public Integer iterateArray() {
        int[] testArray = {1,3,5,7,9,13};
        for (int number : testArray ) {
            System.out.println(number);
        }
        return null;
    }

    public Integer findMaxArray() {
        ArrayList<Integer> testArray = new ArrayList<Integer>();
        testArray.add(1);
        testArray.add(5);
        testArray.add(6);
        testArray.add(2);
        testArray.add(10);
        Integer max;
        max = testArray.get(0);
        for (int number : testArray ) {
            if (number > max) {
                max = number;
            }
        }
        System.out.println(max);
        return null;
    }

    public Integer oddArray() {
        ArrayList<Integer> y = new ArrayList<Integer>();
        for (int i = 1; i < 256; i++) {
            if (i % 2 != 0) {
                y.add(i);
            }
        }
        System.out.println(y);
        return null;
    }
}
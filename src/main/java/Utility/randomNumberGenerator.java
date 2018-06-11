package Utility;

import java.util.Random;

public class randomNumberGenerator {
    public static String generate() {
        char[] chars = "0123451234".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String output = sb.toString();
        return output;


    }
}

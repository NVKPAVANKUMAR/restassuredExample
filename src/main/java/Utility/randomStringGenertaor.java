package Utility;

import java.util.Random;

public class randomStringGenertaor {
    static char c1, c2;

    public static String number() {

        char[] chars1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char[] chars2 = "0123456789".toCharArray();

        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            c1 = chars1[random.nextInt(chars1.length)];
            sb.append(c1);
        }
        for (int j = 0; j < 4; j++) {
            c2 = chars2[random.nextInt(chars2.length)];
            sb.append(c2);
        }

        return (sb.toString());

    }
}

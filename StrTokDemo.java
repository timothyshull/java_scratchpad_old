package ch_3;

import java.util.StringTokenizer;

public class StrTokDemo {
    public static void main(String[] args) {
        StringTokenizer st = new StringTokenizer("Hello World of Java");
        while (st.hasMoreTokens())
            System.out.println("Token: " + st.nextToken());
    }
}

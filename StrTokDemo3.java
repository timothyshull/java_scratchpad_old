package ch_3;

import java.util.StringTokenizer;

public class StrTokDemo3 {
    public static void main(String[] args) {
        StringTokenizer st = new StringTokenizer("Hello, World|of|Java", ", |", true);
        while (st.hasMoreElements())
            System.out.println("Token: " + st.nextElement());
    }
}

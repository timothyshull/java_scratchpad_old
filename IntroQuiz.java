public class IntroQuiz {
    public static void main(String[] args) {
//        int x = 7;
//        int y = x;
//        x = 2;
//        System.out.println(x + ", " + y);

//        String s1 = new String("String 1");
//        String s2 = new String("String 1");
//        if (s1 == s2) {
//            System.out.println("Equal");
//        }
//        else {
//            System.out.println("Not equal");
//        }

        String string1 = new String("Coursera");
        char letter1 = string1.charAt(4);
        char letter2 = string1.charAt(5);
//        char letter3 = string1[4];
//        char letter4 = string1[5];
        System.out.println(letter1);
        System.out.println(letter2);
//        System.out.println(letter3);
//        System.out.println(letter4);

        String string2 = "this is a test.23,54,390.";
        System.out.println(string2.getTokens("[a-z0-9 ]+"));
        System.out.println(string2.getTokens("[^.,]+"));
        System.out.println(string2.getTokens("[a-z0-9]+"));
        System.out.println(string2.getTokens("[^ ]+"));
        System.out.println(string2.getTokens("[a-z ]+|[0-9]+"));

    }
}

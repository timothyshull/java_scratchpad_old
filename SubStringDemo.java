package ch_3;

public class SubStringDemo {
    public static void main(String[] args) {
        String a = "Java is great.";
        System.out.println(a);
        String b = a.substring(5);
        System.out.println(b);
        String c = a.substring(5, 7);
        System.out.println(c);
        String d = a.substring(5, a.length());
        System.out.println(d);
    }
}

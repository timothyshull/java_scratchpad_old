package ch_3;

public class StringBufferDemo {
    public static void main(String[] args) {
        String s1 = "Hello" + ", " + "World";
        System.out.println(s1);

        StringBuffer sb2 = new StringBuffer();
        sb2.append("Hello")
                .append(",")
                .append(" ")
                .append("World");
        String s2 = sb2.toString();
        System.out.println(s2);
    }
}

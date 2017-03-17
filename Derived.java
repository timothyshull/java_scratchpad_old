/**
 * Created by skull on 10/19/16.
 */
public class Derived extends Base {
    int b;

    Derived() {
        this.b = 11;
    }

    public static void main(String[] args) {
        Base b = new Base();
        Derived d = new Derived();
        System.out.println("test");
    }
}

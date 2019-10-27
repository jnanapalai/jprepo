package a;

public class A {
    private static String name = "test12";
    private static A a = new A();

    static {
        name = "test28";
    }

    public A(){
        name = "test3";
    }

    public static String print(){
        return a.name;
    };

    @Override
    public String toString() {
        return print();
    }

    public static void main(String[] args) {
        System.out.println(A.print());
    }
}

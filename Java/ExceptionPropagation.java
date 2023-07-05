public class ExceptionPropagation {

    void method2() {
        method1();
    }

    void method1() throws NullPointerException {
        // int i = 10 / 0;
        throw new ArithmeticException();
    }

    public static void main(String[] args) {
        ExceptionPropagation ex = new ExceptionPropagation();
        ex.method2();
    }
}

import java.io.IOException;
import java.lang.reflect.Method;

class Person {
    int id;
    final String name;

    Person(int id, String name) {
        this.id = id;
        this.name = name;
        System.out.println("Hii");
    }

    void display() {
        System.out.println(id + " " + name);
    }

}

class Emp {
    float salary = 10;

    Emp(int id, String name, float salary) {
        // super(id, name);// reusing parent constructor
        this.salary = salary;
    }

    Emp(float salary) {
        this.salary = salary;
    }

    void display(TestSuper5 ob) {
        // System.out.println(id + " " + name + " " + salary);
        System.out.println("Salray" + salary);
        ob.method();
    }

}

class TestSuper5 {
    public static void main(String[] args) {
        // Emp e1 = new Emp(1, "ankit", 45000f);
        // e1.display();
        // Person p = new Person(12, "Motu");
        // p.display();
        // method();
        // method(new Emp(200));
        System.out.println("Next Line1");
    }

    // static void method(Emp ob) {
    // ob.display();
    // }

    /**
     * 
     */
    static void method() {
        // try {
        // // throw new IOException();
        // int i = 10 / 0;
        // } finally {
        // System.out.println("I am Finally");
        // }
        System.out.println("Next Line");
    }

}

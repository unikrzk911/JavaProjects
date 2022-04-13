class Outer {
    public void outerFunction() {
        System.out.println("Outer class function called");
    }

    class Inner {
        public void innerFunction() {
            System.out.println("Inner class function called");
        }
    }
}

public class InnerClass {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.outerFunction();

        Outer.Inner inner = outer.new Inner();
        inner.innerFunction();
    }
}

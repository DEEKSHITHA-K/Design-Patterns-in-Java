/**
 * Visitor Pattern Example
 * Scenario: We want to add new operations over an object structure without changing the classes.
 * Why this is Visitor:
 * - The visitor contains new operations.
 * - The elements accept the visitor and call back with their type.
 */
public class VisitorExample {
    interface Element {
        void accept(Visitor visitor);
    }

    interface Visitor {
        void visit(Book book);
        void visit(Car car);
    }

    static class Book implements Element {
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    static class Car implements Element {
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    static class PriceVisitor implements Visitor {
        public void visit(Book book) {
            System.out.println("Price of book: 50");
        }

        public void visit(Car car) {
            System.out.println("Price of car: 10000");
        }
    }

    public static void main(String[] args) {
        Element[] elements = {new Book(), new Car()};
        Visitor visitor = new PriceVisitor();

        for (Element element : elements) {
            element.accept(visitor);
        }
    }
}

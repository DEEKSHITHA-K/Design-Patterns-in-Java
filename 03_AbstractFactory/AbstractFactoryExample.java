/**
 * Abstract Factory Pattern Example
 * Scenario: We need to create a family of related UI objects for different platforms.
 * Why this is Abstract Factory:
 * - The client uses an abstract factory interface.
 * - Each platform factory creates compatible objects.
 * - Switching platforms changes the product family without changing client code.
 *
 * Line-by-line explanation:
 * 1. Button and Checkbox are product interfaces.
 * 2. WindowsButton and MacButton are concrete products.
 * 3. GUIFactory defines how to create the related objects.
 * 4. WindowsFactory and MacFactory return matching products.
 * 5. The client only depends on the abstract interfaces.
 */
public class AbstractFactoryExample {
    interface Button {
        void paint();
    }

    interface Checkbox {
        void paint();
    }

    static class WindowsButton implements Button {
        public void paint() {
            System.out.println("Painting Windows button");
        }
    }

    static class MacButton implements Button {
        public void paint() {
            System.out.println("Painting Mac button");
        }
    }

    static class WindowsCheckbox implements Checkbox {
        public void paint() {
            System.out.println("Painting Windows checkbox");
        }
    }

    static class MacCheckbox implements Checkbox {
        public void paint() {
            System.out.println("Painting Mac checkbox");
        }
    }

    interface GUIFactory {
        Button createButton();
        Checkbox createCheckbox();
    }

    static class WindowsFactory implements GUIFactory {
        public Button createButton() {
            return new WindowsButton();
        }

        public Checkbox createCheckbox() {
            return new WindowsCheckbox();
        }
    }

    static class MacFactory implements GUIFactory {
        public Button createButton() {
            return new MacButton();
        }

        public Checkbox createCheckbox() {
            return new MacCheckbox();
        }
    }

    public static void main(String[] args) {
        GUIFactory factory = new WindowsFactory();
        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        button.paint();
        checkbox.paint();
    }
}

/**
 * Decorator Pattern Example
 * Scenario: We want to add features like milk and sugar to coffee dynamically.
 * Why this is Decorator:
 * - Each decorator wraps an existing coffee object.
 * - New behavior is added without changing the original class.
 */
public class DecoratorExample {
    interface Coffee {
        String getDescription();
        double cost();
    }

    static class SimpleCoffee implements Coffee {
        public String getDescription() {
            return "Plain coffee";
        }

        public double cost() {
            return 5.0;
        }
    }

    static abstract class CoffeeDecorator implements Coffee {
        protected final Coffee coffee;

        public CoffeeDecorator(Coffee coffee) {
            this.coffee = coffee;
        }

        public String getDescription() {
            return coffee.getDescription();
        }

        public double cost() {
            return coffee.cost();
        }
    }

    static class MilkDecorator extends CoffeeDecorator {
        public MilkDecorator(Coffee coffee) {
            super(coffee);
        }

        public String getDescription() {
            return coffee.getDescription() + ", milk";
        }

        public double cost() {
            return coffee.cost() + 1.5;
        }
    }

    static class SugarDecorator extends CoffeeDecorator {
        public SugarDecorator(Coffee coffee) {
            super(coffee);
        }

        public String getDescription() {
            return coffee.getDescription() + ", sugar";
        }

        public double cost() {
            return coffee.cost() + 0.5;
        }
    }

    public static void main(String[] args) {
        Coffee coffee = new SugarDecorator(new MilkDecorator(new SimpleCoffee()));
        System.out.println(coffee.getDescription());
        System.out.println("Cost: " + coffee.cost());
    }
}

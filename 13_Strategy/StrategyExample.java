/**
 * Strategy Pattern Example
 * Scenario: We need different payment methods that can be changed at runtime.
 * Why this is Strategy:
 * - The payment algorithm is encapsulated in different strategy classes.
 * - The context can switch strategies without changing its own code.
 */
public class StrategyExample {
    interface PaymentStrategy {
        void pay(int amount);
    }

    static class CreditCardPayment implements PaymentStrategy {
        public void pay(int amount) {
            System.out.println("Paid " + amount + " using Credit Card");
        }
    }

    static class PayPalPayment implements PaymentStrategy {
        public void pay(int amount) {
            System.out.println("Paid " + amount + " using PayPal");
        }
    }

    static class ShoppingCart {
        private PaymentStrategy paymentStrategy;

        public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
            this.paymentStrategy = paymentStrategy;
        }

        public void checkout(int amount) {
            paymentStrategy.pay(amount);
        }
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.setPaymentStrategy(new CreditCardPayment());
        cart.checkout(100);

        cart.setPaymentStrategy(new PayPalPayment());
        cart.checkout(200);
    }
}

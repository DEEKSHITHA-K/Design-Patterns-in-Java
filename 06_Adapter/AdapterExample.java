/**
 * Adapter Pattern Example
 * Scenario: A legacy payment system must work with a new interface.
 * Why this is Adapter:
 * - The adapter converts the old method call into the new expected interface.
 * - The client remains unchanged.
 */
public class AdapterExample {
    interface PaymentProcessor {
        void pay(int amount);
    }

    static class OldPaymentSystem {
        public void makePayment(int amount) {
            System.out.println("Old system paid: " + amount);
        }
    }

    static class PaymentAdapter implements PaymentProcessor {
        private final OldPaymentSystem oldSystem;

        public PaymentAdapter(OldPaymentSystem oldSystem) {
            this.oldSystem = oldSystem;
        }

        public void pay(int amount) {
            oldSystem.makePayment(amount);
        }
    }

    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentAdapter(new OldPaymentSystem());
        processor.pay(150);
    }
}

/**
 * Factory Method Pattern Example
 * Scenario: We want to create different notification objects without knowing the exact type.
 * Why this is Factory Method:
 * - The creation logic is moved to subclasses.
 * - The client only asks for a notification object.
 * - New notification types can be added without changing the client logic.
 *
 * Line-by-line explanation:
 * 1. interface Notification declares the common operation.
 * 2. Each concrete class implements the same behavior differently.
 * 3. abstract class NotificationCreator defines the template for creation.
 * 4. createNotification() is the factory method that subclasses override.
 * 5. sendNotification() uses the created object without caring about the type.
 */
public class FactoryMethodExample {
    interface Notification {
        void send();
    }

    static class EmailNotification implements Notification {
        public void send() {
            System.out.println("Sending email notification");
        }
    }

    static class SmsNotification implements Notification {
        public void send() {
            System.out.println("Sending SMS notification");
        }
    }

    static abstract class NotificationCreator {
        public void sendNotification() {
            Notification notification = createNotification();
            notification.send();
        }

        protected abstract Notification createNotification();
    }

    static class EmailCreator extends NotificationCreator {
        protected Notification createNotification() {
            return new EmailNotification();
        }
    }

    static class SmsCreator extends NotificationCreator {
        protected Notification createNotification() {
            return new SmsNotification();
        }
    }

    public static void main(String[] args) {
        NotificationCreator emailCreator = new EmailCreator();
        NotificationCreator smsCreator = new SmsCreator();

        emailCreator.sendNotification();
        smsCreator.sendNotification();
    }
}

/**
 * Observer Pattern Example
 * Scenario: A subject should notify many observers about changes.
 * Why this is Observer:
 * - Observers subscribe to a subject.
 * - When the subject changes, it notifies all subscribed observers.
 */
import java.util.ArrayList;
import java.util.List;

public class ObserverExample {
    interface Observer {
        void update(String message);
    }

    static class Subject {
        private final List<Observer> observers = new ArrayList<>();

        public void addObserver(Observer observer) {
            observers.add(observer);
        }

        public void notifyObservers(String message) {
            for (Observer observer : observers) {
                observer.update(message);
            }
        }
    }

    static class EmailObserver implements Observer {
        public void update(String message) {
            System.out.println("Email received: " + message);
        }
    }

    static class SmsObserver implements Observer {
        public void update(String message) {
            System.out.println("SMS received: " + message);
        }
    }

    public static void main(String[] args) {
        Subject subject = new Subject();
        subject.addObserver(new EmailObserver());
        subject.addObserver(new SmsObserver());

        subject.notifyObservers("Order placed");
    }
}

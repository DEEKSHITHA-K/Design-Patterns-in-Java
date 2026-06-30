/**
 * Mediator Pattern Example
 * Scenario: Many objects need to interact through a central controller.
 * Why this is Mediator:
 * - The mediator manages communication between objects.
 * - Colleagues do not talk to each other directly.
 */
public class MediatorExample {
    interface ChatMediator {
        void sendMessage(String message, User user);
    }

    static class User {
        private final String name;
        private final ChatMediator mediator;

        public User(String name, ChatMediator mediator) {
            this.name = name;
            this.mediator = mediator;
        }

        public void send(String message) {
            mediator.sendMessage(message, this);
        }

        public void receive(String message) {
            System.out.println(name + " received: " + message);
        }
    }

    static class ChatRoom implements ChatMediator {
        public void sendMessage(String message, User user) {
            System.out.println("Broadcasting message...");
            user.receive(message);
        }
    }

    public static void main(String[] args) {
        ChatMediator mediator = new ChatRoom();
        User alice = new User("Alice", mediator);
        User bob = new User("Bob", mediator);

        alice.send("Hello Bob");
    }
}

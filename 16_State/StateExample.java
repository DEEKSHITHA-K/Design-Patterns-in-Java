/**
 * State Pattern Example
 * Scenario: We need an object whose behavior changes based on its current state.
 * Why this is State:
 * - The behavior is moved into state classes.
 * - The context delegates work to the current state.
 */
public class StateExample {
    interface State {
        void handle();
    }

    static class StartState implements State {
        public void handle() {
            System.out.println("Starting...");
        }
    }

    static class StopState implements State {
        public void handle() {
            System.out.println("Stopping...");
        }
    }

    static class Context {
        private State state;

        public void setState(State state) {
            this.state = state;
        }

        public void request() {
            state.handle();
        }
    }

    public static void main(String[] args) {
        Context context = new Context();
        context.setState(new StartState());
        context.request();

        context.setState(new StopState());
        context.request();
    }
}

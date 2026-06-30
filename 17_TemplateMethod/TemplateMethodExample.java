/**
 * Template Method Pattern Example
 * Scenario: We want to define the skeleton of an algorithm and let subclasses fill in steps.
 * Why this is Template Method:
 * - The base class defines the algorithm structure.
 * - Subclasses override only the changing steps.
 */
public class TemplateMethodExample {
    abstract static class Game {
        public final void play() {
            start();
            end();
        }

        protected abstract void start();
        protected abstract void end();
    }

    static class Cricket extends Game {
        protected void start() {
            System.out.println("Cricket game started");
        }

        protected void end() {
            System.out.println("Cricket game ended");
        }
    }

    static class Football extends Game {
        protected void start() {
            System.out.println("Football game started");
        }

        protected void end() {
            System.out.println("Football game ended");
        }
    }

    public static void main(String[] args) {
        Game cricket = new Cricket();
        Game football = new Football();

        cricket.play();
        football.play();
    }
}

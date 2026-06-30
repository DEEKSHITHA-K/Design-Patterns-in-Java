/**
 * Singleton Pattern Example
 * Scenario: We need exactly one logger instance in the whole application.
 * Why this is Singleton:
 * - The class keeps a single shared instance.
 * - The constructor is private, so no one can create extra instances.
 * - The static getInstance() method returns the same object every time.
 *
 * Line-by-line explanation:
 * 1. private static Logger instance; stores the single shared object.
 * 2. private Logger() {} prevents direct object creation from outside.
 * 3. public static Logger getInstance() provides the only access point.
 * 4. if (instance == null) creates the object only once.
 * 5. return instance; returns the same object on every call.
 */
public class SingletonExample {
    static class Logger {
        private static Logger instance;

        private Logger() {
        }

        public static Logger getInstance() {
            if (instance == null) {
                instance = new Logger();
            }
            return instance;
        }

        public void log(String message) {
            System.out.println("[LOG] " + message);
        }
    }

    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("Application started");
        System.out.println("Same instance? " + (logger1 == logger2));
    }
}

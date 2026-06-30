/**
 * Facade Pattern Example
 * Scenario: A complex subsystem should be accessed through a simple interface.
 * Why this is Facade:
 * - The facade hides the subsystem details.
 * - The client uses one simple method instead of coordinating several classes.
 */
public class FacadeExample {
    static class CPU {
        public void start() {
            System.out.println("CPU started");
        }
    }

    static class Memory {
        public void load() {
            System.out.println("Memory loaded");
        }
    }

    static class ComputerFacade {
        private final CPU cpu;
        private final Memory memory;

        public ComputerFacade() {
            this.cpu = new CPU();
            this.memory = new Memory();
        }

        public void startComputer() {
            cpu.start();
            memory.load();
            System.out.println("Computer is ready");
        }
    }

    public static void main(String[] args) {
        ComputerFacade facade = new ComputerFacade();
        facade.startComputer();
    }
}

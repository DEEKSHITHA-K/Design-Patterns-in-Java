/**
 * Command Pattern Example
 * Scenario: We want to encapsulate actions such as turning a light on or off.
 * Why this is Command:
 * - Every action is wrapped in an object.
 * - The invoker does not need to know the details of execution.
 */
public class CommandExample {
    interface Command {
        void execute();
    }

    static class Light {
        public void on() {
            System.out.println("Light turned on");
        }

        public void off() {
            System.out.println("Light turned off");
        }
    }

    static class LightOnCommand implements Command {
        private final Light light;

        public LightOnCommand(Light light) {
            this.light = light;
        }

        public void execute() {
            light.on();
        }
    }

    static class LightOffCommand implements Command {
        private final Light light;

        public LightOffCommand(Light light) {
            this.light = light;
        }

        public void execute() {
            light.off();
        }
    }

    static class RemoteControl {
        private Command command;

        public void setCommand(Command command) {
            this.command = command;
        }

        public void pressButton() {
            command.execute();
        }
    }

    public static void main(String[] args) {
        Light light = new Light();
        RemoteControl remote = new RemoteControl();

        remote.setCommand(new LightOnCommand(light));
        remote.pressButton();

        remote.setCommand(new LightOffCommand(light));
        remote.pressButton();
    }
}

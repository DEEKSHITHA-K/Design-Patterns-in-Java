/**
 * Bridge Pattern Example
 * Scenario: We want to separate the abstraction from the implementation.
 * Why this is Bridge:
 * - Remote is the abstraction.
 * - Device is the implementation interface.
 * - They can vary independently.
 */
public class BridgeExample {
    interface Device {
        void turnOn();
    }

    static class TV implements Device {
        public void turnOn() {
            System.out.println("TV is ON");
        }
    }

    static class Radio implements Device {
        public void turnOn() {
            System.out.println("Radio is ON");
        }
    }

    static class Remote {
        protected final Device device;

        public Remote(Device device) {
            this.device = device;
        }

        public void turnOn() {
            device.turnOn();
        }
    }

    public static void main(String[] args) {
        Remote remote = new Remote(new TV());
        remote.turnOn();
    }
}

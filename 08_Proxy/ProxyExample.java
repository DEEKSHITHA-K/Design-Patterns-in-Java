/**
 * Proxy Pattern Example
 * Scenario: We want to delay the creation of a resource-heavy object until needed.
 * Why this is Proxy:
 * - The proxy controls access to the real object.
 * - The real object is created only when it is actually used.
 */
public class ProxyExample {
    interface Image {
        void display();
    }

    static class RealImage implements Image {
        private final String filename;

        public RealImage(String filename) {
            this.filename = filename;
            loadFromDisk();
        }

        private void loadFromDisk() {
            System.out.println("Loading image from disk: " + filename);
        }

        public void display() {
            System.out.println("Displaying image: " + filename);
        }
    }

    static class ProxyImage implements Image {
        private RealImage realImage;
        private final String filename;

        public ProxyImage(String filename) {
            this.filename = filename;
        }

        public void display() {
            if (realImage == null) {
                realImage = new RealImage(filename);
            }
            realImage.display();
        }
    }

    public static void main(String[] args) {
        Image image = new ProxyImage("photo.png");
        image.display();
    }
}

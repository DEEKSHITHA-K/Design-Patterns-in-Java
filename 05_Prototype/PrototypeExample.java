/**
 * Prototype Pattern Example
 * Scenario: We need to create many similar objects quickly.
 * Why this is Prototype:
 * - The object can clone itself instead of being built from scratch.
 * - This reduces initialization cost and keeps creation logic inside the object.
 */
public class PrototypeExample {
    static class Document implements Cloneable {
        private String title;
        private String content;

        public Document(String title, String content) {
            this.title = title;
            this.content = content;
        }

        public Document cloneDocument() {
            try {
                return (Document) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }

        public void show() {
            System.out.println("Document: " + title + " -> " + content);
        }
    }

    public static void main(String[] args) {
        Document original = new Document("Report", "Quarterly summary");
        Document copy = original.cloneDocument();

        copy.show();
        System.out.println("Same object? " + (original == copy));
    }
}

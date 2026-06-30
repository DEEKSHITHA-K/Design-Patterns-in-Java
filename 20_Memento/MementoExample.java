/**
 * Memento Pattern Example
 * Scenario: We want to support undo by saving object state.
 * Why this is Memento:
 * - The memento stores a snapshot of the state.
 * - The originator can restore the earlier state later.
 */
public class MementoExample {
    static class Memento {
        private final String state;

        public Memento(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }
    }

    static class Editor {
        private String content;

        public void setContent(String content) {
            this.content = content;
        }

        public Memento save() {
            return new Memento(content);
        }

        public void restore(Memento memento) {
            this.content = memento.getState();
        }

        public void show() {
            System.out.println("Current content: " + content);
        }
    }

    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.setContent("First draft");
        Memento saved = editor.save();

        editor.setContent("Second draft");
        editor.show();

        editor.restore(saved);
        editor.show();
    }
}

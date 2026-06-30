/**
 * Composite Pattern Example
 * Scenario: We need to model a tree structure such as folders and files.
 * Why this is Composite:
 * - Both leaf and container objects implement the same interface.
 * - The client can treat them uniformly.
 */
import java.util.ArrayList;
import java.util.List;

public class CompositeExample {
    interface FileComponent {
        void show();
    }

    static class File implements FileComponent {
        private final String name;

        public File(String name) {
            this.name = name;
        }

        public void show() {
            System.out.println("File: " + name);
        }
    }

    static class Folder implements FileComponent {
        private final String name;
        private final List<FileComponent> children = new ArrayList<>();

        public Folder(String name) {
            this.name = name;
        }

        public void add(FileComponent component) {
            children.add(component);
        }

        public void show() {
            System.out.println("Folder: " + name);
            for (FileComponent child : children) {
                child.show();
            }
        }
    }

    public static void main(String[] args) {
        Folder root = new Folder("root");
        root.add(new File("notes.txt"));

        Folder subFolder = new Folder("docs");
        subFolder.add(new File("guide.pdf"));
        root.add(subFolder);

        root.show();
    }
}

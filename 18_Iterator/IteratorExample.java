/**
 * Iterator Pattern Example
 * Scenario: We want to traverse a collection without exposing its internal structure.
 * Why this is Iterator:
 * - The iterator encapsulates traversal logic.
 * - The client uses a common interface to iterate over elements.
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Asha");
        names.add("Bharat");
        names.add("Chetan");

        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

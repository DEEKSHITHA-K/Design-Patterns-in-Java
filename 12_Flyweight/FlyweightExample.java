/**
 * Flyweight Pattern Example
 * Scenario: We need to create many similar objects efficiently.
 * Why this is Flyweight:
 * - Shared intrinsic state is stored once.
 * - Repeated objects reuse the shared data instead of creating duplicates.
 */
import java.util.HashMap;
import java.util.Map;

public class FlyweightExample {
    static class CharacterFlyweight {
        private final char symbol;

        public CharacterFlyweight(char symbol) {
            this.symbol = symbol;
        }

        public void display() {
            System.out.println("Character: " + symbol);
        }
    }

    static class CharacterFactory {
        private static final Map<Character, CharacterFlyweight> pool = new HashMap<>();

        public static CharacterFlyweight getCharacter(char symbol) {
            CharacterFlyweight flyweight = pool.get(symbol);
            if (flyweight == null) {
                flyweight = new CharacterFlyweight(symbol);
                pool.put(symbol, flyweight);
            }
            return flyweight;
        }
    }

    public static void main(String[] args) {
        CharacterFlyweight a1 = CharacterFactory.getCharacter('A');
        CharacterFlyweight a2 = CharacterFactory.getCharacter('A');

        a1.display();
        a2.display();
        System.out.println("Same object? " + (a1 == a2));
    }
}

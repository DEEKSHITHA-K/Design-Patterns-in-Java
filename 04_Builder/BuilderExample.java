/**
 * Builder Pattern Example
 * Scenario: We need to create a complex object with many optional fields.
 * Why this is Builder:
 * - The object is constructed step by step.
 * - The constructor remains simple and safe.
 * - The client can set only the fields it needs.
 *
 * Line-by-line explanation:
 * 1. The User class has a private constructor to force builder usage.
 * 2. The Builder class holds the temporary values.
 * 3. Each setter returns the builder so calls can be chained.
 * 4. build() creates the final object using the collected values.
 */
public class BuilderExample {
    static class User {
        private final String name;
        private final int age;
        private final String email;

        private User(Builder builder) {
            this.name = builder.name;
            this.age = builder.age;
            this.email = builder.email;
        }

        public String toString() {
            return "User{name='" + name + "', age=" + age + ", email='" + email + "'}";
        }

        static class Builder {
            private String name;
            private int age;
            private String email;

            public Builder setName(String name) {
                this.name = name;
                return this;
            }

            public Builder setAge(int age) {
                this.age = age;
                return this;
            }

            public Builder setEmail(String email) {
                this.email = email;
                return this;
            }

            public User build() {
                return new User(this);
            }
        }
    }

    public static void main(String[] args) {
        User user = new User.Builder()
                .setName("Deekshitha")
                .setAge(25)
                .setEmail("deek@example.com")
                .build();

        System.out.println(user);
    }
}

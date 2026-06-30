/**
 * Interpreter Pattern Example
 * Scenario: We need to interpret a simple expression language.
 * Why this is Interpreter:
 * - Each expression is represented as an object.
 * - The context is evaluated by combining these objects.
 */
public class InterpreterExample {
    interface Expression {
        boolean interpret(String context);
    }

    static class TerminalExpression implements Expression {
        private final String data;

        public TerminalExpression(String data) {
            this.data = data;
        }

        public boolean interpret(String context) {
            return context.contains(data);
        }
    }

    static class AndExpression implements Expression {
        private final Expression left;
        private final Expression right;

        public AndExpression(Expression left, Expression right) {
            this.left = left;
            this.right = right;
        }

        public boolean interpret(String context) {
            return left.interpret(context) && right.interpret(context);
        }
    }

    public static void main(String[] args) {
        Expression expression = new AndExpression(
                new TerminalExpression("Java"),
                new TerminalExpression("Design")
        );

        System.out.println(expression.interpret("Java Design Patterns"));
    }
}

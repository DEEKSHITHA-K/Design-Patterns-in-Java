/**
 * Chain of Responsibility Pattern Example
 * Scenario: A request should be handled by the first suitable handler in a chain.
 * Why this is Chain of Responsibility:
 * - Each handler decides whether to process the request or pass it to the next handler.
 */
public class ChainOfResponsibilityExample {
    abstract static class Handler {
        protected Handler next;

        public void setNext(Handler next) {
            this.next = next;
        }

        public void handleRequest(String request) {
            if (canHandle(request)) {
                process(request);
            } else if (next != null) {
                next.handleRequest(request);
            } else {
                System.out.println("No handler available");
            }
        }

        protected abstract boolean canHandle(String request);
        protected abstract void process(String request);
    }

    static class EmailHandler extends Handler {
        protected boolean canHandle(String request) {
            return request.equals("email");
        }

        protected void process(String request) {
            System.out.println("Handling email request");
        }
    }

    static class SmsHandler extends Handler {
        protected boolean canHandle(String request) {
            return request.equals("sms");
        }

        protected void process(String request) {
            System.out.println("Handling sms request");
        }
    }

    public static void main(String[] args) {
        Handler emailHandler = new EmailHandler();
        Handler smsHandler = new SmsHandler();
        emailHandler.setNext(smsHandler);

        emailHandler.handleRequest("sms");
    }
}

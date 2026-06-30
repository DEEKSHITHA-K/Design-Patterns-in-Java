Perfect Deekshitha 👩🏻‍💻

Now I’ll give you **all 23 GoF Design Patterns** with:

- ✅ Clear scenario
- ✅ Simple Java-style example
- ✅ Where it’s used in real life

No confusion. Clean notes. Save this properly.

Reference: 📘

---

# 🟢 CREATIONAL PATTERNS (5)

---

## 1️⃣ Singleton

### ✅ Scenario

Only one instance of Logger in application.

### ✅ Example

```java
class Logger {
    private static Logger instance;

    private Logger() {}

    public static Logger getInstance() {
        if (instance == null)
            instance = new Logger();
        return instance;
    }

    public void log(String msg) {
        System.out.println(msg);
    }
}
```

### ✅ Real World

Spring beans are singleton by default.

---

## 2️⃣ Factory Method

### ✅ Scenario

Creating different types of notifications.

```java
interface Notification {
    void send();
}

class EmailNotification implements Notification {
    public void send() { System.out.println("Email sent"); }
}

class SMSNotification implements Notification {
    public void send() { System.out.println("SMS sent"); }
}

class NotificationFactory {
    public static Notification create(String type) {
        if(type.equals("email")) return new EmailNotification();
        else return new SMSNotification();
    }
}
```

---

## 3️⃣ Abstract Factory

### ✅ Scenario

Creating UI elements for Windows and Mac.

```java
interface Button { void paint(); }
interface Checkbox { void paint(); }

class WindowsButton implements Button {
    public void paint() { System.out.println("Windows Button"); }
}

class MacButton implements Button {
    public void paint() { System.out.println("Mac Button"); }
}

interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
```

👉 Used in cross-platform frameworks.

---

## 4️⃣ Builder

### ✅ Scenario

Building a complex User object.

```java
class User {
    private String name;
    private int age;

    private User(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
    }

    static class Builder {
        private String name;
        private int age;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
```

Used in many Java libraries.

---

## 5️⃣ Prototype

### ✅ Scenario

Cloning a document.

```java
class Document implements Cloneable {
    String content;

    public Document clone() throws CloneNotSupportedException {
        return (Document) super.clone();
    }
}
```

---

# 🔵 STRUCTURAL PATTERNS (7)

---

## 6️⃣ Adapter

### ✅ Scenario

Old payment system adapting to new interface.

```java
interface PaymentProcessor {
    void pay(int amount);
}

class OldPaymentSystem {
    void makePayment(int amount) {
        System.out.println("Paid: " + amount);
    }
}

class PaymentAdapter implements PaymentProcessor {
    private OldPaymentSystem oldSystem;

    PaymentAdapter(OldPaymentSystem oldSystem) {
        this.oldSystem = oldSystem;
    }

    public void pay(int amount) {
        oldSystem.makePayment(amount);
    }
}
```

---

## 7️⃣ Decorator

### ✅ Scenario

Adding milk and sugar to coffee.

```java
interface Coffee {
    String getDescription();
}

class SimpleCoffee implements Coffee {
    public String getDescription() {
        return "Plain Coffee";
    }
}

class MilkDecorator implements Coffee {
    private Coffee coffee;
    MilkDecorator(Coffee coffee) { this.coffee = coffee; }

    public String getDescription() {
        return coffee.getDescription() + ", Milk";
    }
}
```

---

## 8️⃣ Proxy

### ✅ Scenario

Lazy loading image.

```java
interface Image {
    void display();
}

class RealImage implements Image {
    public RealImage(String filename) {
        System.out.println("Loading image...");
    }

    public void display() {
        System.out.println("Displaying image");
    }
}

class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    ProxyImage(String filename) {
        this.filename = filename;
    }

    public void display() {
        if(realImage == null)
            realImage = new RealImage(filename);
        realImage.display();
    }
}
```

---

## 9️⃣ Facade

### ✅ Scenario

Simplified interface for complex system.

```java
class CPU { void start() {} }
class Memory { void load() {} }

class ComputerFacade {
    private CPU cpu = new CPU();
    private Memory memory = new Memory();

    void startComputer() {
        cpu.start();
        memory.load();
    }
}
```

---

## 🔟 Composite

### ✅ Scenario

File system structure.

```java
interface FileComponent {
    void show();
}

class File implements FileComponent {
    public void show() {
        System.out.println("File");
    }
}

class Folder implements FileComponent {
    List<FileComponent> components = new ArrayList<>();

    public void add(FileComponent component) {
        components.add(component);
    }

    public void show() {
        for(FileComponent c : components)
            c.show();
    }
}
```

---

## 1️⃣1️⃣ Bridge

### ✅ Scenario

Remote and TV separated.

```java
interface Device {
    void on();
}

class TV implements Device {
    public void on() { System.out.println("TV On"); }
}

class Remote {
    protected Device device;
    Remote(Device device) { this.device = device; }

    void turnOn() { device.on(); }
}
```

---

## 1️⃣2️⃣ Flyweight

### ✅ Scenario

Sharing common objects (e.g., characters in text editor).

```java
class Character {
    private char value;
    Character(char value) { this.value = value; }
}
```

Instead of creating new object for each letter, reuse.

---

# 🟣 BEHAVIORAL PATTERNS (11)

---

## 1️⃣3️⃣ Strategy

```java
interface PaymentStrategy {
    void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid by card");
    }
}
```

---

## 1️⃣4️⃣ Observer

```java
interface Observer {
    void update();
}

class Subject {
    List<Observer> observers = new ArrayList<>();

    void addObserver(Observer o) {
        observers.add(o);
    }

    void notifyObservers() {
        for(Observer o : observers)
            o.update();
    }
}
```

---

## 1️⃣5️⃣ Command

```java
interface Command {
    void execute();
}

class LightOnCommand implements Command {
    public void execute() {
        System.out.println("Light On");
    }
}
```

---

## 1️⃣6️⃣ State

```java
interface State {
    void handle();
}

class StartState implements State {
    public void handle() {
        System.out.println("Started");
    }
}
```

---

## 1️⃣7️⃣ Template Method

```java
abstract class Game {
    final void play() {
        start();
        end();
    }

    abstract void start();
    abstract void end();
}
```

---

## 1️⃣8️⃣ Iterator

```java
Iterator<Integer> it = list.iterator();
```

---

## 1️⃣9️⃣ Mediator

### ✅ Scenario

Chat room controlling communication.

```java
interface ChatMediator {
    void sendMessage(String msg);
}
```

---

## 2️⃣0️⃣ Memento

### ✅ Scenario

Undo feature.

```java
class Memento {
    private String state;
    Memento(String state) { this.state = state; }
}
```

---

## 2️⃣1️⃣ Chain of Responsibility

```java
abstract class Handler {
    protected Handler next;

    void setNext(Handler next) {
        this.next = next;
    }
}
```

---

## 2️⃣2️⃣ Visitor

```java
interface Visitor {
    void visit(Element element);
}
```

---

## 2️⃣3️⃣ Interpreter

```java
interface Expression {
    boolean interpret(String context);
}
```

Used in parsing.

---

# 🧠 Important For You

Since you're growing into deeper system understanding:

Focus strongly on:

- Factory
- Abstract Factory
- Builder
- Strategy
- Observer
- Decorator
- Proxy
- State

These appear everywhere in Spring and enterprise systems.

---

If you want next, I can:

- Explain difference between confusing patterns (Factory vs Abstract Factory, Strategy vs State)
- Give you real Spring framework mapping
- Or give interview-ready answers

Tell me which direction you want to go 👩🏻‍💻
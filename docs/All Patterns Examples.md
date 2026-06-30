Here is the complete reference catalog for the 23 classic Gang of Four (GoF) design patterns implemented in Java. Each pattern includes **where to use it (the problem)**, **why to use it (the benefit)**, and a **clean, production-ready prototype code example**.

## 1. Creational Patterns

These patterns handle object creation mechanisms, optimizing flexibility and reuse of code.

### Singleton

- **Where to use:** When a class must have exactly one instance across the entire application (e.g., database connection pools, configuration managers, thread pools).
- **Why to use:** It saves system memory by preventing repetitive allocations and provides a global access point to that single instance.

```java
public class DatabaseConnection {
    // Volatile keyword ensures visibility across multiple threads
    private static volatile DatabaseConnection instance;

    private DatabaseConnection() {} // Prevents direct instantiation

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) { // Double-checked locking
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }

    public void query(String sql) { System.out.println("Executing: " + sql); }
}
```

### Factory Method

- **Where to use:** When a class cannot anticipate the exact class of objects it needs to create, or when you want to delegate creation logic to subclasses.
- **Why to use:** It decouples the creator logic from the concrete product implementations, obeying the Open/Closed Principle.

```java
interface Transport { void deliver(); }
class Truck implements Transport { public void deliver() { System.out.println("Delivering by land."); } }
class Ship implements Transport { public void deliver() { System.out.println("Delivering by sea."); } }

abstract class Logistics {
    public abstract Transport createTransport();
    public void planDelivery() {
        Transport transport = createTransport();
        transport.deliver();
    }
}

class RoadLogistics extends Logistics {
    public Transport createTransport() { return new Truck(); }
}
```

### Abstract Factory

- **Where to use:** When your system needs to create families of related or dependent objects without specifying their concrete classes (e.g., cross-platform UI components).
- **Why to use:** It guarantees that the objects you get from a factory are compatible with one another.

```java
interface Button { void render(); }
interface Checkbox { void toggle(); }

interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

class MacFactory implements GUIFactory {
    public Button createButton() { return () -> System.out.println("Mac Button"); }
    public Checkbox createCheckbox() { return () -> System.out.println("Mac Checkbox"); }
}
```

### Builder

- **Where to use:** When an object requires a complex, multi-step initialization process or has a massive number of optional parameters (anti-pattern: "telescoping constructors").
- **Why to use:** It separates the construction of a complex object from its representation, allowing the same construction process to create different variations.

```java
public class House {
    private final int walls;
    private final boolean hasPool;

    private House(Builder builder) {
        this.walls = builder.walls;
        this.hasPool = builder.hasPool;
    }

    public static class Builder {
        private int walls;
        private boolean hasPool;

        public Builder buildWalls(int walls) { this.walls = walls; return this; }
        public Builder addPool(boolean hasPool) { this.hasPool = hasPool; return this; }
        public House build() { return new House(this); }
    }
}
// Usage: House house = new House.Builder().buildWalls(4).addPool(true).build();
```

### Prototype

- **Where to use:** When creating an object from scratch is resource-heavy or complex, but you already have a similar object instance available.
- **Why to use:** It allows you to clone existing objects directly without coupling your code to their specific concrete classes.

```java
interface Prototype { Prototype clone(); }

class Monster implements Prototype {
    private final int health;
    private final String type;

    public Monster(int health, String type) { this.health = health; this.type = type; }

    @Override
    public Prototype clone() { return new Monster(this.health, this.type); }
}
```

## 2. Structural Patterns

These patterns dictate how classes and objects compose to form larger, efficient structures.

### Adapter

- **Where to use:** When you need an intermediate layer to translate data or interfaces between two legacy/third-party systems that are otherwise incompatible.
- **Why to use:** It allows otherwise incompatible classes to work together seamlessly without modifying their source code.

```java
class LegacyXMLBackend { public String getXMLData() { return "<data>Value</data>"; } }
interface ModernJSONClient { String getJSON(); }

class XMLToJSONAdapter implements ModernJSONClient {
    private final LegacyXMLBackend legacySystem;

    public XMLToJSONAdapter(LegacyXMLBackend legacySystem) { this.legacySystem = legacySystem; }

    public String getJSON() {
        String xml = legacySystem.getXMLData();
        return "{ \"data\": \"Converted from XML\" }";
    }
}
```

### Bridge

- **Where to use:** When you want to divide an abstraction and its implementation into two independent class hierarchies (e.g., differing remote controls running on differing brands of TVs).
- **Why to use:** Avoids an exponential explosion of combination subclasses by swapping a monolithic inheritance tree with composition.

```java
interface Device { void turnOn(); }
class TV implements Device { public void turnOn() { System.out.println("TV On"); } }

abstract class RemoteControl {
    protected Device device;
    public RemoteControl(Device device) { this.device = device; }
    public abstract void togglePower();
}

class AdvancedRemote extends RemoteControl {
    public AdvancedRemote(Device device) { super(device); }
    public void togglePower() { device.turnOn(); }
}
```

### Composite

- **Where to use:** When you need to represent part-whole hierarchies of objects, treating individual components and collections uniformly (e.g., file systems, organization charts).
- **Why to use:** Simplifies client code by letting clients treat primitive leaves and complex composite branches identically.

```java
import java.util.*;

interface FileSystemItem { int getSize(); }

class FileItem implements FileSystemItem {
    private final int size;
    public FileItem(int size) { this.size = size; }
    public int getSize() { return size; }
}

class Folder implements FileSystemItem {
    private final List<FileSystemItem> children = new ArrayList<>();

    public void add(FileSystemItem item) { children.add(item); }
    public int getSize() { return children.stream().mapToInt(FileSystemItem::getSize).sum(); }
}
```

### Decorator

- **Where to use:** When you want to assign extra behaviors to objects dynamically at runtime without breaking existing client code or using inheritance.
- **Why to use:** Offers a flexible alternative to subclassing for extending functionality, complying with the Single Responsibility Principle.

```java
interface Coffee { double getCost(); }
class SimpleCoffee implements Coffee { public double getCost() { return 2.0; } }

abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;
    public CoffeeDecorator(Coffee coffee) { this.decoratedCoffee = coffee; }
    public double getCost() { return decoratedCoffee.getCost(); }
}

class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) { super(coffee); }
    public double getCost() { return super.getCost() + 0.5; }
}
```

### Facade

- **Where to use:** When you want to provide a simplified, highly abstraction-friendly entry point to a broad, intricate subsystem of classes.
- **Why to use:** It isolates your code from complex subsystems, making integration simpler and decoupling code dependancies.

```java
class Amplifier { public void on() {} }
class DVDPlayer { public void play() {} }

class HomeTheaterFacade {
    private final Amplifier amp;
    private final DVDPlayer dvd;

    public HomeTheaterFacade(Amplifier amp, DVDPlayer dvd) { this.amp = amp; this.dvd = dvd; }

    public void watchMovie() {
        amp.on();
        dvd.play();
    }
}
```

### Flyweight

- **Where to use:** When your application handles a massive volume of fine-grained objects, resulting in steep RAM/memory consumption.
- **Why to use:** It optimizes memory usage by sharing common, unchanging intrinsic state across multiple objects instead of keeping redundant copies.

```java
import java.util.*;

class TreeType { // Intrinsic/Shared State
    private final String name;
    private final String texture;
    public TreeType(String name, String texture) { this.name = name; this.texture = texture; }
}

class TreeFactory {
    private static final Map<String, TreeType> types = new HashMap<>();
    public static TreeType getTreeType(String name, String texture) {
        return types.computeIfAbsent(name, k -> new TreeType(name, texture));
    }
}

class Tree { // Extrinsic/Unique State
    private int x, y;
    private TreeType type;
    public Tree(int x, int y, TreeType type) { this.x = x; this.y = y; this.type = type; }
}
```

### Proxy

- **Where to use:** When you want an intermediary substitute object to perform lazy initialization, access control, caching, or logging prior to routing traffic to the real object.
- **Why to use:** It enables you to execute secondary actions smoothly before or after requests target the primary object without the client realizing.

```java
interface ThirdPartyAPI { String fetchVideo(); }
class RealAPI implements ThirdPartyAPI { public String fetchVideo() { return "Video Data"; } }

class CachedProxyAPI implements ThirdPartyAPI {
    private final RealAPI realApi;
    private String cache;

    public CachedProxyAPI(RealAPI realApi) { this.realApi = realApi; }

    public String fetchVideo() {
        if (cache == null) cache = realApi.fetchVideo();
        return cache;
    }
}
```

## 3. Behavioral Patterns

These patterns deal with algorithms and assignment of responsibilities between interacting objects.

### Chain of Responsibility

- **Where to use:** When a request needs to go through a sequential series of distinct handlers, where any handler can decide to stop processing or hand off the request.
- **Why to use:** Decouples senders and receivers of a request, letting multiple objects handle it dynamically.

```java
abstract class Handler {
    protected Handler next;
    public void setNext(Handler next) { this.next = next; }
    public abstract void handle(String request);
}

class AuthHandler extends Handler {
    public void handle(String request) {
        if ("unauthorized".equals(request)) System.out.println("Blocked by Auth");
        else if (next != null) next.handle(request);
    }
}
```

### Command

- **Where to use:** When you want to turn operations or actions into standalone objects (e.g., implementing undo/redo stacks, execution queues).
- **Why to use:** Allows you to parameterize objects with actions, delay execution, queue operations, and easily roll back states.

```java
interface Command { void execute(); void undo(); }
class Editor { public String text = ""; }

class WriteCommand implements Command {
    private final Editor editor;
    private final String textToWrite;

    public WriteCommand(Editor editor, String text) { this.editor = editor; this.textToWrite = text; }
    public void execute() { editor.text += textToWrite; }
    public void undo() { editor.text = ""; }
}
```

### Interpreter

- **Where to use:** When a specific type of problem occurs frequently enough that it is practical to express it as sentences in a simple language/grammar (e.g., SQL execution, basic calculator inputs).
- **Why to use:** Enables quick grammar evaluations by organizing syntactic rules into a highly extendable class tree.

```java
interface Expression { int interpret(); }

class NumberExpr implements Expression {
    private final int value;
    public NumberExpr(int value) { this.value = value; }
    public int interpret() { return value; }
}

class AddExpr implements Expression {
    private final Expression left, right;
    public AddExpr(Expression left, Expression right) { this.left = left; this.right = right; }
    public int interpret() { return left.interpret() + right.interpret(); }
}
```

### Iterator

- **Where to use:** When you need a reliable way to loop through collection elements sequentially without exposing the underlying collection logic (lists, trees, maps, etc.).
- **Why to use:** Decouples collection algorithms from data structure details, providing a universal iteration interface.

```java
interface Iterator<T> { boolean hasNext(); T next(); }

class ArrayIterator implements Iterator<String> {
    private final String[] items;
    private int index = 0;

    public ArrayIterator(String[] items) { this.items = items; }
    public boolean hasNext() { return index < items.length; }
    public String next() { return items[index++]; }
}
```

### Mediator

- **Where to use:** When components interact with one another in an overly complex, chaotic manner, resulting in tangled dependancies.
- **Why to use:** It centralizes direct communication between objects inside a mediator instance, creating an easily maintainable hub.

```java
interface ControlTower { void registerPlane(Plane plane); void notify(Plane sender, String event); }

class Plane {
    private final ControlTower tower;
    public Plane(ControlTower tower) { this.tower = tower; }
    public void land() { tower.notify(this, "landing"); }
}
```

### Memento

- **Where to use:** When you need to create internal state snapshots of an object so that it can be restored to a previous state later (e.g., historical save points, undo logic).
- **Why to use:** It captures an object's state without breaking its internal encapsulation boundary.

```java
class Memento {
    private final String state;
    public Memento(String state) { this.state = state; }
    public String getSavedState() { return state; }
}

class GameCharacter {
    private String health = "Full";
    public Memento save() { return new Memento(health); }
    public void restore(Memento memento) { this.health = memento.getSavedState(); }
}
```

### Observer

- **Where to use:** When changing the state of one object triggers automated side-effects across numerous other dependent objects (a 1-to-many subscription structure).
- **Why to use:** Implements a decoupled pub-sub mechanism where publishers and observers do not depend on explicit implementations.

```java
import java.util.*;

interface Observer { void update(String videoTitle); }

class YouTubeChannel {
    private final List<Observer> subscribers = new ArrayList<>();

    public void subscribe(Observer sub) { subscribers.add(sub); }
    public void notifySubscribers(String videoTitle) {
        for (Observer sub : subscribers) { sub.update(videoTitle); }
    }
}
```

### State

- **Where to use:** When an object shifts its operations drastically based on its current context or state variable, making huge switch/if statements messy.
- **Why to use:** Encapsulates state-specific logic into clean individual classes, helping you avoid massive, complex conditionals.

```java
interface MachineState { void pressButton(); }

class VendingMachine {
    private MachineState state;
    public void setState(MachineState state) { this.state = state; }
    public void press() { state.pressButton(); }
}

class OutOfStockState implements MachineState {
    public void pressButton() { System.out.println("Display: Out of Stock"); }
}
```

### Strategy

- **Where to use:** When you need a way to swap internal algorithms dynamically at runtime depending on the context (e.g., swapping payment processors or transit routes).
- **Why to use:** Isolates the implementation details of specific business rules from the main execution client context.

```java
interface RouteStrategy { void buildRoute(String A, String B); }
class WalkStrategy implements RouteStrategy { public void buildRoute(String A, String B) { System.out.println("Walking path"); } }
class DriveStrategy implements RouteStrategy { public void buildRoute(String A, String B) { System.out.println("Driving path"); } }

class NavigatorApp {
    private RouteStrategy strategy;
    public void setStrategy(RouteStrategy strategy) { this.strategy = strategy; }
    public void executeRoute(String A, String B) { strategy.buildRoute(A, B); }
}
```

### Template Method

- **Where to use:** When various algorithms follow an identical series of foundational execution steps, but individual details vary across subclasses.
- **Why to use:** Defines a rigid algorithmic framework in a base class, letting subclasses override specific steps without modifying the overarching structure.

```java
abstract class DataMiner {
    public final void mine() { // Template Method
        openFile();
        parseData();
        closeFile();
    }
    protected abstract void parseData();
    private void openFile() { System.out.println("Opening file..."); }
    private void closeFile() { System.out.println("Closing file..."); }
}

class CSVDataMiner extends DataMiner {
    protected void parseData() { System.out.println("Parsing CSV data."); }
}
```

### Visitor

- **Where to use:** When you need to run an auxiliary operation over all elements of a complex object tree structure, without modifying the underlying node classes.
- **Why to use:** Centralizes unrelated operations into distinct visitor classes instead of scattering them across node structures.

```java
interface Element { void accept(Visitor visitor); }
interface Visitor { void visit(Building building); }

class Building implements Element {
    public void accept(Visitor visitor) { visitor.visit(this); }
}
```

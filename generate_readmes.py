from pathlib import Path

root = Path(r"c:\Users\deeks\PC Documents\Design Patterns in Java")

patterns = {
    "01_Singleton": """# Singleton Pattern

## What this code is doing
This example uses one shared object for the whole application. The class keeps a single instance in memory and gives every part of the program the same object.

## Why this pattern is used
Use Singleton when you want one global manager, such as a logger, configuration holder, or connection pool. It prevents multiple copies from being created accidentally.

## Key Java ideas for beginners
- `private static Logger instance;` stores the single object.
- `private Logger()` blocks outside code from creating a new object.
- `public static Logger getInstance()` is the only way to access the object.
- `if (instance == null)` creates the object only once.

## Real-life analogy
Think of it as having one office receptionist for the whole company instead of many separate receptionists.
""",
    "02_FactoryMethod": """# Factory Method Pattern

## What this code is doing
The code creates different types of notifications without forcing the caller to know the exact class name. The creator class decides which object should be made.

## Why this pattern is used
Use this pattern when you want to hide object creation logic and make the code easier to extend.

## Key Java ideas for beginners
- `Notification` is the common interface.
- `EmailNotification` and `SmsNotification` are concrete products.
- `createNotification()` is the factory method.
- `sendNotification()` uses the object without caring about its exact type.

## Real-life analogy
It is like asking a manager to give you the right tool, instead of choosing the tool yourself every time.
""",
    "03_AbstractFactory": """# Abstract Factory Pattern

## What this code is doing
This example creates a family of related objects, such as a button and a checkbox, for a specific platform like Windows or Mac.

## Why this pattern is used
Use Abstract Factory when a group of objects must work together and should be created consistently for the same environment.

## Key Java ideas for beginners
- `Button` and `Checkbox` are product interfaces.
- `WindowsFactory` and `MacFactory` create matching products.
- The client code works with interfaces, not concrete classes.

## Real-life analogy
This pattern is useful when a whole set of objects must match each other, like a Windows UI set or a Mac UI set.
""",
    "04_Builder": """# Builder Pattern

## What this code is doing
The code builds a complex object step by step. Instead of passing many constructor parameters, the builder helps set values one by one.

## Why this pattern is used
Use Builder when an object has many optional fields or when the construction logic is long and confusing.

## Key Java ideas for beginners
- `User.Builder` collects values gradually.
- Each setter method returns the builder itself, so methods can be chained.
- `build()` creates the final object.

## Real-life analogy
It is like assembling a custom pizza one topping at a time instead of trying to fit everything into one giant constructor.
""",
    "05_Prototype": """# Prototype Pattern

## What this code is doing
This example creates a copy of an existing object using cloning instead of building the object from scratch.

## Why this pattern is used
Use Prototype when creating a new object is expensive or when many objects are similar.

## Key Java ideas for beginners
- `Cloneable` tells Java that the object can be cloned.
- `super.clone()` creates a copy.
- `cloneDocument()` wraps the cloning logic in a simple method.

## Real-life analogy
It is like copying a ready-made document template instead of rewriting everything from zero.
""",
    "06_Adapter": """# Adapter Pattern

## What this code is doing
The example lets an old component work with a new interface by placing an adapter between them.

## Why this pattern is used
Use Adapter when two systems have incompatible interfaces but need to work together.

## Key Java ideas for beginners
- `PaymentProcessor` is the target interface.
- `OldPaymentSystem` is the existing class with a different method.
- `PaymentAdapter` converts the old method into the new expected method.

## Real-life analogy
It is like using a power plug adapter so a device from one country works in another.
""",
    "07_Decorator": """# Decorator Pattern

## What this code is doing
The code adds extra behavior to an object dynamically by wrapping it in decorators such as milk or sugar.

## Why this pattern is used
Use Decorator when you want to add features to an object without changing its original class.

## Key Java ideas for beginners
- The base interface is `Coffee`.
- `CoffeeDecorator` wraps another coffee object.
- Each decorator adds new behavior and calls the wrapped object.

## Real-life analogy
It is like adding toppings to a basic pizza without rewriting the whole pizza class.
""",
    "08_Proxy": """# Proxy Pattern

## What this code is doing
The code uses a proxy class to control access to another object. The real image is created only when it is actually needed.

## Why this pattern is used
Use Proxy when you want to delay expensive initialization, add access controls, or act as a stand-in for another object.

## Key Java ideas for beginners
- `Image` is the common interface.
- `RealImage` contains the actual work.
- `ProxyImage` checks whether the real object exists before using it.

## Real-life analogy
It is like a receptionist who checks whether a manager is available before giving access to the office.
""",
    "09_Facade": """# Facade Pattern

## What this code is doing
The code hides a complex subsystem behind one simple class so the client can use it easily.

## Why this pattern is used
Use Facade when you want to simplify a complicated system and reduce the number of calls the user must make.

## Key Java ideas for beginners
- `CPU` and `Memory` are the internal parts.
- `ComputerFacade` combines them into one easy interface.
- `startComputer()` performs the whole workflow in one step.

## Real-life analogy
It is like pressing one button to start a whole machine instead of manually wiring every part yourself.
""",
    "10_Composite": """# Composite Pattern

## What this code is doing
This example models a tree structure such as folders and files. Both a single file and a folder are treated in a similar way.

## Why this pattern is used
Use Composite when objects can be grouped into larger structures while still being handled as individual items.

## Key Java ideas for beginners
- `FileComponent` is the common interface.
- `File` is a leaf object.
- `Folder` contains children and can also behave like a component.

## Real-life analogy
It is like treating a single file and a whole folder as both "items in the file system".
""",
    "11_Bridge": """# Bridge Pattern

## What this code is doing
The code separates the abstraction from the implementation. A remote control can work with different devices such as a TV or radio.

## Why this pattern is used
Use Bridge when you want to avoid a permanent connection between an abstraction and one specific implementation.

## Key Java ideas for beginners
- `Device` is the implementation interface.
- `Remote` is the abstraction.
- The remote holds a device object and uses it indirectly.

## Real-life analogy
It is like having a universal remote that can work with many kinds of devices.
""",
    "12_Flyweight": """# Flyweight Pattern

## What this code is doing
The example reuses shared objects instead of creating new ones every time. This helps when many objects share the same basic data.

## Why this pattern is used
Use Flyweight to save memory when many similar objects are created.

## Key Java ideas for beginners
- `CharacterFlyweight` stores the shared state.
- `CharacterFactory` creates and reuses objects.
- The same character object is returned for repeated requests.

## Real-life analogy
It is like reusing the same letter tile in a game instead of creating a new one every time.
""",
    "13_Strategy": """# Strategy Pattern

## What this code is doing
The code lets the application choose different payment methods at runtime, such as credit card or PayPal.

## Why this pattern is used
Use Strategy when an algorithm or behavior can change and you want to swap it easily.

## Key Java ideas for beginners
- `PaymentStrategy` is the interface for the behavior.
- `CreditCardPayment` and `PayPalPayment` are concrete strategies.
- `ShoppingCart` uses whichever strategy is currently selected.

## Real-life analogy
It is like choosing different ways to pay at checkout without changing the shopping cart itself.
""",
    "14_Observer": """# Observer Pattern

## What this code is doing
The subject notifies multiple observers when something changes. In this example, email and SMS observers react to the same message.

## Why this pattern is used
Use Observer when one object needs to inform many other objects about changes.

## Key Java ideas for beginners
- `Subject` keeps a list of observers.
- `addObserver()` registers a new observer.
- `notifyObservers()` sends updates to all registered observers.

## Real-life analogy
It is like a group of friends receiving a message when one person sends an update.
""",
    "15_Command": """# Command Pattern

## What this code is doing
The code wraps actions such as turning a light on or off into objects. These objects can be stored and executed later.

## Why this pattern is used
Use Command when you want to separate the request from the action, or when you need to queue, undo, or log commands.

## Key Java ideas for beginners
- `Command` is the interface for an action.
- `LightOnCommand` and `LightOffCommand` are concrete commands.
- `RemoteControl` executes the command without knowing the details.

## Real-life analogy
It is like sending a request to a helper who knows how to carry out the task.
""",
    "16_State": """# State Pattern

## What this code is doing
The object changes behavior depending on its current state. The same context can behave differently when it switches from one state to another.

## Why this pattern is used
Use State when an object's behavior changes based on internal conditions and you want to keep the logic organized.

## Key Java ideas for beginners
- `State` is the interface for behaviors.
- `StartState` and `StopState` are concrete states.
- `Context` delegates behavior to the current state object.

## Real-life analogy
It is like a traffic light changing its behavior depending on whether it is red, yellow, or green.
""",
    "17_TemplateMethod": """# Template Method Pattern

## What this code is doing
The base class defines the overall flow of an algorithm, while subclasses fill in the specific steps.

## Why this pattern is used
Use Template Method when many classes share the same algorithm structure but differ in a few steps.

## Key Java ideas for beginners
- `Game` defines the method `play()` in a fixed order.
- `start()` and `end()` are overridden by subclasses.
- `final` prevents subclasses from changing the overall algorithm structure.

## Real-life analogy
It is like using a worksheet with fixed sections, while each student fills in different answers.
""",
    "18_Iterator": """# Iterator Pattern

## What this code is doing
The code walks through a collection one item at a time without exposing the internal structure of the collection.

## Why this pattern is used
Use Iterator when you want a standard way to traverse data structures.

## Key Java ideas for beginners
- `Iterator` is the interface for traversal.
- `hasNext()` checks whether more items exist.
- `next()` returns the next element.

## Real-life analogy
It is like reading a book page by page instead of opening the whole book at once.
""",
    "19_Mediator": """# Mediator Pattern

## What this code is doing
The code uses a central mediator to coordinate communication among objects so they do not need to talk to each other directly.

## Why this pattern is used
Use Mediator when many objects interact and the communication becomes complicated.

## Key Java ideas for beginners
- `ChatMediator` defines the communication method.
- `User` sends messages through the mediator.
- `ChatRoom` manages the flow of communication.

## Real-life analogy
It is like having a group chat host who manages who speaks and when.
""",
    "20_Memento": """# Memento Pattern

## What this code is doing
The example saves the current state of an object so it can be restored later. This is commonly used for undo operations.

## Why this pattern is used
Use Memento when you need to capture and restore an earlier state safely.

## Key Java ideas for beginners
- `Memento` stores a snapshot of the state.
- `save()` creates the snapshot.
- `restore()` brings the object back to the earlier state.

## Real-life analogy
It is like saving a document version so you can return to it later.
""",
    "21_ChainOfResponsibility": """# Chain of Responsibility Pattern

## What this code is doing
A request moves through a chain of handlers. Each handler decides whether it can process the request or pass it along.

## Why this pattern is used
Use this pattern when several handlers may be able to process a request and you want to avoid hard-coding the decision logic in one place.

## Key Java ideas for beginners
- `Handler` holds a reference to the next handler.
- `canHandle()` decides whether this handler should process the request.
- `handleRequest()` passes the request forward if needed.

## Real-life analogy
It is like passing a task to the next suitable person until someone can complete it.
""",
    "22_Visitor": """# Visitor Pattern

## What this code is doing
The visitor object performs an operation on different element types. The elements accept the visitor and let it handle their type.

## Why this pattern is used
Use Visitor when new operations need to be added to a family of classes without changing those classes directly.

## Key Java ideas for beginners
- `Element` defines the `accept()` method.
- `Visitor` defines operations for each element type.
- `PriceVisitor` performs the new behavior.

## Real-life analogy
It is like asking a specialist to inspect different objects without changing the objects themselves.
""",
    "23_Interpreter": """# Interpreter Pattern

## What this code is doing
The example reads a simple expression language and evaluates whether a sentence matches some rules.

## Why this pattern is used
Use Interpreter when you need to parse and evaluate a small language or rule-based expression.

## Key Java ideas for beginners
- `Expression` is the common interface.
- `TerminalExpression` checks simple values.
- `AndExpression` combines expressions.

## Real-life analogy
It is like teaching the program to understand a tiny command language.
""",
}

extras = {
    "01_Singleton": {
        "analogy": "A single shared manager in a company, such as one receptionist for all visitors.",
        "differences": "Unlike Factory Method, this pattern does not create different objects; it controls access to one object."
    },
    "02_FactoryMethod": {
        "analogy": "A factory that gives you the right product when you ask for it.",
        "differences": "Compared with Abstract Factory, this pattern creates one product at a time, while Abstract Factory creates a whole family of related products."
    },
    "03_AbstractFactory": {
        "analogy": "A company that provides complete toolkits for a specific platform, such as Windows or Mac.",
        "differences": "Unlike Factory Method, it creates a family of related objects together instead of one object by one object."
    },
    "04_Builder": {
        "analogy": "Building a custom pizza by choosing toppings step by step instead of using one giant constructor.",
        "differences": "Unlike Factory Method, this pattern focuses on constructing a complex object with many options."
    },
    "05_Prototype": {
        "analogy": "Copying a ready-made document template rather than creating everything from scratch.",
        "differences": "Unlike Builder, this pattern creates objects by cloning an existing one rather than assembling them step by step."
    },
    "06_Adapter": {
        "analogy": "Using a plug adapter so a device from one country can work in another.",
        "differences": "Unlike Decorator, this pattern changes the interface so two incompatible components can work together."
    },
    "07_Decorator": {
        "analogy": "Adding toppings to a pizza without changing the base pizza class.",
        "differences": "Unlike Proxy, this pattern adds behavior rather than controlling access to an object."
    },
    "08_Proxy": {
        "analogy": "A receptionist who checks access before you meet a manager.",
        "differences": "Unlike Decorator, this pattern acts as a stand-in and controls access rather than adding features."
    },
    "09_Facade": {
        "analogy": "Pressing one button to start a whole machine instead of handling every part manually.",
        "differences": "Unlike Adapter, this pattern simplifies a complex subsystem rather than making two incompatible interfaces work together."
    },
    "10_Composite": {
        "analogy": "Treating a single file and a whole folder in the same way inside a file system.",
        "differences": "Unlike Decorator, this pattern organizes a tree structure of objects instead of wrapping one object with extra behavior."
    },
    "11_Bridge": {
        "analogy": "A universal remote that can work with many device types.",
        "differences": "Unlike Adapter, this pattern separates abstraction from implementation so both can evolve independently."
    },
    "12_Flyweight": {
        "analogy": "Reusing the same letter tile in a game rather than creating a new tile every time.",
        "differences": "Unlike Singleton, this pattern shares data among many objects, while Singleton shares one object globally."
    },
    "13_Strategy": {
        "analogy": "Choosing different payment methods at checkout without changing the shopping cart code.",
        "differences": "Unlike State, this pattern changes the algorithm or behavior, while State changes the object's internal behavior based on its current condition."
    },
    "14_Observer": {
        "analogy": "A group of friends receiving updates when one person posts a message.",
        "differences": "Unlike Mediator, this pattern is one-to-many; the subject sends updates to many observers."
    },
    "15_Command": {
        "analogy": "Giving a helper a written instruction to carry out later.",
        "differences": "Unlike Strategy, this pattern wraps a request as an object that can be queued or undone."
    },
    "16_State": {
        "analogy": "A traffic light changing behavior depending on whether it is red, yellow, or green.",
        "differences": "Unlike Strategy, this pattern changes behavior based on the object's current state rather than swapping an algorithm."
    },
    "17_TemplateMethod": {
        "analogy": "Using a worksheet with fixed sections while each student fills in different answers.",
        "differences": "Unlike Strategy, this pattern fixes the overall algorithm structure and leaves only some steps flexible."
    },
    "18_Iterator": {
        "analogy": "Reading a book page by page without needing to know the book's internal structure.",
        "differences": "Unlike Composite, this pattern is about traversal rather than organizing objects in a tree."
    },
    "19_Mediator": {
        "analogy": "A group chat host who manages who speaks and when.",
        "differences": "Unlike Observer, this pattern is many-to-many through a central coordinator instead of one subject notifying many observers."
    },
    "20_Memento": {
        "analogy": "Saving a document version so you can restore it later.",
        "differences": "Unlike State, this pattern stores past snapshots rather than changing behavior based on the current condition."
    },
    "21_ChainOfResponsibility": {
        "analogy": "Passing a task to the next suitable person until someone can complete it.",
        "differences": "Unlike Command, this pattern passes a request through a chain instead of wrapping one action as an object."
    },
    "22_Visitor": {
        "analogy": "Calling a specialist to inspect different objects without changing the objects themselves.",
        "differences": "Unlike Strategy, this pattern adds operations over a set of classes rather than selecting an algorithm."
    },
    "23_Interpreter": {
        "analogy": "Teaching a program to understand a tiny command language.",
        "differences": "Unlike Command, this pattern evaluates expressions or rules rather than simply executing an action."
    },
}

for folder, content in patterns.items():
    extra = extras.get(folder, {})
    differences = extra.get("differences", "")
    sections = ""
    if differences:
        sections += f"\n\n## Difference from similar patterns\n{differences}"
    (root / folder / "README.md").write_text(content + sections, encoding="utf-8")

print("Updated README files for all patterns.")

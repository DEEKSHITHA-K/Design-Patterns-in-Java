# Pattern Guide

This guide summarizes why each example belongs to its design pattern.

- Singleton: one shared instance controlled by a private constructor and static accessor.
- Factory Method: creation is delegated to subclasses via an abstract factory method.
- Abstract Factory: related products are created together through a platform-specific factory.
- Builder: object construction is separated into a step-by-step builder API.
- Prototype: objects clone themselves to create similar copies.
- Adapter: an adapter converts one interface into another.
- Decorator: wrappers add behavior dynamically around an existing object.
- Proxy: a proxy controls access and delays heavy initialization.
- Facade: a simple interface hides a complex subsystem.
- Composite: leaf and composite objects share a common interface.
- Bridge: abstraction and implementation are separated so they can vary independently.
- Flyweight: shared objects reuse intrinsic state to reduce memory usage.
- Strategy: interchangeable algorithms are encapsulated and selected at runtime.
- Observer: subjects notify registered observers of changes.
- Command: actions are encapsulated as command objects.
- State: behavior changes depending on the current state object.
- Template Method: the algorithm skeleton is fixed while steps vary by subclass.
- Iterator: traversals are separated into an iterator object.
- Mediator: objects communicate through a central mediator.
- Memento: snapshots preserve previous states for undo support.
- Chain of Responsibility: requests travel through a chain of handlers.
- Visitor: new operations are added by visiting elements through a visitor.
- Interpreter: expressions are represented as objects that interpret a context.

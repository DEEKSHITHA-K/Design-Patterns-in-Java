from pathlib import Path

patterns = [
    ("01_Singleton", "Singleton", "Ensures only one instance exists and provides global access to it."),
    ("02_FactoryMethod", "Factory Method", "Defers object creation to subclasses so the client uses a common interface."),
    ("03_AbstractFactory", "Abstract Factory", "Creates families of related objects without coupling the client to a concrete platform."),
    ("04_Builder", "Builder", "Builds complex objects step by step using a fluent builder API."),
    ("05_Prototype", "Prototype", "Clones an existing object instead of constructing a new one from scratch."),
    ("06_Adapter", "Adapter", "Converts one interface into another so incompatible components can work together."),
    ("07_Decorator", "Decorator", "Adds responsibilities dynamically by wrapping an object with decorators."),
    ("08_Proxy", "Proxy", "Controls access to another object and can delay its creation."),
    ("09_Facade", "Facade", "Provides a simple interface to a complex subsystem."),
    ("10_Composite", "Composite", "Treats individual objects and groups of objects uniformly in a tree structure."),
    ("11_Bridge", "Bridge", "Separates abstraction from implementation so both can vary independently."),
    ("12_Flyweight", "Flyweight", "Shares common state among many objects to reduce memory usage."),
    ("13_Strategy", "Strategy", "Encapsulates interchangeable algorithms and lets the context swap them at runtime."),
    ("14_Observer", "Observer", "Notifies subscribers when the subject changes state."),
    ("15_Command", "Command", "Wraps actions in objects so they can be queued, stored, or executed later."),
    ("16_State", "State", "Changes an object's behavior by switching among state objects."),
    ("17_TemplateMethod", "Template Method", "Defines the skeleton of an algorithm and lets subclasses override the steps."),
    ("18_Iterator", "Iterator", "Provides a standard way to traverse a collection without exposing its structure."),
    ("19_Mediator", "Mediator", "Coordinates communication between objects through a central mediator."),
    ("20_Memento", "Memento", "Captures and restores an object's previous state for undo support."),
    ("21_ChainOfResponsibility", "Chain of Responsibility", "Passes a request along a chain until one handler processes it."),
    ("22_Visitor", "Visitor", "Adds new operations to a set of classes without modifying those classes."),
    ("23_Interpreter", "Interpreter", "Parses and evaluates sentences in a simple language using expression objects."),
]

root = Path(r"c:\Users\deeks\PC Documents\Design Patterns in Java")
for folder, title, summary in patterns:
    folder_path = root / folder
    readme = folder_path / "README.md"
    content = f"""# {title} Pattern

## What this pattern solves
{summary}

## Why this example uses the pattern
- The example keeps the core idea of the pattern visible and easy to understand.
- The code is written in a simple Java form so you can map the pattern to real-world software design.
- The main role of the pattern is shown through interfaces, inheritance, composition, or shared state.

## Key points in the implementation
- The classes and interfaces show the pattern clearly.
- The example demonstrates the expected behavior of the pattern.
- The client code uses the pattern in a way that would be natural in a real application.

## Short study note
If you are learning the pattern, focus on the intention first:
- What problem is being solved?
- Which object controls creation, behavior, or communication?
- Why is the solution better than a simple direct implementation?
"""
    readme.write_text(content, encoding="utf-8")

print("Generated README files for all pattern folders.")

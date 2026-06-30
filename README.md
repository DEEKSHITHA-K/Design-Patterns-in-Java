# GoF Design Patterns in Java

This workspace contains runnable Java implementations for all 23 Gang of Four design patterns.

## Structure

Each pattern has its own folder:

- 01_Singleton
- 02_FactoryMethod
- 03_AbstractFactory
- 04_Builder
- 05_Prototype
- 06_Adapter
- 07_Decorator
- 08_Proxy
- 09_Facade
- 10_Composite
- 11_Bridge
- 12_Flyweight
- 13_Strategy
- 14_Observer
- 15_Command
- 16_State
- 17_TemplateMethod
- 18_Iterator
- 19_Mediator
- 20_Memento
- 21_ChainOfResponsibility
- 22_Visitor
- 23_Interpreter

## How to run

From this folder, run:

```powershell
Get-ChildItem -Recurse -Filter *.java | ForEach-Object { javac $_.FullName }
```

Then run any example:

```powershell
java -cp .\01_Singleton SingletonExample
```

Each source file includes comments that explain the code and why the example matches the pattern.

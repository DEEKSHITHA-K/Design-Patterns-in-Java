# Decorator Pattern

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


## Difference from similar patterns
Unlike Proxy, this pattern adds behavior rather than controlling access to an object.
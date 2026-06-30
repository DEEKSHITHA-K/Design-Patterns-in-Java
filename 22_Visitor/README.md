# Visitor Pattern

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


## Difference from similar patterns
Unlike Strategy, this pattern adds operations over a set of classes rather than selecting an algorithm.
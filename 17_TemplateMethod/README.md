# Template Method Pattern

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


## Difference from similar patterns
Unlike Strategy, this pattern fixes the overall algorithm structure and leaves only some steps flexible.
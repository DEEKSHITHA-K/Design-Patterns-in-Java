# Prototype Pattern

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


## Difference from similar patterns
Unlike Builder, this pattern creates objects by cloning an existing one rather than assembling them step by step.
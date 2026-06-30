# Facade Pattern

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


## Difference from similar patterns
Unlike Adapter, this pattern simplifies a complex subsystem rather than making two incompatible interfaces work together.
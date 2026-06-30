# State Pattern

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


## Difference from similar patterns
Unlike Strategy, this pattern changes behavior based on the object's current state rather than swapping an algorithm.
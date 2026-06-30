# Command Pattern

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


## Difference from similar patterns
Unlike Strategy, this pattern wraps a request as an object that can be queued or undone.
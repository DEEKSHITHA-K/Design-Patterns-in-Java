# Memento Pattern

## What this code is doing
The example saves the current state of an object so it can be restored later. This is commonly used for undo operations.

## Why this pattern is used
Use Memento when you need to capture and restore an earlier state safely.

## Key Java ideas for beginners
- `Memento` stores a snapshot of the state.
- `save()` creates the snapshot.
- `restore()` brings the object back to the earlier state.

## Real-life analogy
It is like saving a document version so you can return to it later.


## Difference from similar patterns
Unlike State, this pattern stores past snapshots rather than changing behavior based on the current condition.
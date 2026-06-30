# Observer Pattern

## What this code is doing
The subject notifies multiple observers when something changes. In this example, email and SMS observers react to the same message.

## Why this pattern is used
Use Observer when one object needs to inform many other objects about changes.

## Key Java ideas for beginners
- `Subject` keeps a list of observers.
- `addObserver()` registers a new observer.
- `notifyObservers()` sends updates to all registered observers.

## Real-life analogy
It is like a group of friends receiving a message when one person sends an update.


## Difference from similar patterns
Unlike Mediator, this pattern is one-to-many; the subject sends updates to many observers.
# Mediator Pattern

## What this code is doing
The code uses a central mediator to coordinate communication among objects so they do not need to talk to each other directly.

## Why this pattern is used
Use Mediator when many objects interact and the communication becomes complicated.

## Key Java ideas for beginners
- `ChatMediator` defines the communication method.
- `User` sends messages through the mediator.
- `ChatRoom` manages the flow of communication.

## Real-life analogy
It is like having a group chat host who manages who speaks and when.


## Difference from similar patterns
Unlike Observer, this pattern is many-to-many through a central coordinator instead of one subject notifying many observers.
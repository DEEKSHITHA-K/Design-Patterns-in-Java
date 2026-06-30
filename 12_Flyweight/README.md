# Flyweight Pattern

## What this code is doing
The example reuses shared objects instead of creating new ones every time. This helps when many objects share the same basic data.

## Why this pattern is used
Use Flyweight to save memory when many similar objects are created.

## Key Java ideas for beginners
- `CharacterFlyweight` stores the shared state.
- `CharacterFactory` creates and reuses objects.
- The same character object is returned for repeated requests.

## Real-life analogy
It is like reusing the same letter tile in a game instead of creating a new one every time.


## Difference from similar patterns
Unlike Singleton, this pattern shares data among many objects, while Singleton shares one object globally.
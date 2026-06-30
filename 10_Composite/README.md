# Composite Pattern

## What this code is doing
This example models a tree structure such as folders and files. Both a single file and a folder are treated in a similar way.

## Why this pattern is used
Use Composite when objects can be grouped into larger structures while still being handled as individual items.

## Key Java ideas for beginners
- `FileComponent` is the common interface.
- `File` is a leaf object.
- `Folder` contains children and can also behave like a component.

## Real-life analogy
It is like treating a single file and a whole folder as both "items in the file system".


## Difference from similar patterns
Unlike Decorator, this pattern organizes a tree structure of objects instead of wrapping one object with extra behavior.
# Abstract Factory Pattern

## What this code is doing
This example creates a family of related objects, such as a button and a checkbox, for a specific platform like Windows or Mac.

## Why this pattern is used
Use Abstract Factory when a group of objects must work together and should be created consistently for the same environment.

## Key Java ideas for beginners
- `Button` and `Checkbox` are product interfaces.
- `WindowsFactory` and `MacFactory` create matching products.
- The client code works with interfaces, not concrete classes.

## Real-life analogy
This pattern is useful when a whole set of objects must match each other, like a Windows UI set or a Mac UI set.


## Difference from similar patterns
Unlike Factory Method, it creates a family of related objects together instead of one object by one object.
# Factory Method Pattern

## What this code is doing
The code creates different types of notifications without forcing the caller to know the exact class name. The creator class decides which object should be made.

## Why this pattern is used
Use this pattern when you want to hide object creation logic and make the code easier to extend.

## Key Java ideas for beginners
- `Notification` is the common interface.
- `EmailNotification` and `SmsNotification` are concrete products.
- `createNotification()` is the factory method.
- `sendNotification()` uses the object without caring about its exact type.

## Real-life analogy
It is like asking a manager to give you the right tool, instead of choosing the tool yourself every time.


## Difference from similar patterns
Compared with Abstract Factory, this pattern creates one product at a time, while Abstract Factory creates a whole family of related products.
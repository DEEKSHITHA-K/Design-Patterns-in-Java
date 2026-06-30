# Adapter Pattern

## What this code is doing
The example lets an old component work with a new interface by placing an adapter between them.

## Why this pattern is used
Use Adapter when two systems have incompatible interfaces but need to work together.

## Key Java ideas for beginners
- `PaymentProcessor` is the target interface.
- `OldPaymentSystem` is the existing class with a different method.
- `PaymentAdapter` converts the old method into the new expected method.

## Real-life analogy
It is like using a power plug adapter so a device from one country works in another.


## Difference from similar patterns
Unlike Decorator, this pattern changes the interface so two incompatible components can work together.
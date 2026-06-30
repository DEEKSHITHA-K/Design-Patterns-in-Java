# Strategy Pattern

## What this code is doing
The code lets the application choose different payment methods at runtime, such as credit card or PayPal.

## Why this pattern is used
Use Strategy when an algorithm or behavior can change and you want to swap it easily.

## Key Java ideas for beginners
- `PaymentStrategy` is the interface for the behavior.
- `CreditCardPayment` and `PayPalPayment` are concrete strategies.
- `ShoppingCart` uses whichever strategy is currently selected.

## Real-life analogy
It is like choosing different ways to pay at checkout without changing the shopping cart itself.


## Difference from similar patterns
Unlike State, this pattern changes the algorithm or behavior, while State changes the object's internal behavior based on its current condition.
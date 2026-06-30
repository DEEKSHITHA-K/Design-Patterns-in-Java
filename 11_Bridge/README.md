# Bridge Pattern

## What this code is doing
The code separates the abstraction from the implementation. A remote control can work with different devices such as a TV or radio.

## Why this pattern is used
Use Bridge when you want to avoid a permanent connection between an abstraction and one specific implementation.

## Key Java ideas for beginners
- `Device` is the implementation interface.
- `Remote` is the abstraction.
- The remote holds a device object and uses it indirectly.

## Real-life analogy
It is like having a universal remote that can work with many kinds of devices.


## Difference from similar patterns
Unlike Adapter, this pattern separates abstraction from implementation so both can evolve independently.
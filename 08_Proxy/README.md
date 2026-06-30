# Proxy Pattern

## What this code is doing
The code uses a proxy class to control access to another object. The real image is created only when it is actually needed.

## Why this pattern is used
Use Proxy when you want to delay expensive initialization, add access controls, or act as a stand-in for another object.

## Key Java ideas for beginners
- `Image` is the common interface.
- `RealImage` contains the actual work.
- `ProxyImage` checks whether the real object exists before using it.

## Real-life analogy
It is like a receptionist who checks whether a manager is available before giving access to the office.


## Difference from similar patterns
Unlike Decorator, this pattern acts as a stand-in and controls access rather than adding features.
# Interpreter Pattern

## What this code is doing
The example reads a simple expression language and evaluates whether a sentence matches some rules.

## Why this pattern is used
Use Interpreter when you need to parse and evaluate a small language or rule-based expression.

## Key Java ideas for beginners
- `Expression` is the common interface.
- `TerminalExpression` checks simple values.
- `AndExpression` combines expressions.

## Real-life analogy
It is like teaching the program to understand a tiny command language.


## Difference from similar patterns
Unlike Command, this pattern evaluates expressions or rules rather than simply executing an action.
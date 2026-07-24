# Quantum Radar System

A Java-based traffic violation detection system that uses the Strategy Design Pattern to evaluate different traffic rules dynamically.

## Features

- Detects multiple traffic violations.
- Supports extensible traffic rules without modifying the radar logic.
- Calculates total fines per vehicle.

## Design Patterns

1) Strategy Pattern

The system uses the Strategy Pattern:

- TrafficRule → Strategy interface
- SpeedRule, SeatBeltRule → Concrete strategies
- QuantumRadar → Context that executes the rules

This allows adding new rules without changing existing code.

2) Dependency Injection Pattern

Used in "QuantumRadar" because QuantumRadar does not create its dependencies. It receives them from outside.

## Example Output
Traffic fine for car ABC1234
Total amount: 400 EGP
Violations:
- Seatbelt not fastened : 100 EGP
- speed of 94 exceeded max allowed 80 : 300 EGP


Traffic fine for car TRK001
Total amount: 500 EGP
Violations:
- speed of 75 exceeded max allowed 70 : 500 EGP

All fines: plate -> total EGP
ABC1234 : 400 EGP
TRK001 : 500 EGP

## Technologies

- Java
- Object-Oriented Programming
- Design Patterns

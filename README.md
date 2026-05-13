# Spring Course Playground

A hands-on Java project with practical examples from a Spring learning path.

This repository contains small, focused demos covering core Spring concepts and related technologies such as Aspect-Oriented Programming (AOP) and Hibernate ORM mappings.

## Overview

The project is structured as a collection of independent examples you can run and study:

- **Spring Core / IoC**: XML and Java-based configuration, dependency injection, bean scopes, and lifecycle basics.
- **AOP**: custom aspects, pointcuts, advice types, and logging/security examples.
- **Hibernate**: entity mapping and relationship scenarios:
  - one-to-one
  - one-to-many (unidirectional and bidirectional)
  - many-to-many

The code is educational by design: classes are intentionally simple and organized by topic for easier navigation.

## Tech Stack

- **Java 18**
- **Maven**
- **Spring Context 6.0.9**
- **AspectJ Weaver 1.9.19**
- **Hibernate Core 5.6.15.Final**
- **MySQL Connector/J 8.0.33**
- **JUnit 4.13.2**

## Project Structure

```text
src/main/java/com/pukhaev/spring/
├── spring_introduction/          # Core Spring basics
├── aop/                          # AOP examples and aspects
├── hibernate_test/               # Basic Hibernate CRUD scenarios
├── hibernate_one_to_one/         # One-to-one mapping examples
├── hibernate_one_to_many_uni/    # One-to-many unidirectional mapping
├── hibernate_one_to_many_bi/     # One-to-many bidirectional mapping
└── hibernate_many_to_many/       # Many-to-many mapping examples

resources/
├── applicationContext.xml
├── applicationContext2.xml
├── applicationContext3.xml
├── hibernate.cfg.xml
└── myApp.properties
```

## Getting Started

### 1) Prerequisites

Make sure you have installed:

- JDK 18+
- Maven 3.8+
- (Optional) MySQL server if you want to run Hibernate DB examples

### 2) Clone and build

```bash
git clone <your-repo-url>
cd spring_course
mvn clean test
```

### 3) Run examples

Most topics have `Test*.java` classes with a `main` method.
Run a specific example from your IDE (recommended for learning) or via Maven/CLI setup.

Examples:

- `com.pukhaev.spring.spring_introduction.Test1`
- `com.pukhaev.spring.aop.Test1`
- `com.pukhaev.spring.hibernate_one_to_one.Test1`

## Database Notes (Hibernate modules)

Hibernate examples rely on settings in `resources/hibernate.cfg.xml`.
Before running DB-related classes:

1. Create/update your local MySQL database.
2. Set valid DB URL, username, and password in `hibernate.cfg.xml`.
3. Verify dialect/driver settings match your environment.

## Learning Goals

This repository is useful for practicing:

- Spring container fundamentals
- bean wiring styles (XML + annotations + Java config)
- cross-cutting concerns with AOP
- ORM entity design and relationship mapping in Hibernate

## Tips for Study

- Start from `spring_introduction` to understand core concepts.
- Move to `aop` after IoC basics.
- Continue with Hibernate relationship packages in order: one-to-one → one-to-many → many-to-many.
- Run examples one by one and inspect console output to understand runtime behavior.

## License

This project is intended for educational use.
Add a license file (`LICENSE`) if you plan to distribute it publicly.

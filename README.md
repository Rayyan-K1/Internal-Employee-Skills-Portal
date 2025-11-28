# Internal Employee Skills Portal

The **Internal Employee Skills Portal** is a Java / JavaFX application for managing employees and their skills inside a company.

It’s designed to help teams:

- Keep a structured record of employees and their skills
- Quickly find people with specific skill sets
- Understand skill gaps across the organisation

---

## Overview

Typical use cases:

- A manager wants to find all employees with **Java** and **SQL** at an “Advanced” level.
- HR wants a quick view of which skills are common vs. rare.
- An employee wants to review their own skills profile and update it over time.

The project focuses on:

- Solid **functional programming** in Java  
- A **JavaFX + FXML** desktop UI  
- Clear separation between **model**, **view** (FXML) and **controller** logic

---

## Features

### 👤 Employee management

- Create new employees
- Update core details (e.g. name, role, department, ID)
- View a list of all employees

### 🧠 Skills management

- Maintain a skills catalogue (e.g. Java, React, SQL, AWS)
- Assign multiple skills to each employee
- Track skill level (e.g. Beginner / Intermediate / Advanced)

### 🔍 Search & filtering

- Search employees by skill
- Optionally filter by:
  - Department / team
  - Minimum skill level
- Quickly see which employees match a given skill profile

### 📄 Employee skill profiles

- View a detailed profile for each employee:
  - Basic information
  - All associated skills and levels
- Designed to answer: “What can this person do?” at a glance

### 📊 Simple reporting (if implemented)

- Count how many employees have each skill
- Spot obvious gaps (skills that no one or very few people have)
- Basic summary views suitable for HR / management

---

## Tech Stack

- **Language:** Java  
- **UI framework:** JavaFX with **FXML** views  
- **Styling:** CSS (for JavaFX styles) :contentReference[oaicite:1]{index=1}  
- **Build / Project:** IntelliJ IDEA project (`main.iml` included)
- **Persistence:** In-memory data structures and/or simple file-based storage (depending on your implementation)

---

## Project Structure

High-level structure of the repository: :contentReference[oaicite:2]{index=2}

```text
Internal-Employee-Skills-Portal/
  java/           # Java source files (models, controllers, services)
  resources/      # FXML layouts, CSS styles, icons, etc.
  main.iml        # IntelliJ IDEA project file
  README.md

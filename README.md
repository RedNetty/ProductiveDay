# ProductiveDay

A Java desktop productivity application designed to help users manage tasks, assignments, and time through a unified interface with customizable notifications and scheduling.

## Features

- 📅 **Calendar with reminders** — schedule events and link them directly to assignments
- 📝 **Assignment tracking** — input, categorize, and monitor academic or work tasks
- ⏱️ **Customizable timers** — countdown and elapsed timers with configurable alerts
- 🔔 **Notification system** — custom notification sounds and visual alerts
- 🎨 **Fully customizable UI** — personalize layouts, themes, and display preferences

## Getting Started

### Prerequisites

- Java 17+
- Maven 3.8+

### Build & Run

```bash
git clone https://github.com/RedNetty/ProductiveDay.git
cd ProductiveDay
mvn clean package
java -jar target/ProductiveDay.jar
```

## Project Structure

```
src/
├── main/java/
│   ├── ui/          # Swing/JavaFX views and controllers
│   ├── model/       # Task, assignment, and calendar models
│   ├── service/     # Notification and timer logic
│   └── util/        # Helpers and config management
└── resources/
    └── sounds/      # Alert audio files
```

## Roadmap

- [ ] Cloud sync for cross-device access
- [ ] Google Calendar integration
- [ ] Recurring task support
- [ ] Dark mode

## Tech Stack

- **Java 17**
- **Maven**
- **Swing / JavaFX** for UI

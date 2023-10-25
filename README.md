# Olympic Database Project

## Overview
This project is a Java application that provides an interactive interface for exploring the history of Olympic athletes. The application adheres to an object-oriented data model and uses the JDK and OpenJFX libraries. It allows users to enter, search, and explore data related to Olympic athletes, teams, sports, events, and games.

## Features
* **Data Import**: At the start of the program, you will be prompted to enter the absolute path of the `olympic.db` file on your machine. The application will then import this data and convert it into the program's data model.
* **Data Exploration**: The application allows you to view details of athletes, teams, sports, events, and Olympic games. You can search by name for athletes, teams, sports, and events, or by year for Olympic games.
* **Data Entry**: In interactive mode, you can use an input mask to create new athletes or results. The application will automatically generate a unique ID for each new athlete.
* **Data Persistence**: New athletes and results are serialized so that they can be found and displayed both during the current program start and when restarting the program.
* **User Interface**: The application features a user-friendly graphical JavaFX interface that is easy to understand and interact with.

## Technologies Used
* **Java**: The main programming language used in this project.
* **JavaFX**: Used to create the graphical user interface.
* **JDK**: The Java Development Kit used for developing the application.

## Notes
Please note that this program does not use serialization. All other features mentioned in the task description have been successfully implemented.

The UML Diagram was challenging to edit in IntelliJ. Therefore, I added one UML diagram with all packages and their dependencies, one with all packages without dependencies, and further diagrams that only display certain packages.

## How to Run
1. Start the program.
2. When prompted, enter the absolute path of your `olympic.db` file in the console.
3. Explore the data or add new entries as needed.

## Future Work
This project is a comprehensive solution for exploring Olympic history. Future work could include expanding the data model to include more details or adding more advanced search features.

Thank you for considering this project. If you have any questions or need further information, please don't hesitate to ask.

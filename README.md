## NotepadGG

### A simple Notepad-style text editor built in Java using Swing.
This project recreates the core functionality of a classic notepad application, allowing users to create, edit, save, and print text files through a graphical interface.

The goal of this project is to demonstrate the fundamentals of Java GUI development, event handling, and file I/O operations using standard Java libraries.


## Overview

NotepadGG is a lightweight desktop application that provides basic text editing features similar to the classic Windows Notepad. The program is built using Java Swing and focuses on simplicity and ease of use.

The application window contains:
- A text editing area
- A menu bar with common editor functions
- Keyboard shortcuts for faster interaction
- Support for opening, saving, and printing text files

The main logic of the program is implemented in the NotepadGG class, which extends JFrame and handles all user actions through an event listener.


## Features
### File Operations
- Create a new document
- Open .txt files
- Save text files
- Print documents
- Exit the application

### Edit Operations
- Copy selected text
- Paste text
- Cut text
- Select all text

### Interface Features
- Scrollable text area
- Word wrapping
- Keyboard shortcuts for common actions
- Custom application icon
- Responsive window resizing


### Technologies Used
| Technology | Purpose                              |
| ---------- | ------------------------------------ |
| Java       | Core programming language            |
| Java Swing | Graphical User Interface             |
| AWT        | Event handling and window management |
| Java IO    | File reading and writing             |


### Important Files

- NotepadGG.java

Main application class responsible for:
- Creating the window
- Setting up menus
- Handling user input
- Managing file operations
It also implements the ActionListener interface to process menu actions.


### How to Run the Project
Requirements
- Java JDK 8 or newer
- Any Java IDE (NetBeans, IntelliJ, Eclipse) or command line


### Running in an IDE

1. Clone the repository
git clone https://github.com/yourusername/notepadgg.git

2. Open the project in your IDE.

3. Run:
NotepadGG.java

The application window will launch immediately.


### Running from Command Line

1. Navigate to the source folder and compile:
javac notepadgg/NotepadGG.java

2. Run the program:
java notepadgg.NotepadGG


### Keyboard Shortcuts

| Shortcut   | Action       |
| ---------- | ------------ |
| Ctrl + N   | New document |
| Ctrl + O   | Open file    |
| Ctrl + S   | Save file    |
| Ctrl + P   | Print        |
| Ctrl + C   | Copy         |
| Ctrl + V   | Paste        |
| Ctrl + X   | Cut          |
| Ctrl + A   | Select all   |
| Ctrl + H   | Help         |
| Ctrl + Esc | Exit         |


### How the Program Works

The application follows a simple event-driven structure.

1. Window Creation
- The NotepadGG constructor initializes:
- The main application window
- Menu bar and menu items
- The text editing area
- Scroll pane

2. User Interaction
Each menu option triggers an event handled inside the actionPerformed() method.

For example:
- Open → Opens a file chooser and loads a .txt file into the editor
- Save → Writes the contents of the text area to a file
- Copy/Paste/Cut → Manipulates selected text in the editor

3. File Handling
Java's BufferedReader and BufferedWriter are used for reading and writing files.


### Learning Goals

This project is useful for understanding:
- Java Swing UI design
- Event-driven programming
- File handling in Java
- GUI application structure


### License
This project is open-source and available for educational purposes.

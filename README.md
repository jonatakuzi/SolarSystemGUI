 Overview

SolarSystemGUI is a modular Java Swing application that displays solar-system objects using a clean, event-driven GUI design.
The project integrates:

enum-based data modeling

Custom panels with Swing components (JFrame, JPanel, JButton, JTextArea, JTable)

A timer-based animation example

User event handling with ActionListener

A composite layout using BorderLayout, FlowLayout, and BoxLayout

The application presents a visual “mini-framework” similar to a dashboard: a central display panel, a control panel of selectable stars/planets, and a fact/description panel.

 Features
 Solar System Enum

Defines star/planet names

Includes physical facts (e.g., mass, radius)

Provides helper methods for easy lookup and integration

 Interactive Event Handling

Buttons update the selected solar-system object

Timer-based animation (Horstmann-style) for periodic updates

Console or dialog feedback showing selected objects

 JTable Facts Panel

Displays star/planet facts in a scrollable table

Data automatically sourced from the enum

Clean, readable layout

 Description Pane

Text area with line wrapping enabled

Displays a short description for the selected object

Designed to fit neatly in the right-side info panel

Modular GUI Structure

Panels separated into reusable classes

Makes the code ready for extension (e.g., images, calendars, etc.)

Encourages scalable frontend design practices

 Project Structure
src/
 ├── enums/
 │    └── SolarSystemStarEnum.java
 ├── ui/
 │    ├── StarPanel.java
 │    ├── InfoPanel.java
 │    ├── ControlPanel.java
 │    └── TablePanel.java
 ├── Main.java
 └── resources/
      └── images/   (optional: icons for stars/planets)

      Technologies used

Java 17+

Swing (JFrame, JPanel, JTable, JTextArea, Timer)

Object-oriented design

Event-driven programming 

# SolarSystemGUI

A Java Swing desktop application that displays an interactive solar system interface. Built around enum-based data modeling and event-driven GUI components to simulate a real-world dashboard layout.

## Features

- **Enum-driven data** — planets and stars defined with attributes (mass, radius, description) directly in a Java enum
- - **Interactive selection panel** — buttons update the active solar body in real time
  - - **JTable facts panel** — scrollable table auto-populated from the enum data
    - - **Description pane** — text area with line wrapping showing details for the selected body
      - - **Timer animation** — periodic UI update cycle using `javax.swing.Timer`
        - - **Composite layout** — `BorderLayout`, `FlowLayout`, and `BoxLayout` combined into a clean dashboard structure
         
          - ## Tech Stack
         
          - - Java 17+
            - - Java Swing (`JFrame`, `JPanel`, `JButton`, `JTable`, `JTextArea`, `JScrollPane`)
              - - `javax.swing.Timer` for animation
                - - IntelliJ IDEA
                 
                  - ## Project Structure
                 
                  - ```
                    SolarSystemGUI/
                    ├── SolarSystemApp.java    # Main frame, layout assembly, event wiring
                    ├── SolarSystemStar.java   # Enum defining solar bodies with attributes
                    └── README.md
                    ```

                    ## Running the App

                    1. Clone the repo
                    2. 2. Open in IntelliJ IDEA (or any Java IDE)
                       3. 3. Run `SolarSystemApp.java`
                         
                          4. ## Concepts Demonstrated
                         
                          5. - Java enums with fields, constructors, and instance methods
                             - - Swing layout managers composed into a multi-panel dashboard
                               - - `ActionListener` for button-driven state updates
                                 - - `TableModel` population from enum data
                                   - - Timer-based periodic UI refresh pattern

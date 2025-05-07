# 🎨 myPaint

A simple paint/drawing grid built in Java using the [SimpleGraphics](https://github.com/AcademiaDeCodigo/SimpleGraphics) library.

Created during the Code for All bootcamp to practice graphics, keyboard input, and file I/O in Java.

---

##  Features

- Move the brush with arrow keys
- Press `Space` to paint or erase a cell
- Press `S` to save the current drawing to a file
- Press `L` to load a saved drawing
- Press `C` to clear the entire grid

---

##  How to Run

1. Clone this repository:

    ```bash
    git clone https://github.com/raquelvencovsky/myPaint.git
    cd myPaint
    ```

2. Open the project in **IntelliJ IDEA**

3. Make sure the **SimpleGraphics** library is added to your project dependencies

4. Run the `Main.java` file

---

##  Project Structure

```
src/
└── io.bootcamp.codeforall.kernelfc/
    ├── Main.java          # Launches the program
    ├── Game.java          # Initializes grid and brush
    ├── Brush.java         # Handles movement and drawing
    ├── Grid.java          # Creates and tracks the drawing grid
    └── GridPosition.java  # Handles coordinate conversion
```

---

##  Drawing File

Drawings are saved to a file called `drawing.txt` in the root folder.  
Only the coordinates of painted cells are saved.

---

##  Requirements

- Java 11 or higher
- IntelliJ IDEA
- [SimpleGraphics](https://github.com/AcademiaDeCodigo/SimpleGraphics) library

---

##  Author

Made by **Raquel Vencovsky**  
During the **Code for All Fullstack developer bootcamp**

---

##  License

MIT License – feel free to use, learn from, or improve it.

# 2D Map Generator - Procedural Terrain Generation through Cellular Automata
By Yuki Kawahara, Neshua Aguilar, Ahmed Aldirderi Abdalla Ahmed

## About this Project

In this project, we implement an algorithm to continuously generate a 2D map. We did this by creating a cellular automaton.
In a cellular automaton, each cell in a grid changes its state depending on pre-defined rules. Usuallly, it is based off of the state of neighboring cells.

The number of states a cell can be in, k, changes the complexity of the automaton. Our program mainly runs with a binary system of "dead" and "alive". 
Other states are added after these main states are determined.

This program produces a window with a square grid populated with dead or alive cells. Users can press buttons to iterate the cellular automaton until it becomes stable, when the iteration stops and details are generated.
This procedurally generates what looks like a 2D map of land and ocean (or a cave system, in "cave" mode) with a very large number of possible maps.
The user can predesignate the size of the map which influences the resolution of the map, and the probability of cells to initially start in the "alive" state, which affects the proportion of land-water cover in the final stable state.

With this program, we generate our exploration into setting an algorithm to generate a large matrix. We set predefined rules that the computer follows to run and "solve".

## How to Run

Run the main method of app.java to run the program.

Set the desired dimensions of the board with "height" and "width" variables in MyPanel.java (Currently only works with square grid!)
MyPanel controls the visual elements of the cellular automaton.

To see the integer matrix in action, run the main method of gol.java. 
It also prompts to save a matrix. Name it to create a text file saving a printed matrix.
To load a saved file, type in the name of the file (without .txt) when prompted.

## Application of the Program

Algorithms such as the 2D Map Generator are useful when creating visual elements that require unpredictability or randomness.
This is especially the case in video game and tabletop game maps. Procedural generation allows for replayability and unique experience without pre-built levels.
Due to the simplistic nature of the rules and initialization, as well as the lack of need for extensive memory, it also saves space.
 
## Ruleset
We created our automaton based on Conway's game of life, using Moore's neighborhood (3x3 space surrounding a cell).
In this binary ruleset, cells are either dead or alive. The rules are as follows:

- If a cell is alive, and there are fewer than 2 live neighbors, the cell dies (underpopulation)
- If a cell is alive and there are more than 3 live neighbors, the cell dies (overpopulation)
- If a cell is dead and there are 3 live neighbors, the cell comes alive (population growth)

However, Conway's rules do not guarantee a stable condition. In fact, often times the live cells expand outward and off-screen, leaving mostly dead cells with dots of stable 2x2 and 1x3 cell groups.
Thus, we utilize a simplified ruleset to guarantee a large stable mass.

- If a cell is alive and has fewer than 3 live neighbors, it dies.
- If a cell is dead and has more than 4 live neighbors, it comes alive.


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.awt.*;
import java.awt.*;
import java.util.Scanner;
import javax.swing.*;



public class gol {

    private int col, row;
    private int numStates = 2;
    protected int [][]board;

    private int maxIterateCount = 10;
    private boolean auto = false;
    private boolean generateNew = true;


    public gol(int height, int width){

        this.col = width;
        this.row = height;
        this.board = new int[col][row];
        
        run();
//        testBoard();
    }

    public gol(int height, int width, boolean auto, boolean generateNew ){
        this.col = width;
        this.row = height;
        this.board = new int[col][row];
        this.auto = auto;
        this.generateNew = generateNew;
        run();
    }

    public int[][] getBoard(){
        return this.board;
    }

    /**
     * Returns the number of columns
     * @return number of columns
     */
    public int getNumColumn(){
        return this.col;
    }

    /**
     * Returns the number of rows
     * @return number of rows
     */
    public int getNumRow(){
        return this.row;
    }

    private void fill(){ //Fills each column as either 1 or 0
        if (generateNew){
            Random state = new Random();
            int upperBound = numStates;

            // Makes outer rims all 0 and randomizes inner matrix
//        for(int i = 1; i< col-1;i++){
//            for(int j = 1; j< row-1 ; j++){
//                board[i][j] = state.nextInt(upperBound);
//                // board[i][j] = 20;
//            }
//        }
            for(int i = 0; i< col;i++){
                for(int j = 0; j< row; j++){
                    board[i][j] = state.nextInt(upperBound);
                }
            }

        } else { // generate preset
            testBoard();
        }

    }

    private void testBoard() { //reads in a text file and creates a matrix from it
        try {
            File file = new File("test");
            ArrayList<int[]> presetBoard = new ArrayList<>();

            Scanner scLine = new Scanner(file);

            while(scLine.hasNextLine()){ //Take each line from textfile and create an int array; add to presetboard
                String nextLine = scLine.nextLine();
                String newString = nextLine.replaceAll("[^-?\\d,]", ""); //regex: not digits and comma
                String[] extracted = newString.split(",");
                presetBoard.add(toIntArray(extracted)) ;
            }

            int colDim = presetBoard.size();
            int rowDim = presetBoard.get(0).length;

            int[][] newBoard = new int[rowDim][colDim]; //make into a 2d int matrix of arrays
            for (int i=0; i<rowDim;i++){
                for (int j=0;j<colDim;j++){
                    newBoard[i][j] = presetBoard.get(i)[j];
                }
            }

            col = colDim;
            row = rowDim;
            board = newBoard;

        } catch (FileNotFoundException e){
            System.out.println("No File Found");
            e.printStackTrace();
        }

    }

    /**
     * Converts a String array with numbers into an array of integers
     * @param input String array with numbers
     * @return integer array
     */
    private int[] toIntArray(String[] input){
        int[] intArray = new int[input.length];
        for (int i=0;i<input.length;i++){
            intArray[i] = Integer.parseInt(input[i]);
        }
        return intArray;
    }

    void iterate(){ //iterate to next state
        int[][] nextGen = new int[col][row];

        //looping through main board

        for (int x = 0; x < row; x++) {
            for (int y = 0; y < col; y++) {

                int aliveNeighbors = 0;

                // looping through the neighbors
                for (int i = -1; i < 2; i++) { //Moore's neighborhood
                    for (int j = -1; j < 2; j++) {
                        try {
                            if (board[x + i][y + j] > Integer.MIN_VALUE) {
                                aliveNeighbors += board[x + i][y + j];//count alive neighbors
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            //do nothing
                        }
                    }
                }

                aliveNeighbors -= board[x][y]; // delete self count
                // System.out.println("live["+x+"]["+y+"]:"+aliveNeighbors );

                int newState = deadOrAlive(board[x][y], aliveNeighbors);

                nextGen[x][y] = newState;
            }
        }
        board = nextGen;
        printBoard(board);
    }

    /**
     * Determines if a cell is dead or alive based on Conway's rules.
     * @param currentState current state of a cell
     * @param neighbors number of alive neighbors
     * @return int of new state of the cell
     */
    private int deadOrAlive(int currentState, int neighbors){ //Conway

        if ((currentState == 1) && (neighbors < 2)){ // alive and few neighbors --> die
            return  0;
        }

        if ((currentState == 1) && (neighbors > 3 )){ //alive and many neighbors --> die
            return 0;
        }

        if ( (currentState ==0) && (neighbors == 3)) { //dead and 3 neighbors --> alive
            return 1;
        }

        else {
            return currentState;
        }
    }

    /**
     * Prints the board as an array
     * @param mat
     */
    public static void printBoard(int[][]mat){
        for (int[] row : mat)
 
        // converting each row as string
        // and then printing in a separate line
        System.out.println(Arrays.toString(row));
        System.out.println("---------------------------------------");
    }

    /**
     * Saves a created matrix as a textfile.
     * @param mat int matrix to save
     */
    public static void saveMatrix(int[][] mat){
        Scanner sc = new Scanner(System.in);
        System.out.println("What would you like to name the matrix?");
        String filename = sc.next()+".txt";
        try{
            File file = new File(filename);
            if (file.createNewFile()){
                System.out.println("File "+filename + " created.");
            } else {
                System.out.println("Overwriting " + filename);
            }
            FileWriter writer = new FileWriter(filename);

            for (int[] row : mat){
                writer.write(Arrays.toString(row));
                writer.write("\n");
            }
            writer.close();


        } catch (IOException e){
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }

    /**
     * Return value in a cell
     * @param x row number
     * @param y column number
     * @return int value in the cell
     */
    private int getCell(int x, int y){
        return board[x][y];
    }

    /**
     * Run method for automatic iteration.
     */
    private void autoRun(){ //iterate automatically for a given number of ticks.
        fill();
        for (int i=0; i<maxIterateCount;i++){
            pause();
            iterate();
        }
    }

    /**
     * Runs gol. Checks if it should auto iterate or not here.
     */
    private void run(){
        if (auto){
            autoRun();
        } else {
            fill();
        }
    }

    private void pause() {
        try{
            Thread.sleep(4000);
        } catch (InterruptedException e){
            System.out.println("InterruptedException");
        }
    }

    public static void main(String[] args) {
        gol newgol = new gol(48,48);
        printBoard(newgol.getBoard());
        newgol.iterate();
        saveMatrix(newgol.getBoard());
    }

}

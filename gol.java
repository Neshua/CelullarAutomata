import java.util.Arrays;
import java.util.Random;
import java.awt.*;
import java.awt.*;
import javax.swing.*;



public class gol {

    private int col, row;
    private int w = 8;
    protected int [][]board;

    public gol(int height, int width){

        // this.setPreferredSize(new Dimension(width,height));

        this.col = width/w;
        this.row = height/w;
        this.board = new int[col][row];
        

        fill();

    }

    public int[][] getBoard(){
        return this.board;
    }

    public int getNumColumn(){
        return this.col;
    }

    public int getNumRow(){
        return this.row;
    }

    private void fill(){
        Random state = new Random();
        int upperBound = 2;

        //Fills each column as either 1 or 0
        for(int i = 1; i< col-1;i++){
            for(int j = 1; j< row-1 ; j++){
                board[i][j] = state.nextInt(upperBound);
                // board[i][j] = 20;
            }
        }
    }

    private void iterate(){
        int[][] nextGen = new int[col][row];

        //looping through main board

        for (int x = 1; x< col-1; x++){
            for (int y = 1; y<row-1;y++){

                int aliveNeighbors = 0;

                // looping through the neighbors
                for (int i = -1; i <2; i++){
                    for(int j = -1; j <2; j++){
                        aliveNeighbors += board[x+i][y+j];//count alive neighbors 
                    }
                }

                aliveNeighbors -= board[x][y]; // delete self count
                // System.out.println("live["+x+"]["+y+"]:"+aliveNeighbors );

                int newState = deadOrAlive(board[x][y], aliveNeighbors);

                nextGen[x][y] = newState;

                // prinfBoard(nextGen);

            }

            // prinfBoard(nextGen);

        }

        board = nextGen;
        prinfBoard(board);

    }

    private int deadOrAlive(int currentState, int neighbors){

        if ((currentState == 1) && (neighbors < 2)){
            return  0;
        }

        if ((currentState == 1) && (neighbors > 3 )){
            return 0;

        }

        if ( (currentState ==0) && (neighbors == 3)) {
            return 1;
        }

        else {
            return currentState;
        }
    }


    public static void prinfBoard(int[][]mat){
        for (int[] row : mat)
 
        // converting each row as string
        // and then printing in a separate line
        System.out.println(Arrays.toString(row));
        System.out.println("---------------------------------------");

    }

    public void step(){

    }


    public static void main(String[] args) {
        gol newgol = new gol(48,48);

        
        int [][]currentBoard = newgol.getBoard();

        prinfBoard(currentBoard);
        newgol.iterate();



        
    
    }




}

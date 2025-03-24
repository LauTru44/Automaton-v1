import java.util.Arrays;

/**
 * Model a 1D elementary cellular automaton.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version  2016.02.29 - version 1
 */
public class Automaton
{
    // The number of cells.
    private final int numberOfCells;
    // The state of the cells.
    private int[] state;
    
    /**
     * Create a 1D automaton consisting of the given number of cells.
     * @param numberOfCells The number of cells in the automaton.
     */
    public Automaton(int numberOfCells)
    {
        this.numberOfCells = numberOfCells;
        state = new int[numberOfCells];
        // Seed the automaton with a single 'on' cell in the middle.
    for (int i = 0; i < state.length; i++) {
    if (i % 3 == 0) { // For example: every 3rd cell is alive
        state[i] = 1; // Alive
    } else {
        state[i] = 0; // Dead
    }
    }
    }
    
    /**
     * Print the current state of the automaton.
     */
    public void print()
    {
        for(int cellValue : state) {
            if(cellValue == 1) {
                System.out.print("*");
            }
            else {
                System.out.print(" ");
            }
        }
        System.out.println();
    }   
    
    /**
     * Update the automaton to its next state.
     */
    public void update()
    {
        // Build the new state in a separate array. //Ex 28
      int[] nextState = new int[state.length];
        int left=0;
        int center = state[0];
        for(int i=0;i<state.length;i++){
        int right = i+1<state.length? state [i+1]:0;
        nextState [i]= (left+center+right)%2;
        left=center;
        center=right;
        }
       
         state = nextState;
    }
    
    public int[] calculateNextState(int left,int center,int right){
    
        //Ex 32
      int[] nextState = new int[state.length];
        left=0;
        center = state[0];
        for(int i=0;i<state.length;i++){
         right = i+1<state.length? state [i+1]:0;
        nextState [i]= (left+center+right)%2;
        left=center;
        center=right;
        }
       
         state = nextState;
         return nextState;
    }
    
    /**
     * Reset the automaton.
     */
    public void reset()
    {
        Arrays.fill(state, 0);
        // Seed the automaton with a single 'on' cell.
        state[numberOfCells / 2] = 1;
            
    }
}

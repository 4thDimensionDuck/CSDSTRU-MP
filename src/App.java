import java.util.*;

public class App {

    public static int row = 7;
    public static int col = 5;


    public static Boolean game = true; // Game is running state
    public static Boolean aTurn = true;
    public static P_Alpha Alpha = new P_Alpha();
    public static P_Beta Beta = new P_Beta();

    public static void main(String[] args) throws Exception {

        do 
        {

            if ( aTurn )
            {
                int[] coor = inputMove();
                /* if ( checkLegal( 1, coor[0], coor[1] ) )
                {
                    Alpha.movePos(coor[0], coor[1]);
                }
                */
            }
            else
            {

            }
                

        }
        while ( game );
        
        

    }

    // TODO: check legal moves
    // This may contain all logic in the game
    public static Boolean checkLegal( int player, int x, int y )
    {

        return null;

    }

    public static String nextInput()
    {
        Scanner scanner = new Scanner( System.in );
        scanner.close();
        return scanner.nextLine();
    }


    /**
     * Asks for user input and returns a two element integer array {x, y}.
     * Catches for errors and asks for reinput.
     * @return
     * int[2]
     */
    public static int[] inputMove()
    {
        int next_x = 0, 
            next_y = 0;
        
        System.out.println("Input Next Move: ");
        String next_move = nextInput();
        String[] coor = new String[2];

        coor = next_move.split(" ");

        try 
        {
            next_x = Integer.parseInt( coor[0] );
            next_y = Integer.parseInt( coor[1] );

            int[] output = {next_x, next_y};
            return output ;
        }
        catch ( Exception e )
        {
            System.out.println("Invalid Input.");
            inputMove();
        }

        return null;

    }
    
}
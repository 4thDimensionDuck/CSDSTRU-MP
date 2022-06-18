import java.util.*;

public class App {

    public static int row = 7;
    public static int col = 5;

    public static int[][] board = new int[col][row];
    public static Boolean over = false;
    public static Boolean aTurn = true;
    public static Boolean ok = true;

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        spawnPlayers();
        
        do
        {
            clear();
            printBoard();

            if ( aTurn )
            System.out.println("Alpha's Turn!");
            else
            System.out.println("Beta's Turn!");

            int[] prev;
            int[] next;

            do
            {

                System.out.println("Pick a Piece: ");
                prev = inputMove();

                System.out.println("Pick a Destination: ");
                next = inputMove();

            }
            while ( NextPlayerMove( new Position( prev[0], prev[1] ), new Position( next[0], next[1] ) ) );

            

            

        }
        while ( !over );

        



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
        
        String next_move = scanner.nextLine();
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

    public static void clear()
    {
        System.out.print("\033[2J\033[1;1H");
        System.out.flush();
    }

    public static void spawnPlayers()
    {

        for (int[] r: board)
        Arrays.fill(r, 0);

        // Spawn Alpha
        for ( int y = 5; y <= 6; y++ )
        {
            for ( int x = 0; x <= 4; x++ )
            {
                if ( x % 2 == y % 2 )
                {
                    board[x][y] = 1;
                }
            }
        }

        // Spawn Beta
        for ( int y = 0; y <= 1; y++ )
        {
            for ( int x = 0; x <= 4; x++ )
            {
                if ( x % 2 == y % 2 )
                {
                    board[x][y] = 2;
                }
            }
        }

    }

    public static Boolean NextPlayerMove( Position prev, Position next )
    {

        ok = true;

        int a = prev.getX() - 1;
        int b = prev.getY() - 1;
        int c = next.getX() - 1;
        int d = next.getY() - 1;
        
        if ( aTurn && board[a][b] == 1 && a == c + 1 && (d == b || d == b + 1 || b == d + 1 ) )
        ok = !ok;

        if ( !aTurn && board[a][b] == 2 && c == a + 1 && (d == b || d == b + 1 || b == d + 1) )
        ok = !ok;

        if ( ok && aTurn && board[c][d] == 0 )
        {
            board[a][b] = 0;
            board[c][d] = 1;
            aTurn = !aTurn;
            ok = !ok;
        }

        if ( ok && !aTurn && board[c][d] == 0 )
        {
            board[a][b] = 0;
            board[c][d] = 2;
            aTurn = !aTurn;
            ok = !ok;
        }

        if ( ok && aTurn && board[c][d] == 2 && ( c % 2 != d % 2 ) )
        ok = !ok;

        if ( ok && aTurn && board[c][d] == 2 && ( c % 2 == d % 2 ) )
        {
            board[a][b] = 0; // Clear Alpha from prev
            board[c][d] = 1; // Replace Beta
            aTurn = !aTurn;
            ok = !ok;
        }

        if ( ok && !aTurn && board[c][d] == 1 && ( c % 2 != d % 2 ) )
        ok = !ok;

        if ( ok && !aTurn && board[c][d] == 1 && ( c % 2 == d % 2 ) )
        {
            board[a][b] = 0; // Clear Beta from prev
            board[c][d] = 2; // Replace Alpha
            aTurn = !aTurn;
            ok = !ok;
        }

        return ok;
    }

    public static void printBoard()
    {

        System.out.println("  1 2 3 4 5");

        for (  int y = 0; y < row; y++ )
        {

            for ( int x = 0; x < col; x++ )
            {   
                if ( x == 0 )
                {
                    System.out.printf("%d ", y+1);
                }

                if ( board[x][y] == 0 )
                {
                    if ( x % 2 == y % 2 )
                    System.out.printf("# ");
                    else
                    System.out.printf("* ");
                }
                else if ( board[x][y] == 1 )
                {
                    System.out.printf("A ");
                }
                else
                {
                    System.out.printf("B ");
                }
            }
            System.out.println();

        }

    }

}

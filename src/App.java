import java.util.Arrays;

public class App {

    public static int row = 7;
    public static int col = 5;

    public static int[][] board = new int[col][row];
    public static Boolean aTurn = true;
    public static Boolean ok = false;

    public static void main(String[] args) throws Exception {
        
        clear();

        spawnPlayers();
        
        printBoard();

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

    public static void NextPlayerMove( Position prev, Position next )
    {

        int a = prev.getX();
        int b = prev.getY();
        int c = next.getX();
        int d = next.getY();
        
        if ( aTurn && board[a][b] == 1 && a == c + 1 && (d == b && d == b + 1 && b == d + 1 ) )
        ok = !ok;

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

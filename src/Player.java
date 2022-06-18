
/** 
 * A Player Object
 */
public class Player
{

    private int pos_x;
    private int pos_y;

    /** 
     * State system:
     * <p>case 0: Dead
     * <p>case 1: Idle
     * <p>case 2: Player's turn (optional)
     */
    private Boolean state;
    
    public Player() {
    }

    public Player( Boolean state ) {
        this.state = state;
    }

    public Player( int x, int y, Boolean state ) {
        this.pos_x = x;
        this.pos_y = y;
        this.state = state;
    }

    public int getPos_x() {
        return pos_x;
    }

    public void setPos_x(int pos_x) {
        this.pos_x = pos_x;
    }

    public int getPos_y() {
        return pos_y;
    }

    public void setPos_y(int pos_y) {
        this.pos_y = pos_y;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public void movePos( int x, int y )
    {
        this.pos_x = x;
        this.pos_y = y;
    }

    public void movePos( int[] coor )
    {
        this.pos_x = coor[0];
        this.pos_y = coor[1];
    }

}
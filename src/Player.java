public class Player {
    
    //private Position currentPos;

    /**
     * <p>0 is Empty
     * <p>1 is Alpha
     * <p>2 is Beta
     */
    private int team;
    
    /*
    public Player( int team, Position currentPos) {
        this.team = team;
        this.currentPos = currentPos;
    }
    */

    public Player(int team) {
        this.team = team;
    }

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }

    /* 
    public Position getCurrentPos() {
        return currentPos;
    }

    public void setCurrentPos(Position currentPos) {
        this.currentPos = currentPos;
    }
    */
}

public class Position {
    
    private int x;
    private int y;
    
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int[] getPos()
    {
        int[] output = { x, y };
        return output;
    }

    public void setPos( int[] pos )
    {   
        this.x = pos[0];
        this.y = pos[1];
    }

}

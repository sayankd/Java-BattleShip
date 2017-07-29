public class ship
{
    /* Instance Variables */
    private int row;
    private int col;
    private int length;
    private int direction;
    
    // Direction Constants
    public static final int U = 100;
    public static final int H = 1;
    public static final int V = 2;
    
    // Constructor
    public ship(int l)
    {
        this.length = l;
        this.row = 100;
        this.col = 100;
        this.direction = U;
    }
    
    // Has the location been init
    public boolean islocationset()
    {
        if (row == 100 || col == 100)
            return false;
        else
            return true;
    }
    
    // Has the direction been init
    public boolean isdirectionset()
    {
        if (direction == U)
            return false;
        else
            return true;
    }
    
    // Set the location of the ship
    public void setlocation(int r, int c)
    {
        this.row = r;
        this.col = c;
    }
    
    // Set the direction of the ship
    public void setdirection(int d)
    {
        if (direction != U && direction != H && direction != V)
            throw new IllegalArgumentException("Invalid direction. It must be 100, 1, or 2");
        this.direction = d;
    }
    
    // Getter for the row value
    public int getrow()
    {
        return row;
    }
    
    // Getter for the column value
    public int getcol()
    {
        return col;
    }
    
    // Getter for the length of the ship
    public int getlength()
    {
        return length;
    }
    
    // Getter for the direction
    public int getdirection()
    {
        return direction;
    }
    
    // Helper method to get a string value from the direction
    private String directiontostring()
    {
        if (direction == U)
            return "UNSET";
        else if (direction == H)
            return "HORIZONTAL";
        else
            return "VERTICAL";
    }
    
    // toString value for this Ship
    public String tostring()
    {
        return "Ship: " + getrow() + ", " + getcol() + " with length " + getlength() + " and direction " + directiontostring();
    }
}

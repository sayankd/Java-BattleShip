package com;

public class Ship {
	private static final int UNSET = -1;
	private static final int HORIZONTAL = 0;
	private static final int VERTICAL = 1;
	private int row;
	private int col;
	private int length;
	private int direction;
	public Ship(int length)
	{
		row = -1;
		col = -1;
		this.length = length;
		direction = -1;
	}
	public int getRow() {
		return row;
	}
	public void setLocation(int row,int col) {
		this.row = row;
		this.col = col;
	}
	public int getCol() {
		return col;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) throws Illegalpointerexception {
		if((this.direction!=UNSET)&&(this.direction!=HORIZONTAL)&&(this.direction!=VERTICAL))
				throw new Illegalpointerexception("VALUE MUST BE -1,0 OR 1");
		this.direction = direction;
	}
	public boolean isDirectionSet()
	{
		if(direction ==UNSET)
		{
			return false;
		}
		return true;
	}
	public boolean IsLocationSet()
	{
		if((row==-1)||(col==-1))
		{
			return false;
		}
		return true;
	}

}

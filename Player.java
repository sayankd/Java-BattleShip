package com;

public class Player {
	private static final int[] SHIP_LENGTH = {2,3,3,4,5};
	private static final int NO_SHIP = 5;
	private Ship[] ships;
	private Grid playergrid;
	public Ship[] getShips() {
		return ships;
	}
	public void setShips(Ship[] ships) {
		this.ships = ships;
	}
	public Grid getPlayergrid() {
		return playergrid;
	}
	public void setPlayergrid(Grid playergrid) {
		this.playergrid = playergrid;
	}
	public Grid getOppogrid() {
		return oppogrid;
	}
	public void setOppogrid(Grid oppogrid) {
		this.oppogrid = oppogrid;
	}
	private Grid oppogrid;
	public Player()
	{
		ships = new Ship[NO_SHIP];
		for(int i=0;i<NO_SHIP;i++)
		{
			Ship temp = new Ship(SHIP_LENGTH[i]);
			ships[i] = temp;
		}
		playergrid = new Grid();
		oppogrid = new Grid();
	}
	public int numOfShipLeft()
	{
		int count = 5;
		for(Ship x:ships)
		{
			if(x.isDirectionSet() && x.IsLocationSet())
			{
				count--;
			}
		}
		return count;
	}
	
	
	

}

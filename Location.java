package com;

public class Location {
	private final static int UNGUESSED = 0;
	private final static int HIT = 1;
	private final static int MISS = 2;
	private boolean hasship;
	private int status;
	private int ship_length;
	public int getShip_length() {
		return ship_length;
	}
	public void setShip_length(int ship_length) {
		this.ship_length = ship_length;
	}
	public Location() {
		this.hasship = false;
		this.status = UNGUESSED;
	}
	public boolean isHasship() {
		return hasship;
	}
	public void setHasship(boolean hasship) {
		this.hasship = hasship;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public boolean checkhitmiss()
	{
		if(status == HIT)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public void sethit()
	{
		setStatus(HIT);
	}
	public void setmiss()
	{
		setStatus(MISS);
	}
	public boolean IsGuessed()
	{
		if(status == UNGUESSED)
		{
			return false;
		}
		return true;
	}
	

}

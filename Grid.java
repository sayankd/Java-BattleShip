package com;

public class Grid {
	private Location[][] grid;
	private int points;
	private static final int ROW_NUM = 10;
	private static final int COL_NUM = 10;
	public Grid()
	{
		points = 0;
		grid = new Location[10][10];
		for(int i=0;i<ROW_NUM;i++)
		{
			for(int j=0;j<COL_NUM;j++)
			{
				grid[i][j] = new Location();
			}
		}
	}
	public void MarkHit(int row,int col)
	{
		grid[row][col].sethit();
		points++;
		System.out.println("p="+points);
	}
	public void MarkMiss(int row,int col)
	{
		grid[row][col].setmiss();
	}
	public boolean AlreadyGuessed(int row,int col)
	{
		return grid[row][col].IsGuessed();
	}
	public void setShip(int row,int col)
	{
		grid[row][col].setHasship(true);
	}
	public boolean hasShip(int row,int col)
	{
		return grid[row][col].isHasship();
	}
	public boolean hasLost()
	{
		if(points>=17)
		{
			return true;
		}
		else
			return false;
	}
	public void AddShip(Ship s) throws Illegalpointerexception
	{
		int row = s.getRow();
		int col = s.getCol();
		int length = s.getLength();
		int dire = s.getDirection();
		if((!s.isDirectionSet())||(!s.IsLocationSet()))
			throw new Illegalpointerexception("ERROR:Location Direction of ship can't be default");
		if(dire==0)
		{
			for(int i=col;i<col+length;i++)
			{
				grid[row][i].setHasship(true);
				grid[row][i].setShip_length(length);
			}
		}
		else if(dire==1)
		{
			for(int i=row;i<row+length;i++)
			{
				grid[i][col].setHasship(true);
				grid[i][col].setShip_length(length);
			}
		}
	}
	public void printstatus()
	{
		int i,j;
		for(i=0;i<ROW_NUM;i++)
		{
			for(j=0;j<COL_NUM;j++)
			{
				if(!grid[i][j].IsGuessed())
				{
					System.out.print("- ");
					
				}
				else if(grid[i][j].checkhitmiss()==true)
				{
					System.out.print("X ");
				}
				else
				{
					System.out.print("O ");
				}
			}
			System.out.println();
		}
	}
	public void printships()
	{
		int i,j;
		for(i=0;i<ROW_NUM;i++)
		{
			for(j=0;j<COL_NUM;j++)
			{
				if(grid[i][j].isHasship())
				{
					if(grid[i][j].getShip_length()==2)
						System.out.print("D ");
					if(grid[i][j].getShip_length()==3)
						System.out.print("C ");
					if(grid[i][j].getShip_length()==4)
						System.out.print("B ");
					if(grid[i][j].getShip_length()==5)
						System.out.print("A ");
				}
				else
				{
					System.out.print("- ");
				}
			}
			System.out.println();
		}
	}
	public void printcombined()
	{
		int i,j;
		for(i=0;i<ROW_NUM;i++)
		{
			for(j=0;j<COL_NUM;j++)
			{
				if(grid[i][j].isHasship())
				{
					if((grid[i][j].getShip_length()==2) && (grid[i][j].getStatus()==1))
					{
						System.out.print("X ");
					}
					if((grid[i][j].getShip_length()==2) && (grid[i][j].getStatus()!=1))
					{
						System.out.print("D ");
					}
					if((grid[i][j].getShip_length()==3) && (grid[i][j].getStatus()==1))
					{
						System.out.print("X ");
					}
					if((grid[i][j].getShip_length()==3) && (grid[i][j].getStatus()!=1))
					{
						System.out.print("C ");
					}
					if((grid[i][j].getShip_length()==4) && (grid[i][j].getStatus()==1))
					{
						System.out.print("X ");
					}
					if((grid[i][j].getShip_length()==4) && (grid[i][j].getStatus()!=1))
					{
						System.out.print("B ");
					}
					if((grid[i][j].getShip_length()==5) && (grid[i][j].getStatus()==1))
					{
						System.out.print("X ");
					}
					if((grid[i][j].getShip_length()==5) && (grid[i][j].getStatus()!=1))
					{
						System.out.print("A ");
					}
					
				}
				else if(grid[i][j].IsGuessed())
					System.out.print("0 ");
				else
					System.out.print("- ");
			}
			System.out.println();
		}
	}

}

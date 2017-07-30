package com;

import java.util.Scanner;

public class BattleShip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player computer = new Player();
		setup(computer,1);

		Player user = new Player();
		setup(user,0);
		String res0 = "",res1 = "";
		while(true)
		{
			//user.getPlayergrid().printcombined();
			System.out.println();
			System.out.println("USER MAKING GUESS");
			res0 = askForGuess(user,computer,0);
			System.out.println(""+res0);
			System.out.println("COMPUTER MAKING GUESS");
			res1 = askForGuess(computer,user,1);
			if(user.getPlayergrid().hasLost())
			{
				System.out.println("COMPUTER HIT...USER LOST!!!");
				break;
			}
			if(computer.getPlayergrid().hasLost())
			{
				System.out.println("USER HIT....COMPUTER LOST!!!");
				break;
			}
			
		}
		
		
	}
	
	private static String askForGuess(Player user, Player computer,int stat) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("VIEWING MY GUESS");
		if(stat==0)
		{
			System.out.println("aaaa");
			user.getOppogrid().printstatus();
		}
		int row = -1;
		int col = -1;
		while(true)
		{
			if(stat==0)
			{
			System.out.println("Enter Position:");
			row = sc.nextInt();
			col = sc.nextInt();
			}
			if(stat==1)
			{
				row = (int )(Math.random() * 9 + 0);
				col = (int )(Math.random() * 9 + 0);
			}
			System.out.println(row);
			if((row>9) ||(row<0)||(col<0)||(col>9)||(user.getOppogrid().AlreadyGuessed(row, col)))
			{
				System.out.println("Invalid Location");
			}
			else
				break;
			
		}
		System.out.println("ddddd"+computer.getPlayergrid().hasShip(row, col));
		if(computer.getPlayergrid().hasShip(row, col))
		{
			System.out.println("a");
			user.getOppogrid().MarkHit(row, col);
			computer.getPlayergrid().MarkHit(row, col);
			if(stat==0)
				return "USER HIT SHIP AT "+row+" "+col;
			else
			{
				System.out.println("bbbbb");
				computer.getPlayergrid().printcombined();
				return null;
			}
		}
		else
		{
			user.getOppogrid().MarkMiss(row, col);
			computer.getPlayergrid().MarkMiss(row, col);
			if(stat==0)
				return "USER MISS SHIP AT "+row+" "+col;
			else
			{
				System.out.println("ccccc");
				computer.getPlayergrid().printcombined();
				return null;
			}
		}
		
	}

	private static void setup(Player p,int a)
	{
		int r,c,d;
		Scanner sc = new Scanner(System.in);
		int counter = 1;
		int normcounter = 0;
		if(a==0)
		{
			System.out.println("Users Grid");
			p.getPlayergrid().printships();
		}
		while(p.numOfShipLeft()>0)
		{
			for(Ship s:p.getShips())
			{
				System.out.println("\nShip# "+counter+" Length "+s.getLength());
				//System.out.println(""+s.getRow()+""+s.getCol()+""+s.getDirection());
				r = -1;
				c = -1;
				d = -1;
				while(true)
				{
				if(a==0)
				{
				System.out.println("Type row");
				r = sc.nextInt();
				c = sc.nextInt();
				d = sc.nextInt();
				}
				if(a==1)
				{
					r = (int )(Math.random() * 9 + 0);
					c = (int )(Math.random() * 9 + 0);
					d = (int )(Math.random() * 1 + 0);
					System.out.println(r+""+c+""+d);
				}
				if((r!=-1)&&(d!=-1)&&(c>=0)&&(c<=9)&&(r>=0)&&(r<=9))
				{
					if(haserrors(r,c,d,p,normcounter,a)==false)
					{
						break;
					}
				}
				System.out.println("ROW AND COLOUMN SHOULD BE BETWEEN 0-9");
				}
				p.getShips()[normcounter].setLocation(r,c);
				try {
					p.getShips()[normcounter].setDirection(d);
					p.getPlayergrid().AddShip(p.getShips()[normcounter]);
				} catch (Illegalpointerexception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(a==0)
				{
				p.getPlayergrid().printships();
				}
				normcounter++;
				counter++;
			}
		}
		if(a==1)
			p.getPlayergrid().printships();
		
		
	}
	private static boolean haserrors(int r, int c, int d, Player p, int normcounter,int a) {
		// TODO Auto-generated method stub
		int x = p.getShips()[normcounter].getLength();
		if(d==0)
		{
			if((c+x)>10)
			{
				if(a==0)
					System.out.println("Ship does not fit");
				return true;
			}
		}
		if(d==1)
		{
			if((r+x)>10)
			{
				if(a==0)
					System.out.println("Ship does not fit");
				return true;
			}
		}
		if(d==0)
		{
			for(int i = c;i<(c+x);i++)
			{
				if(p.getPlayergrid().hasShip(r, i))
				{
					if(a==0)
						System.out.println("There is a ship present");
					return true;
				}
			}
		}
		else if(d==1)
		{
			for(int i = r;i<(r+x);i++)
			{
				if(p.getPlayergrid().hasShip(i, c))
				{
					if(a==0)
						System.out.println("There is a ship present");
					return true;
				}
			}
		}
		return false;
	}
	

}

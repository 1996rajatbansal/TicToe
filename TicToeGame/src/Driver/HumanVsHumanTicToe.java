package Driver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HumanVsHumanTicToe implements TicToeInterface {

	int arr[][];
	String firstPalyer;
	String secondPlayer;
	BufferedReader br;
	@Override
	public void initializeGame(int n,int m) {
		// TODO Auto-generated method stub
		this.arr=new int[n][m];
		br=new BufferedReader(new InputStreamReader(System.in));
		
	}

	@Override
	public void moveUser() {
		try {
			int x,y;
			boolean isMoveValid=false;
			while(isDrawGame(this.arr))
			{
				System.out.println(firstPalyer+" Enter move cordinates 0 based..");
				x=Integer.parseInt(br.readLine());
				y=Integer.parseInt(br.readLine());
				isMoveValid=isValidMove("0",arr,x,y);
				if(!isMoveValid)
				{
					System.out.println("Invalid Move "+firstPalyer+" Enter again..");
					continue;
				}
				markMove("0", arr, x, y);
				if(isUserWins("0", arr)){
					System.out.println(firstPalyer+" Wins Game..Congrats..");
					return;
				}
				System.out.println(secondPlayer+" Enter move cordinates 0 based..");
				x=Integer.parseInt(br.readLine());
				y=Integer.parseInt(br.readLine());
				isMoveValid=false;
				isMoveValid=isValidMove("1",arr,x,y);
				if(!isMoveValid)
				{
					
					while(true) {
						System.out.println("Invalid Move "+ secondPlayer+" Enter again..");
					x=Integer.parseInt(br.readLine());
					y=Integer.parseInt(br.readLine());
					if(!isValidMove("1", arr, x, y)) {
						continue;
					}
					break;
					}
				}
				markMove("1", arr, x, y);
				if(isUserWins("1", arr)){
					System.out.println(secondPlayer+"Wins Game..Congrats..");
					return;
				}
				
				
				
			}
			System.out.println("OOPS! game draws...");	
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public void startGame(int n,int m) {
		// TODO Auto-generated method stub
		System.out.println("Enter two players name.");
		try {
			initializeGame(n, m);
			for(int i=0;i<n;i++)
			{
				Arrays.fill(arr[i],-1);
			}
			firstPalyer=br.readLine();
			secondPlayer=br.readLine();
			moveUser();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public boolean isValidMove(String user, int[][] arr, int x, int y) {
		// TODO Auto-generated method stub
		try {
			if(x>=0&&x<arr.length&&y>=0&&y<arr[0].length&&arr[x][y]==-1)
			{
				return true;
			}
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean isDrawGame(int[][] arr) {
		// TODO Auto-generated method stub
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[0].length;j++)
			{
				if(arr[i][j]==-1)
				{
					return true;
				}
			}
		}
		
		return false;
	}

	@Override
	public boolean markMove(String user, int[][] arr, int x, int y) {
		// TODO Auto-generated method stub
		arr[x][y]=Integer.parseInt(user);
		return false;
	}

	@Override
	public boolean isUserWins(String user, int[][] arr) {
		// TODO Auto-generated method stub
		try {
			int choice=Integer.parseInt(user);
			int count=0;
			//check rows..
			for(int i=0;i<arr.length;i++)
			{
				count=0;
				for(int j=0;j<arr[0].length;j++)
				{
					if(arr[i][j]==choice)
					{
						count++;
					}
				}
				if(count==arr[0].length)
				{
					return true;
				}
			}
			
			//check coloumns...
			for(int i=0;i<arr[0].length;i++)
			{
				count=0;
				for(int j=0;j<arr.length;j++)
				{
					if(arr[j][i]==choice)
					{
						count++;
					}
				}
				if(count==arr[0].length)
				{
					return true;
				}
			}
			//check diagonaly
			
			for(int i=0;i<arr[0].length;i++)
			{
				count=0;
				for(int j=0;j<arr.length;j++)
				{
					if(arr[j][i]==choice)
					{
						count++;
					}
				}
				if(count==arr[0].length)
				{
					return true;
				}
			}
			count=0;
			int i=0,j=0;
			while(i<arr.length&&j<arr.length&&arr[i][j]==choice)
			{
				i++;
				j++;
				count++;
			}
			if(count==arr.length)
			{
				return true;
			}
			
			count=0;
			i=0;
			j=arr[0].length;
			while(i<arr.length&&j>=0&&arr[i][j]==choice)
			{
				i++;
				j--;
				count++;
			}
			if(count==arr.length)
			{
				return true;
			}
			return false;
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	
	

}

package Driver;

public interface TicToeInterface {
	
	public void initializeGame(int n,int m);
	public void moveUser();
	public void startGame(int n,int m);
	boolean isValidMove(String user,int arr[][],int x,int y);
	boolean isDrawGame(int arr[][]);
	boolean markMove(String user,int arr[][],int x,int y);
	boolean isUserWins(String user,int arr[][]);

}

package Driver;

import java.io.BufferedReader;
import java.io.InputStreamReader;



public class DriverClass {

	public static void main(String[] args) {
		try {
			int n,choice;
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter grid size..");
			n=Integer.parseInt(br.readLine());
			System.out.println("Game Choice..");
			System.out.println("1:Human Vs Human\n 2:Human Vs Computer\n 3:computer vs computer");
			HumanVsHumanTicToe humanTicToe=new HumanVsHumanTicToe();
			ComputerVsComputerTicToe computerTicToe=new ComputerVsComputerTicToe();
			HumanVsComputerTicToe humanVsComputerTicToe=new HumanVsComputerTicToe();
			choice=Integer.parseInt(br.readLine());
			switch (choice) {
			case 1:
				humanTicToe.startGame(n,n);
				break;
			case 2:
				humanVsComputerTicToe.startGame(n, n);
				break;
			case 3:
				computerTicToe.startGame(n, n);

			default:
				break;
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
	}
}

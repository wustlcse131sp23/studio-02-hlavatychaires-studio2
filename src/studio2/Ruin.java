package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		System.out.println("The amount of money that you start with: ");
		double startAmount = in.nextDouble(); 
		
		System.out.println("What's the probability you win a single play?: ");
		double winChance = in.nextDouble(); 
		
		System.out.println("Cash out Goal: ");
		double winLimit = in.nextDouble(); 
		
		System.out.println("Total days playing: ");
		int totalSimulations = in.nextInt(); 
		int rounds = 1;
		int days = 1;
		double originalAmount = startAmount;
		int loss = 0;
		while (days <= totalSimulations) {
		while(startAmount <= winLimit && startAmount > 0 ){
			
		double	winProb = Math.random();
		//System.out.println(winProb);
		
		boolean round = winProb < winChance;
		
		if (round == false) {
			startAmount--;
			rounds ++;
			}
		else {
			startAmount++;
			rounds ++;
		}
		if (startAmount == winLimit){
			System.out.println("Trading Day # " +days + ". Rounds played " + rounds +": You Win!");
//System.out.println("Trading Day # " +days + ": You Win!");
		}
		else if (startAmount == 0) {
			System.out.println("Trading Day # " +days + ". Rounds played " + rounds +": You Lose!");
//System.out.println("Ruin!");		
				loss++;
				}
	
		}
		rounds = 1;
		days++;
		startAmount = originalAmount;
		System.out.println("Losses: " +loss+ " Simulations: " +totalSimulations);
	/*	double ruinRate = loss/totalSimulations;
		double alpha = (1 - winChance)/ winChance;
		if(winChance == 0.5) {
			double expectedRuin = 1-(startAmount/winLimit);
			System.out.println("Ruin rate from simulation: " + ruinRate + " Expected ruin rate: " + expectedRuin);

		}else {
			double expectedRuin = (Math.pow(alpha, startAmount)-Math.pow(alpha, winLimit))/(1-Math.pow(alpha, winLimit));
*/		//	System.out.println("Ruin rate from simulation: " + ruinRate + " Expected ruin rate: " + expectedRuin);

		}
	//	System.out.println("Ruin rate from simulation: " + ruinRate + "Expected ruin rate: " + expectedRuin);
//System.out.println(loss);
		double ruinRate = (double) loss/totalSimulations;
		double alpha = (1 - winChance)/ winChance;
		if(winChance == 0.5) {
			double expectedRuin = 1-(startAmount/winLimit);
			System.out.println("Ruin rate from simulation: " + ruinRate + " Expected ruin rate: " + expectedRuin);

		}else {
			double expectedRuin = (Math.pow(alpha, startAmount)-Math.pow(alpha, winLimit)) / (1-Math.pow(alpha, winLimit));
			System.out.println("Ruin rate from simulation: " + ruinRate + " Expected ruin rate: " + expectedRuin);
		}
		
		
		
		
		
		
		
		
		
		
		
		}
		
	}



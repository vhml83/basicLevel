package com.titanium.basic;

public class Final_Test {
	
	public static void main(String[] args) {
		
		int col = 4; 
		int row = 3;
		int[][] myArray = new int[row][col];
		
		for (int i = 0; i < myArray.length; i++) { //Outer loop fills the columns
			for (int j = 0; j < myArray[i].length; j++) { //Inner loop fills the rows
				//Fill first row and first column with '1'. Origin must be '0'
				if ((i == 0) && (j > 0) || (i > 0) && (j == 0)) {
					myArray[i][j] = 1;
				}
				//myArray[i][j-1] = left cell
				//myArray[i-1][j] = upper cell
				else if ((i > 0) || (j > 0)) {
					myArray[i][j] = myArray[i][j-1] +  myArray[i-1][j];
				}
				//Print each row	
				System.out.print(myArray[i][j] + " ");
			}
			//Skip to next line
			System.out.println();
		}

	}

}
package com.iamvkohli.AMAZON.OA;


/*
 * https://aonecode.com/amazon-online-assessment-questions#dl
 */
public class RollDice {

	public int getMinimumRolls( int[] A) {
		
		int len = A.length;
		//Corner case
		if(len<=1) return 0;
		
		/*
		 * Step#01 - Create 2 arrays
		 * 			Array#1 - Tracks the number of occurences of a given face
		 * 			Array#2 - Tracks the number of occurences of opposite face. i,e that needs 2 rolls
		 */
		int[] selfCount = new int[6];
		int[] opposites = new int[6];
		
		/*
		 * Step#02 - Populate both the arrays
		 */
		for(int i:A) {
			selfCount[i-1]++;
			opposites[7-i-1]++;
		}

		/*
		 * Business logic - 
		 * for each face, rolls = length - num of same faces + 2* number of opposite faces
		 * 						= 
		 */
		int min = Integer.MAX_VALUE;
		for(int i=0;i<6; i++) {
			if(selfCount[i]==0) continue;
				
			int rolls = len - selfCount[i] + opposites[i];
			min = Math.min(min, rolls);
		}
		
		return min;
		
	}
	
	public static void main(String[] args) {
		int [] A1 = {1, 6, 2, 3};
		int [] A2 = {1,1,1,6,6,6,3,2,5};
		int	[] A3 = {3,3,4};
		
		RollDice instance1 = new RollDice();
		
		System.out.println(instance1.getMinimumRolls(A1));
		System.out.println(instance1.getMinimumRolls(A2));
		System.out.println(instance1.getMinimumRolls(A3));
	}
	
}

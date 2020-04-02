package com.iamvkohli.AMAZON.OA;

public class LoadBalancer {

	public static boolean balanceLoad(int[] array) {
		
		//Corner case - Check length
		
		//presum[0] = 0; 
		double[] presum = new double[array.length + 1];
		for (int i = 1; i < array.length + 1; i++) {
			presum[i] = presum[i - 1] + (double) array[i - 1];
		}
		//presum - [0.0, 1.0, 4.0, 8.0, 10.0, 12.0, 14.0, 15.0, 16.0, 18.0]
		
		
		int left = 1;
		int right = presum.length - 2;
		
		// r-l >= 2
		while (left < right - 1) {
			double sumLeft = presum[left] - presum[0];
			double sumRight = presum[presum.length - 1] - presum[right];
			
			if (sumLeft == sumRight) { 
				double midSum = presum[right - 1] - presum[left + 1];
				if (midSum == sumLeft) {
					return true;
				} else {
					left++;
					right--;
				}
			} else if (sumLeft < sumRight) {
				left++;
			} else {
				right--;
			}
		}
		return false;
	}

	public static void main(String[] args) {

		int[] A = { 1, 3, 4, 2, 2, 2, 1, 1, 2 };
		System.out.println(balanceLoad(A));
	}
}

package com.iamvkohli.AMAZON.OA;

import java.util.ArrayList;

/*
 * https://aonecode.com/amazon-online-assessment-oa2-shopkeeper-sale
 */
public class ShopkeeperSale {
	
	public int getTotalCost(int[]A) {
		int len = A.length;
		if(len==0) {
			return 0;
		}
		if(len==1) return A[0];
		
		int cost=A[len-1];
		int min=A[len-1];
		
		ArrayList<Integer> nonDiscountedIndices = new ArrayList<>();
		nonDiscountedIndices.add(len-1);
		int [] minArr = new int[len];
		minArr[len-1]= A[len-1];
		
		
		for(int i=len-2; i>=0; i--) {
			if(A[i]<min) {
				nonDiscountedIndices.add(i);
				min = A[i];
				cost+=A[i];
				minArr[i]=min;
			}else {
				minArr[i]=min;
				cost += A[i]-min;
			}
			
			
		}
		
		return cost;
	}

	public static void main(String[] args) {
		int[] A = {2, 3, 1, 2, 4, 2};
		ShopkeeperSale sks1 = new ShopkeeperSale();
		
		System.out.println(sks1.getTotalCost(A));
	}
}

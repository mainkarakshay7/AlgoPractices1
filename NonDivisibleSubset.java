/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class NonDivisibleSubset {
    public static int subsetPairNotDivisibleByK(int[] arr,int n,int k)
    {
		int[] f = new int[k];
		Arrays.fill(f, 0);
		
		for(int i=0;i<n;i++) {
			f[arr[i] % k]++;
		}
		
		if(k % 2 == 0)
			f[k/2] = Math.min(f[k/2], 1);
		
		int res = Math.min(f[0], 1);
		
		for(int i=1;i<=k/2;i++)
		{
			res += Math.max(f[i], f[k-i]);
		}
			return res;
	}
	
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t  = sc.nextInt();
		for(int j =0;j<t;j++)
		{
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr= new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		 System.out.println(subsetPairNotDivisibleByK( 
                 arr, n, k)); 
		}

	}
}
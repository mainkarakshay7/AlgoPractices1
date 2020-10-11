/*
 Chef owns N cars (numbered 1 through N). He wishes to sell all of them over N years by selling exactly one car per year. For each valid i, the initial price of the i-th car is Pi. Due to depreciation, the price of each car decreases by 1 unit per year until it is sold.

Note that the price of a car cannot drop below 0 no matter how many years have passed, i.e. when the price of a car reaches 0 in some year, it remains 0 in all subsequent years.

Find the maximum profit Chef can make if he sells his cars in an optimal way. Since this number may be large, compute it modulo 1,000,000,007 (109+7).
 *
 */
/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class SellCar

{
    
  
    public static int max(int[] arr,int n)
    {
          int profit  = 0;
           int sum =0;
        for(int i=0;i<n;i++)
        {
            sum +=arr[i];
        }
          
        while(sum != 0)
        {
         int max = arr[0];
		   for(int k=0;k<n;k++)
		   {
		       for(int l =k+1;l<n;l++)
		       {
		       if(arr[k] > arr[l])
		       max = arr[k];
		       
		       }
		   }
		   profit += max;
		   for(int j=0;j<n;j++)
		   {
		       if(arr[j]==max || arr[j]==0)
		       { arr[j] = 0;
		       break;
		       }
		       
		       arr[j] = arr[j]-1;
		   }
		   sum =0;
		   for(int g=0;g<n;g++)
		   {
		       sum+=arr[g];
		   }
		   
	   }
	   return profit;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i=0;i<t;i++)
		{
		   int n = sc.nextInt();
		   int[] arr = new int[n];
		   
		   for(int m=0;m<n;m++)
		   {
		       arr[m] = sc.nextInt();
		   }
		   
		   System.out.println(max(arr,n));
		   
		   
		 
		}
	
	}
}

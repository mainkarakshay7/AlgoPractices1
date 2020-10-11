import java.util.Scanner;

public class DigitPairs {
	
	public static int GiveBS(int a)
	{
		int q = a%10;
		 int temp = a/10;
		 int temp1 = a/10;
		int max = a%10;
		while(temp!=0)
		{
			
			if(q> temp%10)
			{
				q=temp%10;
				temp = temp/10;
				
			}
		}
		
		while(temp1!=0)
		{
			
			if(max< temp1%10)
			{
				max=temp1%10;
				temp1 = temp1/10;
				
			}
		}
		return (max*11 + q*7);
	}
	
	
	  public static void main(String args[] ) throws Exception {

			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
	   
	   

	     
	      int[] score = new int [n];
	      
	      for(int j =0;j<n;j++)
	      {
	         score[j]= sc.nextInt();
	      }
	      
	      int [] bitscore = new int[n];
	      for(int i=0;i<n;i++)
	      {
	    	  
	    	  int x = GiveBS(score[i]);
	    	  bitscore[i] = x;
	      }
	      
	      for(int i=0;i<n;i++)
	      {
	    	  System.out.println(bitscore[i]);
	      }
	   }
}

/* Read input from STDIN. Print your output to STDOUT*/

import java.io.*;
import java.util.*;
public class Beyblade {
   public static void main(String args[] ) throws Exception {

		Scanner sc = new Scanner(System.in);
   int T = sc.nextInt();
   int count = 0;
   for(int i=0;i<T;i++)
   {

      int n = sc.nextInt();
      int[] me = new int [n];
      int[] opp = new int [n];
      for(int j =0;j<n;j++)
      {
         me[j]= sc.nextInt();
      }
      for(int k =0;k<n;k++)
      {
         opp[k] = sc.nextInt();
      }
      Arrays.sort(me);
      Arrays.sort(opp);

   for(int p=0,q=0;p<n && q<n;p++,q++)
   {
      if(me[p] > opp[q])
      {
         count++;
         p++;
         q++;
      }
      else
      p++;
   }
   for (int x=0;x<0;x++) {
   System.out.println(me[x]);
   }
   }
}
}

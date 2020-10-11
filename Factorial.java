/* Read input from STDIN. Print your output to STDOUT*/

import java.io.*;
import java.util.*;
public class Factorial {

 private static void swap(int[] me,int x,int y){
        int temp = me[x];
        me[x] = me[y];
        me[y] = temp;
    }



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
      
      for(int l=0;l<n;l++)
      {
         if(me[l]>opp[l]){
            count++;

         }
          if(me[l]<=opp[l]){
         
            for(int m=0;m<n-l;m++){
               if(me[l+m] > opp[l]){
                  swap(me,l,l+m);
                  count++;
               }
            }
         }
      }

      System.out.println(count-1);
    }
    
   }
}



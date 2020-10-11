import java.io.*;
import java.util.*;
public class PowerPuff {
   public static void main(String args[] ) throws Exception {

	//Write code here
   Scanner sc = new Scanner(System.in);
   int n = sc.nextInt();
   
   double[] a = new double[n];
   double[] b = new double[n];
   for (int i=0;i<n;i++){
      a[i] = sc.nextLong();
   }
   for(int j=0;j<n;j++){
      b[j]=sc.nextLong();
   }
   double cur_div = Long.MAX_VALUE;
   double div=b[0] / a[0];
   for (int k=0;k<n;k++){
      cur_div = b[k]/a[k];
      if (cur_div < div){
         div = cur_div;
      }
   }
   long value = (long)Math.round(div);
   System.out.println(value);
  


   }
}

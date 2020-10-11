import java.io.*;

class EquilibriumPoint {
	public static void main (String[] args) throws IOException {
		//code
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-- >0){
		    int n=Integer.parseInt(br.readLine());
		    int[] a=new int[n];
		    String line=br.readLine();
		    String[] str=line.split(" ");
		    int sumr=0;
		    for(int i=0;i<n;i++){
		    a[i]=Integer.parseInt(str[i]);
		    sumr+=a[i];
		    }
		    int eq=-1;
		    if(n==1)
		    eq=n;
		    else{
		    int suml=0;
		    
		    for(int i=0;i<n;i++){
		       sumr-=a[i];
		       if(suml==sumr){
		       eq=i+1;
		       break;
		       }
		       suml+=a[i];
		    }
		}System.out.println(eq);
	}
}}
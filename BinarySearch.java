import java.util.*;
public class BinarySearch {
	
	public static int Search(int[] arr,int lo,int hi,int key)
	{
		int mid = lo + (hi-lo)/2;
		if(lo<=hi)
		{
		if (arr[mid] == key )
			return mid;
		else if(key>arr[mid])
			return Search(arr,mid+1,hi,key);
		else 
		return Search(arr,lo,mid-1,key);
		}
		return -1;
	}

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
				 int n=sc.nextInt();
				 int arr[] = new int[n];
				 for(int i=0;i<n;i++)
				 {
					 arr[i] = sc.nextInt();
				 }
				 
				 int key = sc.nextInt();
				 sc.close();
				int result =  Search(arr,0,n-1,key);
				if(result ==-1)
					System.out.println("Not Found");
				else
					System.out.println("Found at "+result);
					

	}

}

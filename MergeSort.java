import java.util.*;
public class MergeSort {
	
	void merge(int[] arr,int beg,int mid,int end)
	{
		int l = mid - beg + 1;
		int r = end - mid;
		
		int[] leftArray = new int[l];
		int[] rightArray = new int[r];
		
		for(int i=0;i<l;++i)
			leftArray[i] = arr[beg+i];
		
		for(int i=0;i<r;++i)
			rightArray[i] = arr[mid+1+i];
		
		int i=0,j=0;
		int k=beg;
		
		while(i<l && j<r)
		{
			if(leftArray[i] <= rightArray[j])
			{
				arr[k] = leftArray[i];
				i++;
			}
			else
			{
				arr[k] = rightArray[j];
				j++;
			}
			k++;
		}
		/*
		while (i<l)  
		{  
		arr[k] = leftArray[i];  
		i++;  
		k++;  
		}  
		  
		while (j<r)  
		{  
		arr[k] = rightArray[j];  
		j++;  
		k++;  
		} 
		*/
			}
	
	void mergeSort(int[] arr,int beg,int end)
	{
		if(beg<end)
		{
			int mid = (beg + end)/2;
			mergeSort(arr,beg,mid);
			mergeSort(arr,mid+1,end);
			merge(arr,beg,mid,end);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[]  arr = new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i] = sc.nextInt();
		}
		MergeSort ob = new MergeSort();
		ob.mergeSort(arr,0,arr.length-1);
		System.out.println("Sorted Array:");
		for(int i=0;i<n;i++)
		{
			System.out.println(arr[i]);
		}
		sc.close();

	}

}

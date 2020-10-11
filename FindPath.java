import java.util.*;

// deutsche bank coding challenge question
public class FindPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc  = new Scanner(System.in);
		String str = sc.next();
		
		System.out.println(Solution(str));
	}

	public static String Solution(String str)
	{
		StringBuilder sb = new StringBuilder();
		int[] counts = new int[4];
		int n = str.length();
		
		char role = getRole(str);
		
		sb.append(role);
		
		for(int i =0;i<n;i++)
		{
			if(str.charAt(i)=='N')
				counts[0]++;
			if(str.charAt(i)=='S')
				counts[1]++;
			if(str.charAt(i)=='E')
				counts[2]++;
			if(str.charAt(i)=='W')
				counts[3]++;
			
		}
		boolean flag=false;
		
		if(counts[2] > counts[3])
		{
			if(role == 'E')
			{
				addPath(str,sb,counts[0]);
				
				flag=true;
			}
			
			for(int i=0;i<counts[2] - counts[3];i++)
			{
				sb.append('W');
				
				
			}
			
		}
		
		else	if(counts[3] > counts[2])
		{
			
			if(role == 'W')
			{
				addPath(str,sb,counts[0]);
				
				flag=true;
			}
			
			for(int i=0;i<counts[3] - counts[2];i++)
			{
				sb.append('E');
				
			}
		}
		
		if(!flag )
		{
			addPath(str,sb,counts[0]);
		}
		if(!flag)
		{
			if(role=='W')
			sb.append('E');
		else
			sb.append('W');
		}
		return sb.toString() ;
		
	}
	public static void addPath(String str,StringBuilder sb,int m)
	{
		
		for(int i=0;i<m;i++)
		{
			sb.append('S');
		}
	
	
	}
	
	public static char getRole(String str)
	{
		char temp;
		for(int i=str.length()-1;i>=0;i--)
		{
			if(str.charAt(i) != 'N') {
				temp = str.charAt(i);
				return temp;
			}
		}
		
		return str.charAt(str.length() - 2);
	}
    public static int getrr(String forth,char role)
    {
       int n = forth.length();
       int j;
       
       for(int i=0;i<n;i++)
       {
           if(forth.charAt(i)=='N')
           {
               
               while(forth.charAt(j)!='N')
               {}
           }
       }
    
    }    
}
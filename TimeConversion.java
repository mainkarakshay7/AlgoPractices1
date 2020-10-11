import java.util.Scanner;

public class TimeConversion
		{
	
	static String convert(String s)
	{
		String[] str = s.split(":");
		int hour = Integer.parseInt(str[0]);
		String min = str[1];
		String secPeriod= str[2];
		String sec	=	secPeriod.substring(0,secPeriod.length()-2);
		String period = secPeriod.substring(secPeriod.length()-2,secPeriod.length());
		
		String NewTime = "";
		
		if((hour>=0 && hour<12) && (period.equalsIgnoreCase("AM")))
		{
			NewTime =String.format("%2d",hour) +":"+min+":"+sec ; 
		}
		else if((hour>=0 && hour<12) && (period.equalsIgnoreCase("PM")))
		{
			NewTime =(hour+12) +":"+min+":"+sec ; 
		}
		else if((hour==12) && (period.equalsIgnoreCase("AM")))
		{
			NewTime ="00" +":"+min+":"+sec ; 
		}
		else if((hour==12) && (period.equalsIgnoreCase("PM")))
		{
			NewTime =hour +":"+min+":"+sec ; 
		}
			
			return NewTime;
			
		}
		
		public static void main(String[] args)
		{
		Scanner sc = new Scanner(System.in);
		String s  = sc.nextLine();
		String result = convert(s);
		System.out.println(result);
		sc.close();
		}

}

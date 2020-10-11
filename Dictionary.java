import java.util.HashMap;
import java.util.Map;

public class Dictionary {

	public static void main(String[] args) {
		// English to Marathi Dictionary
		Map<String,String> MarEngDictionary = new HashMap <String,String>();
		// Putting Things inside our dictionary
		
		MarEngDictionary.put("Monday","Somwar");
		MarEngDictionary.put("Tuesday", "Mangalwar");
		MarEngDictionary.put("Wednesday","Budhwar");
		MarEngDictionary.put("Thursday","Guruwar");
		MarEngDictionary.put("Friday","Shukrawar");
		MarEngDictionary.put("Saturday","Shaniwar");
		MarEngDictionary.put("Sunday","Raviwar");
		
		// Retrive things from our dictionary
		
		System.out.println(MarEngDictionary.get("Monday"));
		System.out.println(MarEngDictionary.get("Tuesday"));
		System.out.println(MarEngDictionary.get("Wednesday"));
		System.out.println(MarEngDictionary.get("Thursday"));
		System.out.println(MarEngDictionary.get("Friday"));
		
		//print all keys
		System.out.println(MarEngDictionary.keySet());
		//print values
		System.out.println(MarEngDictionary.values());
		//print size 
		System.out.println("The size of our dictionary is"+MarEngDictionary.size());
		
		System.out.println(MarEngDictionary.toString());
		
		
	}

}

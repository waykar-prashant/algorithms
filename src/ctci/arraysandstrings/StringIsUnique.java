package ctci.arraysandstrings;

import java.util.Hashtable;

public class StringIsUnique {

	public static void main(String[] args) {
		Hashtable<String, Integer> h = new Hashtable<>();
		h.put("a", 100);
		h.put("a", 101);
		
		if(isUnique("prashant")){
			System.out.println("Unique!!");
		}else{
			System.out.println("Not Unique!!");
		}
		
	}

	private static boolean isUnique(String string) {
		byte[] array = new byte[128]; 
		for(int i=0; i < string.length(); i++){
			char c = string.charAt(i);
			
			
		}
		return false;
	}

}

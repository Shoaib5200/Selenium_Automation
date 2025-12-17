	//25. Dynamically increase or decrease the array size 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoreJavaBrushUp3_ArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Create an object 'a' for the class
		//<String> is mentioned to tell that this array should ONLY contains the String values
		
		ArrayList<String> a = new ArrayList<String>();
		
		a.add("Shoaib");
		a.add("Danish");
		a.add("SQA");
		a.add("Selenium");
		//a.remove(1);
		System.out.println(a.get(3));
		System.out.println("**************");
		
		// 26. Iterating over Arrays and it's related methods		
		for(int i=0; i<a.size();i++) {
			System.out.println(a.get(i));
		}
		
		
		System.out.println("**************");
		
		for (String val: a) {
			System.out.println(val);
		}
		
		System.out.println("**************");
		
		//item is present in ArrayList
		System.out.println(a.contains("Selenium"));

		// Convert a static array into Dynamic Array List
		String[] name = {"Raahul", "Shetty", "Selenium"};
		List<String> nameArrayList = Arrays.asList(name);
		System.out.println(nameArrayList.contains("Selenium"));
	}

}

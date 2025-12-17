
public class CoreJavaBrushUp4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Strin literal: String is an object that represents a sequence of operation
		//String s = "This is Hello World String.";
		//String s1 = "This is Hello World String.";
		
		//new: allow to create two strings with same value
		String s2 = new String("This is Hello World String.");
		String s3 = new String("This is Hello World String.");
		
		String s = "Shoaib Danish Automation";
		String[] splittedString = s.split("Danish");
		System.out.println(splittedString[0]);
		System.out.println(splittedString[1]);
		System.out.println(splittedString[1].trim());
		
		System.out.println("FORWARD ORDER");
		for (int i=0;i<s.length();i++) {
			System.out.println(s.charAt(i));
		}
		
		System.out.println("REVERSE ORDER");
		
		for (int i=s.length()-1; i>=0;i--) {
			System.out.println(s.charAt(i));
		}
	}

}

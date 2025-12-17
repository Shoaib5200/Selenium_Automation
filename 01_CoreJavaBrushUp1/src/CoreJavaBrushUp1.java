public class CoreJavaBrushUp1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int myNum = 5;
		String website = "Rahul Shetty Academy";
		char letter = 'W';
		double dec = 5.75;
		boolean myCard = true;
		
		System.out.println(myNum+" is the value stored in the myNum variable.");
		
		// Lecture 20: ARRAYS
		int[] arr1 = new int[5];      // Declare an array
		arr1[0] = 101;
		arr1[1] = 111;
		arr1[2] = 222;
		arr1[3] = 333;
		arr1[4] = 444;
		
		int[] arr2 = {10,20,30,40,50};      // Declare an array
		System.out.println(arr2[2]);
		
		
		//For Loop
		for (int a=0; a<arr1.length; a++) {
			
			System.out.println("Test Array 1: " + arr1[a]);
		}
		
		
		for (int i=0; i<arr2.length; i++) {
			
			System.out.println("Test Array 2: " + arr2[i]);
		}
		
		String[] name = {"Raahul", "Shetty", "Selenium"};
		for (int i=0; i<name.length; i++) {
			System.out.println("Test String: " + name[i]);
		}
		
		// Enhanced For Loop
		for (int i: arr1) {
			System.out.println(i); 
		}
		
	}

}

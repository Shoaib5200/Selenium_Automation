//For loop with conditional statement
public class CoreJavaBrushUp2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {5,10,20,30,40,50,55,65,75,85,95,105};
		
		// Check if array has multiple of 2
		for (int i=0; i<arr.length; i++) {
			if (arr[i] % 2 == 0) {
				System.out.println(arr[i]);
				break;
			}
			
			else 
			{
				System.out.println(arr[i] + " is not a multiple of 2.");
			}
		}
	}

}

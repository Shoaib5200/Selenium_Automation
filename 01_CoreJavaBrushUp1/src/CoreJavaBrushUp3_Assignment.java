//1st assignment
public class CoreJavaBrushUp3_Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int []arr = {1,2,5,10,15};
		System.out.println("This is the FIRST element of an array"+" " +arr[0]+".");
		System.out.println("This is the LAST element of an array"+ " " +arr[4]+".");
		
		System.out.println("Elements in the reverse order!!!");
		for (int i=arr.length-1; i>=0;i--) {
			System.out.println(arr[i]);
		}
		
		System.out.println("Total elements in the array are: "+arr.length);

	}

}

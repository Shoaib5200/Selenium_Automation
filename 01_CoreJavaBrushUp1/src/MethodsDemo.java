
public class MethodsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MethodsDemo d = new MethodsDemo();
		String name = d.getData1();
		System.out.println(name);
		
		MethodsDemo2 d2 = new MethodsDemo2();
		d2.getUserData();

		getData2();
	}
	
	public String getData1() {
		System.out.println("Hello World via Method: getData1().");
		return "Shoaib Danish";
	}
	
	public static String getData2() {
		// TODO Auto-generated method stub
		System.out.println("Hello World via Method: getData2().");
		return "Shoaib Danish";
	}

	
	


}

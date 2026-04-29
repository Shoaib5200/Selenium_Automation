// PS2 class demonstrates use of constructor, instance variables, and basic operations
public class PS2 extends PS3{
	
	// Class (instance) variable to store value passed from another class
	int a; 	 
	
	// ============================
	// Constructor
	// ============================
	
	// Parameterized constructor used to initialize the instance variable
	// 'a' (parameter) is the local variable passed during object creation
	public PS2(int a) 
	{
		// 'this.a' refers to the class variable
		// Assigning the passed value to the instance variable
		super(a); // parent class constructor is invoked
		this.a = a;
	}

	// ============================
	// Business Logic Methods
	// ============================

	// Method to increment the value of 'a' by 1
	public int increament() {
		a = a + 1;   // increase value
		return a;    // return updated value
	}
	
	// Method to decrement the value of 'a' by 1
	public int decreament() {
		a = a - 1;   // decrease value
		return a;    // return updated value
	}
}
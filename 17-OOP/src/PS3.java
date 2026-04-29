// PS3 class demonstrates use of constructor and pure calculation methods
// NOTE: This version does NOT modify the instance variable (no side effects)
public class PS3 {

	// Instance variable to store the value passed during object creation
	int a;
	
	// ============================
	// Constructor
	// ============================
	
	// Parameterized constructor used to initialize the instance variable
	// 'a' (parameter) is a local variable passed when creating the object
	public PS3(int a) 
	{
		// 'this.a' refers to the class-level variable
		// Assigning the input value to the instance variable
		this.a = a;
	}
	
	
	// ============================
	// Business Logic Methods
	// ============================

	// Method to multiply the value of 'a' by 2
	// IMPORTANT: This method does NOT change the value of 'a'
	// It simply performs calculation and returns the result
	public int multiplyTwo() {
		return a * 2;    // returns computed value without modifying 'a'
	}

	
	// Method to multiply the value of 'a' by 3
	// IMPORTANT: This method also does NOT modify 'a'
	// Each call gives consistent output based on original value
	public int multiplyThree() {
		return a * 3;    // returns computed value without modifying 'a'
	}
}
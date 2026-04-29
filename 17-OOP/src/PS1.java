import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

// PS1 class extends PS (Parent class)
// Demonstrates inheritance, constructor usage, and method execution flow
public class PS1 extends PS {

	@Test
	public void testRun() {

		// ============================
        // Calling Parent Class Method
        // ============================

        // Option 1 (commented): Call parent method using object creation
		// PS ps = new PS();
		// ps.doThis();
		
		// Option 2 (used): Direct call via inheritance
        // Since PS1 extends PS, parent class methods are directly accessible
		doThis(); 
		
		// ============================
        // Working with Child Class (PS2)
        // ============================

        // Local variable used as input for PS2 constructor
		int a = 3;
		
		// Create PS2 object and pass value 'a'
        // This initializes the instance variable inside PS2
		PS2 ps2 = new PS2(a); 
		
		// ============================
        // Output / Method Execution
        // ============================

        // NOTE:
        // - increment() and decrement() modify the internal state of 'a'
        // - multiplyTwo() and multiplyThree() (from updated PS3 logic) 
        //   do NOT modify 'a' → they return calculated values only
        // - So multiplication results are consistent and predictable

        // Step 1: Increment (a = 3 → 4)
		System.out.println("Sum: " + ps2.increament());
		
        // Step 2: Decrement (a = 4 → 3)
		System.out.println("Difference: " + ps2.decreament());

        // Step 3: multiplyThree → returns 3 * 3 = 9 (does NOT change 'a')
		System.out.println("Multiplication via Super: " + ps2.multiplyThree());

        // Step 4: multiplyTwo → returns 3 * 2 = 6 (value of 'a' remains unchanged)
		System.out.println("Multiplication with 2: " + ps2.multiplyTwo());

        // Step 5: multiplyThree again → still 3 * 3 = 9 (consistent output)
		System.out.println("Multiplication with 3: " + ps2.multiplyThree());
	}
}
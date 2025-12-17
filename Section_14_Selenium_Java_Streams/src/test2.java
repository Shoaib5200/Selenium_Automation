import java.util.ArrayList;

import org.testng.annotations.Test;

public class test2 {
	public static void main(String[] args) {

		// TODO Auto-generated method stub

		// Count the number of names starting with alphabet A in list
		//@Test
		
		public void regular() {
			
		ArrayList<String> names = new ArrayList<String>();
		names.add("Apple");
		names.add("Mango");
		names.add("Banana");
		names.add("Alpha");
		names.add("Grapes");
		int count = 0;
		
		for (int i=0; i<names.size();i++) {
			String actual = names.get(i);
			
			if(actual.startsWith("A")) {
				count++;
			}
		}
		System.out.println(count);
	}
	}
		
		@Test
		public void streamFilter() {
			ArrayList<String> names = new ArrayList<String>();
			names.add("Apple");
			names.add("Mango");
			names.add("Banana");
			names.add("Alpha");
			names.add("Grapes");
		
			Long c = names.stream().filter(s->s.startsWith("A")).count();
			System.out.println(c);
		
}
}

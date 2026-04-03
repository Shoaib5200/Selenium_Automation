import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaStreams_v1_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Method -> 1
		// Count the number of names starting with letter A in the list
		ArrayList<String> names = new ArrayList<String>();
		names.add("Big Show");
		names.add("Triple H");
		names.add("Abishek");
		names.add("Edge");
		names.add("Lita");
		names.add("Brock");
		names.add("Seth Rollins");
		names.add("Roman Reigns");
		names.add("Abdullah");
		names.add("Booker T");
		int count = 0;

		for (int i = 0; i < names.size(); i++) {
			String actualName = names.get(i);
			if (actualName.startsWith("B")) {
				count++;
			}
		}
		System.out.println("The number of names starting with letter A in the list: "+ count);

	}

	// Method -> 2
	// Count the number of names starting with letter A in the list via Streams
	@Test
	public void streamFilter() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Big Show");
		names.add("Triple H");
		names.add("Abishek");
		names.add("Edge");
		names.add("Lita");
		names.add("Brock");
		names.add("Seth Rollins");
		names.add("Roman Reigns");
		names.add("Abdullah");
		names.add("Booker T");

		Long stream_1 = names.stream()
				.filter(s -> s.startsWith("B"))
				.count();
		System.out.println("The number of names starting with letter A in the list via Streams: " + stream_1);
		
		Long stream_2 = Stream.of("Big Show", "Triple H", "Abishek", "Edge", "Brock", "Seth Rollins", "Roman Reigns", "Abdullah", "Booker T").filter(s -> 
		{
			s.startsWith("E");
			return false;
		}).count();	
		
		System.out.println("The number of names starting with letter E in the list via Streams: " + stream_2);
	}
		
//		names.stream()
//		.filter(s -> s.length()>4)
//		.limit(1)
//		.forEach(System.out.println(stream_1);
//		}

	@Test
	public void streamMap() {
		// print names of length > 4 with Uppercase
		Stream.of("Big Show", "Triple H", "Abishek", "Edge", "Brock", "Seth Rolline", "Roman Reigns", "Abdullah", "Booker T").filter(s->s.endsWith("e")).map(s->s.toUpperCase())
		.forEach(s->System.out.println("The name with Upper Case ends with letter E: " + s));
		
		// print names which have first letter as A with uppercase and sorted
		// Convert Array to a ArrayList
		
		List<String> names = Arrays.asList("Big Show", "Triple H", "Abishek", "Edge", "Brock", "Seth Rolline", "Roman Reigns", "Abdullah", "Booker T");
		names.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println("The sorted name with Upper Case starts with letter A: " + s));
	}
	
	@Test
	public void mergeList() {
		ArrayList<String> list_A = new ArrayList<String>();
		list_A.add("Cat");
		list_A.add("Dog");
		list_A.add("Elephant");
		
		List<String> list_B = Arrays.asList("Big Show", "Triple H", "Abishek", "Edge", "Brock", "Seth Rolline", "Roman Reigns", "Abdullah", "Booker T");
		list_B.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println("The sorted name with Upper Case starts with letter A: " + s));
		
		// Merging two different lists
		Stream<String> newStream = Stream.concat(list_A.stream(), list_B.stream());
		// newStream.sorted().forEach(s.s->System.out.println("The concatenated list is: " +s));
		
		// Check if the specific name exists in the list or not
		boolean flag = newStream.anyMatch((s->s.equalsIgnoreCase("Cat")));
		System.out.println(flag);
		Assert.assertTrue(flag);
	}
	
	@Test
	public void streamCollect() {
		List<String> ls = Stream.of("Big Show", "Triple H", "Abishek", "Edge", "Brock", "Seth Rolline", "Roman Reigns", "Abdullah", "Booker T")
				.filter(s->s.endsWith("e"))
				.map(s->s.toUpperCase())
				.collect(Collectors.toList());
		System.out.println("The output of streamCollect(): " + ls.get(0));
		System.out.println("/////////////////////////////////////////////");
		
		List<Integer> values = Arrays.asList(5,6,-7,8,9,-10,1,2,3,5,7);
		// print unique number from the array
		// sort the array
		values.stream().distinct().sorted().forEach(s->System.out.println("Unique numbers are as follows: "+s));
		
	}
}


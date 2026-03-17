import java.util.ArrayList;
import java.util.stream.Stream;
import org.testng.annotations.Test;

public class JavaStreams_v2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Count the number of elements starts with A in the Array List
		ArrayList<String> names = new ArrayList<String>();
		names.add("Izhaan");
		names.add("Arham");
		names.add("Shahzaib");
		names.add("Shoaib");
		names.add("Ejaz");

		// Logic to count names starting with "S"
		int count = 0;
		for (int i = 0; i < names.size(); i++) {
			String actual = names.get(i);
			if (actual.startsWith("S")) {
				count++;
			}
		}
		System.out.println(count);
	}

	// PART 2 — TestNG Method
	@Test
	public void streamFilter() {

		// ArrayList
		ArrayList<String> names = new ArrayList<String>();
		names.add("Izhaan");
		names.add("Arham");
		names.add("Shahzaib");
		names.add("Shoaib");
		names.add("Ejaz");

		// There is no life for intermediate operation if there is no terminal operation
		// Terminal operation will execute only if intermediate operation (filter)
		// returns true
		// we can create stream
		// How to use filter in Stream API

		// STREAMS — First Example
		// Convert list → stream names.stream()
		// Filter filter(s -> s.startsWith("S"))
		long c = names.stream()
				.filter(s -> s.startsWith("S"))
				.count();
		System.out.println(c);

		// STREAM.of() Example
		long d = Stream.of("Izhaan", "Arham", "Shahzaib", "Shoaib", "Ejaz")
				.filter(s -> s.startsWith("S"))
				.count();
		System.out.println(d);

		// print all the names of the arrayList
		// names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));

		// Filter names with length > 4 (Izhaan, Arham, Shahzaib, Shoaib)
		// .limit(1) -> Take only first match -> Izhaan
		names.stream().filter(s -> s.length() > 4).limit(1).forEach(s->System.out.println(s));
	}
}
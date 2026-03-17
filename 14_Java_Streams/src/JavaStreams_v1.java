import java.util.ArrayList;

public class JavaStreams_v1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Count the number of elements starts with A in the Array List
		ArrayList<String> names = new ArrayList<String>();
		names.add("Izhaan");
		names.add("Arham");
		names.add("Shahzaib");
		names.add("Shoaib");
		names.add("Ejaz");

		int count = 0;

		for (int i = 0; i < names.size(); i++) {
			String actual = names.get(i);
			if (actual.startsWith("S")) {
				count++;
			}
		}
		System.out.println(count);
	}

}

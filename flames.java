import java.util.*;

public class flames {

	static Scanner sc = new Scanner(System.in);

	public static void main(String args[]) {

		System.out.print("Enter the first name : ");
		String name1 = sc.next().toLowerCase();
		System.out.print("Enter the second name : ");
		String name2 = sc.next().toLowerCase();
		HashMap<Character, Integer> commonLetter = new HashMap<>();
		for (int i = 0; i < name1.length(); i++)
			commonLetter.put(name1.charAt(i), commonLetter.getOrDefault(name1.charAt(i), 0) + 1);
		for (int i = 0; i < name2.length(); i++)
			commonLetter.put(name2.charAt(i), commonLetter.getOrDefault(name2.charAt(i), 0) - 1);
		ArrayList<String> result = new ArrayList<>();
		result.add("Friends");
		result.add("Lover");
		result.add("Affection");
		result.add("Marriage");
		result.add("Enemy");
		result.add("Sister");
		int removeCharacter = -1;
		for (Map.Entry<Character, Integer> mp : commonLetter.entrySet()) {
			if (mp.getValue() != 0)
				removeCharacter += Math.abs(mp.getValue());
		}
		System.out.println(removeCharacter);
		if (removeCharacter == -1) {
			System.out.println("No Unique Characters. Try with different name!");
			return;
		}
		int ind = 0;
		while (result.size() > 1) {
			ind = (ind + removeCharacter) % result.size();
			result.remove(ind);
		}
		System.out.println("Your FLAMES result is : " + result.get(0));

	}

}

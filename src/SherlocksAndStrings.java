import java.util.*;

public class SherlocksAndStrings {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Set<Character> chars = new HashSet<>();
        Set<Integer> sameValueOccurrenceCheckSet = new HashSet<>();
        List<Integer> occurValues = new ArrayList<>();
        List<Character> characters = new ArrayList<>();
        boolean isValid = false;
        int length = input.length();
        for (int i = 0; i < length; i++) {
            chars.add(input.charAt(i));
        }
        for (Character character : chars) {
            int count = 0;
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == character) {
                    count++;
                }
            }
            characters.add(character);
            occurValues.add(count);
            sameValueOccurrenceCheckSet.add(count);
        }
        System.out.println(characters);
        System.out.println(occurValues);
        if (sameValueOccurrenceCheckSet.size() == 1) {
            System.out.println("YES");
            System.exit(0);
        }
        for (int i = 0; i < occurValues.size(); i++) {

            int temp = occurValues.get(i);
            if (Collections.frequency(occurValues, temp) == 1) {
                if (sameValueOccurrenceCheckSet.size() == 2) {
                    System.out.println("YES");
                    System.exit(0);
                }
            }
            temp = temp - 1;
            isValid = true;
            for (int j = 0; j < occurValues.size(); j++) {
                if (i != j) {
                    if (temp != occurValues.get(j)) {
                        isValid = false;
                        break;
                    }
                }
            }
            if (isValid) {
                break;
            }
        }
        if (isValid) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

public class CharacterStuffing {
    public static void main(String[] args) {
        String input = "DEFGAEEFEFH";
        String stuffed = stuffData(input);
        String unstuffed = unstuffData(stuffed);

        System.out.println("Stuffed: " + stuffed);
        System.out.println("Unstuffed: " + unstuffed);
    }

    private static String stuffData(String s) {
        StringBuilder result = new StringBuilder();
        result.append('F');
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'E' || ch == 'F') {
                result.append('F');
            }
            result.append(ch);
        }
        result.append('F');
        return result.toString();
    }

    private static String unstuffData(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < s.length() - 1; i++) {
            char ch = s.charAt(i);
            if (ch == 'F') {
                if (i + 1 < s.length() - 1) {
                    i++;
                    result.append(s.charAt(i));
                }
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}

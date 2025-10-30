public class CharacterStuffing {
    public static void main(String[] args) {
        String input = "DEFGAEEFEFH";
        String stuffed = "F" + input.replaceAll("([EF])", "F$1") + "F";
        String unstuffed = stuffed.substring(1, stuffed.length() - 1).replaceAll("F([EF])", "$1");
        System.out.println("Stuffed: " + stuffed);
        System.out.println("Unstuffed: " + unstuffed);
    }
}

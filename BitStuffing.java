public class BitStuffing {
    public static void main(String[] args) {
        String s = "01110111011111011111";

        
        String stuffed = s.replaceAll("11111", "111110");
        System.out.println("Stuffed: " + stuffed);
        String unstuffed = stuffed.replaceAll("111110", "11111");
        System.out.println("Unstuffed: " + unstuffed);
    }
}

import java.util.*;

public class Checksum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the boolean string: ");
        int n = sc.nextInt();
        System.out.print("Enter boolean string: ");
        String data = sc.next();
        System.out.print("Enter size of blocks to divide: ");
        int blockSize = sc.nextInt();
        if (n % blockSize != 0) {
            System.out.println("Error: String length must be divisible by block size");
            return;
        }
        if (data.length() != n) {
            System.out.println("Error: Actual string length doesn't match specified length");
            return;
        }
        
        System.out.println("Divided blocks (sender): ");
        int numBlocks = n / blockSize;
        String[] blocks = new String[numBlocks];
        for (int i = 0; i < numBlocks; i++) {
            blocks[i] = data.substring(i * blockSize, (i + 1) * blockSize);
            System.out.println(blocks[i]);
        }
        String sum = blocks[0];
        for (int i = 1; i < numBlocks; i++) {
            sum = addBinary(sum, blocks[i]);
            System.out.println("Sum after adding block " + (i + 1) + ": " + sum);
        }
        String checksum = onesComplement(sum);
        System.out.println("Checksum: " + checksum);
        String finalSum = addBinary(sum, checksum);
        System.out.println("Receiver final sum: " + finalSum);
        if (allOnes(finalSum)) {
            System.out.println("Message received (No error)");
        } else {
            System.out.println("Message received (Error detected)");
        }
        
        sc.close();
    }
    
    private static String addBinary(String a, String b) {
        int n = Math.max(a.length(), b.length());
        while (a.length() < n) a = "0" + a;
        while (b.length() < n) b = "0" + b;
        int carry = 0;
        StringBuilder result = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            int bit1 = a.charAt(i) - '0';
            int bit2 = b.charAt(i) - '0';
            int sum = bit1 + bit2 + carry;
            result.insert(0, sum % 2);  
            carry = sum / 2;
        }
        if (carry > 0) {
            return addBinary(result.toString(), "1");
        }
        
        return result.toString();
    }
    
    private static String onesComplement(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c == '0' ? '1' : '0');
        }
        return sb.toString();
    }
    
    private static boolean allOnes(String s) {
        for (char c : s.toCharArray()) {
            if (c != '1') return false;
        }
        return true;
    }
}
import java.util.*;

public class Checksum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter length of boolean string: ");
        int n = sc.nextInt();
        
        System.out.print("Enter boolean string: ");
        String data = sc.next();

        System.out.print("Enter block size: ");
        int blockSize = sc.nextInt();

        if (n % blockSize != 0 || data.length() != n) {
            System.out.println("Invalid input");
            return;
        }

        int numBlocks = n / blockSize;


        // sivanagu 
        
        String[] blocks = new String[numBlocks];
        for (int i = 0; i < numBlocks; i++)
            blocks[i] = data.substring(i * blockSize, (i + 1) * blockSize);

        String sum = blocks[0];
        for (int i = 1; i < numBlocks; i++)
            sum = addBinary(sum, blocks[i]);

        String checksum = sum.replace('0', 'x').replace('1', '0').replace('x', '1');
        String finalSum = addBinary(sum, checksum);

        System.out.println("Checksum: " + checksum);
        System.out.println(allOnes(finalSum) ? "Message received (No error)" : "Message received (Error detected)");
    }

    private static String addBinary(String a, String b) {
        int sum = Integer.parseInt(a, 2) + Integer.parseInt(b, 2);
        String result = Integer.toBinaryString(sum);
        while (result.length() > a.length())
            result = addBinary(result.substring(1), result.substring(0, 1)); // wrap-around carry
        return String.format("%" + a.length() + "s", result).replace(' ', '0');
    }

    private static boolean allOnes(String s) {
        return !s.contains("0");
    }
}

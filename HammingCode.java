import java.util.*;

public class HammingCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of data bits: ");
        int m = sc.nextInt();
        int[] data = new int[m];
        System.out.print("Enter data bits: ");
        for (int i = 0; i < m; i++) data[i] = sc.nextInt();

        int r = 0;
        while (Math.pow(2, r) < m + r + 1) r++;

        int[] h = new int[m + r + 1];
        for (int i = 1, j = 0; i < h.length; i++)
            if ((i & (i - 1)) != 0) h[i] = data[j++];

        for (int i = 0; i < r; i++) {
            int p = 1 << i, val = 0;
            for (int k = 1; k < h.length; k++) if (((k >> i) & 1) == 1 && k != p) val ^= h[k];
            h[p] = val;
        }

        System.out.print("Hamming code: ");
        for (int i = 1; i < h.length; i++) System.out.print(h[i]);
        System.out.println();

        System.out.print("Enter received bits: ");
        String recv = sc.next();
        int[] rec = new int[recv.length() + 1];
        for (int i = 1; i <= recv.length(); i++) rec[i] = recv.charAt(i - 1) - '0';

        int err = 0;
        for (int i = 0; i < r; i++) {
            int p = 1 << i, val = 0;
            for (int k = 1; k < rec.length; k++) if (((k >> i) & 1) == 1) val ^= rec[k];
            if (val != 0) err += p;
        }

        if (err == 0) System.out.println("Message received correctly");
        else {
            System.out.println("Error at position " + err);
            rec[err] ^= 1;
            System.out.print("Corrected message: ");
            for (int i = 1; i < rec.length; i++) System.out.print(rec[i]);
        }
    }
}

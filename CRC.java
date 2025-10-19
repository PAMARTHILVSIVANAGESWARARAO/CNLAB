import java.util.*;

public class CRC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Frame Size : ");
        int frameSize = sc.nextInt();
        System.out.print("Enter Frame bits (Space Separated 0/1) : ");
        int[] frame = new int[frameSize];
        for (int i = 0; i < frameSize; i++) {
            frame[i] = sc.nextInt();
        }

        System.out.print("Enter the Highest Power of x in the generator : ");
        int gp = sc.nextInt();
        int[] generator = new int[gp + 1];
        System.out.println("Enter Coefficient for Generator Polynomial :");
        for (int i = gp; i >= 0; i--) {
            System.out.print("Coefficient of x^" + i + " : ");
            generator[i] = sc.nextInt();
        }

        int[] transmitted = new int[frameSize + gp];
        for (int i = 0; i < frameSize; i++) {
            transmitted[i] = frame[i];
        }

        int[] remainder = divide(transmitted.clone(), generator);

        System.out.println("Sender Side : ");
        System.out.print("Frame : ");
        for (int i = 0; i < frameSize; i++) System.out.print(frame[i]);
        System.out.println();
        System.out.print("Generator : ");
        for (int i = gp; i >= 0; i--) System.out.print(generator[i]);
        System.out.println();
        System.out.print("CRC : ");
        for (int i = 0; i < gp; i++) System.out.print(remainder[i]);
        System.out.println();

        for (int i = 0; i < gp; i++) {
            transmitted[frameSize + i] = remainder[i];
        }

        System.out.print("Transimitted Frame : ");
        for (int i = 0; i < transmitted.length; i++) System.out.print(transmitted[i]);
        System.out.println();

        System.out.println("Reciever SIde:");
        System.out.print("Enter Recieved Frame Size : ");
        int rsize = sc.nextInt();
        System.out.print("Enter Recieved Frame : ");
        int[] received = new int[rsize];
        for (int i = 0; i < rsize; i++) {
            received[i] = sc.nextInt();
        }

        int[] rem2 = divide(received.clone(), generator);
        System.out.print("Remainder :");
        for (int i = 0; i < gp; i++) System.out.print(rem2[i]);
        System.out.println();
        boolean error = false;
        for (int i = 0; i < gp; i++) {
            if (rem2[i] != 0) {
                error = true;
                break;
            }
        }
        if (error) {
            System.out.println("Error Detected");
        } else {
            System.out.println("NO error Detected");
        }

        sc.close();
    }

    private static int[] divide(int[] dividend, int[] divisor) {
        int gp = divisor.length - 1;
        for (int i = 0; i <= dividend.length - divisor.length; i++) {
            if (dividend[i] == 1) {
                for (int j = 0; j < divisor.length; j++) {
                    dividend[i + j] ^= divisor[j];
                }
            }
        }
        int[] remainder = new int[gp];
        for (int i = 0; i < gp; i++) {
            remainder[i] = dividend[dividend.length - gp + i];
        }
        return remainder;
    }
}

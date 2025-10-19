import java.util.*;

public class GoBackNARQ {
    private int totalFrames;
    private int windowSize;
    private int base = 0;
    private int nextFrame = 0;
    private long timerStart;
    private final int TIMEOUT = 3000;
    private boolean timerRunning = false;
    private Scanner sc = new Scanner(System.in);

    public GoBackNARQ(int totalFrames, int windowSize) {
        this.totalFrames = totalFrames;
        this.windowSize = windowSize;
    }

    public void SendFrames() {
        while (base < totalFrames) {
            while (nextFrame < base + windowSize && nextFrame < totalFrames) {
                System.out.println("Sending frame " + nextFrame);
                nextFrame++;
                if (!timerRunning) {
                    timerRunning = true;
                    timerStart = System.currentTimeMillis();
                }
            }

            System.out.print("Was Ack for frame " + base + " received ? (y/n) : ");
            String ackInput = sc.next();

            if (ackInput.equals("y")) {
                System.out.println("Ack received for frame " + base);
                base++;
                if (base == nextFrame) {
                    timerRunning = false;
                } else {
                    timerStart = System.currentTimeMillis();
                }
            } else if (ackInput.equals("n")) {
                System.out.println("Ack for frame " + base + " is lost waiting for timeout...");
                
                try {
                    Thread.sleep(TIMEOUT);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                int end = Math.min(base + windowSize, totalFrames);
                System.out.println("Time Out ! Resending frames from " + base + " to " + (end - 1));
                
                for (int i = base; i < end; i++) {
                    System.out.println("Sending frame " + i);
                }
                nextFrame = end;
                timerStart = System.currentTimeMillis();
            } else {
                System.out.println("Invalid input please enter y or n");
            }
        }
        System.out.println("All frames are Acknowledged");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter total number of frames to send : ");
        int totalFrames = sc.nextInt();
        System.out.print("Enter Window Size : ");
        int windowSize = sc.nextInt();

        if (windowSize > totalFrames)
            windowSize = totalFrames;
            
        GoBackNARQ gbn = new GoBackNARQ(totalFrames, windowSize);
        gbn.SendFrames();
        sc.close();
    }
}
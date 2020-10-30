package thread.tortoise;
import javax.swing.*;
public class Tortoise  implements Runnable
{
    private static final int MILESTONES = 5;

    private final Thread tortoise;

    public Tortoise() {
        this.tortoise = new Thread(this, "Tortoise");
    }

    public Thread getTortoise() {
        return tortoise;
    }

    @Override
    public void run() {
        for (int index = 0; index < MILESTONES; index++) {
            System.out.printf("The Rabbit has completed %.2f %% of the race!\n",
                    index * (100.0f / MILESTONES)
            );
            switch (index) {
                case 0:
                    System.out.println("The Rabbit has started from the start line!");
                    break;
                case 1:
                    System.out.println("The Rabbit has reached the Cool River!");
                    break;
                case 2:
                    System.out.println("The Rabbit has reached the Mountain Hill!");
                    break;
                case 3:
                    System.out.println("The Rabbit has reached the Big Oak Tree!");
                    System.out.println("The Rabbit is leading and hence is going to sleep!");
                    try {
                        Thread.sleep(9000L);
                    } catch (InterruptedException e) {
                        System.err.println("The Rabbit's sleep got interrupted!");
                    }
                    break;
                case 4:
                    System.out.println("The Rabbit has reached the finish line!");
                    break;
            }
            try {
                Thread.sleep(1500L);
            } catch (InterruptedException e) {
                System.err.println("the Tortoise has lost the path!");

            }
        }
        JOptionPane.showConfirmDialog(
                null,
                "the Tortoise has completed the the race!",
                "Tortoise",
                JOptionPane.OK_CANCEL_OPTION
        );
    }

}

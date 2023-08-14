import java.util.Random;

public class Generator implements Runnable{
    private final Tunnel tunnel1;
    private final Tunnel tunnel2;
    private final int countTrain;


    public Generator(Tunnel tunnel1, Tunnel tunnel2, int countTrain) {
        this.tunnel1 = tunnel1;
        this.tunnel2 = tunnel2;
        this.countTrain = countTrain;
    }

    private Tunnel getRandomTunnel() {
        int n = (int) (Math.random() * 2);
        System.out.println(n);
        if (n == 0) {
            tunnel1.setName("№ 1");
            return tunnel1;
        } tunnel1.setName("№ 2");
            return tunnel2;

    }

    private boolean getRandomDirection() {
        int n = (int) (Math.random() * 2);
        return n != 0;
    }
    @Override
    public void run() {
        int  count = 0;
        System.out.println("Let's go");
        while (count < countTrain) {
            Thread.currentThread().setName("Generator train");
            count++;
            Train train = new Train(getRandomDirection(), getRandomTunnel());
            train.getTunnel().enter(train);
            train.setDirection(!train.isDirection());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            train.getTunnel().exit();
        }
    }
}

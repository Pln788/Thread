import java.util.ArrayList;
import java.util.List;

public class Tunnel {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private List<Train> trains;
    private final int MAX = 1;
    private  int count = 0;
    private  int number;


    public Tunnel() {
        trains = new ArrayList<>();
        number = ++ count;

    }

    public synchronized void enter(Train train) {

        if(count >= MAX) {
            System.out.println("Подожите немного, в тоннеле есть поезд");
            try {
                wait(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Тоннель свободен");
        notifyAll();
        trains.add(train);
        count++;
        System.out.println("Поезд  заехал в тоннель номер " + number);
    }

    public synchronized void exit() {
        if(count < MAX) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll();
        trains.clear();
        System.out.println("Поезд  выехал из тоннеля номер " + number);
        count--;
        System.out.println("Тоннель свободен");
    }
}

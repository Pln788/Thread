public class Main {
    public static void main(String[] args) {
        Tunnel tunnel1 = new Tunnel();
        Tunnel tunnel2 = new Tunnel();

        Thread station1=new Thread(new Generator(tunnel1, tunnel2, 10));
        station1.start();
    }
}

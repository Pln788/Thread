public class Train {
    private boolean direction;
    private Tunnel tunnel;

    public void setDirection(boolean direction) {
        this.direction = direction;
    }

    public boolean isDirection() {
        return direction;
    }

    public Tunnel getTunnel() {
        return tunnel;
    }

    public Train(boolean direction, Tunnel tunnel) {
        this.direction = direction;
        this.tunnel = tunnel;
    }

}

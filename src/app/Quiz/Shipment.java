package app.Quiz;

public class Shipment extends BoxWeight {
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    private int cost;


    public Shipment(int width, int height, int depth, int weight,int cost) {
        super(width, height, depth, weight);
        this.cost=cost;
    }
}

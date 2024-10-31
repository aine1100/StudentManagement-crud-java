package app.Quiz;

public class BoxWeight extends Box{
    private int weight;
    public BoxWeight(int width, int height, int depth,int weight) {
        super(width, height, depth);
        this.weight=weight;
    }
    public void setWeight(int weight){
        this.weight=weight;
    }
    public int getWeight(){
        return  this.weight;
    }
}

package app.oop.abstraction;

public class square extends shape{
    private  int side;

    public square(){
    }
    public square(int side){
        this.side=side;

    }
    public int getSide(){
        return  this.side;
    }
    public  void setSide(int side){
        this.side=side;
    }
    @Override
    public double area() {

        return side*side;
    }
}

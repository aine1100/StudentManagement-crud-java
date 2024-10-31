package app.Quiz;

public class Box {
    private int width;
    private int height;
    private int depth;

    public  Box(int width,int height,int depth ){
        this.width=width;
        this.height=height;
        this.depth=depth;

    }

    public void setWidth(int width){
        this.width=width;
    }
    public int getWidth(){
        return this.width;
    }
    public  void setHeight(int height){
        this.height=height;
    }
    public  int getHeight(){
        return  this.height;
    }
    public  void setDepth(int depth){
        this.depth=depth;
    }
    public  int getDepth(){
        return  this.depth;
    }

    public int volume(){
        return width*height*depth;
    }


}

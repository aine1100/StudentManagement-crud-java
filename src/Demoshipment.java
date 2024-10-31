import app.Quiz.Shipment;

public class Demoshipment {
    public static void main(String[] args){
        Shipment shipmentDemo=new Shipment(10,10,10,10,10);
        System.out.println(shipmentDemo.volume());
        System.out.println(shipmentDemo.getWeight());
        System.out.println(shipmentDemo.getCost());
    }
}

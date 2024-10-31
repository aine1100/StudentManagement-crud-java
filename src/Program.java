import app.oop.abstraction.Animal;
import app.oop.abstraction.Dog;
import app.oop.employee.FootballPerson;
import app.oop.shape.Circle;
import app.oop.shape.Shape;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static  void  main (String[] args){
        FootballPerson person=new FootballPerson(10,"aine","dushimire",14,"rm","rwanda",5);
        System.out.println(person);
        Circle c=new Circle();
        c.setRadius(25);
        System.out.println("The are is" + c.area());
        List<String> districts=new ArrayList<String>();


    }
}

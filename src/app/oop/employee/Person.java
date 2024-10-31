package app.oop.employee;

public class Person {
    public int id;
    public String first;

    public Person(int id, String first, String last) {
        this.id = id;
        this.first = first;
        this.last = last;
    }

    public String last;
     public Person(){

     }
     public Person (int id,String first,String last,int age){
         this.id=id;
         this.first=first;
         this.last=last;
         this.age=age;
     }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    int age;

    @Override
    public String toString() {
        return "hello "+this.first + " " +this.last + " you are " + this.age;
    }
}


public class Student {
  public String studentName;
  public  String studentClass;
  public int age;
  public String studentEmail;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String date;

    public Student(){

    }

    public Student(String studentName,String studentClass,int age,String studentEmail,String date){
        this.studentName=studentName;
        this.studentClass=studentClass;
        this.age=age;
        this.studentEmail=studentEmail;
        this.date=date;
    }
    public void setStudentName(String studentName){
        this.studentName=studentName;
    }
    public String getStudentName(){
        return this.studentName;
    }
    public void setStudentClass(String studentClass){
        this.studentClass=studentClass;
    }
    public String getStudentClass(){
        return this.studentClass;
    }
    public void setAge(int age){
         this.age=age;
    }
    public int getAge(){
        return this.age;
    }
    public void setStudentEmail(String studentEmail){
        this.studentEmail=studentEmail;
    }
    public String getStudentEmail(){
      return   this.studentEmail;
    }
    public String toString(){
        return "I am " + getStudentName() + " and i study in " + getStudentClass() + " and my email is  "+getStudentEmail()+ " and am " + getAge() + "and i was born on "+ getDate() ;
    }

}

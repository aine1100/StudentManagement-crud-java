package app.oop.employee;

public class FootballPerson extends Person {
    private  String team;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    private String country;
    private int number;
    public FootballPerson(){}
    public FootballPerson(int id,String first,String last,int age,String team,String country,int number){
        super(id, first, last, age);
        this.team=team;
        this.country=country;
        this.number=number;
    }

    @Override
    public String toString() {
        return super.toString() + " I play in" + this.team + " And am from : "+this.country + " I play on "+this.number;
    }
}

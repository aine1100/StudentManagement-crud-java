package app.oop.abstraction;

public abstract class AnimalGroup extends Animal {
    public abstract void printGroupName(String group);
    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String group;


}

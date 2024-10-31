package practice;

public class village {
    private int villageId;
    private int cellId;

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public int getCellId() {
        return cellId;
    }

    public void setCellId(int cellId) {
        this.cellId = cellId;
    }

    public int getVillageId() {
        return villageId;
    }

    public void setVillageId(int villageId) {
        this.villageId = villageId;
    }

    private String villageName;
    public village(){

    }
    public village(int id,String name,int cell){
        this.villageId=id;
        this.villageName=name;
        this.cellId=cell;
    }
}

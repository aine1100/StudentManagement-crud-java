package practice;

public class cell {
    private int cellId;
    private String cellName;

    public int getSectorId() {
        return sectorId;
    }

    public void setSectorId(int sectorId) {
        this.sectorId = sectorId;
    }

    public String getCellName() {
        return cellName;
    }

    public void setCellName(String cellName) {
        this.cellName = cellName;
    }

    public int getCellId() {
        return cellId;
    }

    public void setCellId(int cellId) {
        this.cellId = cellId;
    }

    private int sectorId;

    public cell(){

    }
    public cell(int id,String name,int sector){
        this.cellId=id;
        this.cellName=name;
        this.sectorId=sector;
    }
}

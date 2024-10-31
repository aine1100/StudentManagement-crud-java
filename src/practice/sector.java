package practice;

public class sector {
    private int SectorId;
    private String SectorName;
    private int districtId;

    public sector(){

    }
    public sector(int id,String name,int districtId){
        this.SectorId=id;
        this.SectorName=name;
        this.districtId=districtId;

    }
    public void setId(int id){
        this.SectorId=id;
    }
    public int getId(){
        return SectorId;
    }
    public void setName(String name){
        this.SectorName=name;
    }
    public String getName(){
        return SectorName;
    }
    public void setDistrictId(int id){
        this.districtId=id;

    }
    public int getDistrictId(){
        return districtId;
    }

}

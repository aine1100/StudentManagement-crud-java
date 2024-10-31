package practice;

public class district {
    private int districtId;
    private String districtName;

    public int getProvinceId() {
        return ProvinceId;
    }

    public void setProvinceId(int provinceId) {
        ProvinceId = provinceId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    private int ProvinceId;

    public district(){

    }
    public district(int id,String name,int province){
        this.districtId=id;
        this.districtName=name;
        this.ProvinceId=province;

    }
}

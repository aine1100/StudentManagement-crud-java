package practice;

public class Province {
    private int provinceId;

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    private String provinceName;

    public Province(){

    }
    public Province(int id,String name){
        this.provinceId=id;
        this.provinceName=name;
    }
}

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadingFilesWork {
    public static  void  main(String[] args){
        String url="jdbc:mysql://localhost:3306/rwanda";
        String password="";
        String username="root";
        File province=new File("C:\\Users\\user\\Downloads\\rwanda\\Province.txt");
        File district=new File("C:\\Users\\user\\Downloads\\rwanda\\District.txt");
        File cell=new File("C:\\Users\\user\\Downloads\\rwanda\\Cell.txt");
        File sector=new File("C:\\Users\\user\\Downloads\\rwanda\\Sector.txt");
        File village=new File("C:\\Users\\user\\Downloads\\rwanda\\Village.txt");

        try{
            Connection con= DriverManager.getConnection(url,username,password);
            Statement conStat=con.createStatement();

            try{
                BufferedReader readFile=new BufferedReader(new FileReader(province));
                String provinces;
                while((provinces=readFile.readLine())!=null){
                    String data[]=provinces.split(",");
                    int provinceId= Integer.parseInt(data[0]);
                    String provinceName=data[1];
                    String sql="INSERT into province (provinceId,provinceName)"+"VALUES('"+provinceId+"','"+provinceName+"')";
                    Statement insetStatement=con.prepareStatement(sql);
                    insetStatement.executeUpdate(sql);
                }

            }catch(Exception e){
                e.printStackTrace();
                System.out.println("Failed to read the file");

            }
            try{
                BufferedReader readFile=new BufferedReader(new FileReader(district));
                String districts;
                while((districts=readFile.readLine())!=null){
                    String data[]=districts.split(",");
                    int districtId= Integer.parseInt(data[0]);
                    int provinceId= Integer.parseInt(data[1]);
                    String districtName=data[2];
                    String sql="INSERT into district (districtId,districtName,provinceId)"+"VALUES('"+districtId+"','"+districtName+"','"+provinceId+"')";
                    Statement insetStatement=con.prepareStatement(sql);
                    insetStatement.executeUpdate(sql);
                }

            }catch(Exception e){
                e.printStackTrace();
                System.out.println("Failed to read the file");

            }
            try{
                BufferedReader readFile=new BufferedReader(new FileReader(sector));
                String sectors;
                while((sectors=readFile.readLine())!=null){
                    String data[]=sectors.split(",");
                    int sectorId= Integer.parseInt(data[0]);
                    int districtId= Integer.parseInt(data[1]);
                    String sectorName=data[2];
                    String sql="INSERT into sector (sectorId,sectorName,districtId)"+"VALUES('"+sectorId+"','"+sectorName+"','"+districtId+"')";
                    Statement insetStatement=con.prepareStatement(sql);
                    insetStatement.executeUpdate(sql);
                }

            }catch(Exception e){
                e.printStackTrace();
                System.out.println("Failed to read the file");

            }
            try{
                BufferedReader readFile=new BufferedReader(new FileReader(cell));
                String cells;
                while((cells=readFile.readLine())!=null){
                    String data[]=cells.split(",");
                    int cellId= Integer.parseInt(data[0]);
                    int sectorId= Integer.parseInt(data[1]);
                    String cellName=data[2];
                    String sql="INSERT into cell (cellId,cellName,sectorId)"+"VALUES('"+cellId+"','"+cellName+"','"+sectorId+"')";
                    Statement insetStatement=con.prepareStatement(sql);
                    insetStatement.executeUpdate(sql);
                }

            }catch(Exception e){
                e.printStackTrace();
                System.out.println("Failed to read the file");

            }
            try{
                BufferedReader readFile=new BufferedReader(new FileReader(village));
                String villages;
                while((villages=readFile.readLine())!=null){
                    String data[]=villages.split(",");
                    int villageId= Integer.parseInt(data[0]);
                    int cellId= Integer.parseInt(data[1]);
                    String villageName=data[2];
                    String sql="INSERT into village (villageId,villageName,cellId)"+"VALUES('"+villageId+"','"+villageName+"','"+cellId+"')";
                    Statement insetStatement=con.prepareStatement(sql);
                    insetStatement.executeUpdate(sql);
                }

            }catch(Exception e){
                e.printStackTrace();
                System.out.println("Failed to read the file");

            }
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("sql exception");

        }



    }
}
package practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Practice {
    public static void main (String[] args){
         String username="root";
         String url="jdbc:mysql://localhost:3306/practice";
         String password="";

         try{
             Connection con=DriverManager.getConnection(url,username,password);
             Statement conStat=con.createStatement();
             if(con !=null){
                 System.out.println("connected to database successfully");
                 InsertIntoDb(conStat);
             }
         } catch (SQLException e) {
             System.out.println("Sql exception");
             e.printStackTrace();
         }
    }
    public static void InsertIntoDb(Statement conStat){
        File province=new File("C:\\Users\\user\\Downloads\\rwanda\\Province.txt");
        try{
            BufferedReader readFile=new BufferedReader(new FileReader(province));
            String provinces ;
            while((provinces = readFile.readLine())!=null){
                String data[]=provinces.split(",");

                Province rwanda=new Province();
                rwanda.setProvinceId(Integer.parseInt(data[0]));
                rwanda.setProvinceName(data[1]);
                String sql="INSERT INTO province(provinceId,provinceName) VALUES('"+rwanda.getProvinceId()+"','"+rwanda.getProvinceName()+"')";

               try {
                   int st=conStat.executeUpdate(sql);
                   if(st>=1){
                       System.out.println("data is inserted in db successfully");

                   }

               }catch (SQLException e){
                   e.printStackTrace();
                   System.out.println("SqlException");
               }
            }

        }catch (Exception e){
            System.out.println("Failed to read the file");
            e.printStackTrace();
        }
    }
}

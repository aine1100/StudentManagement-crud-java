package app.DataStructure;

import java.util.*;

public class DataStructure {
    public static void main(String[] args){
        List<String> districts=new ArrayList<>();
        districts.addAll(Arrays.asList("nyamagabe","huye","bugesera","gasabo","gasabo","nyaruguru","gasabo","huye","huye","huye","huye","nyamagabe","bugesera","gasabo","nyarugenge","muhanga","musanze","rubavu","kicukiro","kicukiro","gisagara","gakenke","ruhango","gicumbi","nyamasheke","gicumbi","nyanza","nyanza","ruhango","ruhango"));

        int i=1;
        for(String district:districts){
            System.out.println(i+"." + district);
            i++;

        }


    }
}

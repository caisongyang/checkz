package test;

import java.sql.SQLOutput;
import java.util.*;

public class test2 {

    public static void main(String[] args) {
        List<String> a = new ArrayList<String>();
        a.add("1");
        a.add("2");
        a.add("3");
        a.add("4");
        a.add("5");
        a.add("6");

        //List<String> b = a;
        List<String> c = new ArrayList<>();
        boolean whiletof = true;
        while(whiletof){
            if(a.size()==0){
                whiletof = false;
            }else{
                String Maxval = a.get(0);
                int maxkey = 0;
                for(int i = 0;i<a.size();i++){
                    if(Integer.parseInt(Maxval)<Integer.parseInt(a.get(i))){
                        Maxval = a.get(i);
                        maxkey = i;
                    }
                }
                c.add(Maxval);
                a.remove(maxkey);
            }
        }
        System.out.println(c.toString());
    }
}

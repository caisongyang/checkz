package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class test2 {

    public static void main(String[] args) {
/*
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println(reader.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
*/
        Scanner input = new Scanner(System.in);

         System.out.println("请输入你的身份证号:");

         String line = input.nextLine();

         System.out.println("原来你的身份证号是"+line.length()+"位数字啊");
    }
}

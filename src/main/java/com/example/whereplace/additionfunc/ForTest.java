package com.example.whereplace.additionfunc;

import java.util.Scanner;

public class ForTest {
    public static void main(String[] args)throws NumberFormatException {
        String s;
        Scanner scanner=new Scanner(System.in);
        s=scanner.nextLine();
        try {
        System.out.println(Long.parseLong(s));
        }catch (NumberFormatException e){
            System.out.println("error");
        }
    }
}

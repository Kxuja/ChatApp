package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        SocialService socialService=new SocialService();
        while (true){
            System.out.println("1-> Sign Up !");
            System.out.println("2 -> Sign In!");
            System.out.println("CHOOSE :");
            int choose=scanner.nextInt();
            if (choose==1){
                socialService.signUp();
            }
            else  if (choose==2){
                socialService.signIn();
            }
        }
    }
}

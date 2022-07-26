package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class SocialService implements SocialInterface {
    ArrayList<User> userList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    int index;

    @Override
    public void signUp() {
        System.out.println("User name :");
        String name = scanner.next();
        System.out.println("User email :");
        String email = scanner.next();
        System.out.println("User password :");
        String password = scanner.next();
        User user = new User();
        user.email = email;
        user.name = name;
        user.password = password;
        userList.add(user);
        System.out.println("Success !");
    }

    @Override
    public void signIn() {
        System.out.println("email :");
        String email = scanner.next();
        System.out.println("password :");
        String password = scanner.next();
        boolean isHave = false;
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).password.equals(password) && userList.get(i).email.equals(email)) {
                isHave = true;
                index = i;
                break;
            }
        }
        if (isHave) {
            while (true) {
                System.out.println("============My Panel==========");
                System.out.println("1-> My Profile !");
                System.out.println("2-> Edit Profile !");
                System.out.println("3-> Menga kelgan xabarlar !");
                System.out.println("4-> Men junatgan xabarlar !");
                System.out.println("5-> my Balance !");
                System.out.println("6-> add Balance !");
                System.out.println("7-> Xabar jo`natish !");
                System.out.println("0-> Log Out !");
                System.out.println("Choose :");
                int c = scanner.nextInt();
                if (c == 0) {
                    break;
                }
                if (c == 1) {
                    System.out.println("Your name :" + userList.get(index).name);
                    System.out.println("Your email :" + userList.get(index).email);
                    System.out.println("Your password :" + userList.get(index).password);
                    System.out.println("Your balance :" + userList.get(index).myBalance);
                } else if (7 == c) {
                    if (userList.get(index).myBalance==0){
                        System.out.println("Please add balance");
                    }else {
                        messageSend();
                    }
                } else if (c == 5) {
                    System.out.println("=======================Your balance :" + userList.get(index).myBalance + "=========================");
                } else if (c == 4) {
                    if (userList.get(index).userChats.isEmpty()) {
                        System.out.println("Is Empty");
                    } else {
                        for (int i = 0; i < userList.get(index).userChats.size(); i++) {
                            System.out.println("sending message user name :" + userList.get(index).userChats.get(i).userName);
                            System.out.println("sending message user email :" + userList.get(index).userChats.get(i).email);
                            System.out.println("sending message name :" + userList.get(index).userChats.get(i).messageName);
                            System.out.println("sending message title :" + userList.get(index).userChats.get(i).messageTitle);
                            System.out.println("=== === === === === === === === === === === === === === === === === ===  ");
                        }

                    }
                } else if (c == 3) {
                    if (userList.get(index).myChats.isEmpty()) {
                        System.out.println("Is Empty");

                    } else {
                        for (int i = 0; i < userList.get(index).myChats.size(); i++) {
                            System.out.println("Sender user name :" + userList.get(index).myChats.get(i).userName);
                            System.out.println("Sender user email :" + userList.get(index).myChats.get(i).email);
                            System.out.println("message name :" + userList.get(index).myChats.get(i).messageName);
                            System.out.println("message title :" + userList.get(index).myChats.get(i).messageTitle);
                            System.out.println("============================================================================");
                        }
                    }
                } else if (c == 6) {
                    System.out.println("Balance summa :");
                    int sum = scanner.nextInt();
                    userList.get(index).myBalance += sum;
                    System.out.println("Success");
                } else if (c == 2) {
                    System.out.println("new name :");
                    String newName = scanner.next();
                    System.out.println("new email :");
                    String newEmail = scanner.next();
                    System.out.println("new password :");
                    String newPassword = scanner.next();
                    userList.get(index).name = newName;
                    userList.get(index).password = password;
                    userList.get(index).email = email;
                    System.out.println("Success !");
                }
            }
        }
    }


    @Override
    public void messageSend() {
        if (userList.isEmpty()) {
            System.out.println("Is Empty !");
        } else {
            for (int i = 1; i < userList.size(); i++) {
                System.out.println("=============" + (i) + "=============");
                System.out.println("User name :" + userList.get(i).name);
            }
            System.out.println("Choose user | please entered number:");
            int sendUserIndex = scanner.nextInt();
            if (sendUserIndex < userList.size() + 3) {
                if (userList.get(index).myBalance > 10) {
                    System.out.println("Message name  :");
                    String nameMSG = scanner.next();
                    System.out.println("Message :");
                    Scanner scanner1 = new Scanner(System.in);
                    String message = scanner1.nextLine();
                    UserChats userChats = new UserChats();
                    userChats.email = userList.get(sendUserIndex).email;
                    userChats.userName = userList.get(sendUserIndex).name;
                    userChats.messageName = nameMSG;
                    userChats.messageTitle = message;
                    userList.get(sendUserIndex).myChats.add(userChats);
                    userList.get(index).userChats.add(userChats);
                    System.out.println("Success !");
                }
            }
        }
    }
}

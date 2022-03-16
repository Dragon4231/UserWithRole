import User.User;
import User.Role;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        
        User user = null;
        ArrayList<User> userArrayList = new ArrayList<>();
        int action = 0;
        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Menu Users : \n" +
                    "1. Create new User \n" +
                    "2. Edit User\n" +
                    "3. Info of Users\n" +
                    "4. Exit\n");
            action = scanner.nextInt();
            switch (action){
                case 1:
                    System.out.println("1. Create User without parameters\n" +
                    "2. Create User with parameters\n" +
                            "3. Exit for main menu\n");
                    action = scanner.nextInt();
                    switch (action){
                        case 1:
                            user = new User();
                            userArrayList.add(user);
                            System.out.println("User ID"+user.getID()+" create\n");
                            break;
                        case 2:
                            try{
                                String email, name, surname, roleUser, number;
                                scanner.nextLine();
                                System.out.println("Write name Of User\n");
                                name = scanner.nextLine();
                                System.out.println("Write surname Of User\n");
                                surname = scanner.nextLine();
                                System.out.println("Write phone number Of User (ex: 375001112233)\n");
                                number = scanner.nextLine();
                                System.out.println("Write email Of User (ex. mymail@mail.ru)\n");
                                email = scanner.nextLine();
                                System.out.println("Choose role for User\n");
                                System.out.println(User.getAllRoles()+"\n");
                                roleUser = scanner.nextLine();
                                user = new User(name,surname,email,number,roleUser);
                                userArrayList.add(user);
                         }catch (RuntimeException e){
                             System.out.println(e.getMessage());
                        }
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("incorrect action");
                            break;
                    }
                    break;
                case 2:
                    int personID;
                    boolean findID = false;
                    System.out.println("Write USER ID to choose : \n");
                    personID = scanner.nextInt();
                    for(User e : userArrayList){
                        if (e.getID() == personID){
                            user = e;
                            findID = true;
                        }
                    }
                    if( !findID ){
                        System.out.println("Object not found");
                        break;
                    }
                    System.out.println("Select what you want to Edit");
                    System.out.println("1. Email \n" +
                            "2. Phone Number \n" +
                            "3. Name\n" +
                            "4. Surname\n" +
                            "5. Role of User\n" +
                            "6. Exit for main menu");
                    action = scanner.nextInt();
                    scanner.nextLine();
                    switch (action){
                        case 1:
                            System.out.println("Write new email");
                            String newEmail = scanner.nextLine();
                            try{
                                user.setEmail(newEmail);
                            }catch (RuntimeException e){
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            System.out.println("Select new Role, for added");
                            System.out.println(User.getAllRoles()+"\n");
                            String newRole = scanner.nextLine();
                            user.setRoleOfUser(newRole);
                            break;
                        case 6:
                            break;
                        default:
                            break;
                    }
                    break;
                case 3:
                   if(userArrayList.isEmpty()){
                        System.out.println("USER LIST IS EMPTY\n");
                        Thread.sleep(1500);
                        break;
                    }
                    System.out.println("Info about ALL USERS : \n");
                    for(User u : userArrayList){
                        System.out.println(u+"\n");
                    }
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}

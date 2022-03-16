package User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    //COL
    private int ID;
    private static int nextID = 0;
    private String name;
    private String surname;
    private String email;
    private String[] numberOfPhone = new String[3];
    ArrayList<Role> roleOfUser = new ArrayList<Role>();
    protected static ArrayList<Role> roles = new ArrayList<Role>();
    {
        ID = nextID;
        nextID++;
    }
    static
    {
        Role USER = new Role("USER", 1);
        Role CUSTOMER = new Role("CUSTOMER", 1);
        Role ADMIN = new Role("ADMIN", 2);
        Role PROVIDER = new Role("PROVIDER", 2);
        Role SUPER_ADMIN = new Role("SUPER_ADMIN", 3);
        roles.add(USER);
        roles.add(CUSTOMER);
        roles.add(ADMIN);
        roles.add(PROVIDER);
        roles.add(SUPER_ADMIN);
    }

    //METHODS
    public void setRoleOfUser(String newRole) {
        Role tempRole = new Role();
        for(Role e : roles){
            if(e.nameOfRole.equals(newRole)){
                tempRole = e;
            }
        }
        if(tempRole.nameOfRole == null){
            throw new RuntimeException("error: incorrect name of role");
        }
        if(!roleOfUser.isEmpty() && (roleOfUser.get(0).levelOfRole == 3)){
            throw new RuntimeException("error:you have max levelOfRole");
        }else if(roleOfUser.size() == 2){
            throw new RuntimeException("error:you can't add any role");
        }else if(roleOfUser.size() == 1 && tempRole.levelOfRole == 3) {
            throw new RuntimeException("error:you can't add this role");
        }else{
            roleOfUser.add(tempRole);
        }
    }

    public void setEmail(String email){
        Pattern pattern = Pattern.compile("(\\w+[\\.-]?\\w+)+@(\\w+[\\.-]?\\w+)+[\\.]{1}[a-z]{2,4}");
        Matcher matcher = pattern.matcher(email);
        if(matcher.matches()){
            this.email = email;
        }else{
            throw new RuntimeException("error:incorrect email");
        }
    }

    public User(String name, String surname, String email, String numberOfPhone,String roleOfUser) {
        this.name = name;
        this.surname = surname;
        setEmail(email);
        setNumberOfPhone(numberOfPhone);
        setRoleOfUser(roleOfUser);
    }

    public User() {

    }

    public void setNumberOfPhone(String numberOfPhone) {
        for(int i = 0; i < 3; i++){
            if(this.numberOfPhone[i] == null){
                this.numberOfPhone[i] = numberOfPhone;
                return;
            }
        }
        throw new RuntimeException("error : all phones are added");
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", numberOfPhone=" + Arrays.toString(numberOfPhone) +
                ", roleOfUser=" + roleOfUser +
                '}';
    }

    public int getID() {
        return ID;
    }
    public static ArrayList<String> getAllRoles(){
        ArrayList<String> allRoles = new ArrayList<>();
        for(Role u : roles){
            allRoles.add(u.nameOfRole);
        }
        return allRoles;
    }


}

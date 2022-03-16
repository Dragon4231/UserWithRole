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

    //METHODS
    public void setRoleOfUser(String newRole) {
        Role tempRole = null;
        for(Role r : Role.values()){
            if(newRole.equals(r.nameRole)) tempRole = r;
        }
        if(tempRole == null){
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
        for(Role u : Role.values()){
            allRoles.add(u.nameRole);
        }
        return allRoles;
    }


}

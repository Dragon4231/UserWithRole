package User;

public enum Role {
    USER("USER",1),
    CUSTOMER("CUSTOMER",1),
    ADMIN("ADMIN",2),
    PROVIDER("PROVIDER",2),
    SUPER_ADMIN("SUPER_ADMIN",3);
    String nameRole;
    int levelOfRole;
    Role(String nameRole, int levelOfRole){
        this.nameRole = nameRole;
        this.levelOfRole = levelOfRole;
    }
    public String getNameRole() {
        return nameRole;
    }
    public int getLevelOfRole() {
        return levelOfRole;
    }
}
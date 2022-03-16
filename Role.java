package User;

public class Role{
    protected String nameOfRole;
    protected int levelOfRole;

    public Role() {
    }

    public Role(String nameOfRole, int levelOfRole) {
        this.nameOfRole = nameOfRole;
        this.levelOfRole = levelOfRole;
    }

    @Override
    public String toString() {
        return "Role{" +
                "nameOfRole='" + nameOfRole + '\'' +
                ", levelOfRole=" + levelOfRole +
                '}';
    }

}

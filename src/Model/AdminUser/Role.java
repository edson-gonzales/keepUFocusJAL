package Model.AdminUser;

/**
 * Created by ALDO on 16/7/2016.
 */
public class Role {
    private int roleId;
    private String rolName;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRolName() {
        return rolName;
    }

    public void setRolName(String rolName) {
        this.rolName = rolName;
    }

    public Role(String rolName) {
        this.roleId = 0;
        this.rolName = rolName;
    }

    public Role() {
        this.roleId = 0;
        this.rolName = "";
    }

    /**
     * Save user Information in the data base.
     *
     * @return Return boolean value (True = Susses;False = Error).
     */
    public boolean save() {
        System.out.printf("method will implements");
        return true;
    }

    /**
     * Update the user information in the data base.
     *
     * @return Return a boolean value (True = Success;False = Error).
     */
    public boolean update() {
        System.out.printf("method will implements");
        return true;
    }

    /**
     * Deleted an existing user in the data base.
     *
     * @return Return boolean value (True = Success;False = Error).
     */
    public boolean delete() {
        System.out.printf("method will implements");
        return true;
    }

    /**
     * Get an existing user in the data base.
     *
     * @param roleId ID for search in the data base.
     * @return Exits an UserControllersTest.
     */
    public static Role getRole(int roleId) {
        Role role = new Role("User");
        role.setRoleId(roleId);
        return role;
    }
}

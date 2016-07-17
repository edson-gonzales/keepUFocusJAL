package Controller.AdminUser;

import Model.AdminUser.Role;

/**
 * Control the interaction between the view and the model layer
 * Created by ALDO on 16/7/2016.
 */
public class RoleControllers {
    //Methods

    /**
     * Save an role object.
     *
     * @param role Save role in the data base.
     * @return Return boolean value (True = Success;False = Error).
     */
    public boolean saveRole(Role role) {
        return role.save();
    }

    /**
     * Update an role object.
     *
     * @param role update role in the data base.
     * @return Return boolean value (True = Success;False = Error).
     */
    public boolean updateRole(Role role) {
        return role.update();
    }

    /**
     * Delete an role object.
     *
     * @param role delete role in the data base.
     * @return Return boolean value (True = Success;False = Error).
     */
    public boolean deleteRole(Role role) {
        return role.delete();
    }
}

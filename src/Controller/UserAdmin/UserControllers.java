//package Controller.UserAdmin;
//
//
//import Model.Common.Position;
//import Model.UserAdmin.Role;
//import Model.UserAdmin.User;
//
//import java.util.List;
//
///**
// * Created by AldoBalderrama on 7/7/2016.
// */
//public class UserControllers {
//    //Methods
//
//    /**
//     * Save an user object.
//     *
//     * @param user Save user in the data base.
//     * @return Return boolean value (True = Success;False = Error).
//     */
//    public boolean saveUser(User user) {
//        return user.save();
//    }
//
//    /**
//     * Update an user object.~
//     *
//     * @param user update user in the data base.
//     * @return Return boolean value (True = Success;False = Error).
//     */
//    public boolean updateUser(User user) {
//        return user.update();
//    }
//
//    /**
//     * Delete an user object.
//     *
//     * @param user delete user in the data base.
//     * @return Return boolean value (True = Success;False = Error).
//     */
//    public boolean deleteUser(User user) {
//        return user.delete();
//    }
//
//    /**
//     * Get a user set object.
//     *
//     * @return Get list Users.
//     */
//    public List<User> getListUser() {
//        return User.getListUser();
//    }
//
//    /**
//     * Save an role object.
//     *
//     * @param role Save role in the data base.
//     * @return Return boolean value (True = Success;False = Error).
//     */
//    public boolean saveRole(Role role) {
//        return role.save();
//    }
//
//    /**
//     * Update an role object.
//     *
//     * @param role update role in the data base.
//     * @return Return boolean value (True = Success;False = Error).
//     */
//    public boolean updateRole(Role role) {
//        return role.update();
//    }
//
//    /**
//     * Delete an role object.
//     *
//     * @param role delete role in the data base.
//     * @return Return boolean value (True = Success;False = Error).
//     */
//    public boolean deleteRole(Role role) {
//        return role.delete();
//    }
//
//    /**
//     * Get a Role set object.
//     *
//     * @return Get list Roles.
//     */
//    public List<Role> getListRole() {
//        return Role.getListRole();
//    }
//
//    /**
//     * Save an position object.
//     *
//     * @param position Save position in the data base.
//     * @return Return boolean value (True = Success;False = Error).
//     */
//    public boolean savePosition(Position position) {
//        return position.save();
//    }
//
//    /**
//     * Update an position object.
//     *
//     * @param position update position in the data base.
//     * @return Return boolean value (True = Success;False = Error).
//     */
//    public boolean updatePosition(Position position) {
//        return position.update();
//    }
//
//    /**
//     * Delete an position object.
//     *
//     * @param position delete position in the data base.
//     * @return Return boolean value (True = Success;False = Error).
//     */
//    public boolean deletePosition(Position position) {
//        return position.delete();
//    }
//
//    /**
//     * Get a Position set object.
//     *
//     * @return Get list Positions.
//     */
//    public List<Position> getListPosition() {
//        return Position.getListPosition();
//    }
//}
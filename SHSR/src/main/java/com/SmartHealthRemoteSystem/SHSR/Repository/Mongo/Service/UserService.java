// package com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.Service;

// import com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.DAO.MongoUserDAO;
// import com.SmartHealthRemoteSystem.SHSR.User.User;

// import java.util.List;

// public class UserService {
//     private final MongoUserDAO mongoUserDAO;

//     public UserService(MongoUserDAO mongoUserDAO) {
//         this.mongoUserDAO = mongoUserDAO;
//     }

//     public void addUser(User user) {
//         mongoUserDAO.create(user);
//     }

//     public User getUser(String userId) {
//         return mongoUserDAO.findOne(userId);
//     }

//     public String updateUser(User user) {
//         try {
//             mongoUserDAO.update(user);
    
//             // Return a success message
//             return "User updated successfully.";
//         } catch (Exception e) {
//             // Return an error message
//             return "Error updating user: " + e.getMessage();
//         }
//     }
//     public String deleteUser(String userId) {
//         try {
//             mongoUserDAO.delete(userId);
    
//             // Return a success message
//             return "User deleted successfully.";
//         } catch (Exception e) {
//             // Return an error message
//             return "Error deleting user: " + e.getMessage();
//         }
//     }

//     public List<User> getAllUsers() {
//         return mongoUserDAO.findAll();
//     }

//     public List<User> getAdminList() {
//         return null;
//     }

//     public String createUser(User user) {
//         return null;
//     }
// }

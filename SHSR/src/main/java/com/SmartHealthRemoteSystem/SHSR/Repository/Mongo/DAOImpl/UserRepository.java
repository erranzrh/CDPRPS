// package com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.DAOImpl;

// import com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.DAO.MongoUserDAO;
// import com.SmartHealthRemoteSystem.SHSR.User.User;
// import com.mongodb.client.MongoCollection;
// import com.mongodb.client.MongoDatabase;
// import com.mongodb.client.model.Filters;
// import org.bson.Document;
// import org.springframework.stereotype.Repository;

// import java.util.ArrayList;
// import java.util.List;

// @Repository
// public class UserRepository implements MongoUserDAO {
//     private final MongoCollection<Document> collection;

//     public UserRepository(MongoDatabase db) {
//         this.collection = db.getCollection("User");
//     }

//     @Override
//     public void create(User user) {
//         Document doc = new Document("userId", user.getUserId())
//                 .append("name", user.getName())
//                 .append("password", user.getPassword())
//                 .append("contact", user.getContact())
//                 .append("role", user.getRole());
//         collection.insertOne(doc);
//     }

//     @Override
//     public User findOne(String userId) {
//         Document doc = collection.find(Filters.eq("userId", userId)).first();
//         return doc != null ? documentToUser(doc) : null;
//     }

//     @Override
//     public void update(User user) {
//         Document updateDoc = new Document();
//         if (user.getName() != null) {
//             updateDoc.append("name", user.getName());
//         }
//         if (user.getPassword() != null) {
//             updateDoc.append("password", user.getPassword());
//         }
//         if (user.getPassword() != null) {
//             updateDoc.append("contact", user.getContact());
//         }
//         if (user.getPassword() != null) {
//             updateDoc.append("role", user.getRole());
//         }

//         if (!updateDoc.isEmpty()) {
//             collection.updateOne(Filters.eq("userId", user.getUserId()), new Document("$set", updateDoc));
//         }
//     }


//     @Override
//     public void delete(String userId) {
//         collection.deleteOne(Filters.eq("userId", userId));
//     }

//     @Override
//     public List<User> findAll() {
//         List<User> users = new ArrayList<>();
//         for (Document doc : collection.find()) {
//             users.add(documentToUser(doc));
//         }
//         return users;
//     }

//     private User documentToUser(Document doc) {
//         User user = new User();

//         user.setUserId(doc.getString("userId"));
//         user.setName(doc.getString("name"));
//         user.setPassword(doc.getString("password"));
//         user.setContact(doc.getString("contact"));
//         user.setRole(doc.getString("role"));

//         return user;
//     }
// }

// package com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.DAOImpl;

// import com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.DAO.MongoPharmacistDAO;
// import com.SmartHealthRemoteSystem.SHSR.User.Pharmacist.Pharmacist;
// import com.mongodb.client.MongoCollection;
// import com.mongodb.client.MongoDatabase;
// import com.mongodb.client.model.Filters;
// import org.bson.Document;
// import org.springframework.stereotype.Repository;

// import java.util.ArrayList;
// import java.util.List;

// @Repository
// public class PharmacistRepository implements MongoPharmacistDAO {
//     private final MongoCollection<Document> collection;

//     public PharmacistRepository(MongoDatabase db) {
//         this.collection = db.getCollection("Pharmacist");
//     }

//     @Override
//     public void create(Pharmacist pharmacist) {
//         Document doc = new Document("userId", pharmacist.getUserId())
//                 .append("name", pharmacist.getName())
//                 .append("password", pharmacist.getPassword())
//                 .append("contact", pharmacist.getContact())
//                 .append("role", pharmacist.getRole())
//                 .append("pharmacy", pharmacist.getPharmacy())
//                 .append("position", pharmacist.getPosition())
//                 .append("profilePicture", pharmacist.getProfilePicture());
//         collection.insertOne(doc);
//     }

//     @Override
//     public Pharmacist findOne(String pharmacistId) {
//         Document doc = collection.find(Filters.eq("userId", pharmacistId)).first();
//         return doc != null ? documentToPharmacist(doc) : null;
//     }

//     @Override
//     public void update(Pharmacist pharmacist) {
//         Document updateDoc = new Document();
//         if (pharmacist.getName() != null) {
//             updateDoc.append("name", pharmacist.getName());
//         }
//         if (pharmacist.getPassword() != null) {
//             updateDoc.append("password", pharmacist.getPassword());
//         }
//         if (pharmacist.getContact() != null) {
//             updateDoc.append("contact", pharmacist.getContact());
//         }
//         if (pharmacist.getPharmacy() != null) {
//             updateDoc.append("pharmacy", pharmacist.getPharmacy());
//         }
//         if (pharmacist.getPosition() != null) {
//             updateDoc.append("position", pharmacist.getPosition());
//         }
//         if (pharmacist.getProfilePicture() != null) {
//             updateDoc.append("profilePicture", pharmacist.getProfilePicture());
//         }

//         if (!updateDoc.isEmpty()) {
//             collection.updateOne(Filters.eq("userId", pharmacist.getUserId()), new Document("$set", updateDoc));
//         }
//     }

//     @Override
//     public void delete(String pharmacistId) {
//         collection.deleteOne(Filters.eq("userId", pharmacistId));
//     }

//     @Override
//     public List<Pharmacist> findAll() {
//         List<Pharmacist> pharmacists = new ArrayList<>();
//         for (Document doc : collection.find()) {
//             pharmacists.add(documentToPharmacist(doc));
//         }
//         return pharmacists;
//     }

//     private Pharmacist documentToPharmacist(Document doc) {
//         Pharmacist pharmacist = new Pharmacist();

//         pharmacist.setUserId(doc.getString("userId"));
//         pharmacist.setName(doc.getString("name"));
//         pharmacist.setPassword(doc.getString("password"));
//         pharmacist.setContact(doc.getString("contact"));
//         pharmacist.setRole(doc.getString("role"));
//         pharmacist.setPharmacy(doc.getString("pharmacy"));
//         pharmacist.setPosition(doc.getString("position"));
//         pharmacist.setProfilePicture(doc.getString("profilePicture"));

//         return pharmacist;
//     }
// }

// package com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.DAOImpl;

// import com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.DAO.MongoDoctorDAO;
// import com.SmartHealthRemoteSystem.SHSR.User.Doctor.Doctor;
// import com.mongodb.client.MongoCollection;
// import com.mongodb.client.MongoDatabase;
// import com.mongodb.client.model.Filters;
// import org.bson.Document;
// import org.springframework.stereotype.Repository;

// import java.util.ArrayList;
// import java.util.List;

// @Repository
// public class DoctorRepository implements MongoDoctorDAO {
//     private final MongoCollection<Document> collection;

//     public DoctorRepository(MongoDatabase db) {
//         this.collection = db.getCollection("Doctor");
//     }

//     @Override
//     public void create(Doctor doctor) {
//         Document doc = new Document("userId", doctor.getUserId())
//                 .append("name", doctor.getName())
//                 .append("password", doctor.getPassword())
//                 .append("contact", doctor.getContact())
//                 .append("role", doctor.getRole())
//                 .append("hospital", doctor.getHospital())
//                 .append("position", doctor.getPosition())
//                 .append("profilePicture", doctor.getProfilePicture());
//         collection.insertOne(doc);
//     }

//     @Override
//     public Doctor findOne(String doctorId) {
//         Document doc = collection.find(Filters.eq("userId", doctorId)).first();
//         return doc != null ? documentToDoctor(doc) : null;
//     }

//     @Override
//     public void update(Doctor doctor) {
//         Document updateDoc = new Document();
//         if (doctor.getName() != null) {
//             updateDoc.append("name", doctor.getName());
//         }
//         if (doctor.getPassword() != null) {
//             updateDoc.append("password", doctor.getPassword());
//         }
//         if (doctor.getContact() != null) {
//             updateDoc.append("contact", doctor.getContact());
//         }
//         if (doctor.getHospital() != null) {
//             updateDoc.append("hospital", doctor.getHospital());
//         }
//         if (doctor.getPosition() != null) {
//             updateDoc.append("position", doctor.getPosition());
//         }
//         if (doctor.getProfilePicture() != null) {
//             updateDoc.append("profilePicture", doctor.getProfilePicture());
//         }

//         if (!updateDoc.isEmpty()) {
//             collection.updateOne(Filters.eq("userId", doctor.getUserId()), new Document("$set", updateDoc));
//         }
//     }

//     @Override
//     public void delete(String doctorId) {
//         collection.deleteOne(Filters.eq("userId", doctorId));
//     }

//     @Override
//     public List<Doctor> findAll() {
//         List<Doctor> doctors = new ArrayList<>();
//         for (Document doc : collection.find()) {
//             doctors.add(documentToDoctor(doc));
//         }
//         return doctors;
//     }

//     private Doctor documentToDoctor(Document doc) {
//         Doctor doctor = new Doctor();

//         doctor.setUserId(doc.getString("userId"));
//         doctor.setName(doc.getString("name"));
//         doctor.setPassword(doc.getString("password"));
//         doctor.setContact(doc.getString("contact"));
//         doctor.setRole(doc.getString("role"));
//         doctor.setHospital(doc.getString("hospital"));
//         doctor.setPosition(doc.getString("position"));
//         doctor.setProfilePicture(doc.getString("profilePicture"));

//         return doctor;
//     }

//     @Override
//     public List<Doctor> getAll() {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'getAll'");
//     }
// }
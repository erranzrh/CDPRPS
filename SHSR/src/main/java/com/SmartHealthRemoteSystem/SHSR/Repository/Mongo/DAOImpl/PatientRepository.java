// package com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.DAOImpl;

// import com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.DAO.MongoPatientDAO;
// import com.SmartHealthRemoteSystem.SHSR.User.Patient.Patient;
// import com.mongodb.client.MongoCollection;
// import com.mongodb.client.MongoDatabase;
// import com.mongodb.client.model.Filters;
// import org.bson.Document;
// import org.springframework.stereotype.Repository;

// import java.util.ArrayList;
// import java.util.List;

// @Repository
// public class PatientRepository implements MongoPatientDAO {
//     private final MongoCollection<Document> collection;

//     public PatientRepository(MongoDatabase db) {
//         this.collection = db.getCollection("Patient");
//     }

//     @Override
//     public void create(Patient patient) {
//         Document doc = new Document("userId", patient.getUserId())
//                 .append("name", patient.getName())
//                 .append("password", patient.getPassword())
//                 .append("contact", patient.getContact())
//                 .append("sensorDataId", patient.getSensorDataId())
//                 .append("emergencyContact", patient.getEmergencyContact())
//                 .append("address", patient.getAddress())
//                 .append("assigned_doctor", patient.getAssigned_doctor())
//                 .append("prescriptions", new ArrayList<>());
//         collection.insertOne(doc);
//     }

//     @Override
//     public Patient findOne(String patientId) {
//         Document doc = collection.find(Filters.eq("userId", patientId)).first();
//         return doc != null ? documentToPatient(doc) : null;
//     }

//     @Override
//     public void update(Patient patient) {
//         Document updateDoc = new Document();
//         if (patient.getName() != null) {
//             updateDoc.append("name", patient.getName());
//         }
//         if (patient.getPassword() != null) {
//             updateDoc.append("password", patient.getPassword());
//         }
//         if (patient.getContact() != null) {
//             updateDoc.append("contact", patient.getContact());
//         }
//         if (patient.getEmergencyContact() != null) {
//             updateDoc.append("emergencyContact", patient.getEmergencyContact());
//         }
//         if (patient.getAddress() != null) {
//             updateDoc.append("address", patient.getAddress());
//         }
//         if (patient.getAssigned_doctor() != null) {
//             updateDoc.append("assigned_doctor", patient.getAssigned_doctor());
//         }
//         if (!updateDoc.isEmpty()) {
//             collection.updateOne(Filters.eq("userId", patient.getUserId()), new Document("$set", updateDoc));
//         }
//     }

//     @Override
//     public void delete(String patientId) {
//         collection.deleteOne(Filters.eq("userId", patientId));
//     }

//     @Override
//     public List<Patient> findAll() {
//         List<Patient> patients = new ArrayList<>();
//         for (Document doc : collection.find()) {
//             patients.add(documentToPatient(doc));
//         }
//         return patients;
//     }

//     private Patient documentToPatient(Document doc) {
//         Patient patient = new Patient();

//         patient.setUserId(doc.getString("userId"));
//         patient.setName(doc.getString("name"));
//         patient.setPassword(doc.getString("password"));
//         patient.setContact(doc.getString("contact"));
//         patient.setEmergencyContact(doc.getString("emergencyContact"));
//         patient.setAddress(doc.getString("address"));
//         patient.setAssigned_doctor(doc.getString("assigned_doctor"));
        
//         return patient;
//     }

//     @Override
//     public List<Patient> findAssignedPatientsForDoctor(String doctorId) {
//         List<Patient> assignedPatients = new ArrayList<>();
//         for (Document doc : collection.find(Filters.eq("assigned_doctor", doctorId))) {
//             assignedPatients.add(documentToPatient(doc));
//         }
//         return assignedPatients;
//     }




    

//     public List<Patient> getAll() {
//         return null;
//     }
// }

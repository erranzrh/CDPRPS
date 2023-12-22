// package com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.DAOImpl;

// import com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.DAO.MongoPrescriptionDAO;
// import com.SmartHealthRemoteSystem.SHSR.ViewDoctorPrescription.Prescription;
// import com.mongodb.client.MongoCollection;
// import com.mongodb.client.MongoDatabase;
// import com.mongodb.client.model.Filters;
// import org.bson.Document;
// import org.springframework.stereotype.Repository;

// import java.util.ArrayList;
// import java.util.List;

// @Repository
// public class PrescriptionRepository implements MongoPrescriptionDAO {
//     private final MongoCollection<Document> collection;

//     public PrescriptionRepository(MongoDatabase db) {
//         this.collection = db.getCollection("Patient");
//     }
// // 
//     @Override
//     public void create(String patientId, Prescription prescription) {
//         Document prescriptionDoc = new Document("prescriptionId", prescription.getPrescriptionId())
//                 .append("timestamp", prescription.getTimestamp())
//                 .append("doctorId", prescription.getDoctorId())
//                 .append("medicineList", prescription.getMedicineList())
//                 .append("prescriptionDescription", prescription.getPrescriptionDescription())
//                 .append("diagnosisAilmentDescription", prescription.getDiagnosisAilmentDescription());

//         collection.updateOne(Filters.eq("userId", patientId),
//                 new Document("$push", new Document("prescriptions", prescriptionDoc)));
//     }

//     @Override
//     public Prescription findOne(String patientId, String prescriptionId) {
//         Document patientDoc = collection.find(Filters.eq("userId", patientId)).first();

//         if (patientDoc != null) {
//             List<Document> prescriptions = patientDoc.getList("prescriptions", Document.class);

//             if (prescriptions != null) {
//                 for (Document prescriptionDoc : prescriptions) {
//                     if (prescriptionDoc.getString("prescriptionId").equals(prescriptionId)) {
//                         return documentToPrescription(prescriptionDoc);
//                     }
//                 }
//             }
//         }

//         return null;
//     }

//     @Override
//     public void update(String patientId, Prescription prescription) {
//         Document updatedPrescriptionDoc = new Document("prescriptions.$.prescriptionId", prescription.getPrescriptionId())
//                 .append("prescriptions.$.timestamp", prescription.getTimestamp())
//                 .append("prescriptions.$.doctorId", prescription.getDoctorId())
//                 .append("prescriptions.$.medicineList", prescription.getMedicineList())
//                 .append("prescriptions.$.prescriptionDescription", prescription.getPrescriptionDescription())
//                 .append("prescriptions.$.diagnosisAilmentDescription", prescription.getDiagnosisAilmentDescription());

//         collection.updateOne(Filters.and(
//                 Filters.eq("userId", patientId),
//                 Filters.elemMatch("prescriptions", Filters.eq("prescriptionId", prescription.getPrescriptionId()))
//         ), new Document("$set", updatedPrescriptionDoc));
//     }

//     @Override
//     public void delete(String patientId, String prescriptionId) {
//         collection.updateOne(Filters.eq("userId", patientId),
//                 new Document("$pull", new Document("prescriptions", new Document("prescriptionId", prescriptionId))));
//     }

//     @Override
//     public List<Prescription> findAll(String patientId) {
//         Document patientDoc = collection.find(Filters.eq("userId", patientId)).first();

//         List<Prescription> prescriptionList = new ArrayList<>();

//         if (patientDoc != null) {
//             List<Document> prescriptions = patientDoc.getList("prescriptions", Document.class);

//             if (prescriptions != null) {
//                 for (Document prescriptionDoc : prescriptions) {
//                     prescriptionList.add(documentToPrescription(prescriptionDoc));
//                 }
//             }
//         }

//         return prescriptionList;
//     }

//     private Prescription documentToPrescription(Document doc) {
//         Prescription prescription = new Prescription();

//         prescription.setPrescriptionId(doc.getString("prescriptionId"));
//         prescription.setTimestamp(doc.getString("timestamp"));
//         prescription.setDoctorId(doc.getString("doctorId"));
//         prescription.setMedicineList(doc.getList("medicineList", String.class));
//         prescription.setPrescriptionDescription(doc.getString("prescriptionDescription"));
//         prescription.setDiagnosisAilmentDescription(doc.getString("diagnosisAilmentDescription"));

//         return prescription;
//     }
// }

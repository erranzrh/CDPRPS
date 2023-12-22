// package com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.Service;

// import com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.DAO.MongoPrescriptionDAO;
// import com.SmartHealthRemoteSystem.SHSR.ViewDoctorPrescription.Prescription;

// import java.util.List;
// import java.util.Objects;

// public class PrescriptionService {
//     private final MongoPrescriptionDAO mongoPrescriptionDAO;

//     public PrescriptionService(MongoPrescriptionDAO mongoPrescriptionDAO) {
//         this.mongoPrescriptionDAO = mongoPrescriptionDAO;
//     }
    

//     public void addPrescription(String patientId, Prescription prescription) {
//         mongoPrescriptionDAO.create(patientId, prescription);
//     }

//     public Prescription getPrescription(String patientId, String prescriptionId) {
//         return mongoPrescriptionDAO.findOne(patientId, prescriptionId);
//     }

//     public void updatePrescription(String patientId, Prescription prescription) {
//         mongoPrescriptionDAO.update(patientId, prescription);
//     }

//     public void deletePrescription(String patientId, String prescriptionId) {
//         mongoPrescriptionDAO.delete(patientId, prescriptionId);
//     }

//     public List<Prescription> getAllPrescriptions(String patientId) {
//         return mongoPrescriptionDAO.findAll(patientId);
//     }


//     public String createPrescription(Prescription prescription1, String patientId) {
//         return null;
//     }
// }

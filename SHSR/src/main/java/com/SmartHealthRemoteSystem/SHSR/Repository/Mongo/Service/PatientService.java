// package com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.Service;

// import com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.DAO.MongoUserDAO;
// import com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.DAO.MongoPatientDAO;
// import com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.Service.PatientService;

// import com.SmartHealthRemoteSystem.SHSR.User.Patient.Patient;
// import com.SmartHealthRemoteSystem.SHSR.ViewDoctorPrescription.Prescription;
// import com.SmartHealthRemoteSystem.SHSR.User.User;
// import com.SmartHealthRemoteSystem.SHSR.User.Doctor.Doctor;


// import java.util.ArrayList;
// import java.util.List;
// import java.util.Objects;
// import java.util.Optional;


// public class PatientService {
//     private final MongoPatientDAO mongoPatientDAO;
//     private final UserService userService;

//     public PatientService(MongoPatientDAO mongoPatientDAO, UserService userService) {
//         this.mongoPatientDAO = mongoPatientDAO;
//         this.userService = userService;
//     }

//     public void addPatient(Patient patient) {
//         mongoPatientDAO.create(patient);

//         if (Objects.nonNull(patient)) {
//             User tempUser = new User();
//             tempUser.setUserId(patient.getUserId());
//             tempUser.setName(patient.getName());
//             tempUser.setPassword(patient.getPassword());
//             tempUser.setContact(patient.getContact());
//             tempUser.setRole(patient.getRole());

//             userService.addUser(tempUser); // Add user to the User collection
//         }
//     }

//     public Patient getPatient(String patientId) {
//         return mongoPatientDAO.findOne(patientId);
//     }
    
//     public String updatePatient(Patient patient) {
//         try {
//             mongoPatientDAO.update(patient);
    
//             if (Objects.nonNull(patient)) {
//                 User tempUser = new User();
//                 tempUser.setUserId(patient.getUserId());
//                 tempUser.setName(patient.getName());
//                 tempUser.setPassword(patient.getPassword());
//                 tempUser.setContact(patient.getContact());
//                 tempUser.setRole(patient.getRole());
    
//                 userService.updateUser(tempUser);
//             }
//             return "Update successful"; // Or any appropriate success message
//         } catch (Exception e) {
//             e.printStackTrace(); // Handle the exception or log an error
//             return "Update failed"; // Or any appropriate error message
//         }
//     }

//     public String deletePatient(String patientId) {
//         try {
//             mongoPatientDAO.delete(patientId);
    
//             if (Objects.nonNull(patientId)) {
//                 userService.deleteUser(patientId);
//             }
    
//             // Return a success message
//             return "Patient deleted successfully.";
//         } catch (Exception e) {
//             // Return an error message
//             return "Error deleting patient: " + e.getMessage();
//         }
//     }

//     public List<Patient> getAllDoctors() {
//         return mongoPatientDAO.findAll();
//     }

//     public Iterable<Doctor> getAllPatients() {
//         return null;
//     }

//     public List<Patient> getPatientList() {
//         return mongoPatientDAO.findAll();
//     }
    
//     public List<Patient> getAssignedPatientsForDoctor(String userId) {
//         // Assuming you have a method in MongoPatientDAO to get assigned patients for a doctor
//         return mongoPatientDAO.findAssignedPatientsForDoctor(userId);
//     }

//     public ArrayList<Prescription> getAllPrescription(String userId) {
//         return null;
//     }

//     public String createPatient(Patient patient) {
//         return null;
//     }

//     public List<Patient> getListPatient() {
//         return null;
//     }
// }


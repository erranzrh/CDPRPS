// package com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.Service;

// import com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.DAO.MongoDoctorDAO;
// import com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.DAO.MongoPatientDAO;
// import com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.DAO.MongoUserDAO;
// import com.SmartHealthRemoteSystem.SHSR.User.Doctor.Doctor;
// import com.SmartHealthRemoteSystem.SHSR.User.Patient.Patient;
// import com.SmartHealthRemoteSystem.SHSR.User.User;

// import java.util.List;
// import java.util.Objects;
// import java.util.Optional;

// public class DoctorService {
//     private final MongoDoctorDAO mongoDoctorDAO;
//     private final MongoPatientDAO mongoPatientDAO;
//     private final UserService userService;

//     public DoctorService(MongoDoctorDAO mongoDoctorDAO, UserService userService, MongoPatientDAO mongoPatientDAO) {
//         this.mongoDoctorDAO = mongoDoctorDAO;
//         this.mongoPatientDAO = mongoPatientDAO;
//         this.userService = userService;
//     }

//     public void addDoctor(Doctor doctor) {
//         mongoDoctorDAO.create(doctor);

//         if (Objects.nonNull(doctor)) {
//             User tempUser = new User();
//             tempUser.setUserId(doctor.getUserId());
//             tempUser.setName(doctor.getName());
//             tempUser.setPassword(doctor.getPassword());
//             tempUser.setContact(doctor.getContact());
//             tempUser.setRole(doctor.getRole());

//             userService.addUser(tempUser);
//         }
//     }

//     public Doctor getDoctor(String doctorId) {
//         return mongoDoctorDAO.findOne(doctorId);
//     }

//     public String updateDoctor(Doctor doctor) {
//         try {
//             mongoDoctorDAO.update(doctor);
    
//             // Return a success message
//             return "Doctor updated successfully.";
//         } catch (Exception e) {
//             // Return an error message
//             return "Error updating doctor: " + e.getMessage();
//         }
//     }

//     public String deleteDoctor(String doctorId) {
//         try {
//             mongoDoctorDAO.delete(doctorId);
    
//             if (Objects.nonNull(doctorId)) {
//                 userService.deleteUser(doctorId);
//             }
    
//             // Return a success message
//             return "Doctor deleted successfully.";
//         } catch (Exception e) {
//             // Return an error message
//             return "Error deleting doctor: " + e.getMessage();
//         }
//     }

//     public List<Doctor> getAllDoctors() {
//         return mongoDoctorDAO.findAll();
//     }

//     public List<Patient> getListPatient() {
//         return null;
//     }

//     public List<Patient> findAllPatientAssignToDoctor(String userId) {
//         return mongoPatientDAO.findAssignedPatientsForDoctor(userId);
//     }

//     public List<Doctor> getListDoctor() {
//         return null;
//     }

//     public String createDoctor(Doctor doctor) {
//         return null;
//     }
// }

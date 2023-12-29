// package com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.Service;

// import com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.DAO.MongoPharmacistDAO;
// // import com.SmartHealthRemoteSystem.SHSR.User.Pharmacist.Medicine;
// import com.SmartHealthRemoteSystem.SHSR.User.Pharmacist.Pharmacist;
// import com.SmartHealthRemoteSystem.SHSR.User.User;

// import java.util.List;
// import java.util.Objects;

// public class PharmacistService {
//     private final MongoPharmacistDAO mongoPharmacistDAO;
//     private final UserService userService;

//     public PharmacistService(MongoPharmacistDAO mongoPharmacistDAO, UserService userService) {
//         this.mongoPharmacistDAO = mongoPharmacistDAO;
//         this.userService = userService;
//     }

//     public void addPharmacist(Pharmacist pharmacist) {
//         mongoPharmacistDAO.create(pharmacist);

//         if (Objects.nonNull(pharmacist)) {
//             User tempUser = new User();
//             tempUser.setUserId(pharmacist.getUserId());
//             tempUser.setName(pharmacist.getName());
//             tempUser.setPassword(pharmacist.getPassword());
//             tempUser.setContact(pharmacist.getContact());
//             tempUser.setRole(pharmacist.getRole());

//             userService.addUser(tempUser);
//         }
//     }

//     public Pharmacist getPharmacist(String pharmacistId) {
//         return null;
//     }

//     public String updatePharmacist(Pharmacist pharmacist) {
//         return null;
//     }

//     public String deletePharmacist(String pharmacistId) {
//         return null;
//     }

//     public Pharmacist getPharmacist() {
//         return null;
//     }

//     public void deleteMedicine(String medId) {
//     }

//     // public Medicine getMedicine(String medId) {
//     //     return null;
//     // }

//     // public List<Medicine> getListMedicine() {
//     //     return null;
//     // }

//     // Implement other methods (getPharmacist, updatePharmacist, deletePharmacist, getAllPharmacists) similar to DoctorService
//     // ...
// }

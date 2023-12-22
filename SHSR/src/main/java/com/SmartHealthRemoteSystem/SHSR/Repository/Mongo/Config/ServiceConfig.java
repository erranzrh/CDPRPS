// package com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.Config;

// import com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.DAO.MongoDoctorDAO;
// import com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.DAO.MongoPatientDAO;
// import com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.DAO.MongoUserDAO;
// import com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.DAO.MongoPrescriptionDAO;
// // import com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.DAO.MongoSensorDataDAO;
// import com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.DAO.MongoPharmacistDAO;
// // import com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.DAO.MongoMedicineDAO;

// import com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.Service.DoctorService;
// import com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.Service.UserService;
// import com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.Service.PatientService;
// import com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.Service.PrescriptionService;
// import com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.Service.PharmacistService;
// // import com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.Service.SensorDataService;


// // import com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.Service.MedicineService;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// @Configuration
// public class ServiceConfig {

//     @Bean
//     public UserService userService(MongoUserDAO mongoUserDAO) {
//         return new UserService(mongoUserDAO);
//     }

//     @Bean
//     public DoctorService doctorService(MongoDoctorDAO mongoDoctorDAO, UserService userService, MongoPatientDAO mongoPatientDAO) {
//         return new DoctorService(mongoDoctorDAO, userService, mongoPatientDAO);
//     }
//     @Bean
//     public PatientService patientService(MongoPatientDAO mongoPatientDAO, UserService userService) {
//         return new PatientService(mongoPatientDAO, userService);
//     }

//     @Bean
//     public PrescriptionService prescriptionService(MongoPrescriptionDAO mongoPrescriptionDAO) {
//         return new PrescriptionService(mongoPrescriptionDAO);
//     }

//     @Bean
//     public PharmacistService pharmacistService(MongoPharmacistDAO mongoPharmacistDAO, UserService userService) {
//         return new PharmacistService(mongoPharmacistDAO,  userService);
//     }


//     // @Bean
//     // public SensorDataService sensorDataService(MongoSensorDataDAO mongoSensorDataDAO) {
//     //     return new SensorDataService(mongoSensorDataDAO);
//     // }




//     // @Bean
//     // public MedicineService medicineService(MongoMedicineDAO mongoMedicineDAO) {
//     //     return new MedicineService(mongoMedicineDAO);
//     // }

// }

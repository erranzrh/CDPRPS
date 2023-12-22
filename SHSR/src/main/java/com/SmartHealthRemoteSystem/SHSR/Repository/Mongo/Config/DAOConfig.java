package com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.Config;

import com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.DAO.MongoDoctorDAO;
import com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.DAO.MongoPatientDAO;
import com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.DAO.MongoPrescriptionDAO;
// import com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.DAOImpl.DoctorRepository;
// import com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.DAOImpl.PatientRepository;
// import com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.DAOImpl.PrescriptionRepository;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DAOConfig {

    @Autowired
    private MongoDatabase mongoDatabase;

    // @Bean
    // public MongoDoctorDAO mongoDoctorDAO() {
    //     return new DoctorRepository(mongoDatabase);
    // }

    // @Bean
    // public MongoPatientDAO mongoPatientDAO() {
    //     return new PatientRepository(mongoDatabase);
    // }
    
    // @Bean
    // public MongoPrescriptionDAO mongoPrescriptionDAO() {
    //     return new MongoPrescriptionDAOImpl(mongoDatabase);
    // }
}

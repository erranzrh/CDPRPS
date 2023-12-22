package com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.DAO;
import com.SmartHealthRemoteSystem.SHSR.User.Patient.Patient;

import java.util.List;

public interface MongoPatientDAO {

    void create(Patient patient);
    Patient findOne(String patientId);
    void update(Patient patient);
    void delete(String patientId);
    List<Patient> findAll();
    List<Patient> findAssignedPatientsForDoctor(String doctorId);
    
    
}



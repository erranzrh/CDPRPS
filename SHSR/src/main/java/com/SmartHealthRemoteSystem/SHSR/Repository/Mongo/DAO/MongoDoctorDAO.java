package com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.DAO;

import com.SmartHealthRemoteSystem.SHSR.User.Doctor.Doctor;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface MongoDoctorDAO {

    void create(Doctor doctor);
    Doctor findOne(String doctorId);
    void update(Doctor doctor);
    void delete(String doctorId);
    List<Doctor> findAll();
    List<Doctor> getAll();
    // Doctor get(doctorId);


    
}
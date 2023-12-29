package com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.DAO;
import com.SmartHealthRemoteSystem.SHSR.ViewDoctorPrescription.Prescription;
import java.util.List;


public interface MongoPrescriptionDAO {
   
    void create(String patientId, Prescription prescription);
    Prescription findOne(String patientId, String prescriptionId);
    void update(String patientId, Prescription prescription);
    void delete(String patientId, String prescriptionId);
    List<Prescription> findAll(String patientId);

}

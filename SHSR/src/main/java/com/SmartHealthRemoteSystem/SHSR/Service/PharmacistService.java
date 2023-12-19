package com.SmartHealthRemoteSystem.SHSR.Service;

import com.SmartHealthRemoteSystem.SHSR.Medicine.Medicine;
import com.SmartHealthRemoteSystem.SHSR.Medicine.MedicineRepository;
import com.SmartHealthRemoteSystem.SHSR.Repository.SHSRDAO;
import com.SmartHealthRemoteSystem.SHSR.User.User;
import com.SmartHealthRemoteSystem.SHSR.User.UserRepository;
import com.SmartHealthRemoteSystem.SHSR.User.Doctor.Doctor;
import com.SmartHealthRemoteSystem.SHSR.User.Patient.Patient;
import com.SmartHealthRemoteSystem.SHSR.User.Pharmacist.Pharmacist;
import com.SmartHealthRemoteSystem.SHSR.User.Pharmacist.PharmacistRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class PharmacistService {

    private final SHSRDAO<Pharmacist> pharmacistRepository;
    private final SHSRDAO<Medicine> medicineRepository;
    private final SHSRDAO<User> userRepository;

    @Autowired
    public PharmacistService(SHSRDAO<Pharmacist> pharmacistRepository, SHSRDAO<Medicine> medicineRepository, SHSRDAO<User> userRepository) {
        this.pharmacistRepository = pharmacistRepository;
        this.medicineRepository = medicineRepository;
        this.userRepository = userRepository;
    }

    public String createPharmacist(Pharmacist pharmacist) throws ExecutionException, InterruptedException {
         boolean checkUserExist = false;
        //create a temporary user
        User user = new User(pharmacist.getUserId(), pharmacist.getName(), pharmacist.getPassword(), pharmacist.getContact(), pharmacist.getRole(), pharmacist.getRole());

        //get list of all user
        List<User> userList = userRepository.getAll();
        for (User u : userList) {
            //if the Id already exist
            if (u.getUserId().equals(pharmacist.getUserId())) {
                checkUserExist = true;
                break;
            }
        }
        //return error message
        if (checkUserExist) {
            return "Error create pharmacist with id " + pharmacist.getUserId() + ". Please use another Id.";
        }

        userRepository.save(user);
        return pharmacistRepository.save(pharmacist);
    }

     public String updatePharmacist(Pharmacist pharmacist) throws ExecutionException, InterruptedException {
        return pharmacistRepository.update(pharmacist);
    }

    public Pharmacist getPharmacist(String pharmacistId) throws ExecutionException, InterruptedException {

        if(pharmacistId.isEmpty()){
            return new Pharmacist();
        }
        Pharmacist pharmacist = pharmacistRepository.get(pharmacistId);
        if (pharmacist == null) {
            return null;
        } else {
            User user = userRepository.get(pharmacistId);
            pharmacist.setName(user.getName());
            pharmacist.setPassword(user.getPassword());
            pharmacist.setContact(user.getContact());
            pharmacist.setRole(user.getRole());
            pharmacist.setUserId(user.getUserId());
            pharmacist.setEmail(user.getEmail());
            return pharmacist;
        }
    }

    public List<Pharmacist> getListPharmacist() throws ExecutionException, InterruptedException {
        return pharmacistRepository.getAll();
    }

    public String deletePharmacist(String pharmacistId) throws ExecutionException, InterruptedException {
        return pharmacistRepository.delete(pharmacistId);
    }

    public List<Medicine> getListMedicine() throws ExecutionException, InterruptedException {
        return medicineRepository.getAll();
    }

    public Medicine getMedicine(String medicineId) throws ExecutionException, InterruptedException {
        return medicineRepository.get(medicineId);
    }

    public void updateMedicine(Medicine medicine) throws ExecutionException, InterruptedException {
        if (medicineRepository.get(medicine.getMedId()) != null) {
            medicineRepository.update(medicine);
        } else {
            throw new RuntimeException("Medicine not found for update.");
        }
    }
    
    public void deleteMedicine(String medicineId) throws ExecutionException, InterruptedException {
        if (medicineRepository.get(medicineId) != null) {
            medicineRepository.delete(medicineId);
        } else {
            throw new RuntimeException("Medicine not found for delete.");
        }
    }

}

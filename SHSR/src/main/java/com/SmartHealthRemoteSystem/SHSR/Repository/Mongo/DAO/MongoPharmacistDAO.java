package com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.DAO;

import com.SmartHealthRemoteSystem.SHSR.User.Pharmacist.Pharmacist;

import java.util.List;

public interface MongoPharmacistDAO {

    void create(Pharmacist pharmacist);
    Pharmacist findOne(String pharmacistId);
    void update(Pharmacist pharmacist);
    void delete(String pharmacistId);
    List<Pharmacist> findAll();
}

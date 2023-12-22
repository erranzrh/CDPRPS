package com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.DAO;
import com.SmartHealthRemoteSystem.SHSR.User.User;

import java.util.List;

public interface MongoUserDAO {
    
    void create(User user);
    User findOne(String userId);
    void update(User user);
    void delete(String userId);
    List<User> findAll();

}
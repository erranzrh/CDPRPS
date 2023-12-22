// package com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.Service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.SmartHealthRemoteSystem.SHSR.ReadSensorData.SensorData;
// import com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.DAO.MongoSensorDataDAO;
// import com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.DAOImpl.SensorDataRepository;

// import java.util.concurrent.ExecutionException;

// @Service
// public class SensorDataService {

//     private final MongoSensorDataDAO sensorDataRepository;

//     @Autowired
//     public SensorDataService(MongoSensorDataDAO mongoSensorDataDAO) {
//         this.sensorDataRepository = mongoSensorDataDAO;
//     }

//     public void createSensorData(String patientId, SensorData sensorData) throws ExecutionException, InterruptedException {
//         sensorDataRepository.create(patientId, sensorData);
//     }

//     public void deleteSensorData(String sensorId) throws ExecutionException, InterruptedException {
//         sensorDataRepository.delete(sensorId);
//     }

//     public SensorData getSensorData(String sensorId) throws ExecutionException, InterruptedException {
//         return sensorDataRepository.findOne(sensorId);
//     }

//     public String updateSensorData(SensorData sensorData) throws ExecutionException, InterruptedException {
//         sensorDataRepository.update(sensorData.getSensorDataId(), sensorData);
//     }

//     public String stringSensorData(String sensorId) throws ExecutionException, InterruptedException {
//         SensorData sensorData = sensorDataRepository.findOne(sensorId);
//         return sensorData != null ? sensorData.toString() : "Sensor data not found.";
//     }
// }

// // SensorDataRepository.java
// package com.SmartHealthRemoteSystem.SHSR.Repository.Mongo.DAOImpl;

// import com.SmartHealthRemoteSystem.SHSR.ReadSensorData.SensorData;
// import com.mongodb.client.MongoCollection;
// import com.mongodb.client.MongoDatabase;
// import com.mongodb.client.model.Filters;
// import org.bson.Document;
// import org.springframework.stereotype.Repository; 

// @Repository
// public class SensorDataRepository {

//     private final MongoCollection<Document> collection;

//     public SensorDataRepository(MongoDatabase db) {
//         this.collection = db.getCollection("SensorData");
//     }

//     public void saveSensorData(String patientId, SensorData sensorData) {
//         Document doc = new Document("patientId", patientId)
//                 .append("ecgReading", sensorData.getEcgReading())
//                 .append("bodyTemperature", sensorData.getBodyTemperature())
//                 .append("oxygenReading", sensorData.getOxygenReading())
//                 .append("Heart_Rate", sensorData.getHeart_Rate());

//         collection.insertOne(doc);
//     }

//     public SensorData getSensorData(String patientId) {
//         Document doc = collection.find(Filters.eq("patientId", patientId)).first();
//         return doc != null ? documentToSensorData(doc) : null;
//     }

//     private SensorData documentToSensorData(Document doc) {
//         SensorData sensorData = new SensorData();
//         sensorData.setEcgReading(doc.getDouble("ecgReading"));
//         sensorData.setBodyTemperature(doc.getDouble("bodyTemperature"));
//         sensorData.setOxygenReading(doc.getDouble("oxygenReading"));
//         sensorData.setHeart_Rate(doc.getInteger("Heart_Rate"));
//         return sensorData;
//     }

//     public void create(String patientId, SensorData sensorData) {
//     }

//     public void delete(String sensorId) {
//     }

//     public SensorData findOne(String sensorId) {
//         return null;
//     }

//     public void update(String sensorDataId, SensorData sensorData) {
//     }
// }

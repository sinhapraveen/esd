package com.rdc.utilities.esd.service;

import com.rdc.utilities.esd.model.RDCCarriers;
import com.rdc.utilities.esd.model.RDCOperations;
import com.rdc.utilities.esd.model.RDCUsers;
import io.jsondb.JsonDBOperations;
import io.jsondb.JsonDBTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RDCService {
    String dbFilesLocation = "C:\\MyProjects\\ESDProject\\JsonDB";
    String baseScanPackage = "com.rdc.utilities.esd.model";
    //	ICipher cipher = new Default1Cipher("1r8+24pibarAWgS85/Heeg==");

    public final JsonDBTemplate jsonDBTemplate = new JsonDBTemplate(dbFilesLocation, baseScanPackage);

    public RDCService() {
        //Instantiate User collection
        if (!jsonDBTemplate.collectionExists("RDCUsers")) {
                jsonDBTemplate.createCollection(RDCUsers.class);
        }else{
            System.out.println("RDCUser collection exists");
        }
        //Instantiate Carrier collection
        if (!jsonDBTemplate.collectionExists("RDCCarriers")) {
            System.out.println("Carriers collection  does not exists");
            jsonDBTemplate.createCollection(RDCCarriers.class);
        }else{
            System.out.println("Carriers collection exists");
        }
        //Instantiate Operation collection
        if (!jsonDBTemplate.collectionExists("RDCOperations")) {
            System.out.println("RDCOperations collection  does not exists");
            jsonDBTemplate.createCollection(RDCOperations.class);
        }else{
            System.out.println("RDCOperations collection exists");
        }

    }


    public void addCollection(String collectionName){
        if (!jsonDBTemplate.collectionExists(collectionName))
            jsonDBTemplate.createCollection(collectionName);
    }
    public ArrayList getUserCollections(){
        return (ArrayList)jsonDBTemplate.getCollection(RDCUsers.class);
    }
    public RDCUsers getUserById(String userId){
           return  jsonDBTemplate.findById(userId, "RDCUsers");
    }
    public ArrayList getAllUsers(){
        return  (ArrayList)jsonDBTemplate.findAll("RDCUsers");
    }
    public void deleteUserById(String userId){
         jsonDBTemplate.remove(getUserById(userId), "RDCUsers");
    }
    public void addNewUser(RDCUsers user){
        jsonDBTemplate.insert(user, "RDCUsers");
    }
    public void updateUser(RDCUsers user){
        jsonDBTemplate.upsert(user, "RDCUsers");
    }

    //RDC Carriers
    public void addCarrierCollection() {
        if (!jsonDBTemplate.collectionExists("RDCCarriers")) {
            System.out.println("Carriers collection  does not exists");
            jsonDBTemplate.createCollection(RDCCarriers.class);
        } else {
            System.out.println("Carriers collection exists");
        }
    }

    public RDCCarriers getCarrierById(String carrierId){
        return  jsonDBTemplate.findById(carrierId, "RDCCarriers");
    }
    public void addNewCarrier(RDCCarriers carrier){
        jsonDBTemplate.insert(carrier, "RDCCarriers");
    }
    public void updateCarrier(RDCCarriers carrier){
        jsonDBTemplate.upsert(carrier, "RDCCarriers");
    }
    public ArrayList getAllCarriers(){
        return  (ArrayList)jsonDBTemplate.findAll("RDCCarriers");
    }
    public void deleteCarrierById(String carrierId){
        jsonDBTemplate.remove(getCarrierById(carrierId), "RDCCarriers");
    }
    public void deleteAllCarriers(){
        jsonDBTemplate.dropCollection("RDCCarriers");
    }

    //RDC Operations
    public void addOperationCollection() {
        if (!jsonDBTemplate.collectionExists("RDCOperations")) {
            System.out.println("RDCOperations collection  does not exists");
            jsonDBTemplate.createCollection(RDCOperations.class);
        } else {
            System.out.println("RDCOperations collection exists");
        }
    }

    public RDCOperations getOperationByName(String operationName){
        return  jsonDBTemplate.findById(operationName, "RDCOperations");
    }
    public void addNewOperation(RDCOperations operation){
        jsonDBTemplate.insert(operation, "RDCOperations");
    }
    public void updateOperation(RDCOperations operation){
        jsonDBTemplate.upsert(operation, "RDCOperations");
    }
    public ArrayList getAllOperations(){
        return  (ArrayList)jsonDBTemplate.findAll("RDCOperations");
    }
    public void deleteOperationById(String operation){
        jsonDBTemplate.remove(getOperationByName(operation), "RDCOperations");
    }
}

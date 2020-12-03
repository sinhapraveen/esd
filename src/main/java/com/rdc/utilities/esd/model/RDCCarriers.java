package com.rdc.utilities.esd.model;

import io.jsondb.annotation.Document;
import io.jsondb.annotation.Id;


@Document(collection = "RDCCarriers", schemaVersion= "1.0")
public class RDCCarriers {
    @Id
    private String carrierID;
    private String carrierName;
    private String rdcLevel;

    public RDCCarriers() {
    }

    public RDCCarriers(String carrierID, String carrierName, String rdcLevel) {
        this.carrierID = carrierID;
        this.carrierName = carrierName;
        this.rdcLevel = rdcLevel;
    }


    public String getCarrierID() {
        return carrierID;
    }

    public void setCarrierID(String carrierID) {
        this.carrierID = carrierID;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public String getRdcLevel() {
        return rdcLevel;
    }

    public void setRdcLevel(String rdcLevel) {
        this.rdcLevel = rdcLevel;
    }
}

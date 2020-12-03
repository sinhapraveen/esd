package com.rdc.utilities.esd.model;

import io.jsondb.annotation.Document;
import io.jsondb.annotation.Id;


@Document(collection = "RDCOperations", schemaVersion= "1.0")
public class RDCOperations {
    @Id
    private String operationName;
    private String requestXPath;
    private String responseXPath;

    public RDCOperations() {
    }

    public RDCOperations(String operationName, String requestXPath, String responseXPath) {
        this.operationName = operationName;
        this.requestXPath = requestXPath;
        this.responseXPath = responseXPath;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public String getRequestXPath() {
        return requestXPath;
    }

    public void setRequestXPath(String requestXPath) {
        this.requestXPath = requestXPath;
    }

    public String getResponseXPath() {
        return responseXPath;
    }

    public void setResponseXPath(String responseXPath) {
        this.responseXPath = responseXPath;
    }
}

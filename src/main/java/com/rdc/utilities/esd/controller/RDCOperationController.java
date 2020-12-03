package com.rdc.utilities.esd.controller;


import com.rdc.utilities.esd.model.RDCCarriers;
import com.rdc.utilities.esd.model.RDCOperations;
import com.rdc.utilities.esd.service.RDCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = {"/operation"})
public class RDCOperationController {
    @Autowired
    RDCService rdcService;

    @GetMapping("/find")
    public ResponseEntity<Object> findoperation(@RequestParam(value="name") String name) {
        RDCOperations operation= null;
        try{
            operation = rdcService.getOperationByName(name);
            if(operation != null)
                return new ResponseEntity<>(operation, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch(Exception ex) {
            System.out.println("findoperation error issue"+ ex);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/add")
    public boolean addOperation(@RequestParam(value="name") String name,
                              @RequestParam(value="reqxpath") String reqxpath,
                              @RequestParam(value="resxpath") String resxpath) {
        RDCOperations operation = new RDCOperations(name, reqxpath, resxpath);
        try {
            rdcService.addNewOperation(operation);
            return true;
        }catch (Exception ex){
            System.out.println("Add Operation error issue"+ ex);
            return false;
        }
    }

    @PostMapping("/update")
    public boolean updateoperation(@RequestParam(value="name") String name,
                                   @RequestParam(value="reqxpath") String reqxpath,
                                   @RequestParam(value="resxpath") String resxpath) {
        RDCOperations operation = new RDCOperations(name, reqxpath, resxpath);
        try {
            rdcService.updateOperation(operation);
            return true;
        }catch (Exception ex){
            System.out.println("Update Operation error issue"+ ex);
            return false;
        }
    }

    @GetMapping("/findall")
    public ArrayList findalloperations() {

        try{
            return (ArrayList)rdcService.getAllOperations();
        }
        catch(Exception ex) {
            System.out.println("All Operations error issue"+ ex);
            return null;
        }
    }

    @PostMapping("/delete")
    public boolean deleteoperation(@RequestParam(value="name") String name) {
        try {
            rdcService.deleteOperationById(name);
            return true;
        }catch (Exception ex){
            System.out.println("Delete Operation error issue"+ ex);
            return false;
        }
    }
}

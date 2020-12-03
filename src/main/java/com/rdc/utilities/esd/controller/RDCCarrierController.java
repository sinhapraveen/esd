package com.rdc.utilities.esd.controller;

import com.rdc.utilities.esd.model.RDCCarriers;
import com.rdc.utilities.esd.util.LoadRDCCarrier;
import com.rdc.utilities.esd.service.RDCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = {"/carrier"})
public class RDCCarrierController {
    @Autowired
    RDCService rdcService;

    @GetMapping("/load")
    public ResponseEntity<Object> loadcarrier(@RequestParam(value="filepath") String ath) {
        RDCCarriers carriers= null;
        String filepath = "C:\\MyProjects\\ESDProject\\data\\book1.xlsx";
        try{
             LoadRDCCarrier loadcarrier =  new LoadRDCCarrier();
             String jsonstring = loadcarrier.loadcarriers(filepath);
             System.out.println("file JSON String"+ jsonstring);
             ArrayList carrierList = (ArrayList) loadcarrier.readExcelFile(filepath);
             System.out.println("Carrier count"+ carrierList.size());
            if(carrierList != null && carrierList.size() >0){
                rdcService.deleteAllCarriers();
                rdcService.addCarrierCollection();
                for(int i=0; i<carrierList.size(); i++){
                    RDCCarriers carr = (RDCCarriers)carrierList.get(i);
                    System.out.println("Carrier"+ carr);
                    if(carr.getCarrierID() != null && carr.getCarrierID().trim().length()>0){
                        rdcService.addNewCarrier(carr);
                    }
                }
            }

        }
        catch(Exception ex) {
            System.out.println("loadcarrier error issue"+ ex);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<Object> findcarrier(@RequestParam(value="carrierid") String carrierid) {
        RDCCarriers carriers= null;
        try{
            carriers = rdcService.getCarrierById(carrierid);
            if(carriers != null)
                return new ResponseEntity<>(carriers, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch(Exception ex) {
            System.out.println("findcarrier error issue"+ ex);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/add")
    public boolean addcarrier(@RequestParam(value="carrierid") String carrierid,
                           @RequestParam(value="carriername") String carriername,
                           @RequestParam(value="level") String level) {
        RDCCarriers carrier = new RDCCarriers(carrierid, carriername, level);
        try {
            rdcService.addNewCarrier(carrier);
            return true;
        }catch (Exception ex){
            System.out.println("Add error issue"+ ex);
            return false;
        }
    }

    @PostMapping("/update")
    public boolean updatecarrier(@RequestParam(value="carrierid") String carrierid,
                           @RequestParam(value="carriername") String carriername,
                           @RequestParam(value="level") String level) {
        RDCCarriers carrier = new RDCCarriers(carrierid, carriername, level);
        try {
            rdcService.updateCarrier(carrier);
            return true;
        }catch (Exception ex){
            System.out.println("Update error issue"+ ex);
            return false;
        }
    }

    @PostMapping("/delete")
    public boolean deletecarrier(@RequestParam(value="carrierid") String carrierid) {
        try {
            rdcService.deleteCarrierById(carrierid);
            return true;
        }catch (Exception ex){
            System.out.println("Delete carrier error issue"+ ex);
            return false;
        }
    }

    @GetMapping("/findall")
    public ResponseEntity<Object> findallcarriers() {

        try{
            return new ResponseEntity<>(rdcService.getAllCarriers(), HttpStatus.OK);
        }
        catch(Exception ex) {
            System.out.println("isOffshore error issue"+ ex);
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/deleteall")
    public boolean deleteallcarriers() {

        try{
            rdcService.deleteAllCarriers();
            return true;
        }
        catch(Exception ex) {
            System.out.println("Delete error issue"+ ex);
            return false;
        }

    }
}

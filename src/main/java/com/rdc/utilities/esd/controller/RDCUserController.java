package com.rdc.utilities.esd.controller;


import com.rdc.utilities.esd.model.RDCUsers;
import com.rdc.utilities.esd.service.RDCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping(value = {"/user"})
public class RDCUserController {
    @Autowired
    RDCService rdcService;
 //  private Logger log = Logger.getLogger(RDCController.class);

     @GetMapping("/finduser")
    public ResponseEntity<Object> finduser(@RequestParam(value="userid") String userid) {
         RDCUsers rdcuser= null;
         try{
             rdcuser = rdcService.getUserById(userid);
             if(rdcuser != null)
                return new ResponseEntity<>(rdcuser, HttpStatus.OK);
             else
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
         catch(Exception ex) {
             System.out.println("finduser error issue"+ ex);
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }

    }

    @GetMapping("/findallusers")
    public ArrayList findallusers() {

        try{
            return (ArrayList)rdcService.getAllUsers();
        }
        catch(Exception ex) {
            System.out.println("isOffshore error issue"+ ex);
            return null;
        }

    }

    @GetMapping("/isOffshore")
    public boolean isOffshore(@RequestParam(value="userid") String userid) {
     RDCUsers rdcuser= null;
        try{
            rdcuser =  rdcService.getUserById(userid);
            return rdcuser.getLocation().equalsIgnoreCase("offsite");
        }
        catch(Exception ex) {
            System.out.println("isOffshore error issue"+ ex);
            return false;
        }
    }

    @PostMapping("/adduser")
    public boolean adduser(@RequestParam(value="userid") String userid,
                           @RequestParam(value="fname") String fname,
                           @RequestParam(value="lname") String lname,
                           @RequestParam(value="loc") String loc) {
         RDCUsers user = new RDCUsers(userid, fname, lname,loc);
         try {
             rdcService.addNewUser(user);
             return true;
         }catch (Exception ex){
             System.out.println("Add error issue"+ ex);
             return false;
         }
    }

    @PostMapping("/updateuser")
    public boolean updateuser(@RequestParam(value="userid") String userid,
                           @RequestParam(value="fname") String fname,
                           @RequestParam(value="lname") String lname,
                           @RequestParam(value="loc") String loc) {
        RDCUsers user = new RDCUsers(userid, fname, lname,loc);
        try {
            rdcService.updateUser(user);
            return true;
        }catch (Exception ex){
            System.out.println("Add error issue"+ ex);
            return false;
        }
    }

    @PostMapping("/deleteuser")
    public boolean deleteuser(@RequestParam(value="userid") String userid) {
        try {
            rdcService.deleteUserById(userid);
            return true;
        }catch (Exception ex){
            System.out.println("Delete user error issue"+ ex);
            return false;
        }
    }

    ///RDC Operations

}

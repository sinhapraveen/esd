package com.rdc.utilities.esd.bootstrap;


import com.rdc.utilities.esd.model.RDCUsers;
import io.jsondb.JsonDBTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

//import org.apache.log4j.Logger;

@Component
public class RDCBootstrap implements ApplicationListener<ContextRefreshedEvent> {

  //  private Logger log = Logger.getLogger(RDCBootstrap.class);


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
 //       if (!jsonDBTemplate.collectionExists("RDCUsers"))
 //           jsonDBTemplate.createCollection(RDCUsers.class);
        System.out.println("Iboot");
  //  RDCUsers rdcUser = new RDCUsers("test12", "firstTest", "lastTest", "onsite");
   //     rdcRepository.save(rdcUser);


    }
}

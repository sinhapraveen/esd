package com.rdc.utilities.esd;

import com.rdc.utilities.esd.model.RDCUsers;
import io.jsondb.JsonDBTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.rdc.utilities.esd")
public class EsdApplication {

	public static void main(String[] args) {

		SpringApplication.run(EsdApplication.class, args);
		System.out.println("test here");
		//Actual location on disk for database files, process should have read-write permissions to this folder
	//	String dbFilesLocation = "C:\\MyProjects\\ESDProject\\JsonDB";

//Java package name where POJO's are present
	//	String baseScanPackage = "com.rdc.utilities.esd.model";

//Optionally a Cipher object if you need Encryption
	//	ICipher cipher = new Default1Cipher("1r8+24pibarAWgS85/Heeg==");

	/*	JsonDBTemplate jsonDBTemplate = new JsonDBTemplate(dbFilesLocation, baseScanPackage);
		if (!jsonDBTemplate.collectionExists("RDCUsers"))
			jsonDBTemplate.createCollection(RDCUsers.class);
		RDCUsers user = new RDCUsers();
		user.setUserID("qcpi123");
		user.setFname("12first");
		user.setLname("12last");
		user.setLocation("onsite");
	//	jsonDBTemplate.upsert(user);

		jsonDBTemplate.findById("qcpi123", RDCUsers.class);
		System.out.println("test here" +jsonDBTemplate.findById("qcpi123", RDCUsers.class));*/
	}

}

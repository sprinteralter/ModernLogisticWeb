/**
 * @author Rostislav Pavlenko
 * */
package com.rosteach.controllers;

import java.io.File;
import java.sql.SQLException;

import javax.xml.bind.JAXBException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.rosteach.DAO.InsertionDocInvoice;
import com.rosteach.upload.FilesUploader;
import com.rosteach.validators.FilesValidator;

@Controller
public class XMLController {

	@RequestMapping(value = "/XML", method = RequestMethod.GET)
	public String xml() {
		return "XML";
	}
	/**
	 * File upload mapping
	 * */
	@RequestMapping(value = "/uploadFile", method=RequestMethod.POST, produces={"application/text"})
	public @ResponseBody String uploadFile(@RequestParam("file[]") MultipartFile [] file){
		String result = "";
		//checking and saving file block
		FilesUploader files = new FilesUploader();
		FilesValidator validator = new FilesValidator();
		//validate all parameters
		File directory = validator.checkDirectory(files.getDirectory());
		validator.scanForFile(files.getRootPath());
		
		if(validator.checkType(file)==true){
			result = files.saveFiles(file,directory);
		}
		else {
			result = "Invalid type of file or files!!";
		}
		return result;
    }
	//Tampering Data from xml into Database
	@RequestMapping(value = "/Push", method = RequestMethod.GET,produces={"application/text"})
	public @ResponseBody String insertion(@RequestParam("dataBase") String dataBase,@RequestParam("name") String login,@RequestParam("password") String password) throws JAXBException,SQLException{
		String result = "";
		InsertionDocInvoice insertion = new InsertionDocInvoice();
		String data="";
		if(dataBase.equals("alter_ros")){
			data="jdbc:firebirdsql:192.168.20.85/3050:alter_ros";
		} else if(dataBase.equals("Alter")){
			data="jdbc:firebirdsql:192.168.20.17/3050:alter";
		} else if(dataBase.equals("alter_curent")){
			data="jdbc:firebirdsql:192.168.20.13/3050:alter_curent";
		}	
			//check date of document
			if(insertion.checkDate()==true){
				insertion.insertData(data,login,password);
				result="Insertion into database was successfull, documents date: "+insertion.getDate();
			}
			else{
				result="Insertion into database was denied, out of date: "+insertion.getDate()+" !";
			}
		return result;
	}
	//ajax checking date of the document
	@RequestMapping(value = "/getDate", method = RequestMethod.GET)
	public @ResponseBody String getDate() throws JAXBException{
		String result = new InsertionDocInvoice().getDate();
		return result;
	}
}

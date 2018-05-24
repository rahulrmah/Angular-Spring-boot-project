package com.cybage.tes.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.cybage.tes.model.Mentee;
import com.cybage.tes.model.Ott;
import com.cybage.tes.repository.MenteeRepository;
import com.cybage.tes.repository.OttRepository;

@RestController
public class UploadController {
	
	@Autowired
	MenteeRepository menteeRepo;
	@Autowired
	OttRepository ottRepo;
	
	@PostMapping("/uploadMentees")//uploads the list of mentees into the database
	public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file){
		String message = "";
		try {
			File convFile = new File(file.getOriginalFilename());
			
			convFile.createNewFile(); 
			FileOutputStream fos = new FileOutputStream(convFile); 
			fos.write(file.getBytes());
		    fos.close(); 
		    FileInputStream inputStream = new FileInputStream(convFile);
		    XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		    XSSFSheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();
            int rowNumber=0;
            while (iterator.hasNext()) {
            	XSSFRow currentRow = (XSSFRow) iterator.next();
                if(++rowNumber>1){
	                Iterator<Cell> cellIterator = currentRow.iterator();
	                Mentee mentee=new Mentee();
	                while (cellIterator.hasNext()) {
	
	                	XSSFCell currentCell = (XSSFCell) cellIterator.next();
	                    int columnIndex = currentCell.getColumnIndex();
	                    
	                    switch (++columnIndex) {
	                    case 1:
	                        break;
	                    case 2:
	                    	mentee.setMenteeId((int) currentCell.getNumericCellValue());
	                    	
	                    	
	                        break;
	                    case 3:
	                    	mentee.setMenteeName(currentCell.getStringCellValue());
	                    	
	                        break;
	                    case 4:		                   
	                    	mentee.setEmail(currentCell.getStringCellValue());
	                    	
		                        break;
	                    case 5:		                   
	                    	mentee.setTechnology(currentCell.getStringCellValue());
	                    	
		                        break;
		                default:break;
	                    }
	                }
	                Mentee temp=menteeRepo.findOne(mentee.getMenteeId());
	                if(temp==null)
	                	mentee=menteeRepo.saveAndFlush(mentee);
                }
            }
            workbook.close();
            inputStream.close();
            message = "You successfully uploaded " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
			message = "FAIL to upload " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}
	}
	
	@PostMapping("/uploadOtt")//uploads the list of ott marks into the database
	public ResponseEntity<String> handleOttFileUpload(@RequestParam("file") MultipartFile file){
		String message = "";
		try {
			File convFile = new File(file.getOriginalFilename());
			
			convFile.createNewFile(); 
			FileOutputStream fos = new FileOutputStream(convFile); 
			fos.write(file.getBytes());
		    fos.close(); 
		    FileInputStream inputStream = new FileInputStream(convFile);
		    XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		    XSSFSheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();
            int rowNumber=0;
            while (iterator.hasNext()) {
            	XSSFRow currentRow = (XSSFRow) iterator.next();
                if(++rowNumber>1){
	                Iterator<Cell> cellIterator = currentRow.iterator();
	                Mentee mentee=new Mentee();
	                Ott ott=new Ott();
	                while (cellIterator.hasNext()) {
	
	                	XSSFCell currentCell = (XSSFCell) cellIterator.next();
	                    int columnIndex = currentCell.getColumnIndex();
	                    
	                    switch (++columnIndex) {
	                    case 1:
	                    	ott.setExamName(currentCell.getStringCellValue());
	                    	
	                        break;
	                    case 2:
	                    	mentee=menteeRepo.getOne((int) currentCell.getNumericCellValue());
	                    	ott.setMentee(mentee);
	                    	
	                        break;
	                    case 3:
	                    	
	                        break;
	                    case 4:		                   
	                    	ott.setPercentage(new BigDecimal(currentCell.getNumericCellValue()));
	                    	
		                        break;
	                    case 5:		
	                    	
		                        break;
		                default:break;
	                    }
	                }
	                boolean flag=false;
	                List<Ott> exams=new ArrayList<>();
	                if(null!=(exams=mentee.getOtts())){
	                	for(Ott e:exams){
	                		if(null!=e.getExamName()){
	                			if(e.getExamName().equals(ott.getExamName())){
	                				e.setPercentage(ott.getPercentage());
	                				mentee=menteeRepo.saveAndFlush(mentee);
	                				flag=true;
	                				break;
	                			}
	                		}
	                	}
	                }
	                if(!flag){
	                	ott.setOttDate(new Date());
		                ott=ottRepo.saveAndFlush(ott);
	                }
                }
            }
            workbook.close();
            inputStream.close();
            message = "You successfully uploaded " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
			message = "FAIL to upload " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}
	}
}










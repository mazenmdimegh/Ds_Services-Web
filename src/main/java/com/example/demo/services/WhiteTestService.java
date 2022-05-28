package com.example.demo.services;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.stereotype.Service;

import de.tekup.soap.models.whitetest.Address;
import de.tekup.soap.models.whitetest.Exam;
import de.tekup.soap.models.whitetest.Student;
import de.tekup.soap.models.whitetest.StudentRequest;
import de.tekup.soap.models.whitetest.WhiteTestResponse;
@Service
public class WhiteTestService {
	
	
	
	public WhiteTestResponse whiteTest(StudentRequest request) {
		
		
		WhiteTestResponse response = new WhiteTestResponse();
		ArrayList<Student> students = new ArrayList<>();
		ArrayList<Exam> exams = new ArrayList<>();
		
		
		Address address1 = new Address();
		address1.setStreet("rue de paris");
		address1.setCity("tunis");
		address1.setPosteCode(2041);
		
		
		Student student1= new Student();
		student1.setId(1);
		student1.setName("mohamed");
		student1.setAddress(address1);
		
		students.add(student1);

		
		Exam exam1= new Exam();
		exam1.setCode("ccna");
		exam1.setName("CCNA");
		
		exams.add(exam1);
		
		
		Address address2 = new Address();
		address2.setStreet("rue mohammed V ");
		address2.setCity("tunis");
		address2.setPosteCode(2040);
		
		Student student2= new Student();
		student2.setId(2);
		student2.setName("ali");
		student2.setAddress(address2);
		
		students.add(student2);
		
		Exam exam2= new Exam();
		exam2.setCode("oca");
		exam2.setName("oca");
		
		exams.add(exam2);
		
		
		
		

		
		
		if(request.getStudentId() <=0 || request.getStudentId() > students.size())
			response.getBadRequests().add("Student ID is not valid or Not found");
		
		if(response.getBadRequests().isEmpty()) {
		for(Student student : students) {
			if (request.getStudentId()==student.getId())
			{
				response.setStudent(student);
				for(Exam exam : exams) {
					if(request.getExamCode().equals(exam.getCode())) {
						response.setExam(exam);
						LocalDate date = LocalDate.now();
						GregorianCalendar gcal = GregorianCalendar.from(date.atStartOfDay(ZoneId.systemDefault()));
						XMLGregorianCalendar xcal =null;
						try {
							xcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
						} catch (DatatypeConfigurationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						response.setDate(xcal);
						}
			}
		} 		
	}
	

	}
		
		System.out.println(response.getBadRequests());
		return response;

		
		
		
	}
	}



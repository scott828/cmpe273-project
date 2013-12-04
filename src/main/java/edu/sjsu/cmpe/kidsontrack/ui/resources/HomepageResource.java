package edu.sjsu.cmpe.kidsontrack.ui.resources;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.sjsu.cmpe.kidsontrack.dao.StudentMgntDao;
import edu.sjsu.cmpe.kidsontrack.dao.StudentMgntDaoInterface;
import edu.sjsu.cmpe.kidsontrack.dao.TeacherMgntDao;
import edu.sjsu.cmpe.kidsontrack.dao.TeacherMgntDaoInterface;
import edu.sjsu.cmpe.kidsontrack.ui.views.HomepageView;

@Path("/")
@Produces(MediaType.TEXT_HTML)
public class HomepageResource {
	
	private StudentMgntDaoInterface studentMgntDao = new StudentMgntDao();
	private TeacherMgntDaoInterface teacherMgntDao = new TeacherMgntDao();
	
	public HomepageResource() {
		
	}
	
	@GET
	public HomepageView illustrate() {
		return new HomepageView();
	}
	
	@POST
	public Response verifyLogin(@FormParam("Email") String email,
			@FormParam("Password") String password) throws URISyntaxException {
		URI uriLogin = new URI("http://localhost:8080/kidsontrack/login");
		URI uriTeachers = new URI("http://localhost:8080/kidsontrack/teachers");
		URI uriStudents = new URI("http://localhost:8080/kidsontrack/students");
		
		if(teacherMgntDao.isFound(email, password)&&!studentMgntDao.isFound(email, password)) {
			System.out.println("Hello teacher");
			return Response.seeOther(uriTeachers).build();
		}
		if(!teacherMgntDao.isFound(email, password)&&studentMgntDao.isFound(email, password)) {
			System.out.println("Hello Student");
			return Response.seeOther(uriStudents).build();
		}
		else {
			System.out.println("User not found!");
			return Response.seeOther(uriLogin).build();
		}
	}
}

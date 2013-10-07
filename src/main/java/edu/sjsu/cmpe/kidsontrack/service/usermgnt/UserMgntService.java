package edu.sjsu.cmpe.kidsontrack.service.usermgnt;

import java.util.List;

import edu.sjsu.cmpe.kidsontrack.dto.usermgnt.UserDto;
import edu.sjsu.cmpe.kidsontrack.exception.UserManagmentException;
import edu.sjsu.cmpe.kidsontrack.model.usermgnt.User;

/**
 * @author Lei Zhang
 *
 */
public interface UserMgntService {
	
	public User getUserById(String userId) throws UserManagmentException;
	public User getUserByEmail(String email) throws UserManagmentException;
	public List<User> getAllUsers() throws UserManagmentException;
	public UserDto addUser(User user) throws UserManagmentException;
	public UserDto updateUser(User user) throws UserManagmentException;
	public boolean deleteUser(String userId)  throws UserManagmentException;	
	
	public UserDto authenticate(String email, String password) throws UserManagmentException;
	
}

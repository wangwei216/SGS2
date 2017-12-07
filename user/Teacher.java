package user;

import java.io.Serializable;



public class Teacher extends User implements Serializable{
	
	public Teacher(String userNo,String name){
		super(userNo,name,User.USER_TYPE_TEACHER);
	}
}

package user;

import java.io.Serializable;

public class Admin extends User implements Serializable{
	public Admin(String userNo,String name){
		super(userNo,name,User.USER_TYPE_ADMIN);
	}
}

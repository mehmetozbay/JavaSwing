package javagui;

import java.util.ArrayList;
import java.util.List;

public class UserManager {

	
	List<User>users =new ArrayList<>();
	
	 public void userEkle(User user) {
		
		 users.add(user);
	}
}

package registerSimulation.business.abstracts;

import java.util.List;

import registerSimulation.core.utilities.results.Result;
import registerSimulation.model.concretes.User;

public interface UserService {

	Result add(User user);

	Result update(User user);

	Result delete(User user);

	List<User> getAll();

	User getById(int id);
	
	List<String> getEmails();
	
	boolean isMailMatched(User user);
	
	boolean isPassWordMatched(User user);
	
	User getByEmail(String email);
	
	User getEmailAndPassword(String email,String password);
	
}

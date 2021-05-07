package registerSimulation.dataAccess.abstracts;

import java.util.List;

import registerSimulation.core.dataAccess.ModelRepository;
import registerSimulation.model.concretes.User;

public interface UserDao extends ModelRepository<User>{



	User getById(int id);
	
	List<String> getEmails();
	
	boolean isMailMatched(User user);
	
	boolean isPassWordMatched(User user);
	
	User getByEmail(String email);
	
	User getEmailAndPassword(String email,String password);
}

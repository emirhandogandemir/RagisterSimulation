package registerSimulation.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import registerSimulation.business.abstracts.GeneralSendService;
import registerSimulation.business.abstracts.UserService;
import registerSimulation.business.abstracts.ValidationService;
import registerSimulation.business.constants.ValidationMessage;
import registerSimulation.core.crossCuttingConcerns.Authorization.AuthorizationService;
import registerSimulation.core.crossCuttingConcerns.log.LoggerService;
import registerSimulation.core.utilities.mail.MailService;
import registerSimulation.core.utilities.results.Result;
import registerSimulation.core.utilities.results.SuccessResult;
import registerSimulation.dataAccess.abstracts.UserDao;
import registerSimulation.model.concretes.User;

public class UserManager implements UserService{

	private UserDao userDao;
	
	private GeneralSendService generalSendService;
	
	public UserManager(UserDao userDao,GeneralSendService generalSendService) {
		super();
		this.userDao = userDao;
		this.generalSendService=generalSendService;
		
	}

	@Override
	public Result add(User user) {
		userDao.add(user);
	generalSendService.send(user);
		return new SuccessResult(ValidationMessage.userAdded);	
		
	}

	@Override
	public Result update(User user)  {
		userDao.update(user);
		generalSendService.send(user);
		return new SuccessResult(ValidationMessage.userUpdated);	
		
	}

	@Override
	public Result delete(User user) {
		userDao.delete(user);
		return new SuccessResult(ValidationMessage.userDeleted);	
			
		
	}

	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}

	@Override
	public User getById(int id) {
		
		return userDao.getById(id);
	}

	@Override
	public List<String> getEmails() {
		
		return userDao.getEmails();
	}

	
	// burda olmamasý gerek
	@Override
	public boolean isMailMatched(User user) {
		
		return userDao.isMailMatched(user);
	}

	//burda olmamasý gerek
	@Override
	public boolean isPassWordMatched(User user) {
		
		return userDao.isPassWordMatched(user);
	}

	@Override
	public User getByEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.getByEmail(email);
	}

	@Override
	public User getEmailAndPassword(String email, String password) {
		
		return userDao.getEmailAndPassword(email, password);
	}

	
	
	
	
	
}

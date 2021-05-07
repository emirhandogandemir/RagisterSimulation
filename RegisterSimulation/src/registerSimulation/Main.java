package registerSimulation;

import registerSimulation.business.abstracts.GeneralSendService;
import registerSimulation.business.abstracts.UserService;
import registerSimulation.business.abstracts.ValidationService;
import registerSimulation.business.concretes.GeneralSendManager;
import registerSimulation.business.concretes.UserManager;
import registerSimulation.business.concretes.ValidationManager;
import registerSimulation.core.crossCuttingConcerns.Authorization.AuthorizationService;
import registerSimulation.core.crossCuttingConcerns.Authorization.googleAuthorization.GoogleAuthorizationManagerAdapter;
import registerSimulation.core.crossCuttingConcerns.log.LoggerService;
import registerSimulation.core.crossCuttingConcerns.log.email.EmailLoggerManager;
import registerSimulation.core.utilities.mail.MailService;
import registerSimulation.core.utilities.mail.UserMailManager;
import registerSimulation.dataAccess.abstracts.UserDao;
import registerSimulation.dataAccess.concretes.inMemory.InMemoryUserDao;
import registerSimulation.googleAuthorization.GoogleAuthorizationManager;
import registerSimulation.model.concretes.User;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		User user = new User(1, "Emirhan", "doðandemir", "emirhangmail.com", "1898");
		UserDao userDao = new InMemoryUserDao();
		LoggerService loggerService = new EmailLoggerManager();
		ValidationService validationService = new ValidationManager();
		AuthorizationService authorization = new GoogleAuthorizationManagerAdapter(new GoogleAuthorizationManager());
		MailService mailService = new UserMailManager();
		GeneralSendService generalSendService = new GeneralSendManager(authorization, loggerService, mailService,
				validationService);
		
		UserService userService = new UserManager(userDao,generalSendService);
		userService.add(user);
//userService.add(user);
		
		

	}

}

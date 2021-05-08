package registerSimulation.business.concretes;

import registerSimulation.business.abstracts.GeneralSendService;
import registerSimulation.business.abstracts.ValidationService;
import registerSimulation.core.crossCuttingConcerns.Authorization.AuthorizationService;
import registerSimulation.core.crossCuttingConcerns.log.LoggerService;
import registerSimulation.core.utilities.mail.MailService;
import registerSimulation.core.utilities.results.ErrorResult;
import registerSimulation.core.utilities.results.Result;
import registerSimulation.core.utilities.results.SuccessResult;
import registerSimulation.model.concretes.User;

public class GeneralSendManager implements GeneralSendService{

	private AuthorizationService authorizationService;
	private LoggerService loggerService;
	private MailService mailService;
	private ValidationService validationService;
	
	
	
	public GeneralSendManager(AuthorizationService authorizationService, LoggerService loggerService,
			MailService mailService,ValidationService validationService) {
		super();
		this.authorizationService = authorizationService;
		this.loggerService = loggerService;
		this.mailService = mailService;
		this.validationService=validationService;
	}

	@Override
	public void send(User user)  {
		
		boolean result=validationService.validate(user);
		System.out.println(result);
		//System.out.println("aýdjkpaoedý");
		if(result==true ){
			authorizationService.register(user);
			loggerService.add(user);
			mailService.send(user);
			user.setVerified(true);
			
		}
		
	}

}

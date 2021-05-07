package registerSimulation.core.crossCuttingConcerns.Authorization.googleAuthorization;

import registerSimulation.core.crossCuttingConcerns.Authorization.AuthorizationService;
import registerSimulation.googleAuthorization.GoogleAuthorizationManager;
import registerSimulation.model.concretes.User;

public class GoogleAuthorizationManagerAdapter implements AuthorizationService{

	private GoogleAuthorizationManager googleAuthorization;
	
	
	
	public GoogleAuthorizationManagerAdapter(GoogleAuthorizationManager googleAuthorization) {
		this.googleAuthorization = googleAuthorization;
	}

	@Override
	public void login(User user) {
		this.googleAuthorization.login(user.geteMail(), user.getPassword());
		
	}

	

	@Override
	public void logOut(User user) {
		this.googleAuthorization.logOut(user.geteMail());
		
	}

	@Override
	public void register(User user) {
		this.googleAuthorization.register(user.geteMail(),user.getPassword());
		
	}


}

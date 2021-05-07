package registerSimulation.core.crossCuttingConcerns.Authorization;

import registerSimulation.model.concretes.User;

public interface AuthorizationService {
	void register(User user);

	void login(User user);

	void logOut(User user);
}

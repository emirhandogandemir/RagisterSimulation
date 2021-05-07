package registerSimulation.core.utilities.mail;

import registerSimulation.model.concretes.User;

public interface MailService {
	void send(User user);
}

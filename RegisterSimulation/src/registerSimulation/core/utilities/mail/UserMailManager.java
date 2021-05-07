package registerSimulation.core.utilities.mail;

import registerSimulation.business.constants.Environment;
import registerSimulation.model.concretes.User;

public class UserMailManager implements MailService {

	@Override
	public void send(User user) {
		 System.out.println( user.geteMail()+" hesabýna "+ Environment.url+ "link icerigi gönderildi");
		
	}

}

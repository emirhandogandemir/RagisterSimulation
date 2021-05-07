package registerSimulation.business.abstracts;

import registerSimulation.core.utilities.results.Result;
import registerSimulation.model.concretes.User;

public interface ValidationService {
	boolean validate(User user) ;
	
}

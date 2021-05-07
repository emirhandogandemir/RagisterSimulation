package registerSimulation.core.crossCuttingConcerns.log;

import registerSimulation.model.concretes.User;

public interface LoggerService {
 void add (User user);
 void delete (User user);
 void update(User user);
}

package registerSimulation.business.concretes;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import registerSimulation.business.ValidationRules.inMemoryValidation.ValidationRules;
import registerSimulation.business.abstracts.ValidationService;
import registerSimulation.business.constants.ValidationMessage;
import registerSimulation.core.utilities.results.ErrorResult;
import registerSimulation.core.utilities.results.Result;
import registerSimulation.core.utilities.results.SuccessResult;
import registerSimulation.dataAccess.concretes.inMemory.InMemoryUserDao;
import registerSimulation.model.concretes.User;

public class ValidationManager implements ValidationService {

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	@Override
	public boolean validate(User user) {
		//
		Result [] results = ValidationRules.run(this.checkEmailNotNull(user),this.checkFirstNameNotNull(user),
				this.checkLastNameNotNull(user),this.checkPasswordNotNull(user),this.userEmailCheck(user),this.userFirstNameCheck(user),
				this.userLastNameCheck(user),this.isPassWordMatched(user),this.userPasswordCheck(user),this.isMailMatched(user));
		for (Result result : results) {
			if (!result.isSuccess()) {
			return true;
				
			}
		}
		return false;
	}

	private Result userFirstNameCheck(User user) {
		if (user.getFirstName().length() < 2) {
			return new ErrorResult(ValidationMessage.validateUserNameFalse);
		}

		return new SuccessResult();

	}

	private Result userLastNameCheck(User user) {
		if (user.getLastName().length() < 2) {
			return new ErrorResult(ValidationMessage.validateUserLastNameFalse);
		}

		return new SuccessResult();

	}

	private Result userPasswordCheck(User user) {
		if (user.getPassword().length() < 6) {

			return new ErrorResult(ValidationMessage.validateUserPasswordFalse);
		}

		return new SuccessResult();
	}

	private Result userEmailCheck(User user) {

		if (!VALID_EMAIL_ADDRESS_REGEX.matcher(user.geteMail()).find()) {
			return new ErrorResult(ValidationMessage.validateUserEmailFalse);
		}
		return new SuccessResult();
	}

	private Result checkFirstNameNotNull(User user) {
		if (user.getFirstName().isEmpty() || user.getFirstName() == null) {
			return new ErrorResult(ValidationMessage.firstNameCanNotBeNullOrEmpty);
		}
		return new SuccessResult();
	}

	private Result checkLastNameNotNull(User user) {
		if (user.getLastName().isEmpty() || user.getLastName() == null) {
			return new ErrorResult(ValidationMessage.lastNameCanNotBeNullOrEmpty);
		}
		return new SuccessResult();
	}

	private Result checkEmailNotNull(User user) {
		if (user.geteMail().isEmpty() || user.geteMail() == null) {
			return new ErrorResult(ValidationMessage.emailCanNotBeNullOrEmpty);
		}
		return new SuccessResult();
	}

	private Result checkPasswordNotNull(User user) {
		if (user.getPassword().isEmpty() || user.getPassword() == null) {
			return new ErrorResult(ValidationMessage.passwordCanNotBeNullOrEmpty);
		}
		return new SuccessResult();
	}

	public Result isPassWordMatched(User user) {
		if (!InMemoryUserDao.users.stream().anyMatch(mails -> mails.getPassword() == user.getPassword())) {
			return new ErrorResult();
		}
		return new SuccessResult();
	}
	public Result isMailMatched(User user) {
		if(!InMemoryUserDao.users.stream().anyMatch(mails->mails.geteMail() ==user.geteMail())) {
			return new ErrorResult();
		}
		return new SuccessResult();
	}
	
}

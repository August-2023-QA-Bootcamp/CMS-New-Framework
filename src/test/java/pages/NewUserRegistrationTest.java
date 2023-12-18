package pages;

import org.testng.annotations.Test;

import baseUtil.BaseClass;

public class NewUserRegistrationTest extends BaseClass {
	@Test
	public void newUserRegistrationTest() {
		newUserRegistration.directingToNewUserRegistration();
		newUserRegistration.stepOneOfNewUserRegistration();
		newUserRegistration.selectApplication();
//		newUserRegistration.stepTwoTitleHeaderValidation();
//		newUserRegistration.firstNameValidation();
//		newUserRegistration.middleNameValidation();
//		newUserRegistration.lastNameValidation();
//		newUserRegistration.suffixValidation();
//		newUserRegistration.dobValidation();
//		newUserRegistration.addressLine1Validation();
//		newUserRegistration.addressLine2Validation();
		newUserRegistration.cityValidation();
		newUserRegistration.stateValidation();
		newUserRegistration.zipCodeValidation();
//		newUserRegistration.zipCodePlus4Validation();
//		newUserRegistration.emailValidation();
//		newUserRegistration.emailConfirmValidation();
//		newUserRegistration.phoneNumberValidation();
//		newUserRegistration.nextStep2Validation();
	}

}

// If we run from test case, then @optional will work

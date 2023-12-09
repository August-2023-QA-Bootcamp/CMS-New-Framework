package pages;

import org.testng.annotations.Test;

import baseUtil.BaseClass;

public class NewUserRegistrationTest extends BaseClass {
	@Test
	public void newUserRegistrationTest() {
		newUserRegistration.directingToNewUserRegistration();
		newUserRegistration.stepOneOfNewUserRegistration();
		newUserRegistration.selectApplication();
		newUserRegistration.stepTwoOfNewUserRegistration();
	}

}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static common.CommonActions.*;
import static common.CommonWaits.*;

public class NewUserRegistration {
	WebDriver driver;
	
	public NewUserRegistration(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(text(), 'New')]")
	WebElement newUserRegistration;
	
	@FindBy(xpath = "//p[contains(text(), ' Step #')]")
	WebElement stepOneHeader;
	
	@FindBy(xpath = "//p[contains(text(), ' Step 1 of 3')]")
	WebElement stepOnesubHeader;
		
	// @FindBy(xpath = "//div[contains(text(), 'Sel')]")
	@FindBy(xpath = "//div[@class='ng-input']")
	WebElement selectYourApplication;
	
	@FindBy(id = "textSearch")
	WebElement textSearch;
	
	@FindBy(id = "cms-tos-reg")
	WebElement agreeToTheTerms;
	
	@FindBy(name = "termsAndCondNext")
	WebElement nextButtonStep1;
	
	@FindBy(id = "cms-newuser-firstName")
	WebElement firstName;
	
	@FindBy(xpath = "//span[text()='Required field.']")
	WebElement requiredFieldErrorMsgUnderTheField;
	
	@FindBy(xpath = "//span[text()='Must be alphabetic characters.']")
	WebElement alphabeticCharactersErrorMsgUnderTheField;
	
	@FindBy(id = "cms-newuser-middleName")
	WebElement middleName;
	
	@FindBy(id = "cms-newuser-lastName")
	WebElement lastName;
	
	@FindBy(id = "cms-newuser-nameSuffix")
	WebElement suffix;
	
	@FindBy(id = "cms-register-information")
	WebElement stepTwoHeader;
	
	@FindBy(xpath = "//p[contains(text(), ' Step 2 of 3')]")
	WebElement stepTwosubHeader;
	
	@FindBy(id = "cms-newuser-birthMonth")
	WebElement birthMonth;
	
	@FindBy(id = "cms-newuser-birthDate")
	WebElement birthDate;
	
	@FindBy(id = "cms-newuser-birthYear")
	WebElement birthYear;
	
	@FindBy(xpath = "//label[@class='check-radio']//parent::li[@class='cms-radio-item']")
	WebElement usBasedAddress;
	
	@FindBy(xpath = "//label[@class='check-radio']//parent::li[@class='cms-radio-item2']")
	WebElement nonUsBasedAddress;
		
	@FindBy(id = "cms-newuser-homeAddressLine1")
	WebElement addressLine1;
	
	@FindBy(xpath = "//span[text()='Must be alphanumeric characters.']")
	WebElement alphanumericCharactersErrorMsgUnderTheField;
	
	@FindBy(id = "cms-newuser-usAddress2")
	WebElement addressLine2;
	
	@FindBy(id = "cms-newuser-usCity")
	WebElement city;
	
	@FindBy(id = "cms-newuser-usState")
	WebElement state;
	
	@FindBy(name = "cms-newuser-zipcode")
	WebElement zipCode;
	
	@FindBy(xpath = "//span[text()='Must be a valid numeric ZIP Code.']")
	WebElement numericZipCodeErrorMsgUnderTheField;
	
	@FindBy(xpath = "//span[text()='Must be a valid numeric ZIP+4 Code.']")
	WebElement numericZipPlus4CodeErrorMsgUnderTheField;	
	
	@FindBy(id = "cms-newuser-usZipcodeExt")
	WebElement zipCodeExt;
	
	@FindBy(id = "cms-newuser-usEmail")
	WebElement email;
	
	@FindBy(id = "cms-newuser-usConfirmEmail")
	WebElement confirmEmail;
	
	@FindBy(xpath = "//span[text()='Must match Email Address values.']")
	WebElement mismatchEmailAddressErrorMsgUnderTheField;	
	
	@FindBy(id = "cms-newuser-usPhoneNumber")
	WebElement phoneNumber;
	
	@FindBy(xpath = "//span[text()='Phone Number must not start with a 1 or 0.']")
	WebElement phoneNumberNotStartWithErrorMsgUnderTheField;	
	
	@FindBy(xpath = "//span[text()='Must be a valid Phone Number.']")
	WebElement validPhoneNumberErrorMsgUnderTheField;
	
	@FindBy(id = "step2NextButton")
	WebElement nextButtonStep2;
	
	
	public void directingToNewUserRegistration() {
		pause(4);
		buttonEnabled(newUserRegistration);
		verifyTextOfTheWebElement(newUserRegistration, "New User Registration");
		clickElement(newUserRegistration);
	}
	
	public void stepOneOfNewUserRegistration() {
		pause(5);
		currentUrl(driver);
		verifyTitle(driver, "CMS Enterprise Portal - New User Registration");
		validationOfHeader(stepOneHeader, "Step #1: Select Your Application");
		validationOfSubHeader(stepOnesubHeader, "Step 1 of 3 - Select your application from the dropdown. You will then need to agree to the terms & conditions.");
	}
	
	// we have to find listOfEleemnts later
	
	public void selectApplication() {
		clickElement(selectYourApplication);
		pause(3);
		inputTextThenClickEnter(textSearch, "BCRS Web");
		pause(3);
		// waitUntilClickable(agreeToTheTerms); // Not working
		// Cannot invoke "org.openqa.selenium.support.ui.WebDriverWait.until(java.util.function.Function)" because "common.CommonWaits.wait" is null
		clickElement(agreeToTheTerms);
		pause(3);
		buttonEnabled(nextButtonStep1);
		verifyTextOfTheWebElement(nextButtonStep1, "Next");
		clickElement(nextButtonStep1);	
	}
	
	public void stepTwoOfNewUserRegistration() {
		pause(5);
		currentUrl(driver);
		verifyTitle(driver, "CMS Enterprise Portal - New User Registration");
		validationOfHeader(stepTwoHeader, "Step #2: Register Your Information");
		validationOfSubHeader(stepTwosubHeader, "Step 2 of 3 - Please enter your personal and contact information.");		
		verifyLengthOfTheFieldContent(firstName, "20");		
		inputTextThenClickTab(firstName, "% & \\\" ( )");
		verifyErrorMsgUnderTheField(alphabeticCharactersErrorMsgUnderTheField, "Must be alphabetic characters.");
		pause(3);
		clearTextFromTheField(firstName);
		inputTextThenClickTab(firstName, "");
		pause(3);
		verifyErrorMsgUnderTheField(requiredFieldErrorMsgUnderTheField, "Required field.");
		pause(3);
		inputTextThenClickTab(firstName, "6573684765");
		verifyErrorMsgUnderTheField(alphabeticCharactersErrorMsgUnderTheField, "Must be alphabetic characters.");
		pause(3);
		clearTextFromTheField(firstName);
		pause(3);
		inputText(firstName, "Moha'mm-ad Md");	
		pause(3);
		verifyLengthOfTheFieldContent(middleName, "20");
		inputTextThenClickTab(middleName, "% & \\\" ( )");
		verifyErrorMsgUnderTheField(alphabeticCharactersErrorMsgUnderTheField, "Must be alphabetic characters.");
		pause(3);
		clearTextFromTheField(middleName);
		pause(3);
		inputTextThenClickTab(middleName, "6573684765");
		verifyErrorMsgUnderTheField(alphabeticCharactersErrorMsgUnderTheField, "Must be alphabetic characters.");
		pause(3);
		clearTextFromTheField(middleName);
		pause(3);		
		inputText(middleName, "To'fael Ka-bir");
		pause(3);
		verifyLengthOfTheFieldContent(lastName, "25");
		inputTextThenClickTab(lastName, "% & \\\" ( )");
		verifyErrorMsgUnderTheField(alphabeticCharactersErrorMsgUnderTheField, "Must be alphabetic characters.");
		pause(3);
		clearTextFromTheField(lastName);
		inputTextThenClickTab(lastName, "");
		verifyErrorMsgUnderTheField(requiredFieldErrorMsgUnderTheField, "Required field.");
		pause(3);
		inputTextThenClickTab(lastName, "6573684765");
		verifyErrorMsgUnderTheField(alphabeticCharactersErrorMsgUnderTheField, "Must be alphabetic characters.");
		pause(3);
		clearTextFromTheField(lastName);
		pause(3);
		inputText(lastName, "S'- harkar");
		pause(5);
		// we will use a for loop to see what options present, and wil give a if condition for our selection, when we will find SR, Then we will use select method	
		selectDropdown(suffix, "SR");
		pause(3);
		
		clickElementThenTab(birthMonth);	
		clickElementThenTab(birthDate);
		clickElementThenTab(birthYear);
		verifyErrorMsgUnderTheField(requiredFieldErrorMsgUnderTheField, "Required field.");
		pause(3);
		
		selectDropdown(birthMonth, "December");		
//		selectDropdown(birthYear, "1990");
//		verifyErrorMsgUnderTheField(requiredFieldErrorMsgUnderTheField, "Required field.");
		pause(3);
		selectDropdown(birthDate, "31");		
		pause(3);		
		selectDropdown(birthYear, "1990");
		pause(3);
		//verifyErrorMsgUnderTheField(requiredFieldErrorMsgUnderTheField, "Required field.");
		//selectDropdown(birthYear, "1990");
		// selectDropdown(birthMonth, "December");
//		selectDropdown(birthDate, "31");		
//		pause(3);
//		
//		clickElementThenTab(birthDate);
//		verifyErrorMsgUnderTheField(requiredFieldErrorMsgUnderTheField, "Required field.");
//		clickElementThenTab(birthYear);
//		verifyErrorMsgUnderTheField(requiredFieldErrorMsgUnderTheField, "Required field.");
//		pause(3);
//		clickElementThenTab(usBasedAddress);
//		pause(3);
//		clickElementThenTab(nonUsBasedAddress);
//		pause(3);
//		clickElementThenTab(addressLine1);
//		selectDropdown(birthMonth, "December");	
//		pause(3);
//		selectDropdown(birthMonth, "Select Birth Month");
//		pause(3);
//		verifyErrorMsgUnderTheField(requiredFieldErrorMsgUnderTheField, "Required field.");
//		selectDropdown(birthYear, "1990");
//		pause(3);
//		selectDropdown(birthMonth, "December");	
//		pause(3);
//		selectDropdown(birthDate, "31");		
//		selectDropdown(birthYear, "1990");
		clickElement(nonUsBasedAddress);
		pause(5);
		clickElement(usBasedAddress);		
		
		verifyLengthOfTheFieldContent(addressLine1, "60");		
		inputTextThenClickTab(addressLine1, " * < > ^ ! # $ + / : ; = ? @ [ ] ");
		verifyErrorMsgUnderTheField(alphanumericCharactersErrorMsgUnderTheField, "Must be alphanumeric characters.");
		pause(3); // is not used in the industry, this is used when you scripting the test cases, we will comment out all and run, if failed, then we will use web driver wait
		clearTextFromTheField(addressLine1);
		inputTextThenClickTab(addressLine1, "");
		pause(3);
		verifyErrorMsgUnderTheField(requiredFieldErrorMsgUnderTheField, "Required field.");
		pause(3);
		inputText(addressLine1, "6.1'E 97th-s S_t, 66");
		pause(3);
		
		verifyLengthOfTheFieldContent(addressLine2, "64");		
		inputTextThenClickTab(addressLine2, " * < > ^ ! # $ + / : ; = ? @ [ ] ");
		verifyErrorMsgUnderTheField(alphanumericCharactersErrorMsgUnderTheField, "Must be alphanumeric characters.");
		pause(3); // is not used in the industry, this is used when you scripting the test cases, we will comment out all and run, if failed, then we will use web driver wait
		clearTextFromTheField(addressLine2);
		pause(3);
		inputText(addressLine2, "A.pt 123123 'E 1009th-s S_t, 66");
		pause(3);

		verifyLengthOfTheFieldContent(city, "30");		
		inputTextThenClickTab(city, " > ^ ! # $ + / : ; = ? @");
		verifyErrorMsgUnderTheField(alphabeticCharactersErrorMsgUnderTheField, "Must be alphabetic characters.");
		pause(3); 
		clearTextFromTheField(city);
		inputTextThenClickTab(city, "");
		pause(3);
		verifyErrorMsgUnderTheField(requiredFieldErrorMsgUnderTheField, "Required field.");
		pause(3);
		inputTextThenClickTab(city, "64783city");
		verifyErrorMsgUnderTheField(alphabeticCharactersErrorMsgUnderTheField, "Must be alphabetic characters.");
		pause(3); 
		inputText(city, "Clark's Mountain"); // another example: Winston-Salem
		pause(3);
		
		// we have to find out total state number and their name by loop
		clickElementThenTab(state);
		verifyErrorMsgUnderTheField(requiredFieldErrorMsgUnderTheField, "Required field.");
		selectDropdown(state, "New York");
		
		verifyLengthOfTheFieldContent(zipCode, "5");			
		inputText(zipCode, "1002");
		verifyErrorMsgUnderTheField(numericZipCodeErrorMsgUnderTheField, "Must be a valid numeric ZIP Code.");
		clearTextFromTheField(zipCode);
		inputTextThenClickTab(zipCode, "");
		pause(3);
		verifyErrorMsgUnderTheField(requiredFieldErrorMsgUnderTheField, "Required field.");
		pause(3);
		inputTextThenClickTab(zipCode, " > ^ ! # $ + / : ; = ? @");
		verifyErrorMsgUnderTheField(numericZipCodeErrorMsgUnderTheField, "Must be a valid numeric ZIP Code.");
		pause(3); 
		clearTextFromTheField(zipCode);
		inputText(zipCode, "AaBcR");
		verifyErrorMsgUnderTheField(numericZipCodeErrorMsgUnderTheField, "Must be a valid numeric ZIP Code.");
		pause(3);
		clearTextFromTheField(zipCode);
		inputText(zipCode, "10019");
		pause(3);
		
		verifyLengthOfTheFieldContent(zipCodeExt, "4");			
		inputText(zipCodeExt, "100");
		verifyErrorMsgUnderTheField(numericZipPlus4CodeErrorMsgUnderTheField, "Must be a valid numeric ZIP+4 Code.");
		clearTextFromTheField(zipCodeExt);
		inputTextThenClickTab(zipCode, "");
		pause(3);
		inputTextThenClickTab(zipCodeExt, " > ^ ! # $ + / : ; = ? @");
		verifyErrorMsgUnderTheField(numericZipPlus4CodeErrorMsgUnderTheField, "Must be a valid numeric ZIP+4 Code.");
		pause(3); 
		clearTextFromTheField(zipCodeExt);
		inputText(zipCodeExt, "AdBc");
		verifyErrorMsgUnderTheField(numericZipPlus4CodeErrorMsgUnderTheField, "Must be a valid numeric ZIP+4 Code.");
		pause(3);
		clearTextFromTheField(zipCodeExt);
		inputText(zipCodeExt, "1001");
		pause(3);
		
		verifyLengthOfTheFieldContent(email, "74");			
		inputTextThenClickTab(email, "");
		pause(3);
		verifyErrorMsgUnderTheField(requiredFieldErrorMsgUnderTheField, "Required field.");
		pause(3);
		inputText(email, "mtks483@gmail.com");
		pause(3);
		
		verifyLengthOfTheFieldContent(confirmEmail, "74");			
		inputTextThenClickTab(confirmEmail, "");
		pause(3);
		verifyErrorMsgUnderTheField(requiredFieldErrorMsgUnderTheField, "Required field.");
		pause(3);
		inputText(confirmEmail, "amtks483@gmail.com");
		pause(3);
		verifyErrorMsgUnderTheField(mismatchEmailAddressErrorMsgUnderTheField, "Must match Email Address values.");
		clearTextFromTheField(confirmEmail);
		pause(3);
		inputText(confirmEmail, "mtks483@gmail.com");
		pause(3);
		
		verifyLengthOfTheFieldContent(phoneNumber, "12");	
		inputText(phoneNumber, "0929301602");
		verifyErrorMsgUnderTheField(phoneNumberNotStartWithErrorMsgUnderTheField, "Phone Number must not start with a 1 or 0.");
		pause(3);
		clearTextFromTheField(phoneNumber);
		pause(3);
		verifyErrorMsgUnderTheField(requiredFieldErrorMsgUnderTheField, "Required field.");
		pause(3);
		inputText(phoneNumber, "1929301602");
		verifyErrorMsgUnderTheField(phoneNumberNotStartWithErrorMsgUnderTheField, "Phone Number must not start with a 1 or 0.");
		pause(3);
		clearTextFromTheField(phoneNumber);
		pause(3);
		inputText(phoneNumber, "(3)*<>^9!#$+ ");
		pause(3);
		verifyErrorMsgUnderTheField(validPhoneNumberErrorMsgUnderTheField, "Must be a valid Phone Number.");
		clearTextFromTheField(phoneNumber);
		pause(3);
		inputText(phoneNumber, "ahsuchbs");
		pause(3);
		verifyErrorMsgUnderTheField(validPhoneNumberErrorMsgUnderTheField, "Must be a valid Phone Number.");
		clearTextFromTheField(phoneNumber);
		pause(3);
		inputText(phoneNumber, "9293016028");
		pause(5);		
		scrollIntoViewToTheElement(driver, "arguments[0].scrollIntoView(true);", nextButtonStep2);	
		clickElement(nextButtonStep2);
		pause(5);	
	}
	
	
	
	
	
	
	
	
	
	

}

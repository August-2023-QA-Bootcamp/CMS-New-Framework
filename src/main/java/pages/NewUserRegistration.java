package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Attribute;

import static common.CommonActions.*;

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
	
	@FindBy(id = "cms-newuser-usAddress2")
	WebElement addressLine2;
	
	@FindBy(id = "cms-newuser-usCity")
	WebElement city;
	
	@FindBy(id = "cms-newuser-usState")
	WebElement state;
	
	@FindBy(name = "cms-newuser-zipcode")
	WebElement zipCode;
	
	@FindBy(id = "cms-newuser-usZipcodeExt")
	WebElement zipCodeExt;
	
	@FindBy(id = "cms-newuser-usEmail")
	WebElement email;
	
	@FindBy(id = "cms-newuser-usConfirmEmail")
	WebElement confirmEmail;
	
	@FindBy(id = "cms-newuser-usPhoneNumber")
	WebElement phoneNumber;
	
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
		clickElement(agreeToTheTerms); // expected exception ditey hobe
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
		inputTextThenClickTab(firstName, "");
		pause(3);
		verifyErrorMsgUnderTheField(requiredFieldErrorMsgUnderTheField, "Required field.");
		pause(3);
		inputTextThenClickTab(firstName, "% & \\\" ( )");
		verifyErrorMsgUnderTheField(alphabeticCharactersErrorMsgUnderTheField, "Must be alphabetic characters.");
		pause(3);
		clearTextFromTheField(firstName);
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
		inputTextThenClickTab(lastName, "");
		verifyErrorMsgUnderTheField(requiredFieldErrorMsgUnderTheField, "Required field.");
		pause(3);
		inputTextThenClickTab(lastName, "% & \\\" ( )");
		verifyErrorMsgUnderTheField(alphabeticCharactersErrorMsgUnderTheField, "Must be alphabetic characters.");
		pause(3);
		clearTextFromTheField(lastName);
		pause(3);
		inputTextThenClickTab(lastName, "6573684765");
		verifyErrorMsgUnderTheField(alphabeticCharactersErrorMsgUnderTheField, "Must be alphabetic characters.");
		pause(3);
		clearTextFromTheField(lastName);
		pause(3);
		inputText(lastName, "S'- harkar");
		pause(5);
		selectDropdown(suffix, "SR");
		selectDropdown(birthMonth, "December");
		selectDropdown(birthDate, "31");
		selectDropdown(birthYear, "1990");
		pause(5);
		clickElement(nonUsBasedAddress);
		pause(5);
		clickElement(usBasedAddress);		
		scrollIntoViewToTheElement(driver, "arguments[0].scrollIntoView(true);", addressLine1);
		inputText(addressLine1, "61E 97th St");
		inputText(addressLine2, "Apt 4A");
		inputText(city, "New York");
		selectDropdown(state, "New York");
		inputText(zipCode, "10029");
		inputText(zipCodeExt, "2123");
		inputText(email, "mtks483@gmail.com");
		inputText(confirmEmail, "mtks483@gmail.com");
		inputText(phoneNumber, "9293016028");
		pause(5);
		clickElement(nextButtonStep2);
		pause(5);	
	}
	
	
	
	
	
	
	
	
	
	

}

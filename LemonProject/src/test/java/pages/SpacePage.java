package pages;

public class SpacePage extends BasePage{
    
    private String loginButton =        "//button[contains(text(),'Log in')]";

    private String datePicker =         "//*[@id='app']/div/section[1]/div[3]/div/div[1]/div";
    private String dayToSelect =        "/html/body/div[2]/div/div[2]/section/div/div/div/span/div/div[2]/div["+todayDate()+"]";
    private String datePickerOKButton = "//*[text()='Ok']";

    private String adultsDropDown =     "//div/div[3]";
    private String adultsOptions =      "//ul[@class='theme__values___1jS4g WhiteDropDown__values___3lOeL']/li"; 

    private String childrenDropDown =   "//div[4]";
    private String childrenOptions =    "//ul[@class='theme__values___1jS4g WhiteDropDown__values___3lOeL']/li";

   //A try-catch block could be added in the different methods 

    public SpacePage(){
        super(driver);
    }

    public void navigateToSpacepage(){
        navigateTo("https://demo.testim.io/");
     }
    
    public void clickLoginButton(){
        clickElement(loginButton);
    }

    public void selectDate(){
        clickElement(datePicker);
        clickElement(dayToSelect);
        clickElement(datePickerOKButton);
    }

    public void selectAdultPassanger(String number){
        selectOptionList(adultsDropDown, adultsOptions, number);
    }

    public void selectChildrenPassanger(String number){
        selectOptionList(childrenDropDown, childrenOptions, number);
    }

}

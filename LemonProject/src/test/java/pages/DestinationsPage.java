package pages;

public class DestinationsPage extends BasePage {

    private String dropDownLaunch =         "//*[@id='app']/div/section[2]/div[3]/div/div/div[1]/div/input";
    private String launchPlanetOptions =    "//ul[@class='theme__values___1jS4g']/li";

    private String bookButton =             "//*[@id='app']/div/section[2]/div[4]/div/div/div[1]/div[4]/button";

    private String planetPriceText =        "//span[contains(text(),'$')]";

    private String numberOfTravelersText =  "//div[contains(text(),'traveler')]";

    //A try-catch block could be added in the different methods 

    public DestinationsPage() {
        super(driver);
    }

    public void clickBookButton(){
        clickElement(bookButton);
    }

    public void selectLaunchPlanet(String planetName){
        selectOptionList(dropDownLaunch, launchPlanetOptions, planetName);
    }

    public float getPlanetPrice(){
        float price;

        price  = stringToFloat(textForElement(planetPriceText));

        return price;
    }

    public int getNumberOfTravelers(){
        int travelers;

        travelers = stringToInt(textForElement(numberOfTravelersText));

        return travelers;
    }


}

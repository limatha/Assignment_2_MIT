package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdvanceSearchPage {
    WebDriver driver;

    // Locators using @FindBy
    @FindBy(id = "_nkw") // Search input field
    WebElement keyWordsField;

    @FindBy(id = "s0-1-17-4[0]-7[1]-_in_kw") // Search button
    WebElement keyWordOptions;

    @FindBy(id = "_ex_kw") // Advance Search button
    WebElement excludeSearchField;

    @FindBy(id = "s0-1-17-4[0]-7[3]-_sacat") // Advance Search button
    WebElement categoryField;

    @FindBy(xpath = "/html/body/div[2]/div/main/form/fieldset[1]/div[5]/button") // Advance Search button
    WebElement searchButton;

    // Constructor to initialize elements
    public AdvanceSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to searchFor
    public void advanceSearchFor(String keyword) {
        keyWordsField.sendKeys(keyword);
        try {
            // Use the Select class to interact with the dropdown
            Select select = new Select(keyWordOptions);

            // Select by index (index starts at 0)
            select.selectByIndex(1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        excludeSearchField.sendKeys("phone");
        try {
            // Use the Select class to interact with the dropdown
            Select select = new Select(categoryField);

            // Select by index (index starts at 0)
            select.selectByIndex(6);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //Method to Advance searchFor
    public void advancedSearchClick() {
        searchButton.click();
    }

}

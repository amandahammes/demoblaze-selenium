package cucumber.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    @FindBy(xpath = "//*[contains(text(), 'monitores')]")
    public static WebElement monitores;

}

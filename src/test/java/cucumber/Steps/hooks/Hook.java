package cucumber.Steps.hooks;

import org.junit.After;
import org.junit.Before;

import static cucumber.TestBase.*;

public class Hook {
    @Before
    public void setUp(){
        String os = System.getProperty("os.name").toLowerCase();
        if(os.contains("win")) {
            getDriver().get(DIR_PATH);
        }
    }

    @After
    public void finish(){
        quitDriver();
    }
}

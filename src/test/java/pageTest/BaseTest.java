package pageTest;

import enums.BrowserType;
import helper.BrowserFabric;
import org.openqa.selenium.WebDriver;
import helper.GetScreenShot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected WebDriver driver;
    protected String username;
    protected String password;
    int tt=0;

    @Parameters({"username", "password","browser"})
    @BeforeMethod
    public void startUp(String username,String password,String browser) throws NoSuchMethodException {
        this.username = username;
        this.password = password;
        BrowserType browserType;
        if(browser.equals("Chrome")){
            browserType =BrowserType.CHROME;
        }else{
            browserType=BrowserType.FIREFOX;
        }
//        BrowserType browserType =browser.equals("Chrome")? BrowserType.CHROME : BrowserType.FIREFOX;
        driver = BrowserFabric.getDriver(browserType);
    }

    @AfterMethod

    public void tearDown(ITestResult iTestResult){
        if(iTestResult.getStatus()==iTestResult.FAILURE){
            GetScreenShot.capture(driver,iTestResult.getName());
        }else{
            String sMethodName = "result";
            Long lExecutionTime;
            sMethodName = iTestResult.getMethod().getMethodName().toString();
            lExecutionTime = (iTestResult.getEndMillis() - iTestResult.getStartMillis()) / 1000;
            System.out.println(sMethodName + " execution Time is : " + lExecutionTime + "sec.");
        }
        driver.quit();
    }

}

package Utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShotUtility {
    public static void takeScreenshot(WebDriver driver, String imageName) throws IOException {
            File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcfile,new File("Screenshots/" + imageName));
    }
}

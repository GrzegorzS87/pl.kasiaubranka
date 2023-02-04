package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

public class MyExtentReports {

    private static ExtentSparkReporter reporter;
    private static ExtentReports reports;
    private int fileNumber = 0;

    public MyExtentReports(){
        reporter = new ExtentSparkReporter("index.html");
        reports = new ExtentReports();
        reports.attachReporter(reporter);

        File directory = new File("src/test/resources/scrnSht/");
        try{
            FileUtils.cleanDirectory(directory);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void toPass(boolean status, String message, WebDriver driver){
        ExtentTest test = reports.createTest(message);
        String fileName = message.toLowerCase(Locale.ROOT)
                .trim()
                .replaceAll("[^A-Za-z0-9]", "");

        if(status){
            test.log(Status.PASS, "test pass",takeScreenShot(fileName,driver));
        }
        else test.log(Status.FAIL,"test fail");
    }

    public void toFail(boolean state, String message, WebDriver driver){
        toPass(!state, message, driver);
    }

    public void flush(){
        reports.flush();
    }

    private static Media takeScreenShot(String filename, WebDriver driver)  {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File file = screenshot.getScreenshotAs(OutputType.FILE);
        String path = "src/test/resources/scrnSht/" + filename + ".png";
        try{
            FileUtils.copyFile( file, new File( path ) );
        }catch (IOException e){
            e.printStackTrace();
        }
        return MediaEntityBuilder.createScreenCaptureFromPath(path).build();
    }
}

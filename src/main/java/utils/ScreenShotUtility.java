package utils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class ScreenShotUtility {

    private static final String SCREENSHOT_DIR = "screenshots/";


    public static void captureScreenShot(WebDriver driver, String fileName){
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("\"yyyyMMdd_HHmmss\"").format(new Date());
        File destination = new File("screenshots/" + fileName + "_" + timestamp + ".png");
        try {
            Files.createDirectories(destination.getParentFile().toPath());
            Files.copy(screenshot.toPath(), destination.toPath());
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    public static void cleanScreenshotFolder(){
        File folder = new File(SCREENSHOT_DIR);
        if(folder.exists() && folder.isDirectory()){
            for(File file : Objects.requireNonNull(folder.listFiles())){
                file.delete();
            }
        }
    }
}

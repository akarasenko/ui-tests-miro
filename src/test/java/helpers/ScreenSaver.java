package helpers;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class ScreenSaver {

    public static String takeScreenshot(WebDriver driver, String fileName) {
        File tempFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String folderPath = new File("").getAbsolutePath() + File.separator + "screenshots";

        File vsFile = new File(folderPath);
        if (!vsFile.exists()) {
            vsFile.mkdir();
        }

        File screen = new File(folderPath + File.separator + fileName + ".png");

        try {
            Files.move(tempFile.toPath(), screen.toPath(), REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return screen.toString();
    }
}

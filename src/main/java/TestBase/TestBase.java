package TestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

    public static Properties prop;
    public static WebDriver driver;

    public TestBase() {
        prop = new Properties();
        FileInputStream ip = null;

        try {
            ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\Config\\Config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Initializing()  {
        String osname = System.getProperty("os.name");
        System.out.println(osname);
        if (osname.contains("Windows")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "Executable\\geckodrivernew.exe");
            driver = new FirefoxDriver();
        } else if (osname.contains("Mac")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//Executable//geckodriverMac.exe");
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
            driver.get(prop.getProperty("url"));



        }
    }




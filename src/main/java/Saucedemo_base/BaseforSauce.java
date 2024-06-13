package Saucedemo_base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseforSauce {

	public static WebDriver driver;
	public static Properties props;

	public static void initialization() {
		props = new Properties();
		String srcPath = System.getProperty("user.dir");
		try {
			FileInputStream file = new FileInputStream(srcPath + "\\src\\main\\java\\config\\config.properties");
			props.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		String browser = props.getProperty("browser");
		String url = props.getProperty("url");

		if (browser.equals("chrome")) {

//			System.setProperty("webdriver.chrome.driver", srcPath + "\\driver\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals(("FireFox"))) {

//			System.setProperty("webdriver.gecko.driver", srcPath + "\\driver\\chromedriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		int waittime = Integer.parseInt(props.getProperty("Implicitwait"));
		int loadtime = Integer.parseInt(props.getProperty("pageloadtime"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.get(url);

	}

	public static void teardown() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}

}

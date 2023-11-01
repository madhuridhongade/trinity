package com.testingshashtra.utilities;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebElement;

import com.testingshashtra.TestBase;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
public class ScreenShot {
	
	public void captureFullPageScreenshot(String filename) throws IOException {
		AShot ashot = new AShot();
		BufferedImage img = ashot.shootingStrategy(ShootingStrategies.viewportPasting(3000)).takeScreenshot(TestBase.getDriver()).getImage();
	
		String baseDir = System.getProperty("user.dir");
		ImageIO.write(img, "png", new File(baseDir+"\\src\\main\\resources\\failedtestscreenshots\\"+filename+"failed.png"));
	}
	
	public void captureElementScreenshot(WebElement element) {
		

	}

}

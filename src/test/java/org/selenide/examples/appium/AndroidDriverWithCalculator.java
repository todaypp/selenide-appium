package org.selenide.examples.appium;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static org.openqa.selenium.remote.CapabilityType.APPLICATION_NAME;

@ParametersAreNonnullByDefault
public class AndroidDriverWithCalculator implements WebDriverProvider {
    @Override
    @CheckReturnValue
    @Nonnull
    public WebDriver createDriver(Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setPlatformName("Android");
        options.setDeviceName("Android Emulator");
        options.setPlatformVersion("9.0");
        options.setCapability(APPLICATION_NAME, "Appium");
        options.setAppPackage("com.android.calculator2");
        options.setAppActivity("com.android.calculator2.Calculator");
        options.setNewCommandTimeout(Duration.ofSeconds(11));
        options.setFullReset(false);

        //Create AndroidDriver instance and connect to the Appium server.
        //It will launch the Calculator App in Android Device using the configurations specified in Desired Capabilities

        try {
            return new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}

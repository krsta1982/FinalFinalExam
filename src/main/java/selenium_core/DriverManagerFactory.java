package selenium_core;

public class DriverManagerFactory {
    public static DriverManager getDriverManager(DriverType type) {
        DriverManager driverManager;

        if (type == DriverType.FIREFOX) {
            driverManager = new FirefoxDriverManager();
        }
        else {
            driverManager = new ChromeDriverManager();
        }
        return driverManager;
    }
}

package utils;

public class SystemProperty {

    public static String readProperty() {
        return System.getProperty("selenoidUrl");
    }
}

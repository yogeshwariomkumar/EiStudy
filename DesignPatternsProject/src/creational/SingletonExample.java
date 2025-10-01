package creational;

// Singleton class
class ConfigurationManager {
    private static ConfigurationManager instance;
    private String config;

    // Private constructor prevents instantiation from other classes
    private ConfigurationManager() {
        config = "Default Configuration";
    }

    // Thread-safe lazy initialization
    public static synchronized ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }
}

// Main class
public class SingletonExample {
    public static void main(String[] args) {
        ConfigurationManager cm1 = ConfigurationManager.getInstance();
        ConfigurationManager cm2 = ConfigurationManager.getInstance();

        System.out.println("Config of cm1: " + cm1.getConfig());
        System.out.println("Config of cm2: " + cm2.getConfig());

        cm1.setConfig("Updated Configuration");

        System.out.println("After updating cm1:");
        System.out.println("Config of cm1: " + cm1.getConfig());
        System.out.println("Config of cm2: " + cm2.getConfig());
    }
}

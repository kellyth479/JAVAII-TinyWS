import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import java.io.File;
/**
 * Process webserver configuration
 * @author student name
 */
public class Config {
    public static final String PORT = "port";
    public static final String DEFAULTPAGE = "defaultPage";
    public static final String DEFAULTFOLDER = "defaultFolder";

    private static final String CONFIG_FILE = "./TinyWS.xml";
    private static Properties properties;

    public Config() {
        // TODO code here
        this.properties = null;
//        try{
//            readProperties();
//        }catch(IOException e){
//            System.out.println("Config Constructor Error: ");
//            e.printStackTrace();
//        }

    }


    /**
     *public void readProperties()
     * @throws IOException
     * Opens this.CONFIG_FILE and parses the contents into its properties data element
     */
    public void readProperties() throws IOException {
        // TODO code here
        try{
            File file = new File(CONFIG_FILE);
            FileInputStream fileInput = new FileInputStream(file);
//            Properties properties = new Properties();
            properties.loadFromXML(fileInput);
            fileInput.close();

        }catch (FileNotFoundException e){
            System.out.println("File Not Found");
            TinyWS tiny = new TinyWS();
            tiny.fatalError(e);
        }catch(IOException e){
//            e.printStackTrace();
            TinyWS tiny = new TinyWS();
            tiny.fatalError(e);
        }

    }

    /**
     *
     * @param key
     * @return
     */
    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public void dumpProperties() {
        // TODO code here
        Enumeration enuKeys = properties.keys();
        while(enuKeys.hasMoreElements()){
            String key = (String) enuKeys.nextElement();
            String value = properties.getProperty(key);
            System.out.println(key + ": " + value);
        }

        System.out.println("FACEFACEFACEFACE");
        String port = properties.getProperty(PORT);
        String folder = properties.getProperty(DEFAULTFOLDER);
        String page = properties.getProperty(DEFAULTPAGE);
        System.out.println(PORT + ": " + port);
        System.out.println(DEFAULTFOLDER + ": " + folder);
        System.out.println(DEFAULTPAGE + ": " + page);
    }
}

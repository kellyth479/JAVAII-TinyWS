import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import java.io.File;
/**
 * Process webserver configuration
 * @author Thomas Kelly
 * Config class parses the Config file located at ./TinyWS.xml
 * Provides the port, default page and default folder in the config file via parsing the xml using the Properties loadXML(File) method
 * Will also dump these properties to the screen
 */
public class Config {
    public static final String PORT = "port";
    public static final String DEFAULTPAGE = "defaultPage";
    public static final String DEFAULTFOLDER = "defaultFolder";

    private static final String CONFIG_FILE = "TinyWS.xml";
    private static Properties properties;

    public Config() {
        // TODO code here
        this.properties = new Properties();
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
            System.out.println("Working Directory = " +
                    System.getProperty("user.dir"));
            File file = new File(CONFIG_FILE);
            System.out.print("CONFIG_FILE: ");
            System.out.println(CONFIG_FILE);
            if(!file.exists()){
                System.out.println("FILE DOES NOT EXIST!");
            }else {
                FileInputStream fileInput = new FileInputStream(file);
         //                   Properties properties = new Properties();
                properties.loadFromXML(fileInput);
                fileInput.close();
            }
        }catch (FileNotFoundException e){
            System.out.println("File Not Found in readProperties: ");
            TinyWS.fatalError(e);
        }catch(IOException e){
//            e.printStackTrace();
            TinyWS.fatalError(e);
        }
//        catch(NullPointerException e){
//            e.printStackTrace();
//        }

    }


    //Where do we handle to make sure that this function is only requested the keys port/defaultpage/defualtfolder???
    //What does this return if something other than one of these keys is passed in?
    /**
     *public String getProperty(String key)
     * @param key
     * @return The string value of either the port, default page or default folder
     */
    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    /**
     *  public void dumpProperties()
     *  Dumps the properties in this.properties to console
     *  Uses Enumeration as well as using the getProperty function
     */
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

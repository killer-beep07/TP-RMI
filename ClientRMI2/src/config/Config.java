
package config;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;




public class Config {
    public  static String ip;
    public static String port;
    private static Config config;//objet
    static{
        FileInputStream f = null;
        try{
            f = new FileInputStream("configuration.properties");
            Properties p = new Properties();
            p.load(f);
            config.ip=p.getProperty("ip");
             config.port=p.getProperty("port");
        } catch (IOException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                f.close();
            } catch (IOException ex) {
                Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static Config getConfig(){
        return config;
    }
}


package app.config;

import org.javalite.activeweb.AbstractDBConfig;
import org.javalite.activeweb.AppContext;

public class DbConfig extends AbstractDBConfig {

    public void init(AppContext context) {
        configFile("/database.properties");
        environment("production").jndi("jdbc/demo_production"); 
    }
}

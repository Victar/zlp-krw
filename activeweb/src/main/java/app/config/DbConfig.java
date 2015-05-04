package app.config;

import org.javalite.activeweb.AbstractDBConfig;
import org.javalite.activeweb.AppContext;

public class DbConfig extends AbstractDBConfig {

    public void init(AppContext context) {

        environment("development").jdbc("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/demo", "root", "root");
        
        environment("development").testing().jdbc("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/demo", "root", "root");

        environment("production").jndi("jdbc/demo");
    }
}

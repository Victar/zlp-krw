package app.config;

import org.javalite.activeweb.AbstractControllerConfig;
import org.javalite.activeweb.AppContext;
import org.javalite.activeweb.controller_filters.DBConnectionFilter;
import org.javalite.activeweb.controller_filters.TimingFilter;

import app.controllers.JsonController;
import app.controllers.PeopleController;

public class AppControllerConfig extends AbstractControllerConfig {

    public void init(AppContext context) {
        addGlobalFilters(new TimingFilter());
        add(new DBConnectionFilter()).to(PeopleController.class, JsonController.class);
    }
}

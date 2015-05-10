package app.controllers;

import org.javalite.activeweb.DBControllerSpec;
import org.junit.Test;

public class PeopleControllerSpec extends DBControllerSpec {

    @Test
    public void shouldShowHomePage() {
        request().integrateViews().get("index");
        a(statusCode()).shouldBeEqual(200);
    }

}
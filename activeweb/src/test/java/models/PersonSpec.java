package models;

import org.javalite.activeweb.DBSpec;
import org.junit.Test;

import app.models.Person;

public class PersonSpec extends DBSpec{
	
	@Test
	public void shouldValidatePresenceOfAttrbute(){
		Person p = new Person();
		a(p).shouldNotBe("valid");
		p.set(Person.FIELD_FIRST_NAME, "John", Person.FIELD_LAST_NAME , "Doe");
		a(p).shouldBe("valid");
	}

}

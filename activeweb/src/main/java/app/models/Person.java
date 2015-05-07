package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

@Table(value =Person.TABLE_NAME)
public class Person extends Model {
	
	public static final String TABLE_NAME = "persons";
	
	public static final String FIELD_FIRST_NAME = "first_name";
	public static final String FIELD_LAST_NAME = "last_name";
	public static final String FIELD_EMAIL = "email";
	public static final String FIELD_ADDRESS = "address";

	public Person() {
	}

	public Person(String firstName, String lastName) {
		set(FIELD_FIRST_NAME, firstName, FIELD_LAST_NAME, lastName);
	}
}

package app.controllers;

import java.util.List;

import org.javalite.activejdbc.LazyList;
import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.RESTful;

import app.models.Person;

@RESTful @SuppressWarnings("unchecked")
public class JsonController  extends AppController {
    
	public void index(){
    	LazyList<Person> people = Person.findAll();
        String peopleJson = people.toJson(true, Person.FIELD_FIRST_NAME, Person.FIELD_LAST_NAME, Person.FIELD_ADDRESS);
        respond(peopleJson).contentType("application/json").status(200);
    }
    
    public void show(){

        List<Person> people = Person.where("id = ?", getId());
        if(people.size() == 0)
            throw  new RuntimeException("could not find person with id: " + getId()); //catch by filter

        Person person = people.get(0);
        String personJson = person.toJson(true, Person.FIELD_FIRST_NAME, Person.FIELD_LAST_NAME, Person.FIELD_ADDRESS);
        respond(personJson).contentType("application/json").status(200);
    }
    

}

package app.controllers;

import java.util.List;

import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.POST;

import app.models.Person;

public class PeopleController  extends AppController {

    public void index(){
    	List <Person> people = Person.findAll().orderBy(Person.FIELD_LAST_NAME);
    	view("people", people);
    }
    
    public void angular(){
    	List <Person> people = Person.findAll().orderBy(Person.FIELD_LAST_NAME);
    	view("people", people);
    	render().noLayout();
    }
    
    public void newForm(){
    	
    }
    
    @POST
    public void create(){
    	Person p = new Person();
    	p.fromMap(params1st());
    	if (p.save()){
    		redirect(PeopleController.class);
    	}else{
    		view("errors",p.errors());
    		render("new_form");
    	}
    }
    

}

package app.controllers;

import java.util.List;
import java.util.Map;

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
    
    public void sample(){
    	render().noLayout();

    }
    
    
    public void newForm(){
    	
    }
    
    @POST
    public void create(){
    	Person p = new Person();
    	p.fromMap(params1st());
//    	Map<String, String[]> map = params();
//    	for (Map.Entry<String, String[]> mapEntity : map.entrySet()){
//    		logInfo(mapEntity.getKey());
//    		String[] mapEnrtyValue = mapEntity.getValue();
//    		for (String s: mapEnrtyValue){
//    			logInfo(" " + s);
//    		}
//    	}
    	if (p.save()){
    		//ToDo send correct success
    		redirect(PeopleController.class);
    	}else{
    		//ToDo send correct failure
    		view("errors",p.errors());
    		render("new_form");
    	}
    }
    

}

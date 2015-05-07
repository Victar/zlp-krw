package app.controllers;

import org.javalite.activeweb.AppController;

import app.models.Person;

public class HomeController extends AppController {
	
    public void index(){
    	view("persons", Person.findAll());
    }
}

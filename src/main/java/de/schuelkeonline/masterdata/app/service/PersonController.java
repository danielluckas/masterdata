package de.schuelkeonline.masterdata.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.schuelkeonline.masterdata.app.bean.Person;
import de.schuelkeonline.masterdata.app.db.PersonRepository;

@Controller // assumes @ResponseBody annotation in methods annotated with  @RequestMapping
@RequestMapping(value = "/person")
public class PersonController {
 
    @Autowired
    protected PersonRepository personRepository;
 
    
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAllPersons(Model model) {
    	
    	Iterable<Person> allPersons = personRepository.findAll();
    	model.addAttribute("allpersons", allPersons);
        return "/personList"; // uses the findAll() method inherited from CrudRepository
    }
    
    @RequestMapping(value = "/{userid}", method=RequestMethod.GET)
    public String getPerson(@PathVariable Long userid, Model model) {
    	
    	Person person = personRepository.findOne(userid);
    	model.addAttribute("person", person);
        return "/editPerson"; // uses the findAll() method inherited from CrudRepository
    }
    
    @RequestMapping(value="/{userid}", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute Person newPerson, @PathVariable Long userid,Model model) {
    	Person person = personRepository.findOne(userid);
    	
    	person.setFirstname(newPerson.getFirstname());
    	person.setLastname(newPerson.getLastname());
    	person.setUsername(newPerson.getUsername());
    	
    	personRepository.save(person);
    	
    	model.addAttribute("person", person);

        return "/editPerson";
    }
}
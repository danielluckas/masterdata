package de.schuelkeonline.masterdata.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.schuelkeonline.masterdata.app.bean.User;
import de.schuelkeonline.masterdata.app.db.UserRepository;

@RestController // assumes @ResponseBody annotation in methods annotated with  @RequestMapping
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
 
    @Autowired
    protected UserRepository userRepository;
 
    @RequestMapping
    public Iterable<User> persons() {
        return userRepository.findAll(); // uses the findAll() method inherited from CrudRepository
    }
}
package teksystems.casestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import teksystems.casestudy.database.dao.UserDAO;
import teksystems.casestudy.database.entity.User;
import teksystems.casestudy.formbean.RegisterFormBean;

import javax.validation.Valid;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class UserController {

    @Autowired
    private UserDAO userDao;

//    This is the controller method for the entry point of the user registration pate. It does not do anything other than provide a route to the register.jsp page
    @RequestMapping(value = "/user/register", method = RequestMethod.GET)
    public ModelAndView register() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/register");

        // Preseeding the form
        RegisterFormBean form = new RegisterFormBean();
        response.addObject("form", form);

        return response;
    }

    // This method now becomes a create and an edit based on if the user id is populated in the registerFormBean
    @RequestMapping(value = "/user/registerSubmit", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView registerSubmit(@Valid RegisterFormBean form, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();

        log.info(form.toString());


        if (bindingResult.hasErrors() ) {

            List<String> errorMessages = new ArrayList<>();
            for ( ObjectError error : bindingResult.getAllErrors()) {
                errorMessages.add(error.getDefaultMessage());
                log.info( ((FieldError) error).getField()  + " " + error.getDefaultMessage() );
            }

            response.addObject("form", form);

            response.addObject("bindingResult", bindingResult);

            // because there is one or more error we do not want to process the logic below
            // that will creat a new user in the database we want to show the same model that we are already on
            response.setViewName("/user/register");
            return response;
        }

        // first try to load the user from the database using the incoming id on the form
        User user = userDao.findById(form.getId());

        //now if the id from the database is null then it is a create
        if ( form.getId() == null ) {

            user = new User();

        }

        user.setEmail(form.getEmail());
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setPassword(form.getPassword());

        userDao.save(user);

        log.info(form.toString());

        // Will send us to the edit page for this user which will be responsible for loading the user from the database and rendering the info
        // When you use redirect: it tells spring to redirect page, uses an actual URL rather than a view name path
        response.setViewName("redirect:/user/edit/" + user.getId());

        return response;
    }

    @GetMapping("/user/edit/{userId}")
//    @RequestMapping(value = "/user/edit/{userId}", method = RequestMethod.POST)
    public ModelAndView editUser(@PathVariable("userId") Integer userId) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/register");

        User user = userDao.findById(userId);

        RegisterFormBean form = new RegisterFormBean();

        form.setId(user.getId());
        form.setEmail(user.getEmail());
        form.setFirstName(user.getFirstName());
        form.setLastName(user.getLastName());
        form.setPassword(user.getPassword());
        form.setConfirmPassword(user.getPassword());

        response.addObject("form", form);

        return response;
    }

    @RequestMapping(value  = "/user/search", method = RequestMethod.POST )
    public ModelAndView search( @RequestParam (required = false) String searchFirstName ) {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/search");

        // Create a new array list to hold the list of users
        List<User> users = new ArrayList<>();

        if ( searchFirstName != null && !searchFirstName.isBlank()) {
            // Query the database for that name
            users = userDao.findByFirstNameIgnoreCaseContaining(searchFirstName);
        }

        // Adds user list to model
        response.addObject("users", users);

        // Adds the search value to the model
        response.addObject("searchFirstName", searchFirstName);

        return response;
    }


}

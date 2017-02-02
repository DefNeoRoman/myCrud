package roman.controller;


import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import roman.entity.User;
import roman.service.UserService;

import java.util.List;

@Controller
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class);
    private int start;
    private int countItems =10;

    private int end;
    @Autowired
    private UserService userService;

    @RequestMapping(value="/")
    public ModelAndView listOfUsers(@RequestParam(required = false) Integer page) {
        logger.info("Getting all Users.");
        ModelAndView modelAndView = new ModelAndView("userList");
        List<User> users = userService.getAllUsers();
        int mpages = (int) Math.ceil((double)users.size()/(double)countItems);
        Double realPages = Math.ceil(users.size()/10);
        int countOfUsers = users.size();
        modelAndView.addObject("countOfUsers", countOfUsers);
        modelAndView.addObject("maxPages", mpages);

           if (page == null || page == 1){
               start = 0;
               end = countItems;
               modelAndView.addObject("userList", userService.getLimitUsers(start,end));
           } else  {
               start = (page-1)*countItems;
               end = countItems;
               modelAndView.addObject("userList", userService.getLimitUsers(start,end));
           }

        return modelAndView;
    }

    @RequestMapping("createUser")
    public ModelAndView createUser(@ModelAttribute User user) {
        logger.info("Creating User. Data: "+user);
        return new ModelAndView("userForm");
    }
    @RequestMapping("editUser")
    public ModelAndView editUser(@RequestParam int id, @ModelAttribute User user) {
        logger.info("Updating the User for the Id "+id);
        user = userService.getUser(id);
        return new ModelAndView("userForm", "userObject", user);
    }
    @RequestMapping("saveUser")
    public ModelAndView saveUser(@ModelAttribute User user) {
        logger.info("Saving the User. Data : "+user);
        if(user.getId() == 0){ // if user id is 0 then creating user other updating user
            userService.createUser(user);
        } else {
            userService.updateUser(user);
        }
        return new ModelAndView("redirect:/");
    }
    @RequestMapping("deleteUser")
    public ModelAndView deleteUser(@RequestParam int id)
    {
        logger.info("Deleting the User. Id : " + id);
        userService.deleteUser(id);
        return new ModelAndView("redirect:/");
    }
    @RequestMapping("searchUser")
    public ModelAndView searchUser(@RequestParam("searchName") String searchName){
        logger.info("Searching the User. User Names: "+searchName);
        List<User> usersList = userService.getAllUsers(searchName);

        return new ModelAndView("userList", "userList", usersList);
    }
}

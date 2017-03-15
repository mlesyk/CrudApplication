package usermanager.controller;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.web.servlet.ModelAndView;
import usermanager.model.User;
import usermanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    private UserService userService;
    int recordsPerPage = 10;

    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String listUsers(@RequestParam(value = "page", defaultValue = "0", required = false)
                                        int page, Model model) {
        List<User> resultList = userService.listUsers();
        PagedListHolder<User> usersPages = new PagedListHolder<User>(resultList);
        usersPages.setPageSize(recordsPerPage);
        usersPages.setPage(page);
        String nextPageRequest="?page=" + (page+1);
        String prevPageRequest="?page=" + (page-1);
        model.addAttribute("nextPageRequest",nextPageRequest);
        model.addAttribute("prevPageRequest",prevPageRequest);
        model.addAttribute("resultPages", usersPages);
        return "users";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchRequest(@RequestParam("name") String name,
                                       @RequestParam(value = "page", defaultValue = "0") int page,
                                       Model model) {
        List<User> resultList = userService.searchUsers(name);
        PagedListHolder<User> usersPages = new PagedListHolder<User>(resultList);
        usersPages.setPageSize(recordsPerPage);
        usersPages.setPage(page);
        String nextPageRequest="?name=" + name + "&page=" + (page+1);
        String prevPageRequest="?name=" + name + "&page=" + (page-1);
        model.addAttribute("nextPageRequest",nextPageRequest);
        model.addAttribute("prevPageRequest",prevPageRequest);
        model.addAttribute("resultPages", usersPages);
        return "search";
    }

    @RequestMapping(value = "/addForm", method = RequestMethod.GET)
    public ModelAndView addForm() {
        return new ModelAndView("addForm","command", new User());
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user) {
            userService.addUser(user);
        return "redirect:/users";
    }

    @RequestMapping(value = "/remove/{id}")
    public String removeUser(@PathVariable("id") int id) {
        userService.removeUser(id);
        return "redirect:/users";
    }

    @RequestMapping(value = "/edit/{id}")
    public ModelAndView edit(@PathVariable int id){
        User user=userService.getUserById(id);
        return new ModelAndView("editForm","command", user);
    }

    @RequestMapping(value="/editsave",method = RequestMethod.POST)
    public String editsave(@ModelAttribute("user") User user){
        userService.updateUser(user);
        return "redirect:/users";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception exception,Model model) {
        model.addAttribute("message", exception.getMessage());
        return "error";
    }
}
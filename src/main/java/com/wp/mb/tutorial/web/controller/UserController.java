package com.wp.mb.tutorial.web.controller;

import com.wp.mb.tutorial.model.User;
import com.wp.mb.tutorial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Marcio Ballem
 * Date: 10/10/12
 * Time: 14:59
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    //quando clicar no botao salvar, vem para este metodo
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveUser(@ModelAttribute("user") User user, BindingResult result) {
        userService.save(user);
        return new ModelAndView("redirect:/users.html");
    }

    //lista os users
    @SuppressWarnings("SpringMVCViewInspection")
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listUsers() {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("users", userService.findAll());

        return new ModelAndView("userList", model);
    }

    //a pagina abre aqui quando vem do index
    @SuppressWarnings("SpringMVCViewInspection")
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addArticle(@ModelAttribute("user") User user, BindingResult result) {
        return new ModelAndView("userAdd");
    }
}

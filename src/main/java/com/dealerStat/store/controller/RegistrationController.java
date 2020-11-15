package com.dealerStat.store.controller;

import com.dealerStat.store.dto.TraderDto;
import com.dealerStat.store.model.RoleEnum;
import com.dealerStat.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationController {
    @Autowired
    private UserService service;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String register(Model model) {
        TraderDto dto = new TraderDto();
        model.addAttribute("usr", dto);
        return "main/registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String register(@ModelAttribute TraderDto dto, BindingResult errors, Model model) throws Exception {
        dto.setRoleName(RoleEnum.ROLE_TRADER);
        if (service.getByEmail(dto.getEmail()) == null) {
            userService.add(dto);
        }
        return "redirect:/login";
    }
}

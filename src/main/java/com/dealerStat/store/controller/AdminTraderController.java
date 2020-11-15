package com.dealerStat.store.controller;

import com.dealerStat.store.dto.TraderDto;
import com.dealerStat.store.model.RoleEnum;
import com.dealerStat.store.service.TraderService;
import com.dealerStat.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminTraderController {

    @Autowired
    private UserService service;

    @Autowired
    private TraderService traderService;

    @RequestMapping(value = "/addTrader", method = RequestMethod.GET)
    public String addTrader(Model model) {
        TraderDto dto = new TraderDto();
        model.addAttribute("trader", dto);
        return "admin/addTrader";
    }

    @RequestMapping(value = "/addTrader", method = RequestMethod.POST)
    public String addTrader(@ModelAttribute TraderDto dto, BindingResult errors, Model model) throws Exception {
        service.add(dto);
        if (service.getByEmail(dto.getEmail()) == null) {
            dto.setRoleName(RoleEnum.ROLE_TRADER);
        }
        return "redirect:/trader/traders";
    }

    @RequestMapping(value = "/deleteTrader", method = RequestMethod.GET)
    public String deleteTrader(@RequestParam(value = "id", required = false) Long id, Model model) {
        if (id != null) {
            TraderDto dto = traderService.getById(id);
            traderService.delete(dto);
        }
        List<TraderDto> traders = traderService.allTraders();
        model.addAttribute("traders", traders);
        return "admin/deleteTrader";
    }

    @RequestMapping(value = "/deleteTrader", method = RequestMethod.POST)
    public String deleteTrader(@ModelAttribute TraderDto dto, BindingResult errors, Model model) throws Exception {
        traderService.delete(dto);
        return "redirect:/admin/traders";
    }
}

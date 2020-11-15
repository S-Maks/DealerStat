package com.dealerStat.store.controller;

import com.dealerStat.store.dto.GeneralUserDto;
import com.dealerStat.store.service.TraderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/trader")
public class TraderController {

    @Autowired
    private TraderService traderService;

    @RequestMapping(value = "/traders", method = RequestMethod.GET)
    public String allTraders(Model model) {
        List<GeneralUserDto> sellers = traderService.getGeneralTradersInfo();
        model.addAttribute("traders", sellers);
        return "trader/traders";
    }
}

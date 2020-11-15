package com.dealerStat.store.controller;

import com.dealerStat.store.dto.TraderDto;
import com.dealerStat.store.model.RoleEnum;
import com.dealerStat.store.service.TraderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private TraderService traderService;

    @RequestMapping(value = "/blockTrader", method = RequestMethod.GET)
    public String blockTrader(@RequestParam(value = "id", required = false) Long id, Model model) {
        if (id != null) {
            TraderDto dto = traderService.getById(id);
            dto.setRoleName(RoleEnum.ROLE_BLOCKED);
            traderService.edit(dto);
        }
        List<TraderDto> sellers = traderService.allTraders();
        model.addAttribute("traders", sellers);
        return "admin/blockTrader";
    }
}

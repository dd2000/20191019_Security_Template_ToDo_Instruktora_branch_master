package com.j24.security.template.controller;

import com.j24.security.template.model.Account;
import com.j24.security.template.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.management.openmbean.CompositeData;
import java.util.List;

@Controller
@RequestMapping(path = "/admin/account/")
@PreAuthorize(value = "hasRole('ADMIN')")
public class AdminAccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/list")
    public String getUserList(Model model) {
        List<Account> accountList = accountService.getAll();
        model.addAttribute("accounts", accountList);
        return "account-list";
    }

    @GetMapping("/remove")
    public String remove(@RequestParam("accountId") Long id) {
        accountService.removeAccount(id);

        return "redirect:/admin/account/list";
    }

    @GetMapping("/toggleLock")
    public String toggleLock(@RequestParam("accountId") Long id) {
        accountService.toggleLock(id);

        return "redirect:/admin/account/list";
    }
}

package com.example.jsdengluprovider.web;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/guest")
public class GuestController {
    /**
     * 游客界面;
     *
     * @return
     */
    @RequestMapping("/guest")
    public String guest() {
        return "guest";
    }
}

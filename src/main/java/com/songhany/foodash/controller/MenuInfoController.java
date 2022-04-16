package com.songhany.foodash.controller;

import com.songhany.foodash.entity.MenuItem;
import com.songhany.foodash.entity.Restaurant;
import com.songhany.foodash.service.MenuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

import java.util.List;

@Controller
public class MenuInfoController {

    @Autowired
    private MenuInfoService menuInfoService;

    // /restaurant
    @RequestMapping(value = "/restaurants", method = RequestMethod.GET)
    @ResponseBody
    public List<Restaurant> getRestaurants() {
        return menuInfoService.getRestaurants();
    }

    // /restaurant/123/menu
    @RequestMapping(value = "/restaurant/{restaurantId}/menu", method = RequestMethod.GET)
    @ResponseBody
    public List<MenuItem> getMenus(@PathVariable(value = "restaurantId") int restaurantId) {
        return menuInfoService.getAllMenuItem(restaurantId);
    }
}



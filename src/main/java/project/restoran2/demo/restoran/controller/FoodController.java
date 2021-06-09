package project.restoran2.demo.restoran.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import project.restoran2.demo.restoran.model.menu.ComparatorTest;
import project.restoran2.demo.restoran.model.menu.DrinkMenu;
import project.restoran2.demo.restoran.model.menu.FoodMenu;
import project.restoran2.demo.restoran.service.RestoranService;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/food")
public class FoodController {

    private final RestoranService<FoodMenu> restoranService;

    @Autowired
    public FoodController(RestoranService<FoodMenu> restoranService) {
        this.restoranService = restoranService;
    }

    @GetMapping
    public String showMenuFood(Model model) {
        List<FoodMenu> foodList = restoranService.getAllList();
        Collections.sort(foodList, new ComparatorTest());
        model.addAttribute("food", foodList);
        return "menu/food-page";
    }

    @GetMapping("/new")
    public String formForFood(Model model) {
        FoodMenu foodMenu = new FoodMenu();
        model.addAttribute("formFood", foodMenu);
        return "menu/add-food-page";
    }

    @PostMapping
    public String createFood(@ModelAttribute("formFood") @Valid FoodMenu foodMenu, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "menu/add-food-page";
        }
        restoranService.save(foodMenu);
        return "redirect:/food";

    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        restoranService.deleteById(id);
        return "redirect:/food";
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable("id") int id, Model model) {
        FoodMenu foodMenu = restoranService.findById(id);
        model.addAttribute("food", foodMenu);
        return "menu/update-food-page";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("food") @Valid FoodMenu foodMenu, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "menu/update-food-page";
        }

        restoranService.save(foodMenu);
        return "redirect:/food";
    }

}

package project.restoran2.demo.restoran.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import project.restoran2.demo.restoran.model.menu.ComparatorTest;
import project.restoran2.demo.restoran.model.menu.DrinkMenu;
import project.restoran2.demo.restoran.service.RestoranService;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/drinks")
public class DrinkController {

    private final RestoranService<DrinkMenu> restoranService;
    @Autowired
    public DrinkController(RestoranService<DrinkMenu> restoranService) {
        this.restoranService = restoranService;
    }

    @GetMapping
    public String showMenuDrinks(Model model) {
        List<DrinkMenu> drinkList = restoranService.getAllList();
        Collections.sort(drinkList, new ComparatorTest());
        model.addAttribute("drinks", drinkList);
        return "menu/drink-page";
    }

    @GetMapping("/new")
    public String formForDrink(Model model) {
       DrinkMenu drinkMenu = new DrinkMenu();
       model.addAttribute("formDrink", drinkMenu);
        return "menu/add-drink-page";
    }

    @PostMapping
    public String createDrink(@ModelAttribute("formDrink") @Valid DrinkMenu drinkMenu, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "menu/add-drink-page";
        }
        restoranService.save(drinkMenu);
        return "redirect:/drinks";

    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        restoranService.deleteById(id);
        return "redirect:/drinks";
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable("id") int id, Model model) {
        DrinkMenu drinkMenu = restoranService.findById(id);
        model.addAttribute("drink", drinkMenu);
        return "menu/update-drink-page";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("drink") @Valid DrinkMenu drinkMenu, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "menu/update-drink-page";
        }
        restoranService.save(drinkMenu);
        return "redirect:/drinks";
    }

}

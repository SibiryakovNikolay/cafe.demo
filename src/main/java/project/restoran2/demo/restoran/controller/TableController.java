package project.restoran2.demo.restoran.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import project.restoran2.demo.restoran.model.Tables;
import project.restoran2.demo.restoran.model.menu.DrinkMenu;
import project.restoran2.demo.restoran.service.RestoranService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TableController {
    private final RestoranService<Tables> restoranService;
    @Autowired
    public TableController(RestoranService<Tables> restoranService) {
        this.restoranService = restoranService;
    }
    @GetMapping("/reserved")
    public String showTableReserved(Model model){
        List<Tables> tablesList = restoranService.getAllList();
        model.addAttribute("tables", tablesList);
        return "table/table-reserved";
    }

    @GetMapping("/table")
    public String tableReserving(Model model) {
        Tables tables = new Tables();
        model.addAttribute("newTable", tables);
        return "table/add-table-page";
    }

    @PostMapping("/success")
    public String newReserve(@ModelAttribute("newTable") @Valid Tables tables, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "table/add-table-page";
        }
        tables.setConfirm("не подтверждено");
        restoranService.save(tables);
        return "redirect:/success";
    }
    @GetMapping("/success")
        public String successReserved(){
        return "table/success-page";
        }


    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable("id") int id, Model model){
        Tables table = restoranService.findById(id);
        model.addAttribute("table", table);
        return "table/update-table-page";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("table") Tables table){
        restoranService.save(table);
        return "redirect:/reserved";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        restoranService.deleteById(id);
        return "redirect:/reserved";
    }

}



package project.demo.restoran.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import project.demo.restoran.service.RestoranService;
import project.demo.restoran.model.Review;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/reviews")
public class ReviewController {
    private final RestoranService<Review> reviewRestoranService;

    @Autowired
    public ReviewController(RestoranService<Review> reviewRestoranService) {
        this.reviewRestoranService = reviewRestoranService;
    }

    @GetMapping
    public String showReviews(Model modelforList, Model modelForForm) {
        List<Review> listReview = reviewRestoranService.getAllList();
        modelforList.addAttribute("reviews", listReview);
        Review review = new Review();
        modelForForm.addAttribute("formReview", review);
        return "review/review-page";
    }

    @PostMapping
    public String createReview(@ModelAttribute("formReview") @Valid Review review, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "review/review-page";
        }
        if(review.getGrade()==null){
            review.setGrade("не указана");
        }
        reviewRestoranService.save(review);
        return "redirect:/reviews";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        reviewRestoranService.deleteById(id);
        return "redirect:/reviews";
    }
}

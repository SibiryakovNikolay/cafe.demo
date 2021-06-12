package project.demo.restoran.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.demo.restoran.repository.ReviewRepo;
import project.demo.restoran.model.Review;

import java.util.List;
import java.util.Optional;
@Service
public class ReviewService implements RestoranService<Review> {

    private ReviewRepo reviewRepo;

    @Autowired
    public ReviewService(ReviewRepo reviewRepo) {
        this.reviewRepo = reviewRepo;
    }


    @Override
    public List<Review> getAllList() {
        List<Review> reviews = reviewRepo.findAll();
        return reviews;
    }

    @Override
    public void save(Review review) {
        reviewRepo.save(review);

    }

    @Override
    public void deleteById(int id) {
        reviewRepo.deleteById(id);
    }

    @Override
    public Review findById(int id) {
        Review review = null;
        Optional<Review> findId = reviewRepo.findById(id);
        if (findId.isPresent()) {
            review = findId.get();
        }
        return review;
    }
    }


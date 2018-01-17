package vn.plusplusc.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import vn.plusplusc.ecommerce.database.model.Review;
import vn.plusplusc.ecommerce.repository.ReviewRepository;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public Page<Review> findByProductId(long productId, int pageNumber, int pageSize) {
        return reviewRepository.findByProductId(productId, new PageRequest(pageNumber, pageSize));
    }

    public Review save(Review review) {
        return reviewRepository.save(review);
    }
}

package exercise.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import exercise.dto.ProductParamsDTO;
import exercise.model.Product;


// BEGIN
@Component
public class ProductSpecification {

    public Specification<Product> build(ProductParamsDTO params) {
        return Specification.where(withCategoryId(params.getCategoryId()))
                .and(withPriceGt(params.getPriceGt()))
                .and(withPriceLt(params.getPriceLt()))
                .and(withRatingGt(params.getRatingGt()))
                .and(withTitleContaining(params.getTitleCont()));
    }

    private Specification<Product> withCategoryId(Long categoryId) {
        return (root, query, criteriaBuilder) -> {
            if (categoryId == null) {
                return criteriaBuilder.conjunction(); // фильтр не применяется
            }
            return criteriaBuilder.equal(root.get("category").get("id"), categoryId);
        };
    }

    private Specification<Product> withPriceGt(Integer priceGt) {
        return (root, query, criteriaBuilder) -> {
            if (priceGt == null) {
                return criteriaBuilder.conjunction(); // фильтр не применяется
            }
            return criteriaBuilder.greaterThan(root.get("price"), priceGt);
        };
    }

    private Specification<Product> withPriceLt(Integer priceLt) {
        return (root, query, criteriaBuilder) -> {
            if (priceLt == null) {
                return criteriaBuilder.conjunction(); // фильтр не применяется
            }
            return criteriaBuilder.lessThan(root.get("price"), priceLt);
        };
    }

    private Specification<Product> withRatingGt(Double ratingGt) {
        return (root, query, criteriaBuilder) -> {
            if (ratingGt == null) {
                return criteriaBuilder.conjunction(); // фильтр не применяется
            }
            return criteriaBuilder.greaterThan(root.get("rating"), ratingGt);
        };
    }

    private Specification<Product> withTitleContaining(String titleCont) {
        return (root, query, criteriaBuilder) -> {
            if (titleCont == null || titleCont.trim().isEmpty()) {
                return criteriaBuilder.conjunction(); // фильтр не применяется
            }
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("title")), "%" + titleCont.trim().toLowerCase() + "%");
        };
    }
}
// END

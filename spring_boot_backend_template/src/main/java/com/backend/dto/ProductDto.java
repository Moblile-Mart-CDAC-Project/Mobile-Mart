package com.backend.dto;



import java.util.List;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
	   private Long productId;
	    private String name;
	    private String brand;
	    private String description;
	    private Double price;
	    private Integer stockQuantity;
	    private List<String> images;
}

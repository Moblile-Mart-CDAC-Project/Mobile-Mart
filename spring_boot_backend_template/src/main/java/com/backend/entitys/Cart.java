package com.backend.entitys;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
//@Table(name = "carts")
//@Getter @Setter
//@NoArgsConstructor @AllArgsConstructor
//public class Cart {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long cartId;
//
//    @OneToOne
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;
//
//    @OneToMany(mappedBy = "cart",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true)
//    private List<CartItem> items = new ArrayList<>();
//
//    private String status = "ACTIVE";
//
//    private LocalDateTime createdAt = LocalDateTime.now();
//
//    public Cart(User user) {
//        this.user = user;
//    }
//
//    public void clear() {
//        items.clear();
//        status = "CONVERTED";
//    }
//
//    public void addItem(Product product, int qty) {
//        for (CartItem i : items) {
//            if (i.getProduct().getProductId().equals(product.getProductId())) {
//                i.setQuantity(i.getQuantity() + qty);
//                return;
//            }
//        }
//        items.add(new CartItem(this, product, qty));
//    }
//
//    public void updateItem(Long cartItemId, int qty) {
//        items.stream()
//             .filter(i -> i.getCartItemId().equals(cartItemId))
//             .findFirst()
//             .ifPresent(i -> i.setQuantity(qty));
//    }
//
//    public void removeItem(Long cartItemId) {
//        items.removeIf(i -> i.getCartItemId().equals(cartItemId));
//    }
//}


@Entity
@Table(name = "carts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    private String status = "ACTIVE"; // ACTIVE, CONVERTED

    private LocalDateTime createdAt = LocalDateTime.now();
}


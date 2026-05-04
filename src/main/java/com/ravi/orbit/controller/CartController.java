package com.ravi.orbit.controller;

import com.ravi.orbit.dto.CartDTO;
import com.ravi.orbit.entity.User;
import com.ravi.orbit.service.ICartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

    private final ICartService cartService;

    @PostMapping("/add-to-cart")
    public ResponseEntity<?> addToCart(@RequestParam Long userId,
                                       @RequestParam Long productId){
        cartService.addToCart(userId, productId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/my-cart")
    public ResponseEntity<CartDTO> getCartById(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        return ResponseEntity.ok(cartService.getCartByUserId(user.getId()));
    }

    @PostMapping("/remove-from-cart")
    public ResponseEntity<?> removeFromCart(@RequestParam Long userId,
                                            @RequestParam Long productId){
        cartService.removeFromCart(userId, productId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/clean-cart")
    public ResponseEntity<?> removeAllFromCart(@RequestParam Long userId){
        cartService.removeAllFromCart(userId);
        return ResponseEntity.ok().build();
    }

//    @PostMapping
//    public ResponseEntity<CartDTO> handleCart(@RequestBody CartDTO cartDTO){
//        return ResponseEntity.ok(cartService.handleCart(cartDTO));
//    }
//
//    @GetMapping("{id}")
//    public ResponseEntity<CartDTO> getCartById(@PathVariable Long id){
//        return ResponseEntity.ok(cartService.getCartDTOById(id));
//    }
//
//    @GetMapping("/myCart")
//    public ResponseEntity<CartDTO> getCartByUserId(@RequestParam Long userId){
//        return ResponseEntity.ok(cartService.getCartDTOByUserId(userId));
//    }
//
//    @PreAuthorize("hasRole('ADMIN')")
//    @GetMapping("/allCarts")
//    public ResponseEntity<List<CartDTO>> getAllCarts(){
//        return ResponseEntity.ok(cartService.getAllCarts());
//    }

}

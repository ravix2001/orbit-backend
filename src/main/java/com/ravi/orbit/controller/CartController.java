package com.ravi.orbit.controller;

import com.ravi.orbit.dto.CartDTO;
import com.ravi.orbit.entity.User;
import com.ravi.orbit.service.ICartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    public ResponseEntity<?> addToCart(@RequestParam Long productId){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        cartService.addToCart(username, productId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/my-cart")
    public ResponseEntity<CartDTO> getMyCart(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        return ResponseEntity.ok(cartService.getCartByUsername(username));
    }

    @DeleteMapping("/remove-from-cart")
    public ResponseEntity<?> removeFromCart(@RequestParam Long productId){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        cartService.removeFromCart(username, productId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/clean-cart")
    public ResponseEntity<?> removeAllFromCart(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        cartService.removeAllFromCart(username);
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

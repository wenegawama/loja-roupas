package com.loja.roupas.trein.controllers;

import com.loja.roupas.trein.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/sellers")
public class ProductImportController {

    private final ProductService productService;

    @PostMapping(value = "/upload", consumes = {"multipart/form-data"})
    public ResponseEntity<Integer> uploadMassiveProducts(
            @RequestPart("file") MultipartFile file,
            @RequestParam("userId") Long userId
    ) throws IOException {
        return ResponseEntity.ok(productService.uploadProducts(file, userId));
    }
}

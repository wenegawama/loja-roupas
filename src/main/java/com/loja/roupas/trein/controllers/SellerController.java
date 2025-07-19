package com.loja.roupas.trein.controllers;

import com.loja.roupas.trein.domain.dto.UpdateProductDTO;
import com.loja.roupas.trein.domain.dto.product.CreateProductDTO;
import com.loja.roupas.trein.domain.dto.sellerDTO.CreateSellerDTO;
import com.loja.roupas.trein.domain.dto.userDTO.UpdateRecoveryDTO;
import com.loja.roupas.trein.domain.entities.contact.Contact;
import com.loja.roupas.trein.domain.entities.product.Product;
import com.loja.roupas.trein.domain.entities.user.User;
import com.loja.roupas.trein.services.AuthenticationService;
import com.loja.roupas.trein.services.ProductService;
import com.loja.roupas.trein.services.SellerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.List;

@Tag(name="Vendedor")
@Slf4j
@RestController
@RequestMapping("/api/v1/users/sellers")
public class SellerController {
    @Autowired
    private SellerService sellerService;
    @Autowired
    private AuthenticationService authenticationService;

    private final ProductService productService;

    @Autowired
    public SellerController(ProductService productService) {
        this.productService = productService;
    }



    @Operation(summary = "Cadastrar um vendedor.")
    @PostMapping
    public ResponseEntity<Contact> insert(@RequestBody @Valid CreateSellerDTO createSellerDTO) {
        var sellerContactCreated = sellerService.create(createSellerDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(sellerContactCreated.getId()).toUri();
        return ResponseEntity.created(uri).body(sellerContactCreated);
    }
    @Operation(summary = "Cadastrar um produto.")
    @PostMapping(value = "/product")
    public ResponseEntity<Product> insertProduct(@RequestBody @Valid CreateProductDTO createProductDTO) throws IOException {
        var productCreated = productService.create(createProductDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/api/v1/users/product/{id}")
                .buildAndExpand(productCreated.getId()).toUri();
        return ResponseEntity.created(uri).body(productCreated);
    }

    @Operation(summary = "Buscar um produto pelo Id qualquer")
    @GetMapping("/produtos/buscar")
    public ResponseEntity<Product> list(@Parameter(description="Id do produto", example = "28", required = true) @RequestParam Long id) {
        log.info("Controller do produto - id");
        var product = productService.findOneProduct(id);
        return ResponseEntity.ok().body(product);
    }

    @Operation(summary = "Buscar um produto pelo Id de um vendedor especifico")
    @GetMapping("/product/{idSeller}/products/{idProduct}")
    public ResponseEntity<Product> findOneProductById(@PathVariable Long idSeller, @PathVariable Long idProduct) {
        log.info("Controller da busca do produto by - id");
        var product = this.productService.findOneProductId(idSeller, idProduct);
        return ResponseEntity.ok().body(product);
    }

    @Operation(summary = "Buscar todos os produtos.")
    @GetMapping("/products")
    public ResponseEntity<List<Product>> listAllProducts() {
        var products = productService.findAllProducts();
        return ResponseEntity.ok().body(products);
    }

    //Listar somente todos produtos que pertence a um vendedor
    @Operation(summary = "Buscar todos os produtos de um vendedor.")
    @GetMapping("/product/{id}/products")
    public ResponseEntity<List<Product>> listProducts (@PathVariable Long id) {
        var products = productService.findAllProductsSeller(id);
        return ResponseEntity.ok().body(products);
    }

    @Operation(summary = "Alterar um produto (objeto inteiro) de um vendedor.")
    @PutMapping("/product/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody @Valid UpdateProductDTO updateProductDTO) {
        var productUpdated = productService.updateOneProduct(id, updateProductDTO);
        return ResponseEntity.ok().body(productUpdated);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Deletar um produto de um vendedor.")
    @DeleteMapping("/product/products/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        //return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Alterar a senha.")
    @PatchMapping("/updatePassword")
    public ResponseEntity<User> update(@RequestBody @Valid UpdateRecoveryDTO updateRecoveryDTO) {
        User updatedUser = authenticationService.updatePassword(updateRecoveryDTO);

        return ResponseEntity.ok().body(updatedUser);
    }
}

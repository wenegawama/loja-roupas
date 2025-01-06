package com.loja.roupas.trein.controllers;

import com.loja.roupas.trein.domain.dto.sellerDTO.CreateSellerDTO;
import com.loja.roupas.trein.domain.dto.sellerDTO.DetailSellerDTO;
import com.loja.roupas.trein.domain.dto.sellerDTO.ListSellerDTO;
import com.loja.roupas.trein.domain.dto.sellerDTO.UpdateSellerDTO;
import com.loja.roupas.trein.domain.entities.seller.Seller;
import com.loja.roupas.trein.repositories.SellerRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "sellers", produces = {"application/json"})
@Tag(name = "loja-api")
public class SellerController {
    @Autowired
    private SellerRepository sellerRepository;

    //@Operation(summary = "Cadastro de vendedor", method = "POST")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    @Tag(name = "seller", description = "crud")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "201", description = "Seller created with sucess!!!"),
//            @ApiResponse(responseCode = "400", description = "Bad request!!!"),
//            @ApiResponse(responseCode = "401", description = "Seller unauthorized!!!"),
//            @ApiResponse(responseCode = "422", description = "Invalid Seller data!!!"),
//            @ApiResponse(responseCode = "500", description = "Unkwown server request!!!")
//    })
    public ResponseEntity create(@RequestBody @Valid CreateSellerDTO createSellerDTO, UriComponentsBuilder uriComponentsBuilder) {
        var seller = new Seller(createSellerDTO);
        sellerRepository.save(seller);

        var uri = uriComponentsBuilder.path("/sellers/{id}").buildAndExpand(seller.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetailSellerDTO(seller));
    }

    @Operation(summary = "Busca do vendedor", method = "GET")

    @GetMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Seller found with sucess!!!"),
            @ApiResponse(responseCode = "400", description = "Bad request!!!"),
            @ApiResponse(responseCode = "401", description = "Seller unauthorized!!!"),
            @ApiResponse(responseCode = "422", description = "Invalid Seller data!!!"),
            @ApiResponse(responseCode = "500", description = "Unkwown server request!!!")
    })
    public ResponseEntity<List<ListSellerDTO>> list() {
        var listSellers = sellerRepository.findAllByActiveTrue().stream().map(ListSellerDTO::new).toList();
        return ResponseEntity.ok(listSellers);
    }

    @Operation(summary = "Busca do vendedor por id", method = "GET")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucess found Seller with id!!!"),
            @ApiResponse(responseCode = "400", description = "Bad request!!!"),
            @ApiResponse(responseCode = "401", description = "Seller unauthorized!!!"),
            @ApiResponse(responseCode = "422", description = "Invalid Seller data!!!"),
            @ApiResponse(responseCode = "500", description = "Unkwown server request!!!")
    })
    @GetMapping("/{id}")
    public ResponseEntity sellerById(@PathVariable Long id) {
        var sellerById = sellerRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetailSellerDTO(sellerById));
    }

    @Operation(summary = "Alteração do vendedor ", method = "PUT")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucess updated Seller!!!"),
            @ApiResponse(responseCode = "400", description = "Bad request!!!"),
            @ApiResponse(responseCode = "401", description = "Seller unauthorized!!!"),
            @ApiResponse(responseCode = "422", description = "Invalid Seller data!!!"),
            @ApiResponse(responseCode = "500", description = "Unkwown server request!!!")
    })
    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid UpdateSellerDTO updateSellerDTO) {
        var sellerToUpdate = sellerRepository.getReferenceById(updateSellerDTO.id());
        sellerToUpdate.updateSeller(updateSellerDTO);
        return ResponseEntity.ok(new UpdateSellerDTO(sellerToUpdate));
    }

    @Operation(summary = "Deleção do vendedor pelo id ", method = "DELETE")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Sucess deleted Seller!!!"),
            @ApiResponse(responseCode = "400", description = "Bad request!!!"),
            @ApiResponse(responseCode = "401", description = "Seller unauthorized!!!"),
            @ApiResponse(responseCode = "422", description = "Invalid Seller data!!!"),
            @ApiResponse(responseCode = "500", description = "Unkwown server request!!!")
    })
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        var sellerToDelete = sellerRepository.getReferenceById(id);
        sellerToDelete.deleteSeller();
        return ResponseEntity.noContent().build();
    }
}

package com.loja.roupas.trein.services;

import com.loja.roupas.trein.domain.dto.UpdateProductDTO;
import com.loja.roupas.trein.domain.dto.product.CreateProductDTO;
import com.loja.roupas.trein.domain.entities.product.Product;
import com.loja.roupas.trein.domain.entities.product.ProductCsvRepresentation;
import com.loja.roupas.trein.domain.entities.user.User;
import com.loja.roupas.trein.infra.exceptionsService.ResourceNotFoundException;
import com.loja.roupas.trein.repositories.ContactRepository;
import com.loja.roupas.trein.repositories.ProductRepository;
import com.loja.roupas.trein.repositories.UserRepository;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private UserRepository userRepository;

    public Product create(CreateProductDTO createProductDTO) {
        User user = new User();
        user.setId(createProductDTO.id_user());

        Product product = new Product();
        product.setName(createProductDTO.name());
        product.setDescription(createProductDTO.description());
        product.setCategory(createProductDTO.category());
        product.setPrice(createProductDTO.price());
        product.setColor(createProductDTO.color());
        product.setQuantity(createProductDTO.quantity());
        product.setTamanho(createProductDTO.tamanho());
        //product.setFoto(createProductDTO.foto());

        product.setUser(user);

        log.info("Salvando o produto....");
        return productRepository.save(product);
    }

    public List<Product> findAllProducts() {
        log.info("Buscando os produtos.");
        return productRepository.findAll();
    }

    public Product findOneProduct(Long id) {
        log.info("Procurando o id do produto no service");
        var product =  productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        log.info("Id do produto encontrado - retornando o produto");

        return product;
    }

    public List<Product> findAllProductsSeller(Long id) {
        log.info("Buscando a lista dos produtos");
        return productRepository.findBySellerId(id);
    }

    public Product updateOneProduct(Long id, UpdateProductDTO updateProductDTO) {
        log.info("Procurando o id do produto especifico para atualização");
        var product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));

        if (updateProductDTO.name() != null) {
            product.setName(updateProductDTO.name());
        }
        if (updateProductDTO.description() != null) {
            product.setDescription(updateProductDTO.description());
        }
        if (updateProductDTO.category() != null) {
            product.setCategory(updateProductDTO.category());
        }
        if (updateProductDTO.price() != null) {
            product.setPrice(updateProductDTO.price());
        }
        if (updateProductDTO.color() != null) {
            product.setColor(updateProductDTO.color());
        }
        if (updateProductDTO.quantity() != null) {
            product.setQuantity(updateProductDTO.quantity());
        }
        if (updateProductDTO.tamanho() != null) {
            product.setTamanho(updateProductDTO.tamanho());
        }
//        if (updateProductDTO.foto() != null) {
//            product.setFoto(updateProductDTO.foto());
//        }

        log.info("Produto atualizado com sucesso");
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        log.info("Procurando o produto pelo id para deletar");
        var product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        productRepository.delete(product);
        log.info("Produto deletado com sucesso");
    }

    public Product findOneProductId(Long idSeller, Long idPproduct) {
        //buscar o id do vendedor
        var id = userRepository.findById(idSeller).orElseThrow(() -> new ResourceNotFoundException(idSeller));

        System.out.println(id);
        log.info("Buscando o produto pelo Id");
        return productRepository.findById(idPproduct).orElseThrow(() -> new ResourceNotFoundException(idPproduct));

    }

    public Integer uploadProducts(MultipartFile file) throws IOException {
        Set<Product> productSet = parseCsv(file);

        productRepository.saveAll(productSet);
        return  productSet.size();
    }

    private Set<Product> parseCsv(MultipartFile file) throws IOException {

        try(Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) { //ler o arquivo
            HeaderColumnNameMappingStrategy<ProductCsvRepresentation> strategy =
                    new HeaderColumnNameMappingStrategy<>();
            strategy.setType(ProductCsvRepresentation.class);
            CsvToBean<ProductCsvRepresentation> csvToBean =
                    new CsvToBeanBuilder<ProductCsvRepresentation>(reader)
                            .withMappingStrategy(strategy)
                            .withIgnoreEmptyLine(true)
                            .withIgnoreLeadingWhiteSpace(true)
                            .build();
            return csvToBean.parse()
                    .stream()
                    .map(csvLine -> {
                        Product p = new Product();
                        p.setName(csvLine.getName());
                        p.setDescription(csvLine.getDescription());
                        p.setCategory(csvLine.getCategory());
                        p.setPrice(csvLine.getPrice());
                        p.setColor(csvLine.getColor());
                        p.setQuantity(csvLine.getQuantity());
                        p.setTamanho(csvLine.getTamanho());
                        //p.setFoto(csvLine.getFoto());

                        return p;
                            }
                    )
                    .collect(Collectors.toSet());
        }
    }
}

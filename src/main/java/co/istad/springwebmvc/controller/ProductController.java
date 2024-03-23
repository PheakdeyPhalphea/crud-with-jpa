package co.istad.springwebmvc.controller;

import co.istad.springwebmvc.dto.ProductEditRequest;
import co.istad.springwebmvc.dto.ProductCreateRequest;
import co.istad.springwebmvc.dto.ProductResponse;
import co.istad.springwebmvc.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;
    @GetMapping("{id}")
    ProductResponse findProductById (@PathVariable Integer id ){
       return  productService.findProductById(id);
    }
    @GetMapping()
    List<ProductResponse> findProduct() {
        return productService.findAllProduct();
    }
    @GetMapping("/uuid/{uuid}")
    ProductResponse findProductByUuid(@PathVariable String uuid) {
       return  productService.findProductByUUID(uuid);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    void createNewProduct( @Valid @RequestBody ProductCreateRequest request){
        System.out.println(request);
        productService.createNewProduct(request);
    }
    @PutMapping("/{uuid}") 
    void editProductByUuid(@PathVariable String uuid,
                           @RequestBody ProductEditRequest request) {
        productService.editProductByUUID(uuid, request);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{uuid}")
    void deleteProductByUuid(@PathVariable String uuid){
        productService.deleteProductByUUId(uuid);
    }
}
 
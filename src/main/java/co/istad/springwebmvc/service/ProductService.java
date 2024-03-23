package co.istad.springwebmvc.service;

import co.istad.springwebmvc.dto.ProductEditRequest;
import co.istad.springwebmvc.dto.ProductCreateRequest;
import co.istad.springwebmvc.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> findAllProduct();
    List<ProductResponse> findProducts(String name, Boolean status);
    ProductResponse findProductById(Integer id);
    ProductResponse findProductByUUID(String UUID);
    void createNewProduct(ProductCreateRequest request);
    ProductResponse editProductByUUID(String uuid, ProductEditRequest request);
    void deleteProductByUUId(String uuid);
}

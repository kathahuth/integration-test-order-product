package de.neuefische.orderdb.controller;

import de.neuefische.orderdb.database.ProductDB;
import de.neuefische.orderdb.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class ProductControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ProductDB productDB;

    @Test
    public void postProductShouldAddProductToDb() {
        //Given
        String url = "http://localhost:" + port + "/product";
        Product productToSend = new Product("1", "Shampoo");

        //When
        ResponseEntity<Product> response = restTemplate.postForEntity(url, productToSend, Product.class);

        //Then
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody(), is(new Product("1", "Shampoo")));

        //check in db
        Optional<Product> savedProduct = productDB.getProductById("1");
        assertThat(savedProduct.get(), is(new Product("1", "Shampoo")));

        // or check list returns product
    }

}
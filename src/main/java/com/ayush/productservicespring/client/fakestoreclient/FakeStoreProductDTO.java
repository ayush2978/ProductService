package com.ayush.productservicespring.client.fakestoreclient;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Create separate DTO for each 3rd party api from where we are communicating to avoid tight coupling
 * Our own api will not change i.r ProductDTO. If FakeStore api changes, then we need to do changes only in FakeStoreProductDTO only.
 */


@Getter
@Setter
@ToString
public class FakeStoreProductDTO {
    private long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}

package com.sweetshop.services;

import com.sweetshop.entities.Sweet;

import java.util.List;

public interface SweetService {
    Sweet addSweet(Sweet sweet);
    List<Sweet> getAllSweets();
    Sweet getSweetById(Long id);
    Sweet updateSweet(Long id, Sweet sweet);
    void deleteSweet(Long id);
    List<Sweet> searchByName(String name);
    List<Sweet> searchByCategory(String category);
    List<Sweet> searchByPriceRange(Double minPrice, Double maxPrice);
}

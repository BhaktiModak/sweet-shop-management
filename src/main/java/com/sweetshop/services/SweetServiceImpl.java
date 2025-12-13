package com.sweetshop.services;

import com.sweetshop.entities.Sweet;
import com.sweetshop.repositories.SweetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SweetServiceImpl implements SweetService {

    private final SweetRepository sweetRepository;

    public SweetServiceImpl(SweetRepository sweetRepository) {
        this.sweetRepository = sweetRepository;
    }

    @Override
    public Sweet addSweet(Sweet sweet) {
        return sweetRepository.save(sweet);
    }

    @Override
    public List<Sweet> getAllSweets() {
        return sweetRepository.findAll();
    }

    @Override
    public Sweet getSweetById(Long id) {
        return sweetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sweet not found with id: " + id));
    }

    @Override
    public Sweet updateSweet(Long id, Sweet sweet) {
        Sweet existing = getSweetById(id);
        existing.setName(sweet.getName());
        existing.setCategory(sweet.getCategory());
        existing.setPrice(sweet.getPrice());
        existing.setQuantity(sweet.getQuantity());
        return sweetRepository.save(existing);
    }

    @Override
    public void deleteSweet(Long id) {
        sweetRepository.deleteById(id);
    }

    @Override
    public List<Sweet> searchByName(String name) {
        return sweetRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Sweet> searchByCategory(String category) {
        return sweetRepository.findByCategoryContainingIgnoreCase(category);
    }

    @Override
    public List<Sweet> searchByPriceRange(Double minPrice, Double maxPrice) {
        return sweetRepository.findByPriceBetween(minPrice, maxPrice);
    }
}

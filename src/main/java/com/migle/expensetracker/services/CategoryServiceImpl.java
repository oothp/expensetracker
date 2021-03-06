package com.migle.expensetracker.services;

import com.migle.expensetracker.domain.Category;
import com.migle.expensetracker.exceptions.EtBadRequestException;
import com.migle.expensetracker.exceptions.EtResourceNotFoundException;
import com.migle.expensetracker.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    // di
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> fetchAllCategories(Integer userId) {
        return categoryRepository.findAll(userId);
    }

    @Override
    public Category fetchCategoryById(Integer userId, Integer categoryId) throws EtResourceNotFoundException {
        return categoryRepository.findById(userId, categoryId);
    }

    @Override
    public Category addCategory(Integer userId, String title, String description) throws EtBadRequestException {
        int categoryId = categoryRepository.create(userId, title, description);
        return categoryRepository.findById(userId, categoryId);
    }

    @Override
    public void updateCategory(Integer userId, Integer categoryId, Category category) throws EtBadRequestException {
        categoryRepository.update(userId, categoryId, category);
    }

    @Override
    public void removeCategoryWithAllTransactions(Integer userID, Integer categoryId) throws EtResourceNotFoundException {
        this.fetchCategoryById(userID, categoryId);
        // is theres no catgry, 404 will be thrown - resource not found.

        categoryRepository.removeById(userID, categoryId);
    }
}

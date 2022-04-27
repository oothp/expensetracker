package com.migle.expensetracker.services;

import com.migle.expensetracker.domain.Category;
import com.migle.expensetracker.exceptions.EtBadRequestException;
import com.migle.expensetracker.exceptions.EtResourceNotFoundException;

import java.util.List;

public interface CategoryService {
    // info for a particular user canbe  accessed thru this service

    List<Category> fetchAllCategories(Integer userId);
    Category fetchCategoryById(Integer userId, Integer categoryId) throws EtResourceNotFoundException;
    Category addCategory(Integer userId, String title, String description) throws EtBadRequestException;
    void updateCategory(Integer userId, Integer categoryId, Category category) throws EtBadRequestException;
    void removeCategoryWithAllTransactions(Integer userID, Integer categoryId) throws EtResourceNotFoundException;
}

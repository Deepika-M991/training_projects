package com.skillsoft.springJPA;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ExpenseRepository extends CrudRepository<Expense, Long> {

    public List<Expense> findByItem(String item);

    @Query("SELECT e FROM Expense e WHERE e.amount >= :amount")
    public List<Expense> listItemsWithPriceOver(@Param("amount") float amount);
}
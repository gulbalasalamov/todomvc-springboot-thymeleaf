package com.gulbalasalamov.softwareengineerassignment.repository;

import com.gulbalasalamov.softwareengineerassignment.entity.ToDoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *  Declaring the following ToDoRepository interface we automatically will be able to
 *   ->  Create new Employees
 *   ->  Update existing ones
 *   -> Delete Employees
 *   -> Find Employees (one, all, or search by simple or complex properties)
 */

@Repository
public interface ToDoItemRepository extends JpaRepository<ToDoItem, Long> {
}

package com.gulbalasalamov.softwareengineerassignment.repository;

import com.gulbalasalamov.softwareengineerassignment.entity.ToDoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *  Declaring the following ToDoRepository interface we automatically will be able to
 *   ->  Create new ToDo items, Update existing ones, Delete ToDo items, Find ToDo items (one, all, or search by simple or complex properties)
 */

@Repository
//public interface ToDoItemRepository extends JpaRepository<ToDoItem, Long> {
/**
 * The JpaRepository should be avoided if possible, because it ties you repositories to the JPA persistence technology,
 * and in most cases you probably wouldn’t even use the extra methods provided by it.
 * In the scope of project, there is no need to sort or pagination
 */
public interface ToDoItemRepository extends CrudRepository<ToDoItem, Long> {
}

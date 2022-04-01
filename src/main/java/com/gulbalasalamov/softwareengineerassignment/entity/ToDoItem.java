package com.gulbalasalamov.softwareengineerassignment.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@Entity // JPA annotation to make this object ready for storage in a JPA-based data store
public class ToDoItem {
    @Id //  the primary key and automatically populated by the JPA provider.
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String category;
    private String name;
    private boolean complete;
}

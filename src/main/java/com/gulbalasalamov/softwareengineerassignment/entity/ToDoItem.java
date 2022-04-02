package com.gulbalasalamov.softwareengineerassignment.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@Entity // JPA annotation to make this object ready for storage in a JPA-based data store
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ToDoItem {
    @Id //  the primary key and automatically populated by the JPA provider.
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String title;
    boolean isCompleted;

    public ToDoItem(String title, boolean isCompleted) {
        this.title = title;
        this.isCompleted = isCompleted;
    }
}

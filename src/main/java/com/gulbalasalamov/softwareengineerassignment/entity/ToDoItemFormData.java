package com.gulbalasalamov.softwareengineerassignment.entity;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ToDoItemFormData {
    @NotBlank
    String title;
}

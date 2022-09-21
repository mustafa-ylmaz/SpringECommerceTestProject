package com.testapp.ecommerce.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    private int id;

    @NotNull
    @NotEmpty
    private String name;

    @Min(value = 0)
    private int topCategory;

    @NotNull
    @NotEmpty
    private boolean isActive;

}

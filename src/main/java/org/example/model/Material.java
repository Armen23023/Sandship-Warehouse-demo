package org.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Material {
    private MaterialType type;
    private int quantity;


    public Material(MaterialType type, int quantity) {
        this.type = type;
        this.quantity = quantity;
    }



}

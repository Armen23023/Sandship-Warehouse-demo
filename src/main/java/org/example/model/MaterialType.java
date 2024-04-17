package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class MaterialType {

   private String name;
   private String description;
   private String icon;
   private int maxCapacity;

    public MaterialType(String name, String description, String icon, int maxCapacity) {
        this.name = name;
        this.description = description;
        this.icon = icon;
        this.maxCapacity = maxCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaterialType that = (MaterialType) o;
        return maxCapacity == that.maxCapacity && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(icon, that.icon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, icon, maxCapacity);
    }
}

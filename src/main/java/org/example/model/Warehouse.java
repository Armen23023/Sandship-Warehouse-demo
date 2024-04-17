package org.example.model;

import org.example.ExeptionHandler.QuantityException;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Warehouse {
    private Map<MaterialType, Material> materials;
    String name;

    public Warehouse() {
        materials = new HashMap<>();
    }

    public Warehouse(String name){
        this.name = name;
        materials = new HashMap<>();
    }


    public boolean addMaterial(MaterialType type, int quantity) {
        if (materials.containsKey(type)) {
            Material material = materials.get(type);
            int newQuantity = material.getQuantity() + quantity;
            if (newQuantity <= type.getMaxCapacity()) {
                material.setQuantity(newQuantity);
                System.out.println("Material \"" + type.getName() + " \" added to " + this +" count : " + quantity);
                return true;
            } else {
                throw new QuantityException("The quantity is high than max capacity for " + type.getName());
            }
        } else {
            if (quantity <= type.getMaxCapacity()) {
                Material newMaterial = new Material(type, quantity);
                materials.put(type, newMaterial);
                System.out.println("New material : " + type.getName() +" added to " + this + " :: Count : " + quantity);
                return true;
            } else {
                throw new QuantityException("The quantity is high than max capacity for " + type.getName());
            }
        }
    }

    public boolean claimMaterial(MaterialType type, int quantity) {
        if (materials.containsKey(type)) {
            Material material = materials.get(type);
            int newQuantity = material.getQuantity() - quantity;
            if (newQuantity >= 0) {
                material.setQuantity(newQuantity);
//                if (newQuantity == 0) materials.remove(type);  delete type if count is 0
                return true;
            } else{
                System.out.println("there isn't that much material  \""+ type.getName() +"\" here in " + this);
                return false;
            }
        } else{
            System.out.println("there is no  material \""+ type.getName() +"\" here in " + this);
            return false;
        }

    }


    public void deleteMaterial(MaterialType type){
        materials.remove(type);
    }



    public void claimAllMaterials() {

        for (Map.Entry<MaterialType,Material> entry : materials.entrySet()  ) {
            materials.put(entry.getKey(),new Material(entry.getKey(),0));
        }
    }


    public boolean moveMaterial(MaterialType type, int quantity, Warehouse targetWarehouse) {
        if (this.claimMaterial(type, quantity)) {
             if(targetWarehouse.addMaterial(type, quantity)){
                 System.out.println("Materials \""+ type.getName() +"\" was moved from " + this + " to " + targetWarehouse);
                 return true;
             }
             return true;
        } else {
            System.out.println("Materials  \""+ type.getName() +"\" didn't move from " + this + " to " + targetWarehouse);

            return false;
        }
    }


    public  void printWarehouse(){
        if (materials.size()>0){
            System.out.printf("--------------------------------%n");
            System.out.printf("           Warehouse  %n         "+ this + " %n");
            System.out.printf("--------------------------------%n");
            System.out.printf("| %-10s | %-8s | %-8s |%-8s |%n", "NAME", "DESCRIPTION", "QUANTITY", " MAX CAPACITY");
            for (Map.Entry<MaterialType,Material> mat: materials.entrySet()) {
                System.out.printf("| %-10s | %-11s |  %7d |  %11d |%n", mat.getKey().getName(), mat.getKey().getDescription(), mat.getValue().getQuantity() ,mat.getKey().getMaxCapacity());
            }
        }else {
            System.out.println(this + " is empty");
        }
    }

    @Override
    public String toString() {
        return " " + name  ;
    }




}


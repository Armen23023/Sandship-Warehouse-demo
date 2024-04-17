package org.example;


import org.example.ExeptionHandler.QuantityException;
import org.example.model.MaterialType;
import org.example.model.Warehouse;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            Warehouse warehouse = new Warehouse("Warehouse N1");
            Warehouse warehouse2 = new Warehouse("Warehouse N2");
            MaterialType metal = new MaterialType("Metal", "Hard", "icon", 500);
            MaterialType bolt = new MaterialType("Bolt", "Hard", "icon", 1000);
            MaterialType cable = new MaterialType("Cable", "weak", "icon", 700);
            warehouse.addMaterial(metal, 500);

            warehouse.addMaterial(bolt, 400);

            System.out.println("-------------------------------");
            warehouse.moveMaterial(metal, 500, warehouse2);

            System.out.println("-------------------------------");

            warehouse.printWarehouse();

            warehouse2.printWarehouse();

            Warehouse warehouse3 = new Warehouse("Warehouse 3");
            warehouse3.printWarehouse();




        }catch (QuantityException quantityException){
            quantityException.getMessage();
        }

    }
}

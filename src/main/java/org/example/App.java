package org.example;


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

            Warehouse warehouse = new Warehouse("Warehouse N1");
            Warehouse warehouse2 = new Warehouse("Warehouse N2");
            MaterialType metal = new MaterialType("Metal", "Hard", "icon", 500);
            MaterialType bolt = new MaterialType("Bolt", "Hard", "icon", 1000);
            MaterialType cable = new MaterialType("Cable", "weak", "icon", 700);


            warehouse.addMaterial(metal,350);
            warehouse.addMaterial(metal,500);
            warehouse.printWarehouse();
            warehouse2.addMaterial(metal,400);
            warehouse2.printWarehouse();

            warehouse.moveMaterial(metal,200,warehouse2);

            warehouse2.printWarehouse();
            warehouse.printWarehouse();


        }

}


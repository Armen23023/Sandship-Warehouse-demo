package org.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.example.model.MaterialType;
import org.example.model.Warehouse;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{

    public AppTest( String testName )
    {
        super( testName );
    }
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    public void testWarehouseName(){
        Warehouse warehouse = new Warehouse("Warehouse N1");
        assertEquals("Warehouse N1",warehouse.getName());
    }

    public void testAddMaterial(){
        Warehouse warehouse = new Warehouse("Warehouse N1");

        MaterialType bolt = new MaterialType("Bolt", "Hard", "icon", 1000);


        assertTrue(warehouse.addMaterial(bolt,900));
    }
    public void testAddMaterialWrong(){
        Warehouse warehouse = new Warehouse("Warehouse N1");

        MaterialType bolt = new MaterialType("Bolt", "Hard", "icon", 1000);


        assertFalse(warehouse.addMaterial(bolt,1200));
    }
    public void testClaimMaterial(){
        Warehouse warehouse = new Warehouse("Warehouse N1");
        MaterialType bolt = new MaterialType("Bolt", "Hard", "icon", 1000);
        warehouse.addMaterial(bolt,1000);


        assertTrue(warehouse.claimMaterial(bolt,900));
    }
    public void testClaimMaterialWrongNoMaterial(){
        Warehouse warehouse = new Warehouse("Warehouse N1");
        MaterialType bolt = new MaterialType("Bolt", "Hard", "icon", 1000);


        assertFalse(warehouse.claimMaterial(bolt,1200));
    }
    public void testClaimMaterialWrongNoThatMuchMaterial(){
        Warehouse warehouse = new Warehouse("Warehouse N1");
        MaterialType bolt = new MaterialType("Bolt", "Hard", "icon", 1000);
        warehouse.addMaterial(bolt,1000);

        assertFalse(warehouse.claimMaterial(bolt,1200));
    }


    public void testMoveMaterials()
    {
        Warehouse warehouse = new Warehouse("Warehouse N1");
        Warehouse warehouse2 = new Warehouse("Warehouse N2");
        MaterialType metal = new MaterialType("Metal", "Hard", "icon", 500);


        warehouse.addMaterial(metal,350);

        warehouse2.addMaterial(metal,400);


        warehouse.moveMaterial(metal,200,warehouse2);


        assertEquals(250,warehouse.getMaterials().get(metal).getQuantity());

    }
}

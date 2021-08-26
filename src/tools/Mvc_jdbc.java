/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import daos.RegionDAO;
import models.Region;

/**
 *
 * @author kelvi
 */
public class Mvc_jdbc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        DBConnection dbc = new DBConnection();
        // Test Connection
        System.out.println(dbc.getConnection());

        // Dependency Injection
        RegionDAO regionDAO = new RegionDAO(dbc.getConnection());

        // Test insert
//        System.out.println(
//            regionDAO.insert(
//                new Region(6, "Antartica")
//            ) ?
//            "Insert Succesfully" :
//            "Insert Failed"
//        );

        // Test update
        Region updateRegion = new Region(6, "Africa");
        String resultUpdate = regionDAO.update(updateRegion) ? "updated!" : "failed to update";
        System.out.println(resultUpdate);

        // Test GetAll
        for (Region region : regionDAO.getAll()) {
            System.out.println(region.getId() + " - " + region.getName());
        }

        // Test getById

        Region regionById = new Region();
        regionById = regionDAO.getById(1);

        System.out.println();
        System.out.println("Get Region By Id");
        System.out.println("Id " + regionById.getId() + " - " + regionById.getName());

        // Test Delete

        String result = regionDAO.delete(6) ? "Deleted" : "Failed to delete";
        System.out.println(result);
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Region;

/**
 *
 * @author kelvi
 */
public class RegionDAO {
    private Connection connection;
    
    public RegionDAO(Connection connection){
        this.connection = connection;
    }
    
    public List<Region> getAll(){
        List<Region> regions = new ArrayList<>();
        
        try {
            ResultSet resultSet = connection
                    .prepareStatement("SELECT * FROM regions")
                    .executeQuery();    
            
            while(resultSet.next()) {
                Region region = new Region();
                region.setRegionid(resultSet.getInt(1));
                region.setRegionName(resultSet.getString(2));
                
                regions.add(region);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return regions;
    } 
    
    public boolean insert(Region region){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO regions(region_id, region_name) VALUES (?, ?)");
            preparedStatement.setInt(1, region.getRegionid());
            preparedStatement.setString(2, region.getRegionName());
            preparedStatement.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
}

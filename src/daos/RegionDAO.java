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
import tools.Query;

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
                    .prepareStatement(Query.GET_REGION.getDisplayQuery())
                    .executeQuery();    
            
            while(resultSet.next()) {
                Region region = new Region();
                regions.add(new Region(resultSet.getInt(1), resultSet.getString(2)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return regions;
    } 

    public Region getById(int id){

        Region region = new Region();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Query.GET_BY_ID_REGION.getDisplayQuery());
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                region.setId(resultSet.getInt(1));
                region.setName(resultSet.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return region;
    }

    public boolean insert(Region region){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO regions(region_id, region_name) VALUES (?, ?)");
            preparedStatement.setInt(1, region.getId());
            preparedStatement.setString(2, region.getName());
            preparedStatement.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean update(Region region){
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(Query.UPDATE_REGION.getDisplayQuery());
            preparedStatement.setInt(1, region.getId());
            preparedStatement.setString(2, region.getName());
            preparedStatement.setInt(3, region.getId());
            preparedStatement.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean delete(int id){
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(Query.DELETE_REGION.getDisplayQuery());
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    
}

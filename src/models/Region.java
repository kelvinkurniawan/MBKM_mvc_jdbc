/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author kelvi
 */
public class Region {
    private int regionid;
    private String regionName;
    
    public Region(){
        
    }

    public Region(int regionid, String regionName) {
        this.regionid = regionid;
        this.regionName = regionName;
    }

    public int getRegionid() {
        return regionid;
    }

    public void setRegionid(int regionid) {
        this.regionid = regionid;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
    
    @Override
    public String toString() {
        return "Region{" + "regionid=" + regionid + ", regionName=" + regionName + '}';
    }

    
}

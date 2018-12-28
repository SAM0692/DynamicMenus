/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sam.dynamicmenus.classes;

import java.util.List;

/**
 *
 * @author SAcevedoM
 */
public class SubMenu {
    
    String name;
    
    List<MenuItem> items;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public void setItems(List<MenuItem> items) {
        this.items = items;
    }
    
    
    
}

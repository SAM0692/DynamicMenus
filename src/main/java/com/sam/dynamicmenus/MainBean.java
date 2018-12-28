/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sam.dynamicmenus;

import com.sam.dynamicmenus.classes.Menu;
import com.sam.dynamicmenus.classes.MenuItem;
import com.sam.dynamicmenus.classes.SubMenu;
import com.sam.dynamicmenus.classes.TblConfig;
import com.sybit.airtable.Airtable;
import com.sybit.airtable.Base;
import com.sybit.airtable.Query;
import com.sybit.airtable.Sort;
import com.sybit.airtable.Table;
import com.sybit.airtable.exception.AirtableException;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author sacevedom
 */
@ManagedBean
@SessionScoped
public class MainBean {

    Airtable airTable;
    Base base;
    Table<TblConfig> tblConfig;
    List<TblConfig> result;
    List<Menu> lstMenu;

    String message;

    public MainBean() {
    }

    @PostConstruct
    public void init() {
        try {
            airTable = new Airtable().configure("keyGud53GenTwK01X");

            base = airTable.base("appdqzfZoeTcXC7VD");

            tblConfig = base.table("Config", TblConfig.class);

            result = tblConfig.select(getQueryWithFilter("AND({Live}='1', NOT({Actions} = ''), NOT({URL} = ''))"));

        } catch (AirtableException ex) {
            Logger.getLogger(MainBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        lstMenu = new ArrayList();

        createMenuObjects();
    }

    private void createMenuObjects() {
        boolean exists;
        for (TblConfig tc : result) {
            exists = false;

            for (Menu m : lstMenu) {
                if (m.getName().equals(tc.getMainMenu())) {
                    exists = true;
                    break;
                }
            }

            if (!exists || lstMenu.isEmpty()) {
                Menu newMenu = new Menu();
                newMenu.setName(tc.getMainMenu());

                if (tc.getSubMenu() != null && !tc.getSubMenu().equals("")) {
                    newMenu.setSubMenus(getSubMenuObjects(newMenu.getName()));
                } else {
                    newMenu.setItems(getMenuItemObjects(newMenu.getName()));
                }

                lstMenu.add(newMenu);
            }
        }
    }

    public List<SubMenu> getSubMenuObjects(String name) {
        List<SubMenu> subMenus = new ArrayList();
        boolean exists;

        for (TblConfig tc : result) {
            exists = false;

            if ((tc.getSubMenu() != null && !tc.getSubMenu().equals("")) && tc.getMainMenu().equals(name)) {
                for (SubMenu sm : subMenus) {
                    if (sm.getName().equals(tc.getSubMenu())) {
                        exists = true;
                        break;
                    }
                }

                if (!exists || subMenus.isEmpty()) {
                    SubMenu newSubMenu = new SubMenu();
                    newSubMenu.setName(tc.getSubMenu());
                    newSubMenu.setItems(getMenuItemObjects(newSubMenu.getName()));

                    subMenus.add(newSubMenu);
                }
            }
        }

        return subMenus;
    }

    public List<MenuItem> getMenuItemObjects(String name) {
        List<MenuItem> menuItems = new ArrayList();
        boolean exists;
        
        for (TblConfig tc : result) {
            exists = false;

            if ((tc.getSubMenu() != null && tc.getSubMenu().equals(name)) || tc.getMainMenu().equals(name)) {
                for (MenuItem mi : menuItems) {
                    if (mi.getName().equals(tc.getActions())) {
                        exists = true;
                        break;
                    }
                }

                if (!exists || menuItems.isEmpty()) {
                    MenuItem newItem = new MenuItem();
                    newItem.setName(tc.getActions());
                    newItem.setUrl(tc.getUrl());

                    menuItems.add(newItem);
                }
            }
        }

        return menuItems;
    }

    public List<Menu> getLstMenu() {
        return lstMenu;
    }

    public void setLstMenu(List<Menu> lstMenu) {
        this.lstMenu = lstMenu;
    }

    private Query getQueryWithFilter(final String queryString) {

        Query query = new Query() {
            @Override
            public String[] getFields() {
                return null;
            }

            @Override
            public Integer getPageSize() {
                return null;
            }

            @Override
            public Integer getMaxRecords() {
                return null;
            }

            @Override
            public String getView() {
                return null;
            }

            @Override
            public List<Sort> getSort() {
                return null;
            }

            @Override
            public String filterByFormula() {
                return queryString;
            }

        };

        return query;
    }
}

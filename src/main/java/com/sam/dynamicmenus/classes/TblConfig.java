/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sam.dynamicmenus.classes;

import com.google.gson.annotations.SerializedName;


/**
 *
 * @author sacevedom
 */
public class TblConfig {
    
    @SerializedName("Actions")
    String actions;
    @SerializedName("Sub-menu")
    String subMenu;
    @SerializedName("MainMenu")
    String mainMenu;
    @SerializedName("Live")
    boolean isLive;
    @SerializedName("LinkType")
    String linkType;
    @SerializedName("URL")
    String url;

    public String getActions() {
        return actions;
    }

    public void setActions(String actions) {
        this.actions = actions;
    }

    public String getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(String subMenu) {
        this.subMenu = subMenu;
    }

    public String getMainMenu() {
        return mainMenu;
    }

    public void setMainMenu(String mainMenu) {
        this.mainMenu = mainMenu;
    }

    public boolean isIsLive() {
        return isLive;
    }

    public void setIsLive(boolean isLive) {
        this.isLive = isLive;
    }

    public String getLinkType() {
        return linkType;
    }

    public void setLinkType(String linkType) {
        this.linkType = linkType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
}

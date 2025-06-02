/*
Job Management & Tracking System (JMTS) 
Copyright (C) 2024  D P Bennett & Associates Limited

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <https://www.gnu.org/licenses/>.

Email: info@dpbennett.com.jm
 */
package jm.com.dpbennett.sm.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jm.com.dpbennett.business.entity.sm.User;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Desmond Bennett
 */
public class Dashboard implements Serializable {

    private User user;
    private List<TabPanel> tabs;
    private Boolean render;
    private Integer tabIndex;
    private String selectedTabId;

    public Dashboard(User user) {
        this.user = user;
        tabs = new ArrayList<>();
        tabIndex = 0;
        render = false;
    }

    public String getSelectedTabId() {
        return selectedTabId;
    }

    public void setSelectedTabId(String selectedTabId) {
        this.selectedTabId = selectedTabId;
    }

    public void removeAllTabs() {
        tabs.clear();
    }

    public void openTab(String tabId) {
        addTab(tabId, true);
        //select(tabId);
    }

    // tk change to addTab since rendering is not actually being done here
    public void addTab(
            String tabId,
            Boolean render) {

        TabPanel tab = findTab(tabId);

        if (tab != null && !render) {
            // TabPanel is being removed and update the dashboard          
            tabs.remove(tab);
            // Update dashboard and select the appropriate tab
            update("appForm:dashboardAccordion");
            select(render);
        } else if (tab != null && render) {
            // TabPanel already added so select and update the dashboard
            select(render);
        } else if (tab == null && !render) {
            // TabPanel is not be added or removed           
        } else if (tab == null && render) {
            // TabPanel is to be rendered 
            tabs.add(new TabPanel(tabId, tabId));
            // Update tabview and select the appropriate tab
            update("appForm:dashboardAccordion");
            select(render);
        }
    }

    public int getTabIndex(String tabId) {
        TabPanel tab = findTab(tabId);
        if (tab != null) {
            return tabIndex;
        }

        return -1;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TabPanel findTab(String tabId) {
        tabIndex = 0;

        for (TabPanel tab : tabs) {
            if (tab.getId().equals(tabId)) {
                return tab;
            }
            ++tabIndex;
        }

        return null;
    }

    public void select(int tabIndex) {

        this.tabIndex = tabIndex < 0 ? 0 : tabIndex;

        PrimeFaces.current().executeScript("PF('dashboardAccordionVar').select(" + this.tabIndex + ");");

    }

    public void select(String componentVar, int tabIndex) {

        this.tabIndex = tabIndex < 0 ? 0 : tabIndex;

        PrimeFaces.current().executeScript("PF('" + componentVar + "')" + ".select(" + this.tabIndex + ");");

    }

    public void select(Boolean wasTabAdded) {

        if (wasTabAdded) {
            PrimeFaces.current().executeScript("PF('dashboardAccordionVar').select(" + tabIndex + ");");
        } else {
            PrimeFaces.current().executeScript("PF('dashboardAccordionVar').select(" + ((tabIndex - 1) < 0 ? 0 : (tabIndex - 1)) + ");");
        }
    }

    public void select(String componentVar, Boolean wasTabAdded) {

        if (wasTabAdded) {
            PrimeFaces.current().executeScript("PF('" + componentVar + "')" + ".select(" + tabIndex + ");");
        } else {
            PrimeFaces.current().executeScript("PF('" + componentVar + "')" + ".select(" + ((tabIndex - 1) < 0 ? 0 : (tabIndex - 1)) + ");");
        }
    }

    public void update(String tabId, String componentId, String componentVar) {

        TabPanel tab = findTab(tabId);

        if (tab != null) {
            PrimeFaces.current().ajax().update(componentId);
            select(componentVar, true);
        }
    }

    public void update(String componentId) {
        PrimeFaces.current().ajax().update(componentId);
    }

    public Integer getTabIndex() {
        return tabIndex;
    }

    public void setTabIndex(Integer tabIndex) {
        this.tabIndex = tabIndex;
    }

    public void reset(User user, boolean removeAllTabs) {
        this.user = user;

        if (removeAllTabs) {
            removeAllTabs();
        }

        setRender(true);
    }

    public Boolean getRender() {
        return render;
    }

    public void setRender(Boolean render) {
        this.render = render;
    }

    public List<TabPanel> getTabs() {

        return tabs;
    }

    public void setTabs(ArrayList<TabPanel> tabs) {
        this.tabs = tabs;
    }

}

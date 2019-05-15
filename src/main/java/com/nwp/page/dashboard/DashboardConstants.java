package com.nwp.page.dashboard;

public interface DashboardConstants {
    //Locators
    String profileCss = "div.user_profile";
    String settingsCss = "div.user_profile img[src*='settings']";
    String logoutCss = "a.logout-btn";
    String cashoutCss = "div.lft-panel a[href*='cashout']";
    String dashboardCss = "div.lft-inner a[href='/client/dashboard']";
    String eventDropdownCss = "div.left_tools.dashboard_tool select[name='select2']>option";
    String pageLoaderCss = "div#loading";
    String addPromoterCss = "div.lft-panel a[href*='add-affiliate']";
}

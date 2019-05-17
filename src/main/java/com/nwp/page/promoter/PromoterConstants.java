package com.nwp.page.promoter;

public interface PromoterConstants {
    String userNameCss = "input[data-ng-model*='UserName']";
    String emailCss = "input[data-ng-model*='Email']";
    String mobileNumberCss = "input[data-ng-model*='tempContactNo']";
    String roleDropDownCss = "select[data-ng-model*='RoleName']~input";
    String parentCss = "select[ng-model*='ParentId']~input";
    String digit1Css = "div[data-val='1']";
    String firstElementCss = "div[data-index='1']";
    String savePromoterCss = "button[data-ng-click='RegisterAffiliate()']";
}

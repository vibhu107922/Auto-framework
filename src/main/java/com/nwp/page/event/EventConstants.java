package com.nwp.page.event;

public interface EventConstants {

    String createEventCss="div.lft-inner a[href='/client/add-event']";
    String createEventFormCss="div.eventtickethd.border-0";
    String eventTitleNameCss="#mbsc-form-control-2";
    //String eventStartDateXpath = "//label[text()='Event Starts *']/..//input";
    //Event Start Date
    String eventStartDateCss = "input[placeholder='Event Start...']";
    String eventIframeId = "set_cookie";
    String eventCalenderSetButtonCss= "div.mbsc-fr-btn1.mbsc-fr-btn-e.mbsc-fr-btn";

    //Event End Date
    String eventEndDateCss = "input[placeholder='Event End...']";
    String eventNextDateXpath = "//div[text()='2021']";

    String venueCss ="#mbsc-form-control-3";
    String emailCss = "#mbsc-form-control-5";
    String nextButtonCss = "button[data-ng-click='SaveEventDetail()']";
    String deleteTicketCss = "#mbsc-form-control-12";
}

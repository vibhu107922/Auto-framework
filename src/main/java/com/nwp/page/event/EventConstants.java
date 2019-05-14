package com.nwp.page.event;

public interface EventConstants {

    String createEventXpath="//div[@class='lft-panel']//a[@href='/client/add-event']";
    String createEventFormCss="h2.margin0";
    String eventTitleNameId="mbsc-form-control-2";
    //String eventStartDateXpath = "//label[text()='Event Starts *']/..//input";
    //Event Start Date
    String eventStartDateCss = "input#mobiscroll1557762137123";
    String eventIframeId = "set_cookie";
    String eventCalenderSetButtonCss= "div.mbsc-fr-btn1.mbsc-fr-btn-e.mbsc-fr-btn";

    //Event End Date
    String eventEndDateCss = "input#mobiscroll1557762137124";
    String eventNextDate = "//div[text()='%1s']";

    String venueCss ="#mbsc-form-control-3";
    String emailCss = "#mbsc-form-control-5";
    String deleteTicketCss = "#mbsc-form-control-12";
}

package com.nwp.page.messageblast;

public interface MessageBlastConstants {
    String eventToPromoteCss = "select[ng-model='eventId']~input";
    String emailGuestListPastEventCss = "select[ng-model='finalEventId']~input";
    String messageBlastReceiverEmailListCss = "textarea[data-ng-model='emailList']";
    String emailSubjectCss = "input[data-ng-model='subject']";
    String messageBodyIFrameId = "ui-tinymce-1_ifr";
    String messageBodyCss = "body.mce-content-body";
    String sendEmailCss = "button[data-ng-click*='sendEmail']";
    String setCss = "div.mbsc-fr-btn-cont div.mbsc-fr-btn-s";
    String firstElementCss = "div.mbsc-sc-whl-sc div[data-index='1']";
}

package com.nwp.page.promocode;

public interface PromocodeConstants {
    String editPromocodeButtonCss = "a[data-ng-click*='goToEditMode']";
    String addPromocodeButtonCss = "a[data-ng-click*='isEditPromocode=false']";
    String eventSelectButtonCss = "select[name='eventSelect']";
    String editEventSelectButtonCss = "select[name='editEventSelect']";
    String ticketSelectButtonCss = "select[ng-model*='promocode.TicketId']";
    String editTicketSelectButtonCss = "select[data-ng-model*='EditModeTicketId']";
    String promocodeTextCss = "input[data-ng-model*='promocode.PromoCode']";
    String editPromocodeTextCss = "input[data-ng-model*='editPromocode.PromoCode']";
    String validFromDateSelectCss = "input[data-ng-model*='promocode.ValidFrom']";
    String validUptoDateSelectCss = "input[data-ng-model*='promocode.ValidTill']";
    String editValidUptoDateSelectCss = "input[data-ng-model*='editPromocode.ValidTill']";
    String discountAmountTextCss = "input[data-ng-model*='promocode.DiscountAmount']";
    String allowedUsageTextCss = "input[data-ng-model*='promocode.AllowedUsage']";
    String savePromocodeButtonCss = "button[data-ng-click*='SavePromoCode']";
    String updatePromocodeButtonCss = "button[data-ng-click*='UpdatePromocode']";
}

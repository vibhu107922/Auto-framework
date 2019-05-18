package com.nwp.page.promocode;

public interface PromocodeConstants {
    String editPromocodeButtonCss = "a[data-ng-click*='goToEditMode']";
    String addPromocodeButtonCss = "a[data-ng-click*='isEditPromocode=false']";
    String eventSelectButtonCss = "select[name='eventSelect']";
    String ticketSelectButtonCss = "select[ng-model*='promocode.TicketId']";
    String promocodeTextCss = "input[data-ng-model*='promocode.PromoCode']";
    String validFromDateSelectCss = "input[data-ng-model*='promocode.ValidFrom']";
    String validUptoDateSelectCss = "input[data-ng-model*='promocode.ValidTill']";
    String discountAmountTextCss = "input[data-ng-model*='promocode.DiscountAmount']";
    String allowedUsageTextCss = "input[data-ng-model*='promocode.AllowedUsage']";
    String savePromocodeButtonCss = "button[data-ng-click*='SavePromoCode']";
}

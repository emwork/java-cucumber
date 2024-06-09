package ca.skyline.service;

import ca.skyline.model.Security;

public class FixdIncomeService {

    public Security recalcPrice(Security security, float oldRate, float newRate) {
        float weight = 10;
        if ("Bond".equals(security.getAssetClass())) {
            // when rates go up: bond prices go down, yields go yp
            // when rates go down: bond prices go up. yields go down
            float newPrice = security.getPrice() * (100 - weight*(newRate - oldRate))/100;
            float newYield = security.getYield() * (100 - weight*(oldRate - newRate))/100;
            return Security.builder()
                    .description(security.getDescription())
                    .assetClass(security.getAssetClass())
                    .price(newPrice)
                    .yield(newYield)
                    .build();
        } else {
            throw new RuntimeException("The service handles bonds only");
        }
    }
}

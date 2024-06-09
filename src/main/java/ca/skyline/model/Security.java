package ca.skyline.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Security {
    String assetClass;
    String description;
    float price;
    float yield;
}


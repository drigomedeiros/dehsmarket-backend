package com.dehsmarket.core;

import java.util.ArrayList;
import java.util.List;

public class DehsMarketApp {

    public List<Product> getAvalilableProducts() {
        return getAvalilableProducts("", "default");
    }

    public List<Product> getAvalilableProducts(String filter, String sorter) {
        return new ArrayList<>();
    }

}

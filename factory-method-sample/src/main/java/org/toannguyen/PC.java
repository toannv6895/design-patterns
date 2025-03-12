package org.toannguyen;

public class PC implements Computer {
    @Override
    public String getName() {
        return "Vostro 3671";
    }

    @Override
    public String getDescription() {
        return "Dell Vostro 3671 MT97001 – Core i7 9700 | 16G | 500G SSD";
    }

    @Override
    public String getModel() {
        return "Vostro";
    }

    @Override
    public String getManufacturer() {
        return "Dell";
    }
}

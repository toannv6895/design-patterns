package org.toannguyen;

public class Server implements Computer {
    @Override
    public String getName() {
        return "iMac M1 24 inch";
    }

    @Override
    public String getDescription() {
        return "iMac M1 24 inch - 2021 - USED Apple M1 8 Core CPU | 7 Core GPU 16GB 256GB 4.5K";
    }

    @Override
    public String getModel() {
        return "M1";
    }

    @Override
    public String getManufacturer() {
        return "MAC";
    }
}

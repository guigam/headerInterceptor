package com.intact.headerforwardinterceptorlib.util;

public enum HeaderTypeEnum {
    JUNCTION("junction"),
    MOCK("mock"),
    PROFIL("profil"),
    APIKEY("apikey");

    private String headerType;

    HeaderTypeEnum(String headerType) {
        this.headerType = headerType;
    }

    public String getHeaderType() {
        return headerType;
    }
}

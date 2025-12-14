package com.road.roadbe.type;

public enum CtptStatusType {
    ACTIVE ,
    INACTIVE;
    public static CtptStatusType fromCtpt(String str) {
        if (str == null) return null;
        return CtptStatusType.valueOf(str.toUpperCase());
    }
}

package com.road.roadbe.type;

public enum RoadHandoverStatus {
    HANDOVER,
    UNHANDOVER;
    public static RoadHandoverStatus fromRoadHandoverStatus(String str) {
        if (str == null) return null;
        return RoadHandoverStatus.valueOf(str.toUpperCase());
    }
}

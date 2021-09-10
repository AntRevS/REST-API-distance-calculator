package com.reviakin_package.dist_api.Util;

import java.util.HashMap;
import java.util.Map;

public enum CalculationType {
    CROWFLIGHT ("crowflight"),
    MATRIX ("matrix"),
    ALL ("all");

    private String title;

    private static Map<String, CalculationType> map = new HashMap<>();
    static{
        for(CalculationType type : CalculationType.values()){
            map.put(type.title, type);
        }
    }

    public static CalculationType getByTitle(String title){
        return map.get(title);
    }

    CalculationType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "title = " + title;
    }
}

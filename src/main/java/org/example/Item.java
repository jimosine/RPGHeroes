package org.example;

import java.util.HashMap;

public abstract class Item  {
    public String name;
    public int requiredLevel;
    enum slot {
        WEAPON,
        HEAD,
        BODY,
        LEGS
    }

}

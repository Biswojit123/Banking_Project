package com24.biswo.factoryClass;

import com12.biswo.dataAccess.HolderData;
import com12.biswo.dataAccess.HolderDataImplematation;

public class HolderDataFactory {
    private static HolderData accountHolder = null;

    static {
        accountHolder = new HolderDataImplematation();
    }

    public static HolderData getHolderData() {
        return accountHolder ;
    }
}

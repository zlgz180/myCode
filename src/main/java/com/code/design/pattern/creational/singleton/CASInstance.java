package com.code.design.pattern.creational.singleton;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * Created by geely
 */
public class CASInstance {
    private static AtomicStampedReference<CASInstance> reference = new AtomicStampedReference<CASInstance>(null, 1);

    public static CASInstance getInstance() {
        while (true) {
            CASInstance casInstance = reference.getReference();
            if (casInstance != null) {
                return casInstance;
            }
            reference.compareAndSet(null, new CASInstance(), 1, reference.getStamp() + 1);
        }
    }

}

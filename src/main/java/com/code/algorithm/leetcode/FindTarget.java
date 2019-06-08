package com.code.algorithm.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author tianwei
 * @since 2019-06-07 20:26
 */
public class FindTarget extends LinkedHashMap {

    public FindTarget(int initialCapacity) {
        super(initialCapacity, 0.75f, true);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return super.removeEldestEntry(eldest);
    }
}

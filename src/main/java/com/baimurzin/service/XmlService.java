package com.baimurzin.service;

import java.util.Map;

/**
 * Common interface for XML services.
 * todo it can be moved to separate module to use in different type of application as a dependency
 */
public interface XmlService<T> {

    /**
     *
     * @param params Map of user parameters
     * @return result of execution command
     */
    T apply(Map<String, String> params);
}

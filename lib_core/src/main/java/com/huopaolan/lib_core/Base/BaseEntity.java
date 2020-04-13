package com.huopaolan.lib_core.Base;

import java.io.Serializable;

public class BaseEntity<T> implements Serializable {
    public boolean success;
    public T result;
    public String returnCode;
    public boolean timeOut;
}

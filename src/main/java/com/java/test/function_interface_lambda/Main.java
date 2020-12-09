package com.java.test.function_interface_lambda;

import java.util.HashMap;
import java.util.Map;

/**
 * 函数式接口的使用
 */
@SuppressWarnings("all")
public class Main {
    private static final Map<Long,Worker> id2WorkerMap = new HashMap<>();
    static {
        id2WorkerMap.put(1L,new Worker(1L,"qinyi",19));
    }

    public static void main(String[] args) {
        IFindWorker findWorker = id2WorkerMap::get;
//        IFindWorker findWorker = id -> id2WorkerMap.get(id);
        System.out.println(findWorker.findWorkerById(1L));
    }
}

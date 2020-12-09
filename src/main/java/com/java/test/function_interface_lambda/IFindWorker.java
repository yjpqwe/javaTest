package com.java.test.function_interface_lambda;

@FunctionalInterface
public interface IFindWorker {
    Worker findWorkerById(Long id);
}

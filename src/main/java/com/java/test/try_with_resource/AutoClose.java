package com.java.test.try_with_resource;

public class AutoClose implements AutoCloseable {
    @Override
    public void close() {
        System.out.println(">>> close()");
        throw new RuntimeException("Exception in close()");
    }

    public void work() throws MyException{
        System.out.println(">>> work()");
        throw new MyException("Exception in work()");
    }
}

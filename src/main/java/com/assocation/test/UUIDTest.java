package com.assocation.test;

import java.util.UUID;

public class UUIDTest {

    public static void main(String[] args) {
        String uuid = UUID.randomUUID().toString().replace("-","");
        System.out.println(uuid);
    }
}

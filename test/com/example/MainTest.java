package com.example;

import org.junit.Test;

import java.net.MalformedURLException;

import static org.junit.Assert.*;

public class MainTest {

    @Test(expected = MalformedURLException.class)
    public void testBadURL() throws Exception {
        Main.makeApiRequest("foobar");
    }
}
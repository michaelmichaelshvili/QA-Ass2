package com;

import org.junit.Test;

import static org.junit.Assert.*;

public class LeafTest {

    @Test
    public void getPath() {
        FileSystem fs = new FileSystem(10);
        try {
            fs.dir(new String[]{"root","dir1"});
            fs.file(new String[]{"root","dir1","file1"},5);
        } catch (OutOfSpaceException | BadFileNameException e) {
            e.printStackTrace();
        }
        Node n = fs.FileExists(new String[]{"root","dir1","file1"});
        String[] path = n.getPath();
        assertArrayEquals(new String[]{"root","dir1","file1"}, path);
    }
}
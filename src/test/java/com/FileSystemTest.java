package com;

import org.junit.Test;

import static org.junit.Assert.*;

public class FileSystemTest {


    @Test
    public void fileExists() throws OutOfSpaceException {
        FileSystem fs;
        fs = new FileSystem(10);
        Leaf leaf = new Leaf("leaf1", 10);
        //


    }

    @Test
    public void dirExists() {
    }

    @Test
    public void dir() {
        FileSystem fs;
        boolean thrownException = false;
        fs = new FileSystem(10);
        try {
            fs.dir(new String[]{"dir1"});
        } catch (BadFileNameException e) {
            thrownException = true;
        }
        assertTrue(thrownException);

    }

    @Test
    public void dirFileExists(){
        FileSystem fs;
        fs = new FileSystem(10);
        boolean thrownException = false;
        try {
            fs.dir(new String[]{"root","dir1"});
        } catch (BadFileNameException e) {
            e.printStackTrace();
        }
        thrownException = false;
        try {
            fs.dir(new String[]{"root","dir1"});
        } catch (BadFileNameException e) {
            thrownException = true;
        }
        assertTrue(thrownException);
    }

    @Test
    public void dirDirExists(){
        FileSystem fs;
        fs = new FileSystem(10);
        boolean thrownException = false;
        try {
            fs.dir(new String[]{"root","dir1"});
        } catch (BadFileNameException e) {
            e.printStackTrace();
        }
        thrownException = false;
        try {
            fs.dir(new String[]{"root","dir1"});
        } catch (BadFileNameException e) {
            thrownException = true;
        }
        assertTrue(thrownException);
    }


    @Test
    public void disk() {
    }

    @Test
    public void file() {
    }

    @Test
    public void lsdir() {
    }

    @Test
    public void rmfile() {
    }

    @Test
    public void rmdir() {
    }


}
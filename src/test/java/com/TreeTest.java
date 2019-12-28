package com;

import org.junit.Test;

import static org.junit.Assert.*;

public class TreeTest {

    @Test
    public void getPath() {
        FileSystem fs = new FileSystem(10);
        try {
            fs.dir(new String[]{"root","dir1"});
            fs.dir(new String[]{"root","dir1","dir2"});
        } catch (BadFileNameException e) {
            e.printStackTrace();
        }
        Node n = fs.DirExists(new String[]{"root","dir1","dir2"});
        String[] path = n.getPath();
        assertArrayEquals(new String[]{"root","dir1","dir2"}, path);
    }

    @Test
    public void getChildByNameExists() {
        Tree tree = new Tree("tree1");
        tree.children.put("tree2",new Tree("tree2"));
        Tree t = tree.GetChildByName("tree2");
        assertEquals("tree2", t.name);
    }

    @Test
    public void getChildByNameNotExists() {
        Tree tree = new Tree("tree1");
        Tree t = tree.GetChildByName("tree2");
        assertEquals("tree2", t.name);
    }
}
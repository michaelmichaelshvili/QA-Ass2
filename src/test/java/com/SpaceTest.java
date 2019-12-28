package com;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpaceTest {

    @Test
    public void getAlloc() {
        Space space = new Space(10);
        Leaf[] leafs = space.getAlloc();
    }

    @Test
    public void allocCorrect() {
        FileSystem fs = new FileSystem(20);
        Space space = new Space(10);
        Leaf leaf = null;
        try {
            leaf = new Leaf("leaf1", 5);
        } catch (OutOfSpaceException e) {
            e.printStackTrace();
        }
        try {
            space.Alloc(5, leaf);
        } catch (OutOfSpaceException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 5; i++) {
            assertEquals(leaf, space.getAlloc()[i]);
        }
    }

    @Test(expected = OutOfSpaceException.class)
    public void allocException() throws OutOfSpaceException {
        FileSystem fs = new FileSystem(20);
        Space space = new Space(10);
        Leaf leaf = null;
        try {
            leaf = new Leaf("leaf1", 5);
        } catch (OutOfSpaceException e) {
            e.printStackTrace();
        }
        space.Alloc(20, leaf);
    }

    @Test
    public void dealloc() {
        FileSystem fs = new FileSystem(20);
        Space space = new Space(10);
        Tree tree = new Tree("tree1");
        Leaf leaf = null;
        try {
            leaf = new Leaf("leaf1", 5);
            space.Alloc(5, leaf);
        } catch (OutOfSpaceException e) {
            e.printStackTrace();
        }
        tree.children.put("leaf1", leaf);
        leaf.parent = tree;
        space.Dealloc(leaf);
        for (Leaf l: space.getAlloc()) {
            assertNull(l);
        }
    }

    @Test
    public void countFreeSpace() {
        Space space = new Space(10);
        assertEquals(10, space.countFreeSpace());
    }


}
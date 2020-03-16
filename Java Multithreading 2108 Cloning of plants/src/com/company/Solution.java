package com.company;

/*

2108 Cloning of plants
The Plant class should not implement the Cloneable interface.
Implement the deep cloning mechanism for Tree.

Requirements:
1. The Plant class should not support the Cloneable interface.
2. The Tree class must support the Cloneable interface.
3. The Tree class must be a descendant of the Plant class.
4. In the Tree class, the clone method must be correctly implemented.


 */

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {
    public static void main(String[] args) {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
        try {
            clone = tree.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);
    }

    public static class Plant{
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Tree extends Plant implements Cloneable {
        private String[] branches;

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        public String[] getBranches() {
            return branches;
        }

        @Override
        protected Tree clone() throws CloneNotSupportedException {
            String[] strings = new String[branches.length];
            for (int i=0;i<branches.length;i++) {
                strings[i] = branches[i];
            }

            return new Tree(super.getName(), strings);
        }
    }
}

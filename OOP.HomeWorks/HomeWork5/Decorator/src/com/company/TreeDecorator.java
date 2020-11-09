package com.company;

public class TreeDecorator implements Tree
{
    protected Tree tree;
    public TreeDecorator(Tree tree)
    {
        this.tree = tree;
    }

    @Override
    public String showTree()
    {
        return tree.showTree();
    }
}

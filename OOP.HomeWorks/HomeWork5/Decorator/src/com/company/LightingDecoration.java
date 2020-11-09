package com.company;

public class LightingDecoration extends TreeDecorator
{
    public LightingDecoration(Tree tree)
    {
        super(tree);
    }

    @Override
    public String showTree()
    {
        return super.showTree() + " I shine like a diamond";
    }
}

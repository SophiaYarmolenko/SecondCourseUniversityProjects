package com.company;

public class ChristmasDecorationsDecorator extends TreeDecorator
{
    public ChristmasDecorationsDecorator(Tree tree)
    {
        super(tree);
    }

    @Override
    public String showTree()
    {
        return super.showTree() + " I have a nice christmas decorations.";
    }
}

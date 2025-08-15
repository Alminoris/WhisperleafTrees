package net.alminoris.whisperleaftrees.world.gen.decorator;

import net.alminoris.whisperleaftrees.world.gen.decorator.custom.CustomVineDecorator;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

public class ModTreeDecorators
{
    public static final TreeDecoratorType<CustomVineDecorator> CUSTOM_ADVANCED_VINE_DECORATOR = new TreeDecoratorType<>(CustomVineDecorator.CODEC);

    public static void register()
    {
        Registry.register(Registries.TREE_DECORATOR_TYPE, "custom_advanced_vine_decorator", CUSTOM_ADVANCED_VINE_DECORATOR);
    }
}
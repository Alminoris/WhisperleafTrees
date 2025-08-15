package net.alminoris.whisperleaftrees.world.tree;

import net.alminoris.whisperleaftrees.util.helper.ModBlockSetsHelper;
import net.alminoris.whisperleaftrees.world.ModConfiguredFeatures;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Optional;

public class ModSaplingGenerators
{
    public static final Dictionary<String, RegistryKey<ConfiguredFeature<?, ?>>> keys = new Hashtable<>()
    {{
        put("willow", ModConfiguredFeatures.WILLOW_KEY);
        put("poplar", ModConfiguredFeatures.POPLAR_KEY);
        put("alder", ModConfiguredFeatures.ALDER_KEY);
        put("aspen", ModConfiguredFeatures.ASPEN_KEY);
    }};

    public static final Dictionary<String, SaplingGenerator> saplingGenerators = new Hashtable<>()
    {{
        for(String name : ModBlockSetsHelper.WOOD_NAMES)
        {
            put(name, new CustomSaplingGenerator(keys.get(name)));
        }
    }};
}
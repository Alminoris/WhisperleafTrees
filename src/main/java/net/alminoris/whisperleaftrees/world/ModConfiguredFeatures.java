package net.alminoris.whisperleaftrees.world;

import com.google.common.collect.ImmutableList;
import net.alminoris.whisperleaftrees.block.ModBlocks;
import net.alminoris.whisperleaftrees.util.helper.ModBlockSetsHelper;
import net.alminoris.whisperleaftrees.world.gen.decorator.custom.CustomVineDecorator;
import net.alminoris.whisperleaftrees.world.tree.custom.PoplarFoliagePlacer;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.CherryFoliagePlacer;
import net.minecraft.world.gen.foliage.LargeOakFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.CherryTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

public class ModConfiguredFeatures
{
    public static RegistryKey<ConfiguredFeature<?, ?>> WILLOW_KEY = registerKey("willow");

    public static RegistryKey<ConfiguredFeature<?, ?>> POPLAR_KEY = registerKey("poplar");

    public static RegistryKey<ConfiguredFeature<?, ?>> ALDER_KEY = registerKey("alder");

    public static RegistryKey<ConfiguredFeature<?, ?>> ASPEN_KEY = registerKey("aspen");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context)
    {
        register(context, POPLAR_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlockSetsHelper.LOGS.get("poplar")),
                new StraightTrunkPlacer(
                        11,
                        1,
                        1),
                BlockStateProvider.of(ModBlockSetsHelper.LEAVES.get("poplar")),
                new PoplarFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(5), 15),
                new TwoLayersFeatureSize(1, 0, 2)
        ).build());

        register(context, WILLOW_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlockSetsHelper.LOGS.get("willow")),
                new CherryTrunkPlacer(
                        3,
                        1,
                        1,
                        UniformIntProvider.create(2, 3),
                        UniformIntProvider.create(2, 3),
                        UniformIntProvider.create(-1, 0),
                        ConstantIntProvider.create(1)
                ),
                BlockStateProvider.of(ModBlockSetsHelper.LEAVES.get("willow")),
                new CherryFoliagePlacer(
                        UniformIntProvider.create(2, 4),
                        ConstantIntProvider.create(0),
                        UniformIntProvider.create(5, 8),
                        0.35f,
                        0.25f,
                        0.75f,
                        0.75f
                ),
                new TwoLayersFeatureSize(1, 0, 2)
        ).decorators(ImmutableList.of(new CustomVineDecorator(0.35f, ModBlocks.WILLOW_VINES))).build());

        register(context, ASPEN_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlockSetsHelper.LOGS.get("aspen")),
                new StraightTrunkPlacer(
                        9,
                        2,
                        1
                ),
                BlockStateProvider.of(ModBlockSetsHelper.LEAVES.get("aspen")),
                new LargeOakFoliagePlacer(
                        ConstantIntProvider.create(2),
                        UniformIntProvider.create(0, 2),
                        6
                ),
                new TwoLayersFeatureSize(1, 0, 2)
        ).ignoreVines().build());

        register(context, ALDER_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlockSetsHelper.LOGS.get("alder")),
                new StraightTrunkPlacer(
                        5,
                        2,
                        0
                ),
                BlockStateProvider.of(ModBlockSetsHelper.LEAVES.get("alder")),
                new BlobFoliagePlacer(
                        ConstantIntProvider.create(3),
                        ConstantIntProvider.create(0),
                        3
                ),
                new TwoLayersFeatureSize(1, 0, 2)
        ).ignoreVines().build());

    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name)
    {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(net.alminoris.whisperleaftrees.WhisperleafTrees.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration)
    {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
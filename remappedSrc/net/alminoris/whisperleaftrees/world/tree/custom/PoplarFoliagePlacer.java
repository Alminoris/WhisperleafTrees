package net.alminoris.whisperleaftrees.world.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.alminoris.whisperleaftrees.world.tree.ModFoliagePlacerTypes;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class PoplarFoliagePlacer extends BlobFoliagePlacer
{
    public static final Codec<PoplarFoliagePlacer> CODEC = RecordCodecBuilder.create((instance) ->
            createCodec(instance).apply(instance, PoplarFoliagePlacer::new));

    public PoplarFoliagePlacer(IntProvider intProvider, IntProvider intProvider2, int i)
    {
        super(intProvider, intProvider2, i);
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return ModFoliagePlacerTypes.POPLAR_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(
            TestableWorld world,
            FoliagePlacer.BlockPlacer placer,
            Random random,
            TreeFeatureConfig config,
            int trunkHeight,
            FoliagePlacer.TreeNode treeNode,
            int foliageHeight,
            int radius,
            int offset)
    {
        int c = 0;
        for (int i = offset; i >= offset - foliageHeight; i--)
        {
            int j;
            if (c < 3)
            {
                j = (radius-1) + (i != offset && i != offset - foliageHeight ? 1 : 0);
            }
            else
            {
                j = radius + (i != offset && i != offset - foliageHeight ? 1 : 0);
            }

            this.generateSquare(world, placer, random, config, treeNode.getCenter(), j, i, treeNode.isGiantTrunk());
            c++;
        }
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk)
    {
        return MathHelper.square(dx + 0.5F) + MathHelper.square(dz + 0.5F) > radius * radius;
    }
}

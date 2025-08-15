package net.alminoris.whisperleaftrees.world.tree;

import net.alminoris.whisperleaftrees.mixin.FoliagePlacerTypeInvoker;
import net.alminoris.whisperleaftrees.world.tree.custom.PoplarFoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class ModFoliagePlacerTypes
{
    public static final FoliagePlacerType<?> POPLAR_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("poplar_foliage_placer", PoplarFoliagePlacer.CODEC);

    public static void register()
    {
    }
}

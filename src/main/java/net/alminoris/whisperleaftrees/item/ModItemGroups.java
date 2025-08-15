package net.alminoris.whisperleaftrees.item;

import net.alminoris.whisperleaftrees.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static net.alminoris.whisperleaftrees.util.helper.ModBlockSetsHelper.*;

public class ModItemGroups
{
    public static final ItemGroup WHISPERLEAF_TREES_TAB = FabricItemGroup.builder(new Identifier(net.alminoris.whisperleaftrees.WhisperleafTrees.MOD_ID, "whisperleaftreestab")).displayName(Text.translatable("itemgroup.whisperleaftreestab"))
                    .icon(() -> new ItemStack(WOODEN_SAPLINGS.get("willow"))).entries((displayContext, entries) ->
                    {
                        for (String name : WOOD_NAMES)
                        {
                            entries.add(WOODEN_SAPLINGS.get(name));
                            if (name.equals("willow"))
                                entries.add(ModBlocks.WILLOW_VINES);
                            entries.add(LEAVES.get(name));
                            entries.add(LOGS.get(name));
                            entries.add(WOODS.get(name));
                            entries.add(STRIPPED_LOGS.get(name));
                            entries.add(STRIPPED_WOODS.get(name));
                            entries.add(WOODEN_PLANKS.get(name));
                            entries.add(WOODEN_SLABS.get(name));
                            entries.add(WOODEN_STAIRS.get(name));
                            entries.add(WOODEN_FENCES.get(name));
                            entries.add(WOODEN_FENCE_GATES.get(name));
                            entries.add(WOODEN_DOORS.get(name));
                            entries.add(WOODEN_TRAPDOORS.get(name));
                            entries.add(WOODEN_BUTTONS.get(name));
                            entries.add(WOODEN_PRESSURE_PLATES.get(name));
                            entries.add(WOODEN_SIGN_ITEMS.get(name));
                            entries.add(WOODEN_HANGING_SIGN_ITEMS.get(name));
                            entries.add(WOODEN_BOATS.get(name));
                            entries.add(WOODEN_CHEST_BOATS.get(name));
                        }
                    }).build();

    public static void registerItemGroups()
    {

    }
}
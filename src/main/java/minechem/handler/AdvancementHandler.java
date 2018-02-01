package minechem.handler;

import minechem.chemical.Element;
import minechem.registry.AdvancementRegistry;
import minechem.registry.BlockRegistry;
import minechem.registry.ElementRegistry;
import minechem.registry.ItemRegistry;
import net.minecraft.advancements.Advancement;

public class AdvancementHandler
{
    public static void init()
    {
        initMinechem();
        initElements();
    }

    private static void initElements()
    {
        for (Element element : ElementRegistry.getInstance().getElements())
        {
            AdvancementRegistry.getInstance().addAdvancement(element);
        }
        AdvancementRegistry.getInstance().registerElementAdvancements();
    }

    private static void initMinechem()
    {
        Advancement journal = AdvancementRegistry.getInstance().addAdvancement(ItemRegistry.journal.getUnlocalizedName(), 0, 0, ItemRegistry.journal);
        Advancement microscope = AdvancementRegistry.getInstance().addAdvancement(BlockRegistry.opticalMicroscope.getUnlocalizedName(), 1, 3, BlockRegistry.opticalMicroscope, journal);
        Advancement electrolysis = AdvancementRegistry.getInstance().addAdvancement(BlockRegistry.electrolysisBlock.getUnlocalizedName(), 3, 3, BlockRegistry.electrolysisBlock, microscope);
        Advancement crucible = AdvancementRegistry.getInstance().addAdvancement(BlockRegistry.electricCrucibleBlock.getUnlocalizedName(), -2, 3, BlockRegistry.electricCrucibleBlock, microscope);
        AdvancementRegistry.getInstance().registerMinechemAdvancements();
    }
}

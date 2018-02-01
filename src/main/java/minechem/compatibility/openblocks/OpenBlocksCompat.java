package minechem.compatibility.openblocks;

import minechem.Compendium;
import minechem.compatibility.CompatBase;
import net.minecraftforge.fml.common.event.FMLInterModComms;

public class OpenBlocksCompat extends CompatBase
{
    @Override
    protected void init()
    {
        FMLInterModComms.sendMessage(mod.getModId(), "donateUrl", Compendium.MetaData.patreon);
    }
}

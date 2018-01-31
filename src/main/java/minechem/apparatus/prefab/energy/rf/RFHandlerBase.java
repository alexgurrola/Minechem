package minechem.apparatus.prefab.energy.rf;

import cofh.redstoneflux.api.IEnergyProvider;
import net.minecraftforge.fml.common.Optional;
import net.minecraft.util.EnumFacing;

@Optional.Interface(iface = "cofh.redstoneflux.api.IEnergyProvider", modid = "CoFHAPI|energy")
public class RFHandlerBase extends RFMachineBase implements IEnergyProvider
{
    @Optional.Method(modid = "CoFHAPI|energy")
    @Override
    public int extractEnergy(EnumFacing enumFacing, int amount, boolean doExtract)
    {
        return this.energy.extractEnergy(amount, doExtract);
    }
}

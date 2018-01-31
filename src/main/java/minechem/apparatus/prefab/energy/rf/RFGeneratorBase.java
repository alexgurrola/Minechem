package minechem.apparatus.prefab.energy.rf;

import cofh.redstoneflux.api.IEnergyProvider;
import net.minecraftforge.fml.common.Optional;
import net.minecraft.util.EnumFacing;

@Optional.Interface(iface = "cofh.redstoneflux.api.IEnergyProvider", modid = "CoFHAPI|energy")
public class RFGeneratorBase extends RFBase implements IEnergyProvider
{
    @Optional.Method(modid = "CoFHAPI|energy")
    @Override
    public boolean canConnectEnergy(EnumFacing enumFacing)
    {
        return true;
    }

    @Optional.Method(modid = "CoFHAPI|energy")
    @Override
    public int extractEnergy(EnumFacing enumFacing, int amount, boolean doExtract)
    {
        return this.energy.extractEnergy(amount, doExtract);
    }

    @Optional.Method(modid = "CoFHAPI|energy")
    @Override
    public int getEnergyStored(EnumFacing enumFacing)
    {
        return this.energy.getStored();
    }

    @Optional.Method(modid = "CoFHAPI|energy")
    @Override
    public int getMaxEnergyStored(EnumFacing enumFacing)
    {
        return this.energy.getCapacity();
    }
}

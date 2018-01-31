package minechem.apparatus.prefab.energy.rf;

import cofh.redstoneflux.api.IEnergyReceiver;
import net.minecraftforge.fml.common.Optional;
import net.minecraft.util.EnumFacing;

@Optional.Interface(iface = "cofh.redstoneflux.api.IEnergyReceiver", modid = "CoFHAPI|energy")
public abstract class RFMachineBase extends RFBase implements IEnergyReceiver
{
    @Optional.Method(modid = "CoFHAPI|energy")
    @Override
    public boolean canConnectEnergy(EnumFacing enumFacing)
    {
        return true;
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

    @Optional.Method(modid = "CoFHAPI|energy")
    @Override
    public int receiveEnergy(EnumFacing enumFacing, int amount, boolean doInsert)
    {
        return this.energy.inputEnergy(amount, doInsert);
    }
}

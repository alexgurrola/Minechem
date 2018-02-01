package minechem.compatibility.computercraft;

import dan200.computercraft.api.ComputerCraftAPI;
import dan200.computercraft.api.peripheral.IPeripheral;
import dan200.computercraft.api.peripheral.IPeripheralProvider;
import minechem.Compendium;
import minechem.apparatus.prefab.peripheral.TilePeripheralBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Optional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@Optional.Interface(iface = "dan200.computercraft.api.peripheral.IPeripheralProvider", modid = Compendium.Naming.Mods.computerCraft)
public class PeripheralProvider implements IPeripheralProvider
{
    public static void register()
    {
        ComputerCraftAPI.registerPeripheralProvider(new PeripheralProvider());
    }

    @Nullable
    @Override
    @Optional.Method(modid = Compendium.Naming.Mods.computerCraft)
    public IPeripheral getPeripheral(@Nonnull World world, @Nonnull BlockPos blockPos, @Nonnull EnumFacing enumFacing)
    {
        TileEntity te = world.getTileEntity(blockPos);
        if (te instanceof TilePeripheralBase) {
            return (IPeripheral) te;
        }
        return null;
    }
}

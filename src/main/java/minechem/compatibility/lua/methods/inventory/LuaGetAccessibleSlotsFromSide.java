package minechem.compatibility.lua.methods.inventory;

import minechem.compatibility.lua.LuaParser;
import minechem.compatibility.lua.methods.LuaMethod;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

public class LuaGetAccessibleSlotsFromSide extends LuaMethod
{
    public LuaGetAccessibleSlotsFromSide()
    {
        super("getAccessibleSlotsFromSide", "(int side)", Number.class);
    }

    @Override
    public Object[] action(TileEntity te, Object[] args) throws Exception
    {
        return new Object[]
                {
                        LuaParser.toLua(((ISidedInventory) te).getSlotsForFace((EnumFacing) args[0]))
                };
    }

    @Override
    public boolean applies(TileEntity te)
    {
        return te instanceof ISidedInventory;
    }
}

package minechem.helper;

import net.minecraft.util.EnumFacing;

public class RotationHelper
{
    public static final EnumFacing[] ROTATION_DIRECTIONS =
            {
                    EnumFacing.SOUTH, EnumFacing.WEST, EnumFacing.NORTH, EnumFacing.EAST
            };

    public static EnumFacing getDirectionFromMetadata(int meta)
    {
        return ROTATION_DIRECTIONS[meta];
    }

}

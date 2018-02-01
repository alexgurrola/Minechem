package minechem.helper;

import minechem.chemical.Element;
import minechem.handler.MessageHandler;
import minechem.handler.message.AdvancementMessage;
import minechem.registry.AdvancementRegistry;
import net.minecraft.advancements.Advancement;
import net.minecraft.entity.player.EntityPlayer;

public class AdvancementHelper
{
    /**
     * Short hand for getting an {@link net.minecraft.stats.Advancement} from the {@link minechem.registry.AdvancementRegistry} by name
     *
     * @param name the advancement name
     * @return the {@link net.minecraft.stats.Advancement} or null if the name does not exist
     */
    public static Advancement getAdvancement(String name)
    {
        return AdvancementRegistry.getInstance().getAdvancement(name);
    }

    /**
     * Short hand for getting an {@link net.minecraft.stats.Advancement} from the {@link minechem.registry.AdvancementRegistry} by {@link minechem.chemical.Element}
     *
     * @param element an {@link minechem.chemical.Element}
     * @return the {@link net.minecraft.stats.Advancement} or null if the {@link minechem.chemical.Element} does not exist
     */
    public static Advancement getAdvancement(Element element)
    {
        return AdvancementRegistry.getInstance().getAdvancement(element);
    }

    /**
     * Give a {@link net.minecraft.entity.player.EntityPlayer} an {@link net.minecraft.stats.Advancement} for an {@link minechem.chemical.Element} It will send an
     * {@link minechem.handler.message.AdvancementMessage} when the world is remote
     *
     * @param player   the {@link net.minecraft.entity.player.EntityPlayer} to grand the {@link net.minecraft.stats.Advancement}
     * @param element  the {@link minechem.chemical.Element} to give the {@link net.minecraft.stats.Advancement} for
     * @param isRemote {@link net.minecraft.world.World#isRemote} is the to pass argument here
     */
    public static void giveAdvancement(EntityPlayer player, Element element, boolean isRemote)
    {
        if (isRemote)
        {
            MessageHandler.INSTANCE.sendToServer(new AdvancementMessage(element));
        } else
        {
            giveAdvancement(player, getAdvancement(element));
        }
    }

    /**
     * Give a {@link net.minecraft.entity.player.EntityPlayer} an {@link net.minecraft.stats.Advancement} wih given name It will send an {@link minechem.handler.message.AdvancementMessage} when the
     * world is remote
     *
     * @param player   the {@link net.minecraft.entity.player.EntityPlayer} to grand the {@link net.minecraft.stats.Advancement}
     * @param name     the name of the {@link net.minecraft.stats.Advancement} to give
     * @param isRemote {@link net.minecraft.world.World#isRemote} is the to pass argument here
     */
    public static void giveAdvancement(EntityPlayer player, String name, boolean isRemote)
    {
        if (isRemote)
        {
            MessageHandler.INSTANCE.sendToServer(new AdvancementMessage(name));
        } else
        {
            giveAdvancement(player, getAdvancement(name));
        }
    }

    /**
     * Grants the {@link net.minecraft.entity.player.EntityPlayer} an {@link net.minecraft.stats.Advancement}
     *
     * @param player      the {@link net.minecraft.entity.player.EntityPlayer} to grant the {@link net.minecraft.stats.Advancement}
     * @param advancement the {@link net.minecraft.stats.Advancement} to grant
     */
    public static void giveAdvancement(EntityPlayer player, Advancement advancement)
    {
        player.triggerAdvancement(advancement);
    }
}

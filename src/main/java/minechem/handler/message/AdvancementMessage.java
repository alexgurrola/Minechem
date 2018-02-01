package minechem.handler.message;

import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import minechem.chemical.Element;
import minechem.helper.AdvancementHelper;
import minechem.registry.ElementRegistry;

/**
 * Used for triggering advancements from Client only code
 */
public class AdvancementMessage extends BaseTEMessage implements IMessageHandler<AdvancementMessage, IMessage>
{
    private String advancement;
    private boolean isElement;

    public AdvancementMessage()
    {

    }

    public AdvancementMessage(String advancement)
    {
        this.advancement = advancement;
        this.isElement = false;
    }

    public AdvancementMessage(Element element)
    {
        this.advancement = element.shortName;
        this.isElement = true;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.isElement = buf.readBoolean();
        int length = buf.readInt();
        this.advancement = new String(buf.readBytes(length).array());
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeBoolean(this.isElement);
        buf.writeInt(this.advancement.length());
        buf.writeBytes(this.advancement.getBytes());
    }

    @Override
    public IMessage onMessage(AdvancementMessage message, MessageContext ctx)
    {
        if (message.isElement)
        {
            AdvancementHelper.giveAdvancement(getServerPlayer(ctx), AdvancementHelper.getAdvancement(ElementRegistry.getInstance().getElement(message.advancement)));
        } else
        {
            AdvancementHelper.giveAdvancement(getServerPlayer(ctx), AdvancementHelper.getAdvancement(message.advancement));
        }
        return null;
    }
}

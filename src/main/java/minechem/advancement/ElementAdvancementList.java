package minechem.advancement;

import minechem.Compendium;
import minechem.proxy.client.render.RenderHelper;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementList;
import net.minecraft.client.Minecraft;

public class ElementAdvancementList extends AdvancementList implements IAdvancementListRenderer
{
    public ElementAdvancementList(String name, Advancement... advancements)
    {
        super(name, advancements);
    }

    @Override
    public void drawBackground(Minecraft mc, float z, float scale, int columnWidth, int rowHeight)
    {
        int k = (columnWidth + 288);
        int l = (rowHeight + 288);
        RenderHelper.setScissor(254, 200, 0, 0, 250, 200);
        RenderHelper.drawTexturedRectUV(-10 - k, 50 - l, z, 0, 0, 640, 480, 640, 480, Compendium.Resource.GUI.advancements);
        RenderHelper.stopScissor();
    }

    @Override
    public float setScaleOnLoad()
    {
        return 2.0F;
    }

    @Override
    public float getMaxZoomOut()
    {
        return 3.0F;
    }

    @Override
    public float getMaxZoomIn()
    {
        return 1.0F;
    }
}

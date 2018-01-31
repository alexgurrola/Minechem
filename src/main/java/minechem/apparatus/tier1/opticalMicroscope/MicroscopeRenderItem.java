package minechem.apparatus.tier1.opticalMicroscope;

import minechem.proxy.client.render.RenderHelper;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

public class MicroscopeRenderItem extends RenderItem
{
    public OpticalMicroscopeGUI microscopeGui;

    public MicroscopeRenderItem(OpticalMicroscopeGUI microscopeGui)
    {
        super.render();
        this.microscopeGui = microscopeGui;
    }

    @Override
    public void renderItemAndEffectIntoGUI(FontRenderer fontRenderer, TextureManager textureManager, ItemStack stack, int xPosition, int yPosition)
    {
        if (stack == null)
        {
            return;
        }

        RenderHelper.enableGUIStandardItemLighting();

        Slot slot = microscopeGui.inventorySlots.getSlotFromInventory(microscopeGui.opticalMicroscope, 0);
        if (slot.getStack() != null)
        {
            GL11.glPushMatrix();
            RenderHelper.setScissor(microscopeGui.getXSize(), microscopeGui.getYSize(), OpticalMicroscopeGUI.eyePieceX, OpticalMicroscopeGUI.eyePieceY, OpticalMicroscopeGUI.eyePieceW, OpticalMicroscopeGUI.eyePieceH);
            int renderX = microscopeGui.getGuiLeft() + slot.xDisplayPosition;
            int renderY = microscopeGui.getGuiTop() + slot.yDisplayPosition;
            GL11.glTranslatef(renderX, renderY, 0.0F);
            GL11.glScalef(3.0F, 3.0F, 1.0F);
            GL11.glTranslatef(-renderX - 5.4F, -renderY - 4.5F, 540.0F);
            super.renderItemAndEffectIntoGUI(fontRenderer, textureManager, slot.getStack(), renderX, renderY);
            RenderHelper.stopScissor();
            GL11.glPopMatrix();
        }

        if (stack == microscopeGui.getContainer().getInventoryPlayer().getItemStack() && microscopeGui.isMouseInMicroscope())
        {
            GL11.glPushMatrix();
            RenderHelper.setScissor(microscopeGui.getXSize(), microscopeGui.getYSize(), OpticalMicroscopeGUI.eyePieceX, OpticalMicroscopeGUI.eyePieceY, OpticalMicroscopeGUI.eyePieceW, OpticalMicroscopeGUI.eyePieceH);
            GL11.glTranslatef(xPosition, yPosition, 0.0F);
            GL11.glScalef(3.0F, 3.0F, 1.0F);
            GL11.glTranslatef(-xPosition - 8.0F, -yPosition - 8.0F, 540.0F);
            super.renderItemAndEffectIntoGUI(fontRenderer, textureManager, stack, xPosition, yPosition);
            RenderHelper.stopScissor();
            GL11.glPopMatrix();
        }
    }
}

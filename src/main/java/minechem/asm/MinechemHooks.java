package minechem.asm;

import minechem.advancement.IAdvancementListRenderer;
import minechem.advancement.IAdvancementRenderer;
import minechem.advancement.MinecraftAdvancementList;
import minechem.item.IOverlay;
import minechem.proxy.client.render.RenderHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.item.ItemStack;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementList;

public class MinechemHooks
{
    public static void recolourAdvancement(Advancement advancement, float greyscale)
    {
        if (advancement instanceof IAdvancementRenderer) {
            int colour = ((IAdvancementRenderer) advancement).recolourBackground(greyscale);
            RenderHelper.setOpenGLColour(colour);
        }
    }

    public static void resetGreyscale(float greyscale)
    {
        RenderHelper.setGreyscaleOpenGLColour(greyscale);
    }

    public static void drawIconAdvancement(RenderItem renderItem, FontRenderer fontRenderer, TextureManager textureManager, final ItemStack itemStack, int x, int y, Advancement advancement)
    {
        if (advancement instanceof IAdvancementRenderer && ((IAdvancementRenderer) advancement).hasSpecialIconRenderer()) {
            ((IAdvancementRenderer) advancement).renderIcon(fontRenderer, textureManager, itemStack, x, y);
        } else {
            renderItem.renderItemAndEffectIntoGUI(fontRenderer, textureManager, itemStack, x, y);
        }
    }

    public static void drawAdvancementListBackground(Minecraft mc, float scale, int columnWidth, int rowHeight, int currentPage)
    {
        if (currentPage != -1) {
            AdvancementList advancementList = AdvancementList.getAdvancementList(currentPage);
            if (advancementList instanceof IAdvancementListRenderer) {
                ((IAdvancementListRenderer) advancementList).drawBackground(mc, 0, scale, columnWidth, rowHeight);
                return;
            }
        }
        MinecraftAdvancementList.drawBackground(mc, 0, scale, columnWidth, rowHeight);
    }

    public static float setScaleOnLoad(int currentPage)
    {
        if (currentPage != -1) {
            AdvancementList advancementList = AdvancementList.getAdvancementList(currentPage);
            if (advancementList instanceof IAdvancementListRenderer) {
                return ((IAdvancementListRenderer) advancementList).setScaleOnLoad();
            }
        }
        return 1.0F;
    }

    public static float getMaxZoomOut(int currentPage)
    {
        if (currentPage != -1) {
            AdvancementList advancementList = AdvancementList.getAdvancementList(currentPage);
            if (advancementList instanceof IAdvancementListRenderer) {
                return ((IAdvancementListRenderer) advancementList).getMaxZoomOut();
            }
        }
        return 2.0F;
    }

    public static float getMaxZoomIn(int currentPage)
    {
        if (currentPage != -1) {
            AdvancementList advancementList = AdvancementList.getAdvancementList(currentPage);
            if (advancementList instanceof IAdvancementListRenderer) {
                return ((IAdvancementListRenderer) advancementList).getMaxZoomIn();
            }
        }
        return 1.0F;
    }

    public static void renderOverlay(FontRenderer fontRenderer, TextureManager textureManager, ItemStack itemStack, int left, int top, float z)
    {
        if (itemStack.getItem() instanceof IOverlay) {
            ((IOverlay) itemStack.getItem()).renderOverlay(fontRenderer, textureManager, itemStack, left, top, z);
        }
    }
}

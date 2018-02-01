package minechem.advancement;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.item.ItemStack;

/**
 * This can be applied and will be hooked into the render code of an {@link net.minecraft.advancements.Advancement} during the rendering in the {@link net.minecraft.client.gui.advancement.GuiAdvancement}
 */
public interface IAdvancementRenderer
{
    /**
     * Recolour the background of the {@link net.minecraft.advancements.Advancement} icon in the {@link net.minecraft.client.gui.advancement.GuiAdvancement}
     *
     * @param greyScale the current gray scale
     * @return the int colour you want the background to be
     */
    public int recolourBackground(float greyScale);

    /**
     * Is there any special Icon rendering
     *
     * @return if true renderIcon will be executed, if false the regular item rendering will be done
     */
    public boolean hasSpecialIconRenderer();

    /**
     * Any special render code
     *
     * @param fontRenderer
     * @param textureManager
     * @param itemStack
     * @param left           left of the advancement icon
     * @param top            top of the advancement icon
     */
    public void renderIcon(FontRenderer fontRenderer, TextureManager textureManager, ItemStack itemStack, int left, int top);
}

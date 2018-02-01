package minechem.registry;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import minechem.Compendium;
import minechem.advancement.ElementAdvancement;
import minechem.advancement.ElementAdvancementList;
import minechem.chemical.Element;
import minechem.helper.PeriodicTableHelper;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementList;

public class AdvancementRegistry
{
    private static AdvancementRegistry instance;
    private Map<Element, Advancement> elementsAdvancementMap;
    private Map<String, Advancement> minechemAdvancementMap;
    public AdvancementList elementList, minechemList;

    private static Advancement nullAdvancement = null;

    public static AdvancementRegistry getInstance()
    {
        if (instance == null) {
            instance = new AdvancementRegistry();
        }
        return instance;
    }

    private AdvancementRegistry()
    {
        elementsAdvancementMap = new TreeMap<Element, Advancement>();
        minechemAdvancementMap = new TreeMap<String, Advancement>();
    }

    /**
     * Adds default advancement for an {@link minechem.chemical.Element}
     *
     * @param element the element to create an advancement for
     * @return the added {@link net.minecraft.advancements.Advancement}
     */
    public Advancement addAdvancement(Element element)
    {
        int[] position = PeriodicTableHelper.getPosition(element);
        ElementAdvancement advancement = new ElementAdvancement(element, position[0] - 5, position[1] - 8);
        elementsAdvancementMap.put(element, advancement);
        return advancement;
    }

    /**
     * Creates and adds an {@link net.minecraft.advancements.Advancement} to the {@link net.minecraft.advancements.AdvancementList} with given prerequisite {@link net.minecraft.advancements.Advancement}
     *
     * @param name             the name for the advancement
     * @param row              the row to display
     * @param column           the column display
     * @param displayItemStack the {@link net.minecraft.item.ItemStack} to display
     * @param prerequisite     the prerequisite {@link net.minecraft.advancements.Advancement}
     * @return the added {@link net.minecraft.advancements.Advancement}
     */
    public Advancement addAdvancement(String name, int row, int column, ItemStack displayItemStack, Advancement prerequisite)
    {
        return addAdvancement(name, row, column, displayItemStack, prerequisite, false);
    }

    public Advancement addAdvancement(String name, int row, int column, Item displayItem, Advancement prerequisite)
    {
        return addAdvancement(name, row, column, new ItemStack(displayItem), prerequisite);
    }

    public Advancement addAdvancement(String name, int row, int column, Block displayBlock, Advancement prerequisite)
    {
        return addAdvancement(name, row, column, new ItemStack(displayBlock), prerequisite);
    }

    /**
     * Creates and adds an {@link net.minecraft.advancements.Advancement} to the {@link net.minecraft.advancements.AdvancementList} with given prerequisite {@link net.minecraft.advancements.Advancement}
     *
     * @param name             the name for the advancement
     * @param row              the row to display
     * @param column           the column display
     * @param displayItemStack the {@link net.minecraft.item.ItemStack} to display
     * @param prerequisite     the prerequisite {@link net.minecraft.advancements.Advancement}
     * @param isSpecial        is this a special {@link net.minecraft.advancements.Advancement} ?
     * @return the added {@link net.minecraft.advancements.Advancement}
     */
    public Advancement addAdvancement(String name, int row, int column, ItemStack displayItemStack, Advancement prerequisite, boolean isSpecial)
    {
        String statName = Compendium.Naming.id + "." + name;
        Advancement advancement = new Advancement("advancement." + statName, statName, column, row, displayItemStack, prerequisite);
        if (isSpecial) {
            advancement.setSpecial();
        }
        if (prerequisite == null) {
            advancement.initIndependentStat();
        }
        return addAdvancement(advancement);
    }

    /**
     * Creates and adds an {@link net.minecraft.advancements.Advancement} to the {@link net.minecraft.advancements.AdvancementList}
     *
     * @param name             the name for the advancement
     * @param row              the row to display
     * @param column           the column display
     * @param displayItemStack the {@link net.minecraft.item.ItemStack} to display
     * @return the added {@link net.minecraft.advancements.Advancement}
     */
    public Advancement addAdvancement(String name, int row, int column, ItemStack displayItemStack)
    {
        return addAdvancement(name, row, column, displayItemStack, nullAdvancement, false);
    }

    public Advancement addAdvancement(String name, int row, int column, Item displayItem)
    {
        return addAdvancement(name, row, column, new ItemStack(displayItem), nullAdvancement, false);
    }

    public Advancement addAdvancement(String name, int row, int column, Block displayBlock)
    {
        return addAdvancement(name, row, column, new ItemStack(displayBlock), nullAdvancement, false);
    }

    /**
     * Add an {@link net.minecraft.advancements.Advancement} to the minechem {@link net.minecraft.advancements.AdvancementList}
     *
     * @param advancement the {@link net.minecraft.advancements.Advancement} to add
     * @return the added {@link net.minecraft.advancements.Advancement}
     */
    public Advancement addAdvancement(Advancement advancement)
    {
        minechemAdvancementMap.put(advancement.statId, advancement);
        return advancement;
    }

    /**
     * Gets the advancement for a specific {@link minechem.chemical.Element}
     *
     * @param element the element to find an {@link net.minecraft.advancements.Advancement for}
     * @return can be null if the {@link minechem.chemical.Element} has no {@link net.minecraft.advancements.Advancement}
     */
    public Advancement getAdvancement(Element element)
    {
        return elementsAdvancementMap.get(element);
    }

    /**
     * Get a minechem {@link net.minecraft.advancements.Advancement} for the given name
     *
     * @param name the name of the advancement
     * @return can be null if the name does not exist in the registry
     */
    public Advancement getAdvancement(String name)
    {
        return minechemAdvancementMap.get("advancement." + Compendium.Naming.id + "." + name);
    }

    /**
     * Registers {@link minechem.advancement.ElementAdvancement}s to the periodic table page
     */
    public void registerElementAdvancements()
    {
        Collection<Advancement> advancements = elementsAdvancementMap.values();
        for (Advancement advancement : advancements) {
            advancement.registerStat();
        }
        elementList = new ElementAdvancementList("Periodic Table", advancements.toArray(new Advancement[advancements.size()]));
        AdvancementList.registerAdvancementList(elementList);
    }

    /**
     * Registers {@link minechem.advancement.ElementAdvancement}s to the minechem page
     */
    public void registerMinechemAdvancements()
    {
        Collection<Advancement> advancements = minechemAdvancementMap.values();
        for (Advancement advancement : advancements) {
            advancement.registerStat();
        }
        minechemList = new AdvancementList(Compendium.Naming.name, advancements.toArray(new Advancement[advancements.size()]));
        AdvancementList.registerAdvancementList(minechemList);
    }
}

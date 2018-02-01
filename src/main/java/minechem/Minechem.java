package minechem;

import minechem.handler.*;
import minechem.helper.LogHelper;
import minechem.proxy.CommonProxy;
import minechem.registry.*;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod(modid = Compendium.Naming.id, name = Compendium.Naming.name, version = Compendium.Version.full, useMetadata = false, guiFactory = "minechem.proxy.client.gui.GuiFactory", acceptedMinecraftVersions = "[1.7.10,)", dependencies = "required-after:Forge@[10.13.2.1291,)")
public class Minechem
{
//    compile already
//    i would like to go to bed
//    compile failed: see log

    public static boolean isCoFHAAPILoaded;

    // Instancing
    @Instance(value = Compendium.Naming.id)
    public static Minechem INSTANCE;

    // Public extra data about our mod that Forge uses in the mods listing page for more information.
    @Mod.Metadata(Compendium.Naming.id)
    public static ModMetadata metadata;

    @SidedProxy(clientSide = "minechem.proxy.client.ClientProxy", serverSide = "minechem.proxy.CommonProxy")
    public static CommonProxy proxy;

    public static ElementHandler elementHandler;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        // Register instance.
        INSTANCE = this;

        try {
            // Shouldn't we be using Loader.isModLoaded here?
            Class.forName("cofh.redstoneflux.api.IEnergyHandler");
            isCoFHAAPILoaded = true;
        } catch (Exception e) {
            isCoFHAAPILoaded = false;
        }

        // Load configuration.
        LogHelper.debug("Loading configuration...");
        Config.init();
        FMLCommonHandler.instance().bus().register(new Config());

        LogHelper.debug("Registering Packets...");
        MessageHandler.init();

        LogHelper.debug("Setting up ModMetaData");
        metadata = Compendium.MetaData.init(metadata);

        // Register Elements and Molecules before constructing items
        LogHelper.debug("Registering Elements...");
        ElementHandler.init();

        LogHelper.debug("Registering Molecules...");
        MoleculeHandler.init();

        // Register items and blocks.
        LogHelper.debug("Registering Items...");
        ItemRegistry.init();

        LogHelper.debug("Registering Blocks...");
        BlockRegistry.init();

        LogHelper.debug("Registering Augments...");
        AugmentRegistry.init();

        LogHelper.debug("Registering CreativeTabs...");
        CreativeTabRegistry.init();

        // Register Event Handlers
        LogHelper.debug("Registering Event Handlers...");
        proxy.registerEventHandlers();

        LogHelper.debug("Registering Journal...");
        JournalRegistry.init();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        LogHelper.debug("Registering Recipes...");
        RecipeRegistry.getInstance().init();

        LogHelper.debug("Registering GUI and Container handlers...");
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());

        LogHelper.debug("Registering Renderers...");
        proxy.registerRenderers();

        LogHelper.debug("Registering Fonts...");
        proxy.registerFonts();

        LogHelper.debug("Registering Advancements...");
        AdvancementHandler.init();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.registerResourcesListener();

        LogHelper.info("Minechem has loaded");
    }

    @EventHandler
    public void onServerStarted(FMLServerStartedEvent event)
    {
        ResearchHandler.readPlayerResearch();
    }

    @EventHandler
    public void onServerStopping(FMLServerStoppingEvent event)
    {
        ResearchHandler.saveResearch();
    }
}

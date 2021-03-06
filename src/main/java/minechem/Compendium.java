package minechem;

import net.minecraftforge.fml.common.ModMetadata;

import java.util.Arrays;

import minechem.helper.LogHelper;
import minechem.helper.StringHelper;
import net.afterlifelochie.fontbox.api.ITracer;
import net.minecraft.util.ResourceLocation;

/*
 * A compendium of all constants for the mod, such as the modID and ResourceLocations, as well as more general things like color codes
 */
public class Compendium
{
    private static final String modPrefix = Compendium.Naming.id + ":";

    public static final class Color
    {
        public static final class TextFormat
        {
            public static final String black = "\u00A70";
            public static final String darkBlue = "\u00A71";
            public static final String darkCyan = "\u00A73";
            public static final String darkGreen = "\u00A72";
            public static final String darkGrey = "\u00A78";
            public static final String darkRed = "\u00A74";
            public static final String lightBlue = "\u00A79";
            public static final String lightCyan = "\u00A7b";
            public static final String lightGreen = "\u00A7a";
            public static final String lightGrey = "\u00A77";
            public static final String lightRed = "\u00A7c";
            public static final String orange = "\u00A76";
            public static final String pink = "\u00A7d";
            public static final String purple = "\u00A75";
            public static final String white = "\u00A7f";
            public static final String yellow = "\u00A7e";
        }

        public static final class TrueColor
        {
            public static final int black = -16777216;
            public static final int blue = -16776961;
            public static final int cyan = -16711681;
            public static final int darkGrey = -12303292;
            public static final int grey = -7829368;
            public static final int green = -16711936;
            public static final int lightGrey = -3355444;
            public static final int magenta = -65281;
            public static final int red = -65536;
            public static final int transparent = 0;
            public static final int white = -1;
            public static final int yellow = -256;
        }

    }

    public static final class Config
    {
        public static final String configPrefix = "config/minechem/";
        public static final String assetPrefix = "/assets/minechem/";
        public static final String dataJsonPrefix = "data/";
        public static final String elementsDataJson = "elementsData.json";
        public static final String moleculesDataJson = "moleculesData.json";
        public static final String researchPagesJson = "pages.json";
        public static final String playerResearchData = "minechem/researchData.json";
    }

    public static final class MetaData
    {
        public static final String patreon = "https://www.patreon.com/jakimfett";

        /**
         * Setup mod metadata
         *
         * @param metadata
         * @return edited metadata object
         */
        public static ModMetadata init(ModMetadata metadata)
        {
            metadata.modId = Compendium.Naming.id;
            metadata.name = Compendium.Naming.name;
            metadata.description = Compendium.Naming.name + " is a mod about chemistry, allowing you to research blocks and items, and then break them down into their base compounds and elements.";
            metadata.url = "http://www.minechemmod.com/";
            metadata.logoFile = "assets/" + Compendium.Naming.id + "/logo.png";
            metadata.version = Compendium.Version.major + "." + Compendium.Version.minor + "." + Compendium.Version.build;
            metadata.authorList = Arrays.asList("jakimfett", "hilburn", "way2muchnoise");
            metadata.credits = "View a full list of contributors on our site!";
            metadata.autogenerated = false;
            return metadata;
        }
    }

    public static final class Naming
    {
        public static final String id = "minechem";
        public static final String name = "Minechem";
        public static final String fontBox = "fontbox";
        public static final String opticalMicroscope = "opticalMicroscope";
        public static final String electrolysis = "electrolysis";
        public static final String electricCrucible = "electricCrucible";
        public static final String centrifuge = "centrifuge";
        public static final String journal = "journal";
        public static final String light = "light";
        public static final String redstone = "redstone";

        public class Mods
        {
            public static final String ae = "AppliedEnergistics";
            public static final String ae2 = "appliedenergistics2";
            public static final String armorStatusHUD = "ArmorStatusHUD";
            public static final String arsMagica2 = "arsmagica2";
            public static final String biblioCraft = "BiblioCraft";
            public static final String billund = "Billund";
            public static final String biomesOPlenty = "BiomesOPlenty";
            public static final String blockBreaker = "BlockBreaker";
            public static final String bloodMagic = "AWWayofTime";
            public static final String bluePower = "bluepower";
            public static final String bigReactors = "BigReactors";
            public static final String buildCraftBuilders = "BuildCraft|Builders";
            public static final String buildCraftCore = "BuildCraft|Core";
            public static final String buildCraftEnergy = "BuildCraft|Energy";
            public static final String buildCraftFactory = "BuildCraft|Factory";
            public static final String buildCraftSilicon = "BuildCraft|Factory";
            public static final String buildCraftTransport = "BuildCraft|Transport";
            public static final String chickenChunks = "ChickenChunks";
            public static final String chromatiCraft = "ChromatiCraft";
            public static final String computerCraft = "ComputerCraft";
            public static final String computerCraftTurtle = "CCTurtle";
            public static final String CoFHCore = "CoFHCore";
            public static final String crystalWing = "CrystalWing";
            public static final String directionHUD = "DirectionHUD";
            public static final String denseOres = "denseores";
            public static final String enderStorage = "EnderStorage";
            public static final String extraBees = "ExtraBees";
            public static final String extraBiomesXL = "ExtrabiomesXL";
            public static final String extraTrees = "ExtraTrees";
            public static final String extraUtilities = "ExtraUtilities";
            public static final String electriCraft = "ElectriCraft";
            public static final String expandedRedstone = "ExpandedRedstone";
            public static final String floatingRuins = "FloatingRuins";
            public static final String forestry = "Forestry";
            public static final String gravityGun = "GraviGun";
            public static final String gregTech = "gregtech";
            public static final String hatStand = "HatStand";
            public static final String hats = "Hats";
            public static final String ic2 = "IC2";
            public static final String ingameInfo = "IngameInfo";
            public static final String magicBees = "MagicBees";
            public static final String magicCrops = "magicalcrops";
            public static final String modularPowerSuits = "powersuits";
            public static final String minefactoryReloaded = "MineFactoryReloaded";
            public static final String minecraftMultiPart = "McMultipart";
            public static final String mystCraft = "Mystcraft";
            public static final String metalurgy = "Metallurgy";
            public static final String mobProperties = "MobProperties";
            public static final String netherOres = "NetherOres";
            public static final String openBlocks = "OpenBlocks";
            public static final String openPeripheral = "OpenPeripheral";
            public static final String openPeripheralCore = "OpenPeripheralCore";
            public static final String openComputers = "OpenComputers";
            public static final String portalGun = "PortalGun";
            public static final String pneumaticCraft = "PneumaticCraft";
            public static final String projectRed = "ProjRed|Core";
            public static final String projectRedTransmission = "ProjRed|Transmission";
            public static final String railCraft = "Railcraft";
            public static final String routerReborn = "RouterReborn";
            public static final String reactorCraft = "ReactorCraft";
            public static final String rotaryCraft = "RotaryCraft";
            public static final String scCraft = "SGCraft";
            public static final String startingInventory = "StartingInventory";
            public static final String statusEffectHUD = "StatusEffectHUD";
            public static final String stevesCarts = "StevesCarts";
            public static final String stevesFactoryManager = "StevesFactoryManager";
            public static final String tinkersConstruct = "TConstruct";
            public static final String tinkersMechworks = "TMechworks";
            public static final String thaumcraft = "Thaumcraft";
            public static final String thermalExpansion = "ThermalExpansion";
            public static final String thermalFoundation = "ThermalFoundation";
            public static final String translocator = "Translocator";
            public static final String treeCapitator = "TreeCapitator";
            public static final String wirelessRedstoneCBE = "WR-CBE|Core";
            public static final String worldStateCheckPoints = "WorldStateCheckpoints";
            public static final String flansMod = "FlansMod";
        }

    }

    public static final class Fontbox
    {
        public static ITracer tracer()
        {
            return new Tracer();
        }

        public static final class Tracer implements ITracer
        {
            @Override
            public void trace(Object... params)
            {
                LogHelper.debug("Fontbox trace: " + StringHelper.toString(", ", params));
            }

            @Override
            public void warn(Object... params)
            {
                LogHelper.warn("Fontbox warn: " + StringHelper.toString(", ", params));
            }

            @Override
            public boolean enableAssertion()
            {
                return false;
            }
        }
    }

    public static final class Resource
    {
        public static final class Icon
        {
            public static final ResourceLocation patreon = new ResourceLocation(Compendium.Naming.id, Compendium.Texture.Icon.patreon);
        }

        public static final class GUI
        {
            public static final ResourceLocation journal = new ResourceLocation(Compendium.Naming.id, Compendium.Texture.GUI.journal);
            public static final ResourceLocation opticalMicroscope = new ResourceLocation(Compendium.Naming.id, Compendium.Texture.GUI.opticalMicroscope);
            public static final ResourceLocation advancements = new ResourceLocation(Compendium.Naming.id, Compendium.Texture.GUI.advancements);
            public static final ResourceLocation noContent = new ResourceLocation(Compendium.Naming.id, Compendium.Texture.GUI.noContent);

            public static ResourceLocation getResourceForStructure(String name)
            {
                return new ResourceLocation(Compendium.Naming.id, Compendium.Texture.GUI.compounds + name.replaceAll("\\s", "_") + ".png");
            }

            public static final class Element
            {
                public static final ResourceLocation fluidTank = new ResourceLocation(Compendium.Naming.id, Texture.GUI.Element.fluidTank);
            }
        }

        public static final class Model
        {
            public static final ResourceLocation microscope = new ResourceLocation(Compendium.Naming.id, Compendium.Texture.Model.opticalMicroscope);
            public static final ResourceLocation electrolysis = new ResourceLocation(Compendium.Naming.id, Compendium.Texture.Model.electrolysis);
            public static final ResourceLocation electricCrucible = new ResourceLocation(Compendium.Naming.id, Compendium.Texture.Model.electricCrucible);
            public static final ResourceLocation centrifuge = new ResourceLocation(Compendium.Naming.id, Compendium.Texture.Model.centrifuge);
        }

        public static final class Tab
        {
            public static final ResourceLocation right = new ResourceLocation(Compendium.Naming.id, Compendium.Texture.GUI.tab_right);
            public static final ResourceLocation left = new ResourceLocation(Compendium.Naming.id, Compendium.Texture.GUI.tab_left);
        }

        public static final class Font
        {
            public static final ResourceLocation danielFont = new ResourceLocation(Compendium.Naming.fontBox, Compendium.Texture.Font.danielFont);
            public static final ResourceLocation danielMetrics = new ResourceLocation(Compendium.Naming.fontBox, Compendium.Texture.Font.danielMetrics);
            public static final ResourceLocation vanilla = new ResourceLocation("textures/font/ascii.png");
        }
    }

    public static final class Texture
    {
        public static final String prefix = Compendium.Naming.id + ":";

        public static final class IIcon
        {

        }

        public static final class Icon
        {

            private static final String prefix = "textures/icons/";
            public static final String patreon = Compendium.Texture.Icon.prefix + "patreon.png";
        }

        public static final class Item
        {

            private static final String prefix = "textures/item/";
            private static final String suffix = "Icon.png";
            public static final String augmentDefault = Compendium.Texture.Item.prefix + "augment" + Compendium.Texture.Item.suffix;
        }

        public static final class GUI
        {
            private static final String prefix = "textures/gui/";
            public static final String compounds = Compendium.Texture.GUI.prefix + "compounds/";

            public static final String blankMachine = Compendium.Texture.GUI.prefix + "blankMachine.png";
            public static final String journal = Compendium.Texture.GUI.prefix + "journal.png";
            public static final String opticalMicroscope = Compendium.Texture.GUI.prefix + "opticalMicroscope.png";
            public static final String tab_left = Compendium.Texture.GUI.prefix + "tabLeft.png";
            public static final String tab_right = Compendium.Texture.GUI.prefix + "tabRight.png";
            public static final String advancements = Compendium.Texture.GUI.prefix + "advancementList.png";
            public static final String noContent = Compendium.Texture.GUI.prefix + "noContent.png";

            public static final class Element
            {
                public static final String fluidTank = Compendium.Texture.GUI.prefix + "fluidTank.png";
            }
        }

        public static final class Model
        {
            public static final String prefix = "textures/models/";
            public static final String opticalMicroscope = Compendium.Texture.Model.prefix + "opticalMicroscope.png";
            public static final String electrolysis = Compendium.Texture.Model.prefix + "electrolysis.png";
            public static final String electricCrucible = Compendium.Texture.Model.prefix + "electricCrucible.png";
            public static final String centrifuge = Compendium.Texture.Model.prefix + "centrifuge.png";
        }

        public static final class Font
        {
            public static final String prefix = "textures/fonts/";
            public static final String danielFont = Compendium.Texture.Font.prefix + "daniel.png";
            public static final String danielMetrics = Compendium.Texture.Font.prefix + "daniel.metrics.xml";
        }
    }

    public static final class Version
    {
        public static final String major = "@MAJOR@";
        public static final String minor = "@MINOR@";
        public static final String build = "@BUILD@";
        public static final String full = major + "." + minor + "." + build;
    }

    public class NBTTags
    {
        public static final int tagEnd = 0;
        public static final int tagByte = 1;
        public static final int tagShort = 2;
        public static final int tagInt = 3;
        public static final int tagLong = 4;
        public static final int tagFloat = 5;
        public static final int tagDouble = 6;
        public static final int tagByteArray = 7;
        public static final int tagString = 8;
        public static final int tagList = 9;
        public static final int tagCompound = 10;
        public static final int tagIntArray = 11;

        public static final String slot = "slot";
        public static final String stack = "stack";
        public static final String inventory = "inventory";
        public static final String timer = "timer";
        public static final String count = "count";
        public static final String reset = "reset";
        public static final String fluid = "fluid";
        public static final String fluidNull = "fluid_null";
        public static final String amount = "amount";
        public static final String capacity = "capacity";
        public static final String name = "name";
        public static final String x = "xCoord";
        public static final String y = "xCoord";
        public static final String z = "zCoord";
        public static final String nbt = "nbt";
        public static final String item = "item";
        public static final String damage = "damage";
    }
}

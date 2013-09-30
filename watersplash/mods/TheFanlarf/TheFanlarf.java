package watersplash.mods.TheFanlarf;


import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemTool;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


@Mod(modid = "TheFanlarf", name = "TheFanlarf", version = "1.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class TheFanlarf {

	// Blocks and Items //

	public static ItemTool HardenedClayPick;

	// Config intIDs//

	public int HardenedClayPickID;


	@SidedProxy(clientSide = "watersplash.mods.TheFanlarf.TheFanlarfClient", serverSide = "watersplash.mods.TheFanlarf.TheFanlarfProxy")
	public static TheFanlarfProxy proxy;


	@EventHandler
	public void PreLoad(FMLPreInitializationEvent event){
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());

		config.load();

		HardenedClayPickID=config.getItem("HardenedClayPick ID", Configuration.CATEGORY_ITEM, 3853).getInt();

		config.save();
		
	}



	@EventHandler

	public void load(FMLInitializationEvent event){

		proxy.registerRenderInformation();
	
		HardenedClayPick = (ItemTool)(new HardenedClayPick(HardenedClayPickID, EnumToolMaterial.STONE)).setUnlocalizedName("HardenedClayPick");

		//Registering things//

		//GameRegistry.addSmelting(TheFanlarf.RawFrank.itemID, new ItemStack(TheFanlarf.CookedFrank, 1), 300.0f);

		LanguageRegistry.addName(HardenedClayPick, "Clay Pickaxe");

		//Recipes//

		
		GameRegistry.addRecipe( new ItemStack(HardenedClayPick,1), new Object[]{
			"CCC", " S ", " S ", 'C', Block.hardenedClay  , 'S', Item.stick });

	}


}

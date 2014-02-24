package watersplash.mods.MJHotdog;


import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.init.Items;

@Mod(modid = "MJHotdog", name = "MJHotdog", version = "1.7.2_2")
//@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class MJHotdog {

	// Blocks and Items //

	public static ItemFood RawFrank;
	public static ItemFood CookedFrank;
	public static ItemFood Hotdog;
	public static ItemFood HotdogKetchup;
	public static ItemFood HotdogMustard;
	public static ItemFood HotdogRelish;

	// Config intIDs//
/*
	public int RawFrankID;
	public int CookedFrankID;
	public int HotdogID;
	public int HotdogKetchupID;
	public int HotdogMustardID;
	public int HotdogRelishID;
*/

	@SidedProxy(clientSide = "watersplash.mods.MJHotdog.MJHotdogClient", serverSide = "watersplash.mods.MJHotdog.MJHotdogProxy")
	public static MJHotdogProxy proxy;


	@EventHandler
	public void PreLoad(FMLPreInitializationEvent event){
/*		Configuration config = new Configuration(event.getSuggestedConfigurationFile());

		config.load();

		RawFrankID=config.get("RawFrank ID", Configuration.CATEGORY_GENERAL, 3853).getInt();
		CookedFrankID=config.get("CookedFrank ID", Configuration.CATEGORY_GENERAL, 3854).getInt();
		HotdogID=config.get("Hotdog ID", Configuration.CATEGORY_GENERAL, 3855).getInt();
		HotdogKetchupID=config.get("HotdogKetchup ID", Configuration.CATEGORY_GENERAL, 3856).getInt();
		HotdogMustardID=config.get("HotdogMustard ID", Configuration.CATEGORY_GENERAL, 3857).getInt();
		HotdogRelishID=config.get("HotdogRelish ID", Configuration.CATEGORY_GENERAL, 3858).getInt();

		config.save();
*/		
		initializeItems();
	}

    public void initializeItems() {
    	// 201402011343 MJS : new ItemFood(int healthAmount, bool isFoodForWolves)
		RawFrank = (ItemFood)(new RawFrank(2, false)).setUnlocalizedName("RawFrank");
		CookedFrank = (ItemFood)(new CookedFrank(6, false)).setUnlocalizedName("CookedFrank");
		Hotdog = (ItemFood)(new Hotdog(6, false)).setUnlocalizedName("Hotdog");
		HotdogKetchup = (ItemFood)(new Hotdog(7, false)).setUnlocalizedName("HotdogKetchup");
		HotdogMustard = (ItemFood)(new Hotdog(7, false)).setUnlocalizedName("HotdogMustard");
		HotdogRelish = (ItemFood)(new Hotdog(7, false)).setUnlocalizedName("HotdogRelish");

		GameRegistry.registerItem(RawFrank, "RawFrank");
		GameRegistry.registerItem(CookedFrank, "CookedFrank");
		GameRegistry.registerItem(Hotdog, "Hotdog");
		GameRegistry.registerItem(HotdogKetchup, "HotdogKetchup");
		GameRegistry.registerItem(HotdogMustard, "HotdogMustard");
		GameRegistry.registerItem(HotdogRelish, "HotdogRelish");

    }

	@EventHandler

	public void load(FMLInitializationEvent event){

		//proxy.registerRenderInformation();
		
		//initializeItems();
		

		//Registering things//

//		GameRegistry.addSmelting(MJHotdog.RawFrank, new ItemStack(MJHotdog.CookedFrank, 1), 300.0f);
		GameRegistry.addSmelting(GameRegistry.findItem("MJHotdog", "RawFrank"), new ItemStack(MJHotdog.CookedFrank, 1), 300.0f);

		
		
/* 201401312051 MJS : Added lang/en_US.lang file
		LanguageRegistry.addName(RawFrank, "Raw Frankfurter");
		LanguageRegistry.addName(CookedFrank, "Cooked Frankfurter");
		LanguageRegistry.addName(Hotdog, "Hotdog");
		LanguageRegistry.addName(HotdogKetchup, "Ketchup Hotdog");
		LanguageRegistry.addName(HotdogMustard, "Mustard Hotdog");
		LanguageRegistry.addName(HotdogRelish, "Relish Hotdog");
*/
		//Recipes//
		final int DYE_COLOR_RED = 1;     //only for use with Items.dye below
		final int DYE_COLOR_YELLOW = 11; //only for use with Items.dye below
		final int DYE_COLOR_GREEN = 2;   //only for use with Items.dye below
		
		
		GameRegistry.addShapelessRecipe( new ItemStack(RawFrank,4), 
			Items.porkchop, Items.chicken, Items.beef, Items.rotten_flesh);
		GameRegistry.addRecipe( new ItemStack(Hotdog,2), 
			"F ", "B ", 'F', MJHotdog.CookedFrank, 'B', Items.bread);
		GameRegistry.addRecipe( new ItemStack(HotdogKetchup,1), 
			"R ", "H ", 'R', new ItemStack(Items.dye, 1, DYE_COLOR_RED), 'H', MJHotdog.Hotdog);
		GameRegistry.addRecipe( new ItemStack(HotdogMustard,1), 
			"Y ", "H ", 'Y', new ItemStack(Items.dye, 1, DYE_COLOR_YELLOW), 'H', MJHotdog.Hotdog);
		GameRegistry.addRecipe( new ItemStack(HotdogRelish,1), 
			"G ", "H ", 'G', new ItemStack(Items.dye, 1, DYE_COLOR_GREEN), 'H', MJHotdog.Hotdog);

	}


}

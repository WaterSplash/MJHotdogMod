package watersplash.mods.MJHotdog;


import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
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


@Mod(modid = "MJHotdog", name = "MJHotdog", version = "1.0.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class MJHotdog {

	// Blocks and Items //

	public static ItemFood RawFrank;
	public static ItemFood CookedFrank;
	public static ItemFood Hotdog;
	public static ItemFood HotdogKetchup;
	public static ItemFood HotdogMustard;
	public static ItemFood HotdogRelish;

	// Config intIDs//

	public int RawFrankID;
	public int CookedFrankID;
	public int HotdogID;
	public int HotdogKetchupID;
	public int HotdogMustardID;
	public int HotdogRelishID;


	@SidedProxy(clientSide = "watersplash.mods.MJHotdog.MJHotdogClient", serverSide = "watersplash.mods.MJHotdog.MJHotdogProxy")
	public static MJHotdogProxy proxy;


	@EventHandler
	public void PreLoad(FMLPreInitializationEvent event){
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());

		config.load();

		RawFrankID=config.getItem("RawFrank ID", Configuration.CATEGORY_ITEM, 3853).getInt();
		CookedFrankID=config.getItem("CookedFrank ID", Configuration.CATEGORY_ITEM, 3854).getInt();
		HotdogID=config.getItem("Hotdog ID", Configuration.CATEGORY_ITEM, 3855).getInt();
		HotdogKetchupID=config.getItem("HotdogKetchup ID", Configuration.CATEGORY_ITEM, 3856).getInt();
		HotdogMustardID=config.getItem("HotdogMustard ID", Configuration.CATEGORY_ITEM, 3857).getInt();
		HotdogRelishID=config.getItem("HotdogRelish ID", Configuration.CATEGORY_ITEM, 3858).getInt();

		config.save();
		
	}



	@EventHandler

	public void load(FMLInitializationEvent event){

		proxy.registerRenderInformation();
	
		RawFrank = (ItemFood)(new RawFrank(RawFrankID, 2, false)).setUnlocalizedName("RawFrank");
		CookedFrank = (ItemFood)(new CookedFrank(CookedFrankID, 6, false)).setUnlocalizedName("CookedFrank");
		Hotdog = (ItemFood)(new Hotdog(HotdogID, 6, false)).setUnlocalizedName("Hotdog");
		HotdogKetchup = (ItemFood)(new Hotdog(HotdogKetchupID, 7, false)).setUnlocalizedName("HotdogKetchup");
		HotdogMustard = (ItemFood)(new Hotdog(HotdogMustardID, 7, false)).setUnlocalizedName("HotdogMustard");
		HotdogRelish = (ItemFood)(new Hotdog(HotdogRelishID, 7, false)).setUnlocalizedName("HotdogRelish");

		//Registering things//

		GameRegistry.addSmelting(MJHotdog.RawFrank.itemID, new ItemStack(MJHotdog.CookedFrank, 1), 300.0f);

		LanguageRegistry.addName(RawFrank, "Raw Frankfurter");
		LanguageRegistry.addName(CookedFrank, "Cooked Frankfurter");
		LanguageRegistry.addName(Hotdog, "Hotdog");
		LanguageRegistry.addName(HotdogKetchup, "Ketchup Hotdog");
		LanguageRegistry.addName(HotdogMustard, "Mustard Hotdog");
		LanguageRegistry.addName(HotdogRelish, "Relish Hotdog");

		//Recipes//

		GameRegistry.addShapelessRecipe( new ItemStack(RawFrank,4), new Object[]{
			Item.porkRaw, Item.chickenRaw, Item.beefRaw, Item.rottenFlesh});
		GameRegistry.addRecipe( new ItemStack(Hotdog,2), new Object[]{
			"F ", "B ", 'F', MJHotdog.CookedFrank, 'B', Item.bread});
		GameRegistry.addRecipe( new ItemStack(HotdogKetchup,1), new Object[]{
			"R ", "H ", 'R', new ItemStack(Item.dyePowder, 1, 1), 'H', MJHotdog.Hotdog});
		GameRegistry.addRecipe( new ItemStack(HotdogMustard,1), new Object[]{
			"Y ", "H ", 'Y', new ItemStack(Item.dyePowder, 1, 11), 'H', MJHotdog.Hotdog});
		GameRegistry.addRecipe( new ItemStack(HotdogRelish,1), new Object[]{
			"G ", "H ", 'G', new ItemStack(Item.dyePowder, 1, 2), 'H', MJHotdog.Hotdog});

	}


}

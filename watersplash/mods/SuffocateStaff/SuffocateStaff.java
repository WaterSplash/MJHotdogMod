package watersplash.mods.SuffocateStaff;


import net.minecraft.item.Item;
import net.minecraft.item.EnumToolMaterial;
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


@Mod(modid = "SuffocateStaff", name = "SuffocateStaff", version = "1.6.2")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class SuffocateStaff {

	// Blocks and Items //

	public static ItemSuffocateStaff SuffocateStaff;

	// Config intIDs//

	public int SuffocateStaffID;


	@SidedProxy(clientSide = "watersplash.mods.SuffocateStaff.SuffocateStaffClient", serverSide = "watersplash.mods.SuffocateStaff.SuffocateStaffProxy")
	public static SuffocateStaffProxy proxy;


	@EventHandler
	public void PreLoad(FMLPreInitializationEvent event){
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());

		config.load();

		SuffocateStaffID=config.getItem("ItemSuffocateStaff ID", Configuration.CATEGORY_ITEM, 3873).getInt();

		config.save();
		
	}



	@EventHandler

	public void load(FMLInitializationEvent event){

		proxy.registerRenderInformation();
	
		SuffocateStaff = (ItemSuffocateStaff)(new ItemSuffocateStaff(SuffocateStaffID, EnumToolMaterial.WOOD )).setUnlocalizedName("SuffocateStaff");

		//Registering things//

		LanguageRegistry.addName(SuffocateStaff, "Suffocate Staff");

		//Recipes//

		GameRegistry.addRecipe( new ItemStack(SuffocateStaff,1), new Object[]{
			"  S"," S ","G  ", 'S', Item.stick, 'G', Item.ingotGold});

	}


}

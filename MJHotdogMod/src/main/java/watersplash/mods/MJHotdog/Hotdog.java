package watersplash.mods.MJHotdog;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class Hotdog extends ItemFood {
	
    public Hotdog(int healthAmount, boolean isFoodForWolves)
    {
        super(healthAmount, 0.6F, isFoodForWolves);
    }

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
	{
		String unlocalizedName = this.getUnlocalizedName();
		if(unlocalizedName.equals("item.Hotdog"))
			this.itemIcon = par1IconRegister.registerIcon("MJHotdog:Hotdog");
		else
			if(unlocalizedName.equals("item.HotdogKetchup"))
				this.itemIcon = par1IconRegister.registerIcon("MJHotdog:HotdogKetchup");
			else
				if(unlocalizedName.equals("item.HotdogMustard"))
					this.itemIcon = par1IconRegister.registerIcon("MJHotdog:HotdogMustard");
				else
					if(unlocalizedName.equals("item.HotdogRelish"))
						this.itemIcon = par1IconRegister.registerIcon("MJHotdog:HotdogRelish");
	}

    
}

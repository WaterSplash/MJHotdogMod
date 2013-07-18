package watersplash.mods.MJHotdog;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class Hotdog extends ItemFood {
	
    public Hotdog(int par1, int par2, boolean par3)
    {
        super(par1, par2, 0.6F, par3);
    }
    


	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
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

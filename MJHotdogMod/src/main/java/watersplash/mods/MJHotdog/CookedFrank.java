package watersplash.mods.MJHotdog;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class CookedFrank extends ItemFood {
	
    public CookedFrank(int par2, boolean par3)
    {
        super(par2, 0.6F, par3);
    }
    


	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon("MJHotdog:CookedFrank");
	}

    
}

package watersplash.mods.MJHotdog;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class RawFrank extends ItemFood {
	
    public RawFrank(int par1, int par2, boolean par3)
    {
        super(par1, par2, 0.6F, par3);
    }
    


	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon("MJHotdog:RawFrank");
	}

    
}

package watersplash.mods.MJHotdog;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class RawFrank extends ItemFood {
	
    public RawFrank(int healthAmount, boolean isFoodForWolves)
    {
        super(healthAmount, 0.6F, isFoodForWolves);
    }

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon("MJHotdog:RawFrank");
	}

    
}

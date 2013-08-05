package watersplash.mods.SuffocateStaff;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemSuffocateStaff extends ItemSword {
		
    public ItemSuffocateStaff(int par1, EnumToolMaterial material)
    {
        super(par1, material);
    }
    
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {
    	par2EntityLivingBase.setPositionAndUpdate(par2EntityLivingBase.posX, par2EntityLivingBase.posY - 3.0, par2EntityLivingBase.posZ);
        par1ItemStack.damageItem(1, par3EntityLivingBase);
        return true;
    }


	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon("SuffocateStaff:SuffocateStaff");
	}

    
}

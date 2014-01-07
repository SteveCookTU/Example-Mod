package example;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = Example.modid, name = "Example Mod", version = "1.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class Example {
	
	public static final String modid = "imaboy321_examplemod";
	
	public static Block exampleBlock;
	public static Item exampleItem;
	
	@EventHandler
	public void load(FMLInitializationEvent event) {
		exampleBlock = new BlockExampleBlock(543, Material.ground).setUnlocalizedName("exampleBlock");
		exampleItem = new ItemExample(5432).setUnlocalizedName("exampleItem");
		
		GameRegistry.registerBlock(exampleBlock, modid + exampleBlock.getUnlocalizedName().substring(5));
		GameRegistry.addShapelessRecipe(new ItemStack(exampleBlock), new Object[] {
			new ItemStack(exampleItem), new ItemStack(exampleItem)
		});
		GameRegistry.addShapedRecipe(new ItemStack(exampleBlock), new Object[] {
			" X ",
			"XXX",
			" X ",
			'X', exampleItem
		});
		GameRegistry.addShapedRecipe(new ItemStack(exampleBlock), new Object[] {
			"X X",
			" X ",
			"X X",
			'X', exampleItem
		});
		GameRegistry.addSmelting(exampleBlock.blockID, new ItemStack(exampleItem), 1F);
		LanguageRegistry.addName(exampleBlock, "Example Block");
		LanguageRegistry.addName(exampleItem, "Example Item");
		
	}

}

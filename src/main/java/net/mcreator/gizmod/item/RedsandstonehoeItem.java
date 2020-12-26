
package net.mcreator.gizmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.HoeItem;

import net.mcreator.gizmod.itemgroup.OzItemGroup;
import net.mcreator.gizmod.GizmodModElements;

@GizmodModElements.ModElement.Tag
public class RedsandstonehoeItem extends GizmodModElements.ModElement {
	@ObjectHolder("gizmod:redsandstonehoe")
	public static final Item block = null;
	public RedsandstonehoeItem(GizmodModElements instance) {
		super(instance, 27);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
			public int getMaxUses() {
				return 100;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, -3f, new Item.Properties().group(OzItemGroup.tab)) {
		}.setRegistryName("redsandstonehoe"));
	}
}

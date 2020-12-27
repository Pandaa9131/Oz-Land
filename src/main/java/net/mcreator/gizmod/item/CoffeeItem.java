
package net.mcreator.gizmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;

import net.mcreator.gizmod.procedures.CoffeeEffectProcedure;
import net.mcreator.gizmod.itemgroup.OzItemGroup;
import net.mcreator.gizmod.GizmodModElements;

import java.util.Map;
import java.util.HashMap;

@GizmodModElements.ModElement.Tag
public class CoffeeItem extends GizmodModElements.ModElement {
	@ObjectHolder("gizmod:coffee")
	public static final Item block = null;
	public CoffeeItem(GizmodModElements instance) {
		super(instance, 38);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(OzItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(10).saturation(1f).setAlwaysEdible().build()));
			setRegistryName("coffee");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 20;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.DRINK;
		}

		@Override
		public net.minecraft.util.SoundEvent getEatSound() {
			return net.minecraft.util.SoundEvents.ENTITY_GENERIC_DRINK;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemstack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				CoffeeEffectProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}

package net.mcreator.gizmod.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.gizmod.GizmodModElements;

import java.util.Map;

@GizmodModElements.ModElement.Tag
public class CoffeeEffectProcedure extends GizmodModElements.ModElement {
	public CoffeeEffectProcedure(GizmodModElements instance) {
		super(instance, 39);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure CoffeeEffect!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 300, (int) 2, (false), (false)));
	}
}


package net.mcreator.gizmod.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.Item;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.block.material.Material;

import net.mcreator.gizmod.itemgroup.OzItemGroup;
import net.mcreator.gizmod.GizmodModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@GizmodModElements.ModElement.Tag
public class ChickkyEntity extends GizmodModElements.ModElement {
	public static EntityType entity = null;
	public ChickkyEntity(GizmodModElements instance) {
		super(instance, 36);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.CREATURE).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("chickky")
						.setRegistryName("chickky");
		elements.entities.add(() -> entity);
		elements.items.add(
				() -> new SpawnEggItem(entity, -10092442, -26368, new Item.Properties().group(OzItemGroup.tab)).setRegistryName("chickky_spawn_egg"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			biome.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(entity, 100, 4, 4));
		}
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos,
						random) -> (world.getBlockState(pos.down()).getMaterial() == Material.ORGANIC && world.getLightSubtracted(pos, 0) > 8));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modelcustom_model(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("gizmod:textures/chick.png");
				}
			};
		});
	}
	public static class CustomEntity extends CreatureEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 0;
			setNoAI(false);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false));
			this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 1));
			this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
			this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(5, new SwimGoal(this));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);
		}
	}

	// Made with Blockbench 3.7.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelcustom_model extends EntityModel<Entity> {
		private final ModelRenderer EmptyRootBone;
		private final ModelRenderer BodyBone;
		private final ModelRenderer HeadBone;
		private final ModelRenderer WingControlBone;
		private final ModelRenderer LWingBone;
		private final ModelRenderer cube_r1;
		private final ModelRenderer RWingBone;
		private final ModelRenderer FootControlBone;
		private final ModelRenderer RFootBone;
		private final ModelRenderer LFootBone;
		public Modelcustom_model() {
			textureWidth = 64;
			textureHeight = 64;
			EmptyRootBone = new ModelRenderer(this);
			EmptyRootBone.setRotationPoint(0.0F, 24.0F, 0.0F);
			BodyBone = new ModelRenderer(this);
			BodyBone.setRotationPoint(2.0F, -4.0F, 1.0F);
			EmptyRootBone.addChild(BodyBone);
			BodyBone.setTextureOffset(0, 0).addBox(-4.0F, -7.0F, -4.0F, 7.0F, 7.0F, 7.0F, 0.0F, false);
			HeadBone = new ModelRenderer(this);
			HeadBone.setRotationPoint(1.0F, -11.0F, -3.0F);
			EmptyRootBone.addChild(HeadBone);
			HeadBone.setTextureOffset(0, 14).addBox(-2.0F, -5.0F, -3.0F, 5.0F, 5.0F, 5.0F, 0.0F, false);
			HeadBone.setTextureOffset(21, 4).addBox(-1.0F, -2.0F, -4.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			WingControlBone = new ModelRenderer(this);
			WingControlBone.setRotationPoint(0.0F, 0.0F, 0.0F);
			EmptyRootBone.addChild(WingControlBone);
			LWingBone = new ModelRenderer(this);
			LWingBone.setRotationPoint(5.0F, -10.0F, 0.0F);
			WingControlBone.addChild(LWingBone);
			LWingBone.setTextureOffset(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
			LWingBone.setTextureOffset(0, 14).addBox(0.0F, 0.0F, 1.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(1.0F, 0.0F, -2.0F);
			LWingBone.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.0F, 0.0F, -1.5708F);
			cube_r1.setTextureOffset(20, 20).addBox(-5.0F, -1.0F, 0.0F, 5.0F, 1.0F, 2.0F, 0.0F, false);
			RWingBone = new ModelRenderer(this);
			RWingBone.setRotationPoint(-2.0F, -10.0F, 0.0F);
			WingControlBone.addChild(RWingBone);
			setRotationAngle(RWingBone, 0.0F, 0.0F, -1.5708F);
			RWingBone.setTextureOffset(15, 15).addBox(-5.0F, -1.0F, -2.0F, 5.0F, 1.0F, 2.0F, 0.0F, false);
			RWingBone.setTextureOffset(22, 23).addBox(-3.0F, -1.0F, 1.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			RWingBone.setTextureOffset(20, 18).addBox(-4.0F, -1.0F, 0.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
			FootControlBone = new ModelRenderer(this);
			FootControlBone.setRotationPoint(0.0F, 0.0F, 0.0F);
			EmptyRootBone.addChild(FootControlBone);
			RFootBone = new ModelRenderer(this);
			RFootBone.setRotationPoint(0.0F, -4.0F, 1.0F);
			FootControlBone.addChild(RFootBone);
			RFootBone.setTextureOffset(4, 27).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			RFootBone.setTextureOffset(17, 23).addBox(-1.0F, 3.0F, -1.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			RFootBone.setTextureOffset(23, 25).addBox(-2.0F, 3.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			RFootBone.setTextureOffset(10, 25).addBox(0.0F, 3.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			LFootBone = new ModelRenderer(this);
			LFootBone.setRotationPoint(3.0F, -4.0F, 1.0F);
			FootControlBone.addChild(LFootBone);
			LFootBone.setTextureOffset(0, 27).addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			LFootBone.setTextureOffset(21, 0).addBox(0.0F, 3.0F, -1.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			LFootBone.setTextureOffset(6, 24).addBox(-1.0F, 3.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			LFootBone.setTextureOffset(0, 24).addBox(1.0F, 3.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		}

		@Override
		public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			// previously the render function, render code was moved to a method below
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			EmptyRootBone.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
	}
}

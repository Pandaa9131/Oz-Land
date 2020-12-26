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
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		EmptyRootBone.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
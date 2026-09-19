package com.sweeblyn.srpwarriorsarmaments.effects;

import com.dhanantry.scapeandrunparasites.entity.ai.misc.EntityPMalleable;
import com.dhanantry.scapeandrunparasites.entity.ai.misc.EntityParasiteBase;
import com.dhanantry.scapeandrunparasites.init.SRPPotions;
import com.sweeblyn.srpwarriorsarmaments.SRPWarriorsArmaments;
import com.sweeblyn.srpwarriorsarmaments.util.MirrorUtils;
import com.sweeblyn.srpwarriorsarmaments.util.MirrorUtils.IField;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PotionJudgement extends Potion {
	private final ResourceLocation potionIcon;
	protected static final IField<Boolean> geneMindam$EntityParasiteBase = MirrorUtils
			.reflectField(EntityParasiteBase.class, "geneMindam");
	protected static final IField<Boolean> geneDamcap$EntityParasiteBase = MirrorUtils
			.reflectField(EntityParasiteBase.class, "geneDamcap");
	protected static final IField<Boolean> geneLookwall$EntityParasiteBase = MirrorUtils
			.reflectField(EntityParasiteBase.class, "geneLookwall");
	protected static final IField<Boolean> geneSprinting$EntityParasiteBase = MirrorUtils
			.reflectField(EntityParasiteBase.class, "geneSprinting");
	protected static final IField<Boolean> geneWaterleap$EntityParasiteBase = MirrorUtils
			.reflectField(EntityParasiteBase.class, "geneWaterleap");
	protected static final IField<Boolean> geneSpecialmove$EntityParasiteBase = MirrorUtils
			.reflectField(EntityParasiteBase.class, "geneSpecialmove");
	protected static final IField<Float> genePoisonHealing$EntityParasiteBase = MirrorUtils
			.reflectField(EntityParasiteBase.class, "genePoisonHealing");
	protected static final IField<Float> geneMobHealing$EntityParasiteBase = MirrorUtils
			.reflectField(EntityParasiteBase.class, "geneMobHealing");
	protected static final IField<Float> geneAttackSpeed$EntityParasiteBase = MirrorUtils
			.reflectField(EntityParasiteBase.class, "geneAttackSpeed");

	protected static final IField<Boolean> geneAdaptation$EntityPMalleable = MirrorUtils
			.reflectField(EntityPMalleable.class, "geneAdaptation");
	protected static final IField<Boolean> geneBlocksearch$EntityPMalleable = MirrorUtils
			.reflectField(EntityPMalleable.class, "geneBlocksearch");
	protected static final IField<Boolean> geneResidue$EntityPMalleable = MirrorUtils
			.reflectField(EntityPMalleable.class, "geneResidue");
	protected static final IField<Boolean> geneOrbbox$EntityPMalleable = MirrorUtils
			.reflectField(EntityPMalleable.class, "geneOrbbox");

	public PotionJudgement() {
		super(false, 0xffcb00);
		this.setBeneficial();
		this.setRegistryName("judgement");
		this.setPotionName("effect.judgement.name");

		potionIcon = new ResourceLocation(SRPWarriorsArmaments.MOD_ID + ":textures/potions/judgement.png");
		MinecraftForge.EVENT_BUS.register(this);
	}

	@Override
	public void performEffect(EntityLivingBase entityLivingBaseIn, int amplifier) {
		if (entityLivingBaseIn instanceof EntityParasiteBase) {
			float atkSpeed = 0.75f * (amplifier + 1.0f) + 0.75f;
			if (entityLivingBaseIn.isPotionActive(SRPPotions.PIVOT_E)) {
				atkSpeed = (0.5f*amplifier)+1.0f;
			}
			if (entityLivingBaseIn instanceof EntityPMalleable) {
								((EntityPMalleable) entityLivingBaseIn).applyGene(
						new boolean[] { geneMindam$EntityParasiteBase.get(entityLivingBaseIn),
								geneDamcap$EntityParasiteBase.get(entityLivingBaseIn),
								geneLookwall$EntityParasiteBase.get(entityLivingBaseIn),
								geneSprinting$EntityParasiteBase.get(entityLivingBaseIn),
								geneWaterleap$EntityParasiteBase.get(entityLivingBaseIn),
								geneSpecialmove$EntityParasiteBase.get(entityLivingBaseIn),

								geneAdaptation$EntityPMalleable.get(entityLivingBaseIn),
								geneBlocksearch$EntityPMalleable.get(entityLivingBaseIn),
								geneResidue$EntityPMalleable.get(entityLivingBaseIn),
								geneOrbbox$EntityPMalleable.get(entityLivingBaseIn) },

						new float[] { genePoisonHealing$EntityParasiteBase.get(entityLivingBaseIn),
								geneMobHealing$EntityParasiteBase.get(entityLivingBaseIn),
								atkSpeed });

			} else {
				((EntityParasiteBase) entityLivingBaseIn).applyGene(
						new boolean[] { geneMindam$EntityParasiteBase.get(entityLivingBaseIn),
								geneDamcap$EntityParasiteBase.get(entityLivingBaseIn),
								geneLookwall$EntityParasiteBase.get(entityLivingBaseIn),
								geneSprinting$EntityParasiteBase.get(entityLivingBaseIn),
								geneWaterleap$EntityParasiteBase.get(entityLivingBaseIn),
								geneSpecialmove$EntityParasiteBase.get(entityLivingBaseIn) },
						
						new float[] { genePoisonHealing$EntityParasiteBase.get(entityLivingBaseIn),
								geneMobHealing$EntityParasiteBase.get(entityLivingBaseIn),
								atkSpeed });
			}
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean isBeneficial() {
		return false;
	}

	@Override
	public boolean isReady(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean shouldRenderInvText(PotionEffect effect) {
		return true;
	}

	@Override
	public boolean shouldRenderHUD(PotionEffect effect) {
		return true;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void renderInventoryEffect(int x, int y, PotionEffect effect, Minecraft mc) {
		if (mc.currentScreen != null) {
			mc.getTextureManager().bindTexture(potionIcon);
			Gui.drawModalRectWithCustomSizedTexture(x + 6, y + 7, 0, 0, 18, 18, 18, 18);
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void renderHUDEffect(int x, int y, PotionEffect effect, Minecraft mc, float alpha) {
		mc.getTextureManager().bindTexture(potionIcon);
		Gui.drawModalRectWithCustomSizedTexture(x + 3, y + 3, 0, 0, 18, 18, 18, 18);
	}

}

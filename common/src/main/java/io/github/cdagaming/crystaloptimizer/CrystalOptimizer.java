package io.github.cdagaming.crystaloptimizer;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

import java.sql.SQLOutput;
import java.util.Collection;

public class CrystalOptimizer {
    public static final String MOD_ID = "crystaloptimizer";

    public static void init() {
        // N/A
    }

    public static MobEffectInstance getEffect(Collection<MobEffectInstance> effects, String target) {
        for (MobEffectInstance effect : effects) {
            System.out.println(effect + " " + target);
            System.out.println(effect.getDescriptionId());
            if (effect.toString().toLowerCase().contains(target)) return effect;
        }
        return null;
    }
}
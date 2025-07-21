
package com.jinxedstudios.hellwalker.entities;


import com.jinxedstudios.hellwalker.entities.ai.PossessedScientistAttackGoal;
import com.jinxedstudios.hellwalker.entities.ai.UnwillingAttackGoal;
import com.jinxedstudios.hellwalker.sound.HellwalkerSounds;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.horse.TraderLlama;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class UnwillingEntity extends Monster {

    private static final EntityDataAccessor<Boolean> ATTACKING = SynchedEntityData.defineId(UnwillingEntity.class, EntityDataSerializers.BOOLEAN);

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;



    public void setAttacking(boolean attacking) {
        this.entityData.set(ATTACKING, attacking);
    }

    public boolean isAttacking() {
        return this.entityData.get(ATTACKING);
    }


    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(ATTACKING, false);

    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(11, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Player.class, 12.0f));
        this.goalSelector.addGoal(9, new RandomStrollGoal(this, 0.5d));

        this.goalSelector.addGoal(2, new UnwillingAttackGoal(this, 0.5d, false));

        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, false));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, WanderingTrader.class, false));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, TraderLlama.class, false));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, Villager.class, false));
        this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, Animal.class, true));
        this.targetSelector.addGoal(8, new NearestAttackableTargetGoal<>(this, Monster.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, false));
    }

public static AttributeSupplier.Builder createAttributes() {
            return Monster.createMonsterAttributes()
                    .add(Attributes.MAX_HEALTH, 150d)
                    .add(Attributes.GRAVITY, 0.08d)
                    .add(Attributes.MOVEMENT_SPEED, 0.5d)
                    .add(Attributes.ATTACK_DAMAGE, 20d)
                    .add(Attributes.FOLLOW_RANGE, 32d)
                    .add(Attributes.SAFE_FALL_DISTANCE, 1000d)
                    .add(Attributes.KNOCKBACK_RESISTANCE, 1000d)
                    .add(Attributes.ATTACK_KNOCKBACK, 1.0d)
                    .add(Attributes.ATTACK_SPEED, 1.0);
    }


    public UnwillingEntity(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }
    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 25;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }
        if (this.isAttacking() && attackAnimationTimeout <= 0) {
            this.attackAnimationTimeout = 25;
            this.attackAnimationState.start(this.tickCount);
        } else {
            --this.attackAnimationTimeout;
        }
    }
    @Override
    public void tick() {
        super.tick();

        if(this.level().isClientSide()) {
            this.setupAnimationStates();
        }
    }
    @Override
    public boolean isAffectedByFluids() {
        return false;  // Prevents slowing and damage from fluids like water.
    }
    @Override
    public float maxUpStep() {
        return 2.0f;
    }


    // SOUNDS


    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return HellwalkerSounds.POSSESSED_SCIENTIST_SAY.get();
    }
    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return HellwalkerSounds.POSSESSED_SCIENTIST_HURT.get();
    }
    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return HellwalkerSounds.POSSESSED_SCIENTIST_DEATH.get();
    }
    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    public boolean canBeCollidedWith() {
        return true;
    }
}


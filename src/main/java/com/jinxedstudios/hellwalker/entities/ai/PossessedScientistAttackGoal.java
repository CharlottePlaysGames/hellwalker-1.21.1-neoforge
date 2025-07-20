package com.jinxedstudios.hellwalker.entities.ai;

import com.jinxedstudios.hellwalker.entities.PossessedScientistEntity;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

public class PossessedScientistAttackGoal extends MeleeAttackGoal {
    private final PossessedScientistEntity entity;
    private int attackDelay = 20;
    private int ticksUntilNextAttack = 5;
    private boolean shouldCountTillNextAttack = false;
    private int dashCooldown = 0;
    private boolean isDashing = false;
    private int dashWindup = 0;

    public PossessedScientistAttackGoal(PathfinderMob pMob, double pSpeedModifier, boolean pFollowingTargetEvenIfNotSeen) {
        super(pMob, pSpeedModifier, pFollowingTargetEvenIfNotSeen);
        entity = ((PossessedScientistEntity) pMob);
    }

    @Override
    public void start() {
        super.start();
        attackDelay = 20;
        ticksUntilNextAttack = 5;
    }
    protected double getAttackReachSqr(LivingEntity target) {
        return 4.0F; // 2 blocks squared — adjust to what works best
    }

    @Override
    protected void checkAndPerformAttack(LivingEntity target) {
        double distSqr = this.mob.distanceToSqr(target);
        double attackReach = this.getAttackReachSqr(target);
        double dashRange = attackReach + 6.0F; // slightly out of range
        double distance = mob.distanceToSqr(target.getX(), target.getY(), target.getZ());
        if (distance < 0.50F) {
            mob.getNavigation().stop();
            mob.lookAt(EntityAnchorArgument.Anchor.EYES, target.position());
        }

        if (distSqr <= attackReach) {
            shouldCountTillNextAttack = true;

            if (isTimeToStartAttackAnimation()) {
                entity.setAttacking(true);
            }

            if (isTimeToAttack()) {
                this.mob.getLookControl().setLookAt(target.getX(), target.getEyeY(), target.getZ());
                performAttack(target);
            }


        } else if (distSqr <= dashRange && dashCooldown <= 0 && dashWindup == 0) {
            dashWindup = 1; // wind-up time in ticks (0.5s)
            isDashing = true;
            entity.setAttacking(true);

            // Optional: spawn wind-up particles
            //entity.level().addParticle(ParticleTypes.SMOKE, mob.getX(), mob.getY() + 1, mob.getZ(), 0, 0.1, 0);

            // Optional: play charge-up sound
            // entity.level().playSound(null, mob.blockPosition(), SoundEvents.BLAZE_SHOOT, SoundSource.HOSTILE, 1.0F, 1.0F);
            // Dash forward into range
            double dx = target.getX() - mob.getX();
            double dz = target.getZ() - mob.getZ();
            double length = Math.sqrt(dx * dx + dz * dz);
            double dashSpeed = 0.35D;

            if (length != 0) {
                mob.setDeltaMovement(
                        dx / length * dashSpeed,
                        mob.getDeltaMovement().y,
                        dz / length * dashSpeed
                );
                mob.hurtMarked = true; // force sync with client
            }

            entity.setAttacking(true);
            // Optionally: play sound or particles here

        } else {
            resetAttackCooldown();
            shouldCountTillNextAttack = false;
            entity.setAttacking(false);
            entity.attackAnimationTimeout = 0;
        }
    }
    private void doDash() {
        LivingEntity target = this.mob.getTarget();
        if (target == null) return;

        double dx = target.getX() - mob.getX();
        double dz = target.getZ() - mob.getZ();
        double length = Math.sqrt(dx * dx + dz * dz);
        double dashSpeed = 0.6D;

        if (length != 0 ) {
            mob.setDeltaMovement(
                    dx / length * dashSpeed,
                    mob.getDeltaMovement().y,
                    dz / length * dashSpeed
            );
            mob.hurtMarked = true;
        }

        // Optional: particles when dashing
        for (int i = 0; i < 5; i++) {
            mob.level().addParticle(ParticleTypes.CLOUD,
                    mob.getX(), mob.getY() + 0.1, mob.getZ(),
                    (mob.getRandom().nextDouble() - 0.5) * 0.2,
                    0.1,
                    (mob.getRandom().nextDouble() - 0.5) * 0.2
            );
        }

        dashCooldown = 40; // 2s cooldown
        isDashing = false;
    }

    private boolean isEnemyWithinAttackDistance(LivingEntity pEnemy, double pDistToEnemySqr) {
        return pDistToEnemySqr <= this.getAttackReachSqr(pEnemy);
    }

    protected void resetAttackCooldown() {
        this.ticksUntilNextAttack = this.adjustedTickDelay(attackDelay * 2);
    }

    protected boolean isTimeToAttack() {
        return this.ticksUntilNextAttack <= 0;
    }

    protected boolean isTimeToStartAttackAnimation() {
        return this.ticksUntilNextAttack <= attackDelay;
    }

    protected int getTicksUntilNextAttack() {
        return this.ticksUntilNextAttack;
    }


    protected void performAttack(LivingEntity pEnemy) {
        this.resetAttackCooldown();
        this.mob.swing(InteractionHand.MAIN_HAND);
        this.mob.doHurtTarget(pEnemy);
    }

    @Override
    public void tick() {
        super.tick();

        if (dashCooldown > 0) {
            dashCooldown--;
        }

        if (dashWindup > 0) {
            dashWindup--;

            // Optional: play a wind-up animation or particle
            if (dashWindup == 0 && isDashing) {
                doDash(); // execute the actual dash
            }
        }

        if (shouldCountTillNextAttack) {
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
        }
    }

    @Override
    public void stop() {
        super.stop();
        entity.setAttacking(false);
        shouldCountTillNextAttack = false;
        ticksUntilNextAttack = 0;
        dashWindup = 0;
        isDashing = false;
    }

}

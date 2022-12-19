package net.bytesundso.schabernax.core.interceptor;

import net.minecraft.server.network.DemoServerPlayerInteractionManager;
import net.minecraft.server.network.ServerPlayerEntity;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DemoServerPlayerInteractionManager.class)
public class DemoServerPlayerInteractionManagerInterceptor {
    @Shadow private boolean demoEnded;

    @Inject(method = "update", at = @At("HEAD"), cancellable = true)
    private void update(CallbackInfo ci) {
        ci.cancel();
    }

    @Inject(method = "sendDemoReminder", at = @At("HEAD"), cancellable = true)
    private void sendDemoReminder(CallbackInfo ci) {
        this.demoEnded = false;
        ci.cancel();
    }

    @Inject(method = "processBlockBreakingAction", at = @At("HEAD"))
    private void processBlockBreakingAction(CallbackInfo ci) {
        this.demoEnded = false;
    }

    @Inject(method = "interactItem", at = @At("HEAD"))
    private void interactItem(CallbackInfo ci) {
        this.demoEnded = false;
    }

    @Inject(method = "interactBlock", at = @At("HEAD"))
    private void interactBlock(CallbackInfo ci) {
        this.demoEnded = false;
    }
}

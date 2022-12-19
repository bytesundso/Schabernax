package net.bytesundso.schabernax.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(net.minecraft.client.gui.screen.DemoScreen.class)
public class DemoScreenMixin {
    @Inject(method = "init", at = @At("HEAD"), cancellable = true)
    private void cancelDemoScreen(CallbackInfo ci) {
        ci.cancel();
    }
}

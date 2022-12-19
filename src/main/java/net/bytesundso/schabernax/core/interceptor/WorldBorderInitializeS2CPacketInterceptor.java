package net.bytesundso.schabernax.core.interceptor;

import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.WorldBorderInitializeS2CPacket;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldBorderInitializeS2CPacket.class)
public class WorldBorderInitializeS2CPacketInterceptor {
    @Inject(method = "apply", at=@At("HEAD"), cancellable = true)
    private void apply(ClientPlayPacketListener clientPlayPacketListener, CallbackInfo ci) {
        ci.cancel();
    }
}

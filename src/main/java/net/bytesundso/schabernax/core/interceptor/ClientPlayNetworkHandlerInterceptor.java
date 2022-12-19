package net.bytesundso.schabernax.core.interceptor;

import net.bytesundso.schabernax.handler.InterceptHandler;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.Packet;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public abstract class ClientPlayNetworkHandlerInterceptor {
    @Inject(method = "sendPacket", at = @At("HEAD"), cancellable = true)
    private void onSendPacket(Packet<?> packet, CallbackInfo callback) {
        InterceptHandler.ClientPlayNetworkHandler.sendPacket(packet, callback);
    }
}

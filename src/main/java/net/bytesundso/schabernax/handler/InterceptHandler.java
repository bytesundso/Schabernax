package net.bytesundso.schabernax.handler;

import net.bytesundso.schabernax.module.ModuleManager;

import net.minecraft.network.Packet;
import net.minecraft.network.listener.PacketListener;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

public class InterceptHandler {
    public static class ClientConnection {
        public static <T extends PacketListener> void handlePacket(Packet<T> packet, PacketListener listener, CallbackInfo ci) {
            ModuleManager.getInstance().foreachProxyModule(module -> {
                module.onHandlePacket(packet, listener, ci);
            });
        }
    }

    public static class ClientPlayNetworkHandler {
        public static void sendPacket(Packet<?> packet, CallbackInfo callback) {
            ModuleManager.getInstance().foreachProxyModule(module -> {
                module.onSendPacket(packet, callback);
            });
        }
    }
}

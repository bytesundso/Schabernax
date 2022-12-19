package net.bytesundso.schabernax.module.generic;

import net.minecraft.network.Packet;
import net.minecraft.network.listener.PacketListener;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

public interface ProxyModule extends Module {
    default <T extends PacketListener> void onHandlePacket(Packet<T> packet, PacketListener listener, CallbackInfo ci) { }
    default void onSendPacket(Packet<?> packet, CallbackInfo callback) { }
}

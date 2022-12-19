package net.bytesundso.schabernax.module.modules.movement;

import net.bytesundso.schabernax.core.interfaces.IPlayerMoveC2SPacket;
import net.bytesundso.schabernax.core.interfaces.IVehicleMoveC2SPacket;
import net.bytesundso.schabernax.module.generic.ProxyModule;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.network.packet.c2s.play.VehicleMoveC2SPacket;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

public class AntiHumanBypass implements ProxyModule {
    @Override
    public void onSendPacket(Packet<?> packet, CallbackInfo callback) {
        if(packet instanceof PlayerMoveC2SPacket) {
            ((IPlayerMoveC2SPacket)packet).setX((int)(((PlayerMoveC2SPacket)packet).getX(mc.player.getX()) * 100) / 100.0);
            ((IPlayerMoveC2SPacket)packet).setZ((int)(((PlayerMoveC2SPacket)packet).getZ(mc.player.getZ()) * 100) / 100.0);
        }

        if(mc.player != null && mc.player.getVehicle() instanceof BoatEntity && packet instanceof VehicleMoveC2SPacket) {
            ((IVehicleMoveC2SPacket)packet).setX((int)(((VehicleMoveC2SPacket)packet).getX() * 100) / 100.0);
            ((IVehicleMoveC2SPacket)packet).setZ((int)(((VehicleMoveC2SPacket)packet).getZ() * 100) / 100.0);
        }
    }
}

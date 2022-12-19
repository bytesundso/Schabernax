package net.bytesundso.schabernax.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.network.packet.c2s.play.VehicleMoveC2SPacket;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public class ClientPlayNetworkHandlerMixin {
    @Inject(method = "sendPacket", at = @At("HEAD"), cancellable = true)
    private void onSendPacket(Packet<?> packet, CallbackInfo callback){
        if(packet instanceof PlayerMoveC2SPacket){
            double x = ((int)(((PlayerMoveC2SPacket)packet).getX(MinecraftClient.getInstance().player.getX()) * 100)) / 100.0;
            double z = ((int)(((PlayerMoveC2SPacket)packet).getZ(MinecraftClient.getInstance().player.getZ()) * 100)) / 100.0;

            ((IPlayerMoveC2SPacket)packet).setX(x);
            ((IPlayerMoveC2SPacket)packet).setZ(z);
        }

        if(!(MinecraftClient.getInstance().player.getVehicle() instanceof BoatEntity boat))
        {
            return;
        }

        if(packet instanceof VehicleMoveC2SPacket){
            double boatx = ((int)(((VehicleMoveC2SPacket)packet).getX() * 100)) / 100.0;
            double boatz = ((int)(((VehicleMoveC2SPacket)packet).getZ() * 100)) / 100.0;

            ((IVehicleMoveC2SPacket)packet).setX(boatx);
            ((IVehicleMoveC2SPacket)packet).setZ(boatz);
        }
    }
}
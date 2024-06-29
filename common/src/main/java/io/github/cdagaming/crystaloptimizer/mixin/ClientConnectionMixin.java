package io.github.cdagaming.crystaloptimizer.mixin;

import io.github.cdagaming.crystaloptimizer.PacketHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Connection.class)
public class ClientConnectionMixin {
    @Inject(method = "send(Lnet/minecraft/network/protocol/Packet;)V", at = @At("HEAD"))
    private void onPacketSend(Packet<?> packet, CallbackInfo ci) {
        final Minecraft mc = Minecraft.getInstance();
        if (packet instanceof ServerboundInteractPacket) {
            ServerboundInteractPacket interactPacket = (ServerboundInteractPacket) packet;
            interactPacket.handle(new PacketHandler());
        }
    }
}

package io.github.cdagaming.crystaloptimizer;

import net.minecraft.client.Minecraft;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.*;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.boss.enderdragon.EndCrystal;
import net.minecraft.world.item.*;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class PacketHandler implements ServerGamePacketListener {
    private final Minecraft mc = Minecraft.getInstance();

    @Override
    public void onDisconnect(Component component) {

    }

    @Override
    public Connection getConnection() {
        return null;
    }

    @Override
    public void handleAnimate(ServerboundSwingPacket serverboundSwingPacket) {

    }

    @Override
    public void handleChat(ServerboundChatPacket serverboundChatPacket) {

    }

    @Override
    public void handleClientCommand(ServerboundClientCommandPacket serverboundClientCommandPacket) {

    }

    @Override
    public void handleClientInformation(ServerboundClientInformationPacket serverboundClientInformationPacket) {

    }

    @Override
    public void handleContainerAck(ServerboundContainerAckPacket serverboundContainerAckPacket) {

    }

    @Override
    public void handleContainerButtonClick(ServerboundContainerButtonClickPacket serverboundContainerButtonClickPacket) {

    }

    @Override
    public void handleContainerClick(ServerboundContainerClickPacket serverboundContainerClickPacket) {

    }

    @Override
    public void handlePlaceRecipe(ServerboundPlaceRecipePacket serverboundPlaceRecipePacket) {

    }

    @Override
    public void handleContainerClose(ServerboundContainerClosePacket serverboundContainerClosePacket) {

    }

    @Override
    public void handleCustomPayload(ServerboundCustomPayloadPacket serverboundCustomPayloadPacket) {

    }

    @Override
    public void handleInteract(ServerboundInteractPacket serverboundInteractPacket) {
//        System.out.println("INTERACTION!");
        EntityHitResult entityHitResult;
        Entity entity;
        HitResult hitResult = mc.hitResult;
        if (hitResult == null || serverboundInteractPacket.getAction() != ServerboundInteractPacket.Action.ATTACK) {
            return;
        }
//        System.out.println("HITRESULT");
        if (hitResult.getType() == HitResult.Type.ENTITY && (entity = (entityHitResult = (EntityHitResult) hitResult).getEntity()) instanceof EndCrystal) {
            MobEffectInstance weakness = mc.player.getEffect(MobEffects.WEAKNESS);
            MobEffectInstance strength = mc.player.getEffect(MobEffects.DAMAGE_BOOST);
//            System.out.println("CRYSTAL");
            ItemStack itemStack = mc.player.getMainHandItem();
            boolean isTool = false;
            if (itemStack.getItem() instanceof TieredItem && !(itemStack.getItem() instanceof HoeItem)) {
                Tier material = ((TieredItem) itemStack.getItem()).getTier();
                isTool = material == Tiers.DIAMOND || material == Tiers.NETHERITE;
            }
            if (!(weakness == null || strength != null && strength.getAmplifier() > weakness.getAmplifier() || isTool)) {
                return;
            }
            System.out.println("Crystal Broken");
            entity.kill();
            //entity.setRemoved(Entity.RemovalReason.KILLED);
            //entity.onClientRemoval();
        }
    }

    @Override
    public void handleKeepAlive(ServerboundKeepAlivePacket serverboundKeepAlivePacket) {

    }

    @Override
    public void handleMovePlayer(ServerboundMovePlayerPacket serverboundMovePlayerPacket) {

    }

    @Override
    public void handlePlayerAbilities(ServerboundPlayerAbilitiesPacket serverboundPlayerAbilitiesPacket) {

    }

    @Override
    public void handlePlayerAction(ServerboundPlayerActionPacket serverboundPlayerActionPacket) {

    }

    @Override
    public void handlePlayerCommand(ServerboundPlayerCommandPacket serverboundPlayerCommandPacket) {

    }

    @Override
    public void handlePlayerInput(ServerboundPlayerInputPacket serverboundPlayerInputPacket) {

    }

    @Override
    public void handleSetCarriedItem(ServerboundSetCarriedItemPacket serverboundSetCarriedItemPacket) {

    }

    @Override
    public void handleSetCreativeModeSlot(ServerboundSetCreativeModeSlotPacket serverboundSetCreativeModeSlotPacket) {

    }

    @Override
    public void handleSignUpdate(ServerboundSignUpdatePacket serverboundSignUpdatePacket) {

    }

    @Override
    public void handleUseItemOn(ServerboundUseItemOnPacket serverboundUseItemOnPacket) {

    }

    @Override
    public void handleUseItem(ServerboundUseItemPacket serverboundUseItemPacket) {

    }

    @Override
    public void handleTeleportToEntityPacket(ServerboundTeleportToEntityPacket serverboundTeleportToEntityPacket) {

    }

    @Override
    public void handleResourcePackResponse(ServerboundResourcePackPacket serverboundResourcePackPacket) {

    }

    @Override
    public void handlePaddleBoat(ServerboundPaddleBoatPacket serverboundPaddleBoatPacket) {

    }

    @Override
    public void handleMoveVehicle(ServerboundMoveVehiclePacket serverboundMoveVehiclePacket) {

    }

    @Override
    public void handleAcceptTeleportPacket(ServerboundAcceptTeleportationPacket serverboundAcceptTeleportationPacket) {

    }

    @Override
    public void handleRecipeBookSeenRecipePacket(ServerboundRecipeBookSeenRecipePacket serverboundRecipeBookSeenRecipePacket) {

    }

    @Override
    public void handleRecipeBookChangeSettingsPacket(ServerboundRecipeBookChangeSettingsPacket serverboundRecipeBookChangeSettingsPacket) {

    }

    @Override
    public void handleSeenAdvancements(ServerboundSeenAdvancementsPacket serverboundSeenAdvancementsPacket) {

    }

    @Override
    public void handleCustomCommandSuggestions(ServerboundCommandSuggestionPacket serverboundCommandSuggestionPacket) {

    }

    @Override
    public void handleSetCommandBlock(ServerboundSetCommandBlockPacket serverboundSetCommandBlockPacket) {

    }

    @Override
    public void handleSetCommandMinecart(ServerboundSetCommandMinecartPacket serverboundSetCommandMinecartPacket) {

    }

    @Override
    public void handlePickItem(ServerboundPickItemPacket serverboundPickItemPacket) {

    }

    @Override
    public void handleRenameItem(ServerboundRenameItemPacket serverboundRenameItemPacket) {

    }

    @Override
    public void handleSetBeaconPacket(ServerboundSetBeaconPacket serverboundSetBeaconPacket) {

    }

    @Override
    public void handleSetStructureBlock(ServerboundSetStructureBlockPacket serverboundSetStructureBlockPacket) {

    }

    @Override
    public void handleSelectTrade(ServerboundSelectTradePacket serverboundSelectTradePacket) {

    }

    @Override
    public void handleEditBook(ServerboundEditBookPacket serverboundEditBookPacket) {

    }

    @Override
    public void handleEntityTagQuery(ServerboundEntityTagQuery serverboundEntityTagQuery) {

    }

    @Override
    public void handleBlockEntityTagQuery(ServerboundBlockEntityTagQuery serverboundBlockEntityTagQuery) {

    }

    @Override
    public void handleSetJigsawBlock(ServerboundSetJigsawBlockPacket serverboundSetJigsawBlockPacket) {

    }

    @Override
    public void handleJigsawGenerate(ServerboundJigsawGeneratePacket serverboundJigsawGeneratePacket) {

    }

    @Override
    public void handleChangeDifficulty(ServerboundChangeDifficultyPacket serverboundChangeDifficultyPacket) {

    }

    @Override
    public void handleLockDifficulty(ServerboundLockDifficultyPacket serverboundLockDifficultyPacket) {

    }
}
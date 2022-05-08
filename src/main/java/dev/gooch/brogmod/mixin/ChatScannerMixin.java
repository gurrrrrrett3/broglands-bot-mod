package dev.gooch.brogmod.mixin;

import dev.gooch.brogmod.BrogMod;
import dev.gooch.brogmod.websocket.Message;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(ChatHud.class)
public class ChatScannerMixin {
    @Shadow
    @Final
    private MinecraftClient client;

    @Inject(method = "addMessage(Lnet/minecraft/text/Text;I)V", at = @At("TAIL"))
    public void onChatMessage(Text message, int messageId, CallbackInfo ci) {
        Message msg = new Message();
        msg.setType("MESSAGE");
        msg.setUsername();
        msg.setText(message.asString());
        BrogMod.wsClent.sendMessage(msg.get());
    }
}

package dev.ezhevita.mc.PingPlayersRandomizer.mixin;

import java.util.concurrent.ThreadLocalRandom;
import org.spongepowered.asm.mixin.*;
import com.mojang.authlib.GameProfile;
import net.minecraft.server.ServerMetadata.*;

@Mixin(Players.class)
public class ServerMetadataPlayersMixin {
    private static final GameProfile[] EMPTY_GAME_PROFILES = {};

    @Shadow private int max;

    @Overwrite
    public int getOnlinePlayerCount() {
        return ThreadLocalRandom.current().nextInt(max);
    }

    @Overwrite
    public GameProfile[] getSample() {
        return EMPTY_GAME_PROFILES;
    }
}

package com.github.doctormacc.common.protocols.forwards;

import com.github.doctormacc.common.BedrockBackwards;
import com.github.doctormacc.common.PlayerSession;
import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.packet.StartGamePacket;

public class v408_to_v419_ForwardsPacketHandler extends ForwardsPacketHandler {

    @Override
    public boolean translate(PlayerSession session, BedrockPacket packet, boolean fromUpstream, int translatorIndex) {
        if ( packet.getPacketId()==156) {
            BedrockBackwards.LOGGER.debug("Ignoring packet " + packet.getPacketType());
            return false;
        }
        return true;
    }
}

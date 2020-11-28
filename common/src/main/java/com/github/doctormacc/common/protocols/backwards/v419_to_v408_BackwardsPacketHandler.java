package com.github.doctormacc.common.protocols.backwards;

import com.github.doctormacc.common.BedrockBackwards;
import com.github.doctormacc.common.PlayerSession;
import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.packet.AddEntityPacket;

public class v419_to_v408_BackwardsPacketHandler extends BackwardsPacketHandler {

    @Override
    public boolean translate(PlayerSession session, BedrockPacket packet, boolean fromUpstream, int translatorIndex) {
        if ( packet.getPacketId()==156) {
            BedrockBackwards.LOGGER.debug("Ignoring packet " + packet.getPacketType());
            return false;
        }
        return true;
    }
}
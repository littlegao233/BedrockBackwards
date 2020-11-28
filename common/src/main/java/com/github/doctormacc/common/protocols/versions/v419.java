package com.github.doctormacc.common.protocols.versions;

import com.github.doctormacc.common.protocols.backwards.v419_to_v408_BackwardsPacketHandler;
import com.nukkitx.protocol.bedrock.v419.Bedrock_v419;

public class v419 extends BedrockVersion {

    public v419() {
        this.bedrockCodec = Bedrock_v419.V419_CODEC;
        this.protocolVersion = 419;
        this.raknetVersion = 10;
        this.backwardsPacketHandler = v419_to_v408_BackwardsPacketHandler.class;
    }
    
}

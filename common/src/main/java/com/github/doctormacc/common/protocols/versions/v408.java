package com.github.doctormacc.common.protocols.versions;

import com.github.doctormacc.common.protocols.backwards.v408_to_v407_BackwardsPacketHandler;
import com.github.doctormacc.common.protocols.forwards.v408_to_v419_ForwardsPacketHandler;
import com.nukkitx.protocol.bedrock.v408.Bedrock_v408;

public class v408 extends BedrockVersion {

    public v408() {
        this.bedrockCodec = Bedrock_v408.V408_CODEC;
        this.protocolVersion = 408;
        this.raknetVersion = 10;
        this.backwardsPacketHandler = v408_to_v407_BackwardsPacketHandler.class;
        this.forwardsPacketHandler = v408_to_v419_ForwardsPacketHandler.class;
    }
    
}

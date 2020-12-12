package com.github.doctormacc.common;

import com.nukkitx.protocol.bedrock.BedrockPong;
import com.nukkitx.protocol.bedrock.BedrockServerEventHandler;
import com.nukkitx.protocol.bedrock.BedrockServerSession;
import com.nukkitx.protocol.bedrock.*;
import com.nukkitx.protocol.bedrock.v388.Bedrock_v388;
import com.nukkitx.protocol.bedrock.v422.Bedrock_v422;
import com.nukkitx.protocol.bedrock.v408.Bedrock_v408;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URL;

public class ConnectionServerEventHandler implements BedrockServerEventHandler {

    public boolean onConnectionRequest(InetSocketAddress inetSocketAddress) {
        return true;
    }
    public static String MotdStr="像素彼岸服务器";
    public String GetMotdStr() {
        return MotdStr;
    }
    public BedrockPong onQuery(InetSocketAddress inetSocketAddress) {
        BedrockBackwards.LOGGER.debug("Ping from " + inetSocketAddress.getAddress());
        BedrockPong pong = new BedrockPong();
        pong.setEdition("MCPE");
        pong.setGameType("Default");
        pong.setNintendoLimited(false);
        pong.setProtocolVersion(388);
        pong.setIpv4Port(BedrockBackwards.CONFIG.getListen().getPort());
        pong.setMotd(GetMotdStr());
        pong.setSubMotd("像素彼岸服务器");
        pong.setPlayerCount(233);
        pong.setMaximumPlayerCount(666);
        return pong;
    }

    public void onSessionCreation(BedrockServerSession bedrockServerSession) {
        BedrockBackwards.LOGGER.info("Creating session!");
        bedrockServerSession.setLogging(false);
        bedrockServerSession.setPacketHandler(new InitialPipelinePacketHandler(bedrockServerSession));
        //bedrockServerSession.setPacketCodec(Bedrock_v422.V422_CODEC);
        bedrockServerSession.setPacketCodec(Bedrock_v408.V408_CODEC);
    }
}

package com.github.doctormacc.common.protocols.forwards;

import com.github.doctormacc.common.BedrockBackwards;
import com.github.doctormacc.common.PlayerSession;
import com.github.doctormacc.common.protocols.BasePacketHandler;
import com.nukkitx.nbt.NbtList;
import com.nukkitx.nbt.NbtMap;
import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.BedrockPacketType;
import com.nukkitx.protocol.bedrock.data.AuthoritativeMovementMode;
import com.nukkitx.protocol.bedrock.packet.*;

public class v408_to_v419_ForwardsPacketHandler extends ForwardsPacketHandler {

    @Override
    public boolean translate(PlayerSession session, BedrockPacket packet, boolean fromUpstream, int translatorIndex) {
     //   if (StartGamePacket.class.equals(packet.getClass())) {
      //      ((StartGamePacket) packet).setExperimentsPreviouslyToggled(false); // Otherwise world name is a UUID
      //      ((StartGamePacket) packet).setAuthoritativeMovementMode(AuthoritativeMovementMode.CLIENT); // Otherwise world name is a UUID
      //      BedrockBackwards.LOGGER.debug(   ((StartGamePacket) packet).getVanillaVersion());
      //  }
//    //StartGamePacket.class.equals(packet.getClass())
      //  if (UpdateBlockPropertiesPacket.class.equals(packet.getClass())){
      //      BedrockBackwards.LOGGER.debug("Ignoring packet " + packet.getPacketType());
      //      return false;
      //  }
        if(UpdateBlockPropertiesPacket.class.equals(packet.getClass())){
            BedrockBackwards.LOGGER.debug("Ignoring packet " + packet.getPacketType());
           return false;   }    if(StartGamePacket.class.equals(packet.getClass())){
            DisconnectPacket disconnectPacket = new DisconnectPacket();
            disconnectPacket.setKickMessage( "§c§l" +
                    "                   客户端版本过新无法加入" +
                    "\n§r§b" +
                    "            请使用MCBE1.16.40及以下的版本加入服务器" +
                    "\n§7§o" +
                    "                         (1.16.40安装包可在群文件下载,包括win10和安卓)" +
                    "\n§r§a\n" +
                    "                                 ---像素彼岸服务器§e§r（审核群：707965346）"
                    );
            disconnectPacket.setMessageSkipped(false);
            BasePacketHandler.translatePacket(session, disconnectPacket, fromUpstream, translatorIndex);
            return false;
        }
        BedrockBackwards.LOGGER.debug("Pass : " + packet.getPacketType());
        return true;
    }
}

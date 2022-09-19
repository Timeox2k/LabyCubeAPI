package de.lara.labycubeapi.utils;

import java.nio.charset.StandardCharsets;

import io.netty.buffer.ByteBuf;

public class LabymodProtocol {

	/**
	 * Reads a varint from the given byte buffer
	 *
	 * @param buf the byte buffer the varint should be read from
	 * @return the int read
	 */
	public static int readVarIntFromBuffer(ByteBuf buf) {
		int i = 0;
		int j = 0;

		byte b0;
		do {
			b0 = buf.readByte();
			i |= (b0 & 127) << j++ * 7;
			if (j > 5) {
				throw new RuntimeException("VarInt too big");
			}
		} while ((b0 & 128) == 128);

		return i;
	}

	public static String readString(ByteBuf buf, int maxLength) {
		int i = readVarIntFromBuffer(buf);

		if (i > Short.MAX_VALUE * 4) {
			return "";
		}

		byte[] bytes = new byte[i];
		buf.readBytes(bytes);

		String s = new String(bytes, StandardCharsets.UTF_8);

		if (s.length() > maxLength) {
			return "";
		}

		return s;

	}

}

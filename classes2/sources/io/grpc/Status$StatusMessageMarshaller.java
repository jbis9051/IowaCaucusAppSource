package io.grpc;

import com.google.common.base.Ascii;
import com.google.common.base.Charsets;
import io.grpc.Metadata;
import java.nio.ByteBuffer;

final class Status$StatusMessageMarshaller implements Metadata.TrustedAsciiMarshaller<String> {
    private static final byte[] HEX = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};

    private static boolean isEscapingChar(byte b) {
        return b < 32 || b >= 126 || b == 37;
    }

    private Status$StatusMessageMarshaller() {
    }

    public byte[] toAsciiString(String str) {
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        for (int i = 0; i < bytes.length; i++) {
            if (isEscapingChar(bytes[i])) {
                return toAsciiStringSlow(bytes, i);
            }
        }
        return bytes;
    }

    private static byte[] toAsciiStringSlow(byte[] bArr, int i) {
        byte[] bArr2 = new byte[(((bArr.length - i) * 3) + i)];
        if (i != 0) {
            System.arraycopy(bArr, 0, bArr2, 0, i);
        }
        int i2 = i;
        while (i < bArr.length) {
            byte b = bArr[i];
            if (isEscapingChar(b)) {
                bArr2[i2] = 37;
                byte[] bArr3 = HEX;
                bArr2[i2 + 1] = bArr3[(b >> 4) & 15];
                bArr2[i2 + 2] = bArr3[b & Ascii.SI];
                i2 += 3;
            } else {
                bArr2[i2] = b;
                i2++;
            }
            i++;
        }
        byte[] bArr4 = new byte[i2];
        System.arraycopy(bArr2, 0, bArr4, 0, i2);
        return bArr4;
    }

    public String parseAsciiString(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            if (b < 32 || b >= 126 || (b == 37 && i + 2 < bArr.length)) {
                return parseAsciiStringSlow(bArr);
            }
        }
        return new String(bArr, 0);
    }

    private static String parseAsciiStringSlow(byte[] bArr) {
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length);
        int i = 0;
        while (i < bArr.length) {
            if (bArr[i] == 37 && i + 2 < bArr.length) {
                try {
                    allocate.put((byte) Integer.parseInt(new String(bArr, i + 1, 2, Charsets.US_ASCII), 16));
                    i += 3;
                } catch (NumberFormatException unused) {
                }
            }
            allocate.put(bArr[i]);
            i++;
        }
        return new String(allocate.array(), 0, allocate.position(), Charsets.UTF_8);
    }
}

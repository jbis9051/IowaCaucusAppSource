package com.drew.lang;

import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import com.drew.metadata.StringValue;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public abstract class SequentialReader {
    private boolean _isMotorolaByteOrder = true;

    public abstract int available();

    public abstract byte getByte() throws IOException;

    public abstract void getBytes(@NotNull byte[] bArr, int i, int i2) throws IOException;

    @NotNull
    public abstract byte[] getBytes(int i) throws IOException;

    public abstract long getPosition() throws IOException;

    public abstract void skip(long j) throws IOException;

    public abstract boolean trySkip(long j) throws IOException;

    public void setMotorolaByteOrder(boolean z) {
        this._isMotorolaByteOrder = z;
    }

    public boolean isMotorolaByteOrder() {
        return this._isMotorolaByteOrder;
    }

    public short getUInt8() throws IOException {
        return (short) (getByte() & 255);
    }

    public byte getInt8() throws IOException {
        return getByte();
    }

    public int getUInt16() throws IOException {
        byte b;
        byte b2;
        if (this._isMotorolaByteOrder) {
            b = (getByte() << 8) & 65280;
            b2 = getByte() & 255;
        } else {
            b = getByte() & 255;
            b2 = 65280 & (getByte() << 8);
        }
        return b | b2;
    }

    public short getInt16() throws IOException {
        short s;
        short s2;
        if (this._isMotorolaByteOrder) {
            s = (((short) getByte()) << 8) & -256;
            s2 = ((short) getByte()) & 255;
        } else {
            s = ((short) getByte()) & 255;
            s2 = (((short) getByte()) << 8) & -256;
        }
        return (short) (s | s2);
    }

    public long getUInt32() throws IOException {
        if (this._isMotorolaByteOrder) {
            return (4278190080L & (((long) getByte()) << 24)) | (16711680 & (((long) getByte()) << 16)) | ((((long) getByte()) << 8) & 65280) | (((long) getByte()) & 255);
        }
        long j = 255 & ((long) getByte());
        long j2 = 16711680 & (((long) getByte()) << 16);
        return (4278190080L & (((long) getByte()) << 24)) | j2 | (65280 & (((long) getByte()) << 8)) | j;
    }

    public int getInt32() throws IOException {
        byte b;
        byte b2;
        if (this._isMotorolaByteOrder) {
            b = ((getByte() << 24) & -16777216) | ((getByte() << 16) & 16711680) | ((getByte() << 8) & 65280);
            b2 = getByte() & 255;
        } else {
            b = (getByte() & 255) | (65280 & (getByte() << 8)) | (16711680 & (getByte() << 16));
            b2 = -16777216 & (getByte() << 24);
        }
        return b | b2;
    }

    public long getInt64() throws IOException {
        if (this._isMotorolaByteOrder) {
            return (-72057594037927936L & (((long) getByte()) << 56)) | (71776119061217280L & (((long) getByte()) << 48)) | ((((long) getByte()) << 40) & 280375465082880L) | ((((long) getByte()) << 32) & 1095216660480L) | ((((long) getByte()) << 24) & 4278190080L) | ((((long) getByte()) << 16) & 16711680) | ((((long) getByte()) << 8) & 65280) | (((long) getByte()) & 255);
        }
        return ((((long) getByte()) << 8) & 65280) | (((long) getByte()) & 255) | ((((long) getByte()) << 16) & 16711680) | ((((long) getByte()) << 24) & 4278190080L) | (1095216660480L & (((long) getByte()) << 32)) | (280375465082880L & (((long) getByte()) << 40)) | (71776119061217280L & (((long) getByte()) << 48)) | ((((long) getByte()) << 56) & -72057594037927936L);
    }

    public float getS15Fixed16() throws IOException {
        if (this._isMotorolaByteOrder) {
            byte b = ((getByte() & 255) << 8) | (getByte() & 255);
            double d = (double) ((float) (((getByte() & 255) << 8) | (getByte() & 255)));
            double d2 = (double) b;
            Double.isNaN(d2);
            Double.isNaN(d);
            return (float) (d + (d2 / 65536.0d));
        }
        byte b2 = (getByte() & 255) | ((getByte() & 255) << 8);
        double d3 = (double) ((float) ((getByte() & 255) | ((getByte() & 255) << 8)));
        double d4 = (double) b2;
        Double.isNaN(d4);
        Double.isNaN(d3);
        return (float) (d3 + (d4 / 65536.0d));
    }

    public float getFloat32() throws IOException {
        return Float.intBitsToFloat(getInt32());
    }

    public double getDouble64() throws IOException {
        return Double.longBitsToDouble(getInt64());
    }

    @NotNull
    public String getString(int i) throws IOException {
        return new String(getBytes(i));
    }

    @NotNull
    public String getString(int i, String str) throws IOException {
        byte[] bytes = getBytes(i);
        try {
            return new String(bytes, str);
        } catch (UnsupportedEncodingException unused) {
            return new String(bytes);
        }
    }

    @NotNull
    public String getString(int i, @NotNull Charset charset) throws IOException {
        return new String(getBytes(i), charset);
    }

    @NotNull
    public StringValue getStringValue(int i, @Nullable Charset charset) throws IOException {
        return new StringValue(getBytes(i), charset);
    }

    @NotNull
    public String getNullTerminatedString(int i, Charset charset) throws IOException {
        return getNullTerminatedStringValue(i, charset).toString();
    }

    @NotNull
    public StringValue getNullTerminatedStringValue(int i, Charset charset) throws IOException {
        return new StringValue(getNullTerminatedBytes(i), charset);
    }

    @NotNull
    public byte[] getNullTerminatedBytes(int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < bArr.length) {
            byte b = getByte();
            bArr[i2] = b;
            if (b == 0) {
                break;
            }
            i2++;
        }
        if (i2 == i) {
            return bArr;
        }
        byte[] bArr2 = new byte[i2];
        if (i2 > 0) {
            System.arraycopy(bArr, 0, bArr2, 0, i2);
        }
        return bArr2;
    }
}

package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import com.facebook.common.statfs.StatFsHelper;
import java.io.IOException;
import java.io.InputStream;

@RequiresApi(29)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class TypefaceCompatApi29Impl extends TypefaceCompatBaseImpl {
    /* access modifiers changed from: protected */
    public FontsContractCompat.FontInfo findBestInfo(FontsContractCompat.FontInfo[] fontInfoArr, int i) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    /* access modifiers changed from: protected */
    public Typeface createFromInputStream(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0054, code lost:
        r5 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0055, code lost:
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0059, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005a, code lost:
        r10 = r6;
        r6 = r5;
        r5 = r10;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Typeface createFromFontInfo(android.content.Context r12, @androidx.annotation.Nullable android.os.CancellationSignal r13, @androidx.annotation.NonNull androidx.core.provider.FontsContractCompat.FontInfo[] r14, int r15) {
        /*
            r11 = this;
            android.content.ContentResolver r12 = r12.getContentResolver()
            int r0 = r14.length
            r1 = 0
            r2 = 0
            r4 = r2
            r3 = 0
        L_0x0009:
            r5 = 1
            if (r3 >= r0) goto L_0x006c
            r6 = r14[r3]
            android.net.Uri r7 = r6.getUri()     // Catch:{ IOException -> 0x0069 }
            java.lang.String r8 = "r"
            android.os.ParcelFileDescriptor r7 = r12.openFileDescriptor(r7, r8, r13)     // Catch:{ IOException -> 0x0069 }
            if (r7 != 0) goto L_0x0020
            if (r7 == 0) goto L_0x0069
        L_0x001c:
            r7.close()     // Catch:{ IOException -> 0x0069 }
            goto L_0x0069
        L_0x0020:
            android.graphics.fonts.Font$Builder r8 = new android.graphics.fonts.Font$Builder     // Catch:{ Throwable -> 0x0057, all -> 0x0054 }
            r8.<init>(r7)     // Catch:{ Throwable -> 0x0057, all -> 0x0054 }
            int r9 = r6.getWeight()     // Catch:{ Throwable -> 0x0057, all -> 0x0054 }
            android.graphics.fonts.Font$Builder r8 = r8.setWeight(r9)     // Catch:{ Throwable -> 0x0057, all -> 0x0054 }
            boolean r9 = r6.isItalic()     // Catch:{ Throwable -> 0x0057, all -> 0x0054 }
            if (r9 == 0) goto L_0x0034
            goto L_0x0035
        L_0x0034:
            r5 = 0
        L_0x0035:
            android.graphics.fonts.Font$Builder r5 = r8.setSlant(r5)     // Catch:{ Throwable -> 0x0057, all -> 0x0054 }
            int r6 = r6.getTtcIndex()     // Catch:{ Throwable -> 0x0057, all -> 0x0054 }
            android.graphics.fonts.Font$Builder r5 = r5.setTtcIndex(r6)     // Catch:{ Throwable -> 0x0057, all -> 0x0054 }
            android.graphics.fonts.Font r5 = r5.build()     // Catch:{ Throwable -> 0x0057, all -> 0x0054 }
            if (r4 != 0) goto L_0x004e
            android.graphics.fonts.FontFamily$Builder r6 = new android.graphics.fonts.FontFamily$Builder     // Catch:{ Throwable -> 0x0057, all -> 0x0054 }
            r6.<init>(r5)     // Catch:{ Throwable -> 0x0057, all -> 0x0054 }
            r4 = r6
            goto L_0x0051
        L_0x004e:
            r4.addFont(r5)     // Catch:{ Throwable -> 0x0057, all -> 0x0054 }
        L_0x0051:
            if (r7 == 0) goto L_0x0069
            goto L_0x001c
        L_0x0054:
            r5 = move-exception
            r6 = r2
            goto L_0x005d
        L_0x0057:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x0059 }
        L_0x0059:
            r6 = move-exception
            r10 = r6
            r6 = r5
            r5 = r10
        L_0x005d:
            if (r7 == 0) goto L_0x0068
            if (r6 == 0) goto L_0x0065
            r7.close()     // Catch:{ Throwable -> 0x0068 }
            goto L_0x0068
        L_0x0065:
            r7.close()     // Catch:{ IOException -> 0x0069 }
        L_0x0068:
            throw r5     // Catch:{ IOException -> 0x0069 }
        L_0x0069:
            int r3 = r3 + 1
            goto L_0x0009
        L_0x006c:
            if (r4 != 0) goto L_0x006f
            return r2
        L_0x006f:
            android.graphics.fonts.FontStyle r12 = new android.graphics.fonts.FontStyle
            r13 = r15 & 1
            if (r13 == 0) goto L_0x0078
            r13 = 700(0x2bc, float:9.81E-43)
            goto L_0x007a
        L_0x0078:
            r13 = 400(0x190, float:5.6E-43)
        L_0x007a:
            r14 = r15 & 2
            if (r14 == 0) goto L_0x007f
            r1 = 1
        L_0x007f:
            r12.<init>(r13, r1)
            android.graphics.Typeface$CustomFallbackBuilder r13 = new android.graphics.Typeface$CustomFallbackBuilder
            android.graphics.fonts.FontFamily r14 = r4.build()
            r13.<init>(r14)
            android.graphics.Typeface$CustomFallbackBuilder r12 = r13.setStyle(r12)
            android.graphics.Typeface r12 = r12.build()
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.TypefaceCompatApi29Impl.createFromFontInfo(android.content.Context, android.os.CancellationSignal, androidx.core.provider.FontsContractCompat$FontInfo[], int):android.graphics.Typeface");
    }

    @Nullable
    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i) {
        FontResourcesParserCompat.FontFileResourceEntry[] entries = fontFamilyFilesResourceEntry.getEntries();
        int length = entries.length;
        int i2 = 0;
        FontFamily.Builder builder = null;
        int i3 = 0;
        while (true) {
            int i4 = 1;
            if (i3 >= length) {
                break;
            }
            FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry = entries[i3];
            try {
                Font.Builder weight = new Font.Builder(resources, fontFileResourceEntry.getResourceId()).setWeight(fontFileResourceEntry.getWeight());
                if (!fontFileResourceEntry.isItalic()) {
                    i4 = 0;
                }
                Font build = weight.setSlant(i4).setTtcIndex(fontFileResourceEntry.getTtcIndex()).setFontVariationSettings(fontFileResourceEntry.getVariationSettings()).build();
                if (builder == null) {
                    builder = new FontFamily.Builder(build);
                } else {
                    builder.addFont(build);
                }
            } catch (IOException unused) {
            }
            i3++;
        }
        if (builder == null) {
            return null;
        }
        int i5 = (i & 1) != 0 ? 700 : StatFsHelper.DEFAULT_DISK_YELLOW_LEVEL_IN_MB;
        if ((i & 2) != 0) {
            i2 = 1;
        }
        return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle(i5, i2)).build();
    }

    @Nullable
    public Typeface createFromResourcesFontFile(Context context, Resources resources, int i, String str, int i2) {
        try {
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(new Font.Builder(resources, i).build()).build()).setStyle(new FontStyle((i2 & 1) != 0 ? 700 : StatFsHelper.DEFAULT_DISK_YELLOW_LEVEL_IN_MB, (i2 & 2) != 0 ? 1 : 0)).build();
        } catch (IOException unused) {
            return null;
        }
    }
}

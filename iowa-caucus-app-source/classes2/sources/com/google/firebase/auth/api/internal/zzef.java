package com.google.firebase.auth.api.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.firebase_auth.zzb;
import com.google.android.gms.internal.firebase_auth.zzbp;
import com.google.android.gms.internal.firebase_auth.zzbr;
import com.google.android.gms.internal.firebase_auth.zzbt;
import com.google.android.gms.internal.firebase_auth.zzbv;
import com.google.android.gms.internal.firebase_auth.zzbx;
import com.google.android.gms.internal.firebase_auth.zzbz;
import com.google.android.gms.internal.firebase_auth.zzcb;
import com.google.android.gms.internal.firebase_auth.zzcd;
import com.google.android.gms.internal.firebase_auth.zzcf;
import com.google.android.gms.internal.firebase_auth.zzch;
import com.google.android.gms.internal.firebase_auth.zzcj;
import com.google.android.gms.internal.firebase_auth.zzcl;
import com.google.android.gms.internal.firebase_auth.zzcn;
import com.google.android.gms.internal.firebase_auth.zzcp;
import com.google.android.gms.internal.firebase_auth.zzcr;
import com.google.android.gms.internal.firebase_auth.zzct;
import com.google.android.gms.internal.firebase_auth.zzcv;
import com.google.android.gms.internal.firebase_auth.zzcx;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.android.gms.internal.firebase_auth.zzd;
import com.google.android.gms.internal.firebase_auth.zzdb;
import com.google.android.gms.internal.firebase_auth.zzdd;
import com.google.android.gms.internal.firebase_auth.zzdf;
import com.google.android.gms.internal.firebase_auth.zzdh;
import com.google.android.gms.internal.firebase_auth.zzdj;
import com.google.android.gms.internal.firebase_auth.zzdl;
import com.google.android.gms.internal.firebase_auth.zzdn;
import com.google.android.gms.internal.firebase_auth.zzdp;
import com.google.android.gms.internal.firebase_auth.zzdr;
import com.google.android.gms.internal.firebase_auth.zzdt;
import com.google.android.gms.internal.firebase_auth.zzdv;
import com.google.android.gms.internal.firebase_auth.zzdx;
import com.google.android.gms.internal.firebase_auth.zzdz;
import com.google.android.gms.internal.firebase_auth.zzfk;
import com.google.android.gms.internal.firebase_auth.zzfr;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzef extends zzb implements zzee {
    zzef(IBinder iBinder) {
        super(iBinder, "com.google.firebase.auth.api.internal.IFirebaseAuthService");
    }

    public final void zza(String str, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, zzdz);
        zza(1, zza);
    }

    public final void zzb(String str, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, zzdz);
        zza(2, zza);
    }

    public final void zza(zzfr zzfr, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzfr);
        zzd.zza(zza, zzdz);
        zza(3, zza);
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.google.firebase.auth.UserProfileChangeRequest, android.os.Parcelable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r2, com.google.firebase.auth.UserProfileChangeRequest r3, com.google.firebase.auth.api.internal.zzdz r4) throws android.os.RemoteException {
        /*
            r1 = this;
            android.os.Parcel r0 = r1.zza()
            r0.writeString(r2)
            com.google.android.gms.internal.firebase_auth.zzd.zza(r0, r3)
            com.google.android.gms.internal.firebase_auth.zzd.zza(r0, r4)
            r2 = 4
            r1.zza(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.api.internal.zzef.zza(java.lang.String, com.google.firebase.auth.UserProfileChangeRequest, com.google.firebase.auth.api.internal.zzdz):void");
    }

    public final void zza(String str, String str2, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzd.zza(zza, zzdz);
        zza(5, zza);
    }

    public final void zzb(String str, String str2, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzd.zza(zza, zzdz);
        zza(6, zza);
    }

    public final void zzc(String str, String str2, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzd.zza(zza, zzdz);
        zza(7, zza);
    }

    public final void zzd(String str, String str2, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzd.zza(zza, zzdz);
        zza(8, zza);
    }

    public final void zzc(String str, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, zzdz);
        zza(9, zza);
    }

    public final void zzd(String str, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, zzdz);
        zza(10, zza);
    }

    public final void zza(String str, String str2, String str3, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zza.writeString(str3);
        zzd.zza(zza, zzdz);
        zza(11, zza);
    }

    public final void zza(String str, zzfr zzfr, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, zzfr);
        zzd.zza(zza, zzdz);
        zza(12, zza);
    }

    public final void zze(String str, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, zzdz);
        zza(13, zza);
    }

    public final void zze(String str, String str2, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzd.zza(zza, zzdz);
        zza(14, zza);
    }

    public final void zzf(String str, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, zzdz);
        zza(15, zza);
    }

    public final void zza(zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzdz);
        zza(16, zza);
    }

    public final void zzg(String str, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, zzdz);
        zza(17, zza);
    }

    public final void zzh(String str, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, zzdz);
        zza(18, zza);
    }

    public final void zzi(String str, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, zzdz);
        zza(19, zza);
    }

    public final void zzj(String str, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, zzdz);
        zza(20, zza);
    }

    public final void zzf(String str, String str2, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzd.zza(zza, zzdz);
        zza(21, zza);
    }

    public final void zza(zzfk zzfk, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzfk);
        zzd.zza(zza, zzdz);
        zza(22, zza);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.os.Parcelable, com.google.firebase.auth.PhoneAuthCredential] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.firebase.auth.PhoneAuthCredential r2, com.google.firebase.auth.api.internal.zzdz r3) throws android.os.RemoteException {
        /*
            r1 = this;
            android.os.Parcel r0 = r1.zza()
            com.google.android.gms.internal.firebase_auth.zzd.zza(r0, r2)
            com.google.android.gms.internal.firebase_auth.zzd.zza(r0, r3)
            r2 = 23
            r1.zza(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.api.internal.zzef.zza(com.google.firebase.auth.PhoneAuthCredential, com.google.firebase.auth.api.internal.zzdz):void");
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.os.Parcelable, com.google.firebase.auth.PhoneAuthCredential] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r2, com.google.firebase.auth.PhoneAuthCredential r3, com.google.firebase.auth.api.internal.zzdz r4) throws android.os.RemoteException {
        /*
            r1 = this;
            android.os.Parcel r0 = r1.zza()
            r0.writeString(r2)
            com.google.android.gms.internal.firebase_auth.zzd.zza(r0, r3)
            com.google.android.gms.internal.firebase_auth.zzd.zza(r0, r4)
            r2 = 24
            r1.zza(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.api.internal.zzef.zza(java.lang.String, com.google.firebase.auth.PhoneAuthCredential, com.google.firebase.auth.api.internal.zzdz):void");
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.google.firebase.auth.ActionCodeSettings, android.os.Parcelable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r2, com.google.firebase.auth.ActionCodeSettings r3, com.google.firebase.auth.api.internal.zzdz r4) throws android.os.RemoteException {
        /*
            r1 = this;
            android.os.Parcel r0 = r1.zza()
            r0.writeString(r2)
            com.google.android.gms.internal.firebase_auth.zzd.zza(r0, r3)
            com.google.android.gms.internal.firebase_auth.zzd.zza(r0, r4)
            r2 = 25
            r1.zza(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.api.internal.zzef.zza(java.lang.String, com.google.firebase.auth.ActionCodeSettings, com.google.firebase.auth.api.internal.zzdz):void");
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.google.firebase.auth.ActionCodeSettings, android.os.Parcelable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(java.lang.String r2, com.google.firebase.auth.ActionCodeSettings r3, com.google.firebase.auth.api.internal.zzdz r4) throws android.os.RemoteException {
        /*
            r1 = this;
            android.os.Parcel r0 = r1.zza()
            r0.writeString(r2)
            com.google.android.gms.internal.firebase_auth.zzd.zza(r0, r3)
            com.google.android.gms.internal.firebase_auth.zzd.zza(r0, r4)
            r2 = 26
            r1.zza(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.api.internal.zzef.zzb(java.lang.String, com.google.firebase.auth.ActionCodeSettings, com.google.firebase.auth.api.internal.zzdz):void");
    }

    public final void zzk(String str, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, zzdz);
        zza(27, zza);
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.google.firebase.auth.ActionCodeSettings, android.os.Parcelable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzc(java.lang.String r2, com.google.firebase.auth.ActionCodeSettings r3, com.google.firebase.auth.api.internal.zzdz r4) throws android.os.RemoteException {
        /*
            r1 = this;
            android.os.Parcel r0 = r1.zza()
            r0.writeString(r2)
            com.google.android.gms.internal.firebase_auth.zzd.zza(r0, r3)
            com.google.android.gms.internal.firebase_auth.zzd.zza(r0, r4)
            r2 = 28
            r1.zza(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.api.internal.zzef.zzc(java.lang.String, com.google.firebase.auth.ActionCodeSettings, com.google.firebase.auth.api.internal.zzdz):void");
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.firebase.auth.EmailAuthCredential, android.os.Parcelable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.firebase.auth.EmailAuthCredential r2, com.google.firebase.auth.api.internal.zzdz r3) throws android.os.RemoteException {
        /*
            r1 = this;
            android.os.Parcel r0 = r1.zza()
            com.google.android.gms.internal.firebase_auth.zzd.zza(r0, r2)
            com.google.android.gms.internal.firebase_auth.zzd.zza(r0, r3)
            r2 = 29
            r1.zza(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.api.internal.zzef.zza(com.google.firebase.auth.EmailAuthCredential, com.google.firebase.auth.api.internal.zzdz):void");
    }

    public final void zza(zzch zzch, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzch);
        zzd.zza(zza, zzdz);
        zza(101, zza);
    }

    public final void zza(zzdf zzdf, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzdf);
        zzd.zza(zza, zzdz);
        zza(102, zza);
    }

    public final void zza(zzdd zzdd, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzdd);
        zzd.zza(zza, zzdz);
        zza(103, zza);
    }

    public final void zza(zzdx zzdx, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzdx);
        zzd.zza(zza, zzdz);
        zza(104, zza);
    }

    public final void zza(zzbr zzbr, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzbr);
        zzd.zza(zza, zzdz);
        zza(105, zza);
    }

    public final void zza(zzbt zzbt, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzbt);
        zzd.zza(zza, zzdz);
        zza(106, zza);
    }

    public final void zza(zzbz zzbz, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzbz);
        zzd.zza(zza, zzdz);
        zza(107, zza);
    }

    public final void zza(zzdh zzdh, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzdh);
        zzd.zza(zza, zzdz);
        zza(108, zza);
    }

    public final void zza(zzcj zzcj, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzcj);
        zzd.zza(zza, zzdz);
        zza(109, zza);
    }

    public final void zza(zzcl zzcl, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzcl);
        zzd.zza(zza, zzdz);
        zza(111, zza);
    }

    public final void zza(zzcn zzcn, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzcn);
        zzd.zza(zza, zzdz);
        zza(112, zza);
    }

    public final void zza(zzdt zzdt, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzdt);
        zzd.zza(zza, zzdz);
        zza(113, zza);
    }

    public final void zza(zzdv zzdv, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzdv);
        zzd.zza(zza, zzdz);
        zza(114, zza);
    }

    public final void zza(zzcr zzcr, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzcr);
        zzd.zza(zza, zzdz);
        zza(115, zza);
    }

    public final void zza(zzdb zzdb, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzdb);
        zzd.zza(zza, zzdz);
        zza(116, zza);
    }

    public final void zza(zzcb zzcb, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzcb);
        zzd.zza(zza, zzdz);
        zza(117, zza);
    }

    public final void zza(zzbv zzbv, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzbv);
        zzd.zza(zza, zzdz);
        zza(119, zza);
    }

    public final void zza(zzbp zzbp, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzbp);
        zzd.zza(zza, zzdz);
        zza(120, zza);
    }

    public final void zza(zzbx zzbx, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzbx);
        zzd.zza(zza, zzdz);
        zza(121, zza);
    }

    public final void zza(zzcx zzcx, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzcx);
        zzd.zza(zza, zzdz);
        zza(122, zza);
    }

    public final void zza(zzdl zzdl, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzdl);
        zzd.zza(zza, zzdz);
        zza(123, zza);
    }

    public final void zza(zzcp zzcp, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzcp);
        zzd.zza(zza, zzdz);
        zza(124, zza);
    }

    public final void zza(zzct zzct, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzct);
        zzd.zza(zza, zzdz);
        zza(126, zza);
    }

    public final void zza(zzcz zzcz, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzcz);
        zzd.zza(zza, zzdz);
        zza(127, zza);
    }

    public final void zza(zzcv zzcv, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzcv);
        zzd.zza(zza, zzdz);
        zza(128, zza);
    }

    public final void zza(zzdj zzdj, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzdj);
        zzd.zza(zza, zzdz);
        zza(129, zza);
    }

    public final void zza(zzdn zzdn, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzdn);
        zzd.zza(zza, zzdz);
        zza(130, zza);
    }

    public final void zza(zzdr zzdr, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzdr);
        zzd.zza(zza, zzdz);
        zza(131, zza);
    }

    public final void zza(zzcd zzcd, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzcd);
        zzd.zza(zza, zzdz);
        zza(132, zza);
    }

    public final void zza(zzdp zzdp, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzdp);
        zzd.zza(zza, zzdz);
        zza(133, zza);
    }

    public final void zza(zzcf zzcf, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzcf);
        zzd.zza(zza, zzdz);
        zza(134, zza);
    }

    public final void zza(zzdz zzdz, zzdz zzdz2) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzdz);
        zzd.zza(zza, zzdz2);
        zza(135, zza);
    }
}

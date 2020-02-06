package com.google.firebase.auth.api.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.firebase_auth.zzb;
import com.google.android.gms.internal.firebase_auth.zzd;
import com.google.android.gms.internal.firebase_auth.zzed;
import com.google.android.gms.internal.firebase_auth.zzei;
import com.google.android.gms.internal.firebase_auth.zzes;
import com.google.android.gms.internal.firebase_auth.zzey;
import com.google.android.gms.internal.firebase_auth.zzff;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzeb extends zzb implements zzdz {
    zzeb(IBinder iBinder) {
        super(iBinder, "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
    }

    public final void zza(zzey zzey) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzey);
        zzb(1, zza);
    }

    public final void zza(zzey zzey, zzes zzes) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzey);
        zzd.zza(zza, zzes);
        zzb(2, zza);
    }

    public final void zza(zzei zzei) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzei);
        zzb(3, zza);
    }

    public final void zza(zzff zzff) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzff);
        zzb(4, zza);
    }

    public final void zza(Status status) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, status);
        zzb(5, zza);
    }

    public final void a_() throws RemoteException {
        zzb(6, zza());
    }

    public final void zzb() throws RemoteException {
        zzb(7, zza());
    }

    public final void zza(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzb(8, zza);
    }

    public final void zzb(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzb(9, zza);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.os.Parcelable, com.google.firebase.auth.PhoneAuthCredential] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.firebase.auth.PhoneAuthCredential r2) throws android.os.RemoteException {
        /*
            r1 = this;
            android.os.Parcel r0 = r1.zza()
            com.google.android.gms.internal.firebase_auth.zzd.zza(r0, r2)
            r2 = 10
            r1.zzb(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.api.internal.zzeb.zza(com.google.firebase.auth.PhoneAuthCredential):void");
    }

    public final void zzc(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzb(11, zza);
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.os.Parcelable, com.google.firebase.auth.PhoneAuthCredential] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.common.api.Status r2, com.google.firebase.auth.PhoneAuthCredential r3) throws android.os.RemoteException {
        /*
            r1 = this;
            android.os.Parcel r0 = r1.zza()
            com.google.android.gms.internal.firebase_auth.zzd.zza(r0, r2)
            com.google.android.gms.internal.firebase_auth.zzd.zza(r0, r3)
            r2 = 12
            r1.zzb(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.api.internal.zzeb.zza(com.google.android.gms.common.api.Status, com.google.firebase.auth.PhoneAuthCredential):void");
    }

    public final void zzc() throws RemoteException {
        zzb(13, zza());
    }

    public final void zza(com.google.android.gms.internal.firebase_auth.zzeb zzeb) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzeb);
        zzb(14, zza);
    }

    public final void zza(zzed zzed) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzed);
        zzb(15, zza);
    }
}

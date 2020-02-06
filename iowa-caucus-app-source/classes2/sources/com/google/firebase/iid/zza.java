package com.google.firebase.iid;

import io.sentry.marshaller.json.HttpInterfaceBinding;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public final class zza {
    public static KeyPair zzc() {
        try {
            KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA");
            instance.initialize(HttpInterfaceBinding.MAX_BODY_LENGTH);
            return instance.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }
}

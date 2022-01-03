package s0.a.c.o;

import java.security.AlgorithmParameters;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
/* loaded from: classes4.dex */
public class b implements c {
    @Override // s0.a.c.o.c
    public SecureRandom a(String str) throws NoSuchAlgorithmException {
        return SecureRandom.getInstance(str);
    }

    @Override // s0.a.c.o.c
    public MessageDigest b(String str) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance(str);
    }

    @Override // s0.a.c.o.c
    public Cipher c(String str) throws NoSuchAlgorithmException, NoSuchPaddingException {
        return Cipher.getInstance(str);
    }

    @Override // s0.a.c.o.c
    public Signature createSignature(String str) throws NoSuchAlgorithmException {
        return Signature.getInstance(str);
    }

    @Override // s0.a.c.o.c
    public Mac d(String str) throws NoSuchAlgorithmException {
        return Mac.getInstance(str);
    }

    @Override // s0.a.c.o.c
    public CertificateFactory e(String str) throws CertificateException {
        return CertificateFactory.getInstance(str);
    }

    @Override // s0.a.c.o.c
    public AlgorithmParameters f(String str) throws NoSuchAlgorithmException {
        return AlgorithmParameters.getInstance(str);
    }

    @Override // s0.a.c.o.c
    public SecretKeyFactory g(String str) throws NoSuchAlgorithmException {
        return SecretKeyFactory.getInstance(str);
    }

    @Override // s0.a.c.o.c
    public KeyFactory h(String str) throws NoSuchAlgorithmException {
        return KeyFactory.getInstance(str);
    }
}

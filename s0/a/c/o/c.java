package s0.a.c.o;

import java.security.AlgorithmParameters;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
/* loaded from: classes4.dex */
public interface c {
    SecureRandom a(String str) throws NoSuchAlgorithmException, NoSuchProviderException;

    MessageDigest b(String str) throws NoSuchAlgorithmException, NoSuchProviderException;

    Cipher c(String str) throws NoSuchAlgorithmException, NoSuchPaddingException, NoSuchProviderException;

    Signature createSignature(String str) throws NoSuchAlgorithmException, NoSuchProviderException;

    Mac d(String str) throws NoSuchAlgorithmException, NoSuchProviderException;

    CertificateFactory e(String str) throws NoSuchProviderException, CertificateException;

    AlgorithmParameters f(String str) throws NoSuchAlgorithmException, NoSuchProviderException;

    SecretKeyFactory g(String str) throws NoSuchAlgorithmException, NoSuchProviderException;

    KeyFactory h(String str) throws NoSuchAlgorithmException, NoSuchProviderException;
}

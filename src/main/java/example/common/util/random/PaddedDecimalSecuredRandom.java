package example.common.util.random;

import java.security.SecureRandom;

public final class PaddedDecimalSecuredRandom {
    private PaddedDecimalSecuredRandom() {}

    private static final SecureRandom RANDOM;
    private static final char[] CHAR_SET;

    private static final int CHAR_SET_LENGTH = 10;
    private static final int SUGGESTED_SEED_LENGTH = 64;
    private static final int STRONG_SEED_LENGTH = 128;

    static{
        RANDOM = new SecureRandom();
        CHAR_SET = new char[CHAR_SET_LENGTH];

        for (int i = 0; i < CHAR_SET_LENGTH; i++) {
            CHAR_SET[i] = (char) (i | 0x30);
        }
    }
    public static String next(int length) {
        return next(length, SUGGESTED_SEED_LENGTH);
    }
    public static String nextStrong(int length) {
        return next(length, STRONG_SEED_LENGTH);
    }

    public static String next(int length, int seedLength) {
        StringBuilder stringBuilder = new StringBuilder(length);
        setSeed(seedLength);

        for (int i = 0; i < length; i++) {
            char ch = CHAR_SET[RANDOM.nextInt(CHAR_SET_LENGTH)];
            stringBuilder.append(ch);
        }

        return stringBuilder.toString();
    }

    private static void setSeed(int seedLength) {
        byte[] seed = RANDOM.generateSeed(seedLength);
        RANDOM.setSeed(seed);
    }
}
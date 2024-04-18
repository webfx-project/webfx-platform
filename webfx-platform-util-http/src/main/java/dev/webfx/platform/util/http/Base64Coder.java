package dev.webfx.platform.util.http;

/**
 * @author Bruno Salmon
 */
final class Base64Coder {

    private final static String base64chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

    public static String encode(String s) {

        // the result/encoded string, the padding string, and the pad count
        String r = "", p = "";
        int c = s.length() % 3;

        // add a right zero pad to make this string a multiple of 3 characters
        if (c > 0) {
            for (; c < 3; c++) {
                p += "=";
                s += "\0";
            }
        }

        // increment over the length of the string, three characters at a time
        for (c = 0; c < s.length(); c += 3) {

            // we add newlines after every 76 output characters, according to
            // the MIME specs
            if (c > 0 && (c / 3 * 4) % 76 == 0)
                r += "\r\n";

            // these three 8-bit (ASCII) characters become one 24-bit number
            int n = (s.charAt(c) << 16) + (s.charAt(c + 1) << 8)
                    + (s.charAt(c + 2));

            // this 24-bit number gets separated into four 6-bit numbers
            int n1 = (n >> 18) & 63, n2 = (n >> 12) & 63, n3 = (n >> 6) & 63, n4 = n & 63;

            // those four 6-bit numbers are used as indices into the base64
            // character list
            r += "" + base64chars.charAt(n1) + base64chars.charAt(n2)
                 + base64chars.charAt(n3) + base64chars.charAt(n4);
        }

        return r.substring(0, r.length() - p.length()) + p;
    }

}

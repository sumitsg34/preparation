package org.learn.preparation.leetcode;

public class ValidIP {

    public String validIPAddress(String IP) {
        if (IP == null || IP.length() == 0)
            return "Neither";

        if (IP.contains(":")) {
            //IPv6
            if (IP.charAt(0) == ':' || IP.charAt(IP.length() - 1) == ':')
                return "Neither";
            String[] tokens = IP.split(":");
            if (tokens.length != 8)
                return "Neither";

            if (tokens[0].length() == 0 || tokens[0].length() > 4 || tokens[0].charAt(0) == '0')
                return "Neither";

            for (int i = 1; i < 8; i++) {
                if (tokens[i].length() == 0 || tokens[i].length() > 4)
                    return "Neither";
                for (int j = 0; j < tokens[i].length(); j++) {
                    if ((tokens[i].charAt(j) >= 'A' && tokens[i].charAt(j) <= 'F')
                            || (tokens[i].charAt(j) >= 'a' && tokens[i].charAt(j) <= 'f')
                            || (tokens[i].charAt(j) >= '0' && tokens[i].charAt(j) <= '9')) {
                        continue;
                    }
                    return "Neither";
                }
            }
            return "IPv6";

        } else {
            //IPv4
            if (IP.charAt(0) == '.' || IP.charAt(IP.length() - 1) == '.')
                return "Neither";
            String[] tokens = IP.split("\\.");
            if (tokens.length != 4)
                return "Neither";

            for (String token : tokens) {
                //this is for leading zero
                try {
                    if (token.length() == 0 || token.length() > 3)
                        return "Neither";
                    if (Integer.valueOf(token.substring(0, 1)) == 0 && token.length() > 1) {
                        return "Neither";
                    }
                    if (Integer.valueOf(token) > 255 || Integer.valueOf(token) < 0)
                        return "Neither";
                } catch (NumberFormatException numEx) {
                    return "Neither";
                }
            }
            return "IPv4";
        }
    }


    public static void main(String[] args) {
        ValidIP validIP = new ValidIP();
        System.out.println(validIP.validIPAddress("t001:0db8:85a3:0::0:8A2E:0370"));
        System.out.println(validIP.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
        System.out.println(validIP.validIPAddress("172.16.254.1"));
        System.out.println(validIP.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
        System.out.println(validIP.validIPAddress("256.256.256.256"));
    }
}

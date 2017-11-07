package com.cputech.crypto;

import java.io.*;

/**
 * Created by song on 2017/10/10.
 */
public class IOUtil {
    public static byte[] inputStreamToBytes(InputStream inputStream){
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        byte[] buff = new byte[100];
        int rc = 0;
        try {
            while ((rc = inputStream.read(buff, 0, 100)) > 0) {
                swapStream.write(buff, 0, rc);
            }
        } catch (IOException e) {
            return null;
        }
        return swapStream.toByteArray();
    }
    public static String getContent(String filename) throws IOException {
        // Read key from file
        String strKeyPEM = "";
        InputStream is = filename.getClass().getResourceAsStream("/" + filename);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;
        while ((line = br.readLine()) != null) {
            strKeyPEM += line + "\n";
        }
        br.close();
        return strKeyPEM;
    }

}

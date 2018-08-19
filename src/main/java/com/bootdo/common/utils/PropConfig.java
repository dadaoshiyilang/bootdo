package com.bootdo.common.utils;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropConfig {
    private static final PropConfig config = new PropConfig();
    private Properties prop = new Properties();
    private Map<String, String> preProp = new HashMap();

    public PropConfig() {
    }

    public static PropConfig loadConfig(String propFile) {
        return config.load(propFile) ? config : null;
    }

    public boolean load(String propFile) {
        try {
            ClassLoader loader = this.getClass().getClassLoader();
            InputStream in = loader.getResourceAsStream(propFile);
            this.prop.load(in);
            Set<Object> set = this.prop.keySet();
            this.preProp.clear();
            Iterator it = set.iterator();

            while(it.hasNext()) {
                String entity = (String)it.next();
                String value = this.prop.getProperty(entity);
                this.preProp.put(entity, value);
            }

            return true;
        } catch (Exception var8) {
            var8.printStackTrace();
            return false;
        }
    }

    public String getConfigString(String entry) {
        return this.getConfigString(entry, (String)null);
    }

    public String getConfigString(String entry, String defValue) {
        return this.prop.getProperty(entry, defValue);
    }

    public int getConfigInt(String entry) {
        return this.getConfigInt(entry, 0);
    }

    public int getConfigInt(String entry, int defValue) {
        String value = this.getConfigString(entry);
        return value != null && !value.equals("") ? Integer.parseInt(value) : defValue;
    }
}

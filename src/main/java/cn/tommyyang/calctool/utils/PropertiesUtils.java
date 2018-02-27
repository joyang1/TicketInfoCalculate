package cn.tommyyang.calctool.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by TommyYang on 2017/12/9.
 */
public class PropertiesUtils {

    private static Logger logger = LoggerFactory.getLogger(PropertiesUtils.class);
    private final static String dataSourcePath = "datasource.properties";
    private static Properties properties = new Properties();

    static {
        try {
            InputStream inputStream = PropertiesUtils.class.getClassLoader().getResourceAsStream(dataSourcePath);
            properties.load(inputStream);
        } catch (IOException e) {
            logger.error("load properties error:\n", e);
        }
    }

    public static String getString(String name){
        String value = properties.getProperty(name);
        if(StringUtils.isNotBlank(value)){
            return value;
        }
        return "";
    }

}

package com.galaxy.framework.util;

import com.galaxy.framework.util.model.Location;
import com.google.common.base.Strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author aaron.pan
 * @date 2018/10/19
 */
public class LocationUtils {
    public static Location resolve(String address){
        String regex="(?<province>[^省]+自治区|.*?省|.*?行政区|.*?市)(?<city>[^市]+自治州|.*?地区|.*?行政单位|.+盟|市辖区|.*?市|.*?县)(?<county>[^县]+县|.*?区|.+市|.+旗|.+海域|.+岛)";
        Matcher m= Pattern.compile(regex).matcher(address);
        Location location = new Location();
        while(m.find()){
            String province = m.group("province");
            if(!Strings.isNullOrEmpty(province)){
                location.setProvince(province.trim());
            }
            String city = m.group("city");
            if(!Strings.isNullOrEmpty(city)){
                location.setCity(city.trim());
            }
            String county = m.group("county");
            if(!Strings.isNullOrEmpty(county)){
                location.setCounty(county.trim());
            }
        }
        return location;
    }
}
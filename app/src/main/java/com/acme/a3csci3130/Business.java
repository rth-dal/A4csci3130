package com.acme.a3csci3130;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that defines how the data will be stored in the
 * Firebase databse. This is converted to a JSON format
 */

public class Business implements Serializable {

    public  String id;
    public  String name;
    public  String number;
    public  String province;
    public  String address;
    public  String job;

    public Business() {
        // Default constructor required for calls to DataSnapshot.getValue
    }

    public Business(String id, String name, String number, String province, String address, String job){
        this.id = id;
        this.name = name;
        this.number = number;
        this.province = province;
        this.address = address;
        this.job = job;
    }

    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("id", id);
        result.put("name", name);
        result.put("number", number);
        result.put("province", province);
        result.put("address", address);
        result.put("job", job);
        return result;
    }

}

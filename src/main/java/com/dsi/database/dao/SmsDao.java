package com.dsi.database.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SmsDao {
    private String number;

    public void setNumber(String number) {
        if (!number.startsWith("+88")) {
            this.number = "+88"+number;
        } else {
            this.number = number;
        }
    }
}

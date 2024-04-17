package com.mail.server.entities;

import lombok.Data;

@Data

public class Otp {
    private  String otp1;

    public String getOtp1() {
        return otp1;
    }

    public void setOtp1(String otp1) {
        this.otp1 = otp1;
    }
}

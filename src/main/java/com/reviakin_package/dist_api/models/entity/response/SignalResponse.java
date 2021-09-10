package com.reviakin_package.dist_api.models.entity.response;

import com.reviakin_package.dist_api.models.entity.response.base.BaseResponse;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "SignalResponse")

@XmlType(propOrder = {
        "status", "code"
})
public class SignalResponse extends BaseResponse {

    private String status;
    private Integer code;

    public SignalResponse(){

    }

    public SignalResponse(String status, Integer code) {
        this.status = status;
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public Integer getCode() {
        return code;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}

package com.code.nio.ch02.serializable.msgpack;

/**
 * @author Mark老师 享学课堂 https://enjoy.ke.qq.com 类说明：
 */
public class UserContact {
    private String mail;
    private String phone;

    public UserContact() {
    }

    public UserContact(String mail, String phone) {
        this.mail = mail;
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "UserContact{" + "mail='" + mail + '\'' + ", phone='" + phone + '\'' + '}';
    }
}

package com.fullcycle.balance;

public class Payload {
    private String account_id_from;
    private String account_id_to;
    private String balance_account_id_from;
    private String balance_account_id_to;

    public String getAccount_id_from() {
        return account_id_from;
    }

    public void setAccount_id_from(String account_id_from) {
        this.account_id_from = account_id_from;
    }

    public String getAccount_id_to() {
        return account_id_to;
    }

    public void setAccount_id_to(String account_id_to) {
        this.account_id_to = account_id_to;
    }

    public String getBalance_account_id_from() {
        return balance_account_id_from;
    }

    public void setBalance_account_id_from(String balance_account_id_from) {
        this.balance_account_id_from = balance_account_id_from;
    }

    public String getBalance_account_id_to() {
        return balance_account_id_to;
    }

    public void setBalance_account_id_to(String balance_account_id_to) {
        this.balance_account_id_to = balance_account_id_to;
    }

    @Override
    public String toString() {
        return "Payload [account_id_from=" + account_id_from + ", account_id_to=" + account_id_to
                + ", balance_account_id_from=" + balance_account_id_from + ", balance_account_id_to="
                + balance_account_id_to + "]";
    }

}

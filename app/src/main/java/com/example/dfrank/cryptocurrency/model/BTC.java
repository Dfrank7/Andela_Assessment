package com.example.dfrank.cryptocurrency.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dfrank on 11/1/17.
 */

public class BTC {
    @SerializedName("USD")
    @Expose
    private float uSD;
    @SerializedName("XAF")
    @Expose
    private float xAF;
    @SerializedName("CAD")
    @Expose
    private float cAD;
    @SerializedName("AFN")
    @Expose
    private float aFN;
    @SerializedName("ALL")
    @Expose
    private float aLL;
    @SerializedName("COP")
    @Expose
    private float cOP;
    @SerializedName("EGP")
    @Expose
    private float eGP;
    @SerializedName("DKK")
    @Expose
    private float dKK;
    @SerializedName("KRW")
    @Expose
    private float kRW;
    @SerializedName("ZAR")
    @Expose
    private float zAR;
    @SerializedName("SAR")
    @Expose
    private float sAR;
    @SerializedName("JPY")
    @Expose
    private float jPY;
    @SerializedName("ARS")
    @Expose
    private float aRS;
    @SerializedName("BRL")
    @Expose
    private float bRL;
    @SerializedName("CNY")
    @Expose
    private float cNY;
    @SerializedName("HKD")
    @Expose
    private float hKD;
    @SerializedName("GBP")
    @Expose
    private float gBP;
    @SerializedName("GHS")
    @Expose
    private float gHS;
    @SerializedName("EUR")
    @Expose
    private float eUR;
    @SerializedName("NGN")
    @Expose
    private float nGN;
    @SerializedName("Cname")
    @Expose
    private String Cname;
    @SerializedName("Scode")
    @Expose
    private String Scode;
    @SerializedName("Currency")
    @Expose
    private float currency;

    public BTC(String Cname, String Scode, float currency){
        this.Cname = Cname;
        this.Scode = Scode;
        this.currency = currency;
    }

    public BTC(float uSD, float xAF, float cAD, float aFN, float aLL, float cOP, float eGP, float dKK,
               float kRW, float zAR, float sAR, float jPY, float aRS, float bRL, float cNY, float hKD,
               float gBP, float gHS, float eUR, float nGN) {
        this.uSD = uSD;
        this.xAF = xAF;
        this.cAD = cAD;
        this.aFN = aFN;
        this.aLL = aLL;
        this.cOP = cOP;
        this.eGP = eGP;
        this.dKK = dKK;
        this.kRW = kRW;
        this.zAR = zAR;
        this.sAR = sAR;
        this.jPY = jPY;
        this.aRS = aRS;
        this.bRL = bRL;
        this.cNY = cNY;
        this.hKD = hKD;
        this.gBP = gBP;
        this.gHS = gHS;
        this.eUR = eUR;
        this.nGN = nGN;
    }

    public float getUSD() {
        return uSD;
    }

    public void setUSD(float uSD) {
        this.uSD = uSD;
    }

    public float getXAF() {
        return xAF;
    }

    public void setXAF(float xAF) {
        this.xAF = xAF;
    }

    public float getCAD() {
        return cAD;
    }

    public void setCAD(float cAD) {
        this.cAD = cAD;
    }

    public float getAFN() {
        return aFN;
    }

    public void setAFN(int aFN) {
        this.aFN = aFN;
    }

    public float getALL() {
        return aLL;
    }

    public void setALL(float aLL) {
        this.aLL = aLL;
    }

    public float getCOP() {
        return cOP;
    }

    public void setCOP(float cOP) {
        this.cOP = cOP;
    }

    public float getEGP() {
        return eGP;
    }

    public void setEGP(float eGP) {
        this.eGP = eGP;
    }

    public float getDKK() {
        return dKK;
    }

    public void setDKK(float dKK) {
        this.dKK = dKK;
    }

    public float getKRW() {
        return kRW;
    }

    public void setKRW(float kRW) {
        this.kRW = kRW;
    }

    public float getZAR() {
        return zAR;
    }

    public void setZAR(float zAR) {
        this.zAR = zAR;
    }

    public float getSAR() {
        return sAR;
    }

    public void setSAR(float sAR) {
        this.sAR = sAR;
    }

    public float getJPY() {
        return jPY;
    }

    public void setJPY(float jPY) {
        this.jPY = jPY;
    }

    public float getARS() {
        return aRS;
    }

    public void setARS(float aRS) {
        this.aRS = aRS;
    }

    public float getBRL() {
        return bRL;
    }

    public void setBRL(int bRL) {
        this.bRL = bRL;
    }

    public float getCNY() {
        return cNY;
    }

    public void setCNY(float cNY) {
        this.cNY = cNY;
    }

    public float getHKD() {
        return hKD;
    }

    public void setHKD(float hKD) {
        this.hKD = hKD;
    }

    public float getGBP() {
        return gBP;
    }

    public void setGBP(float gBP) {
        this.gBP = gBP;
    }

    public float getGHS() {
        return gHS;
    }

    public void setGHS(float gHS) {
        this.gHS = gHS;
    }

    public float getEUR() {
        return eUR;
    }

    public void setEUR(float eUR) {
        this.eUR = eUR;
    }

    public float getNGN() {
        return nGN;
    }

    public void setNGN(float nGN) {
        this.nGN = nGN;
    }

    public String getCname() {
        return Cname;
    }

    public String getScode() {
        return Scode;
    }
    public float getCurrency(){
        return currency;
    }
}

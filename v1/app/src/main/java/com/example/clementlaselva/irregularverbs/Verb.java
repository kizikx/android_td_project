package com.example.clementlaselva.irregularverbs;

/**
 * Created by clementlaselva on 27/03/2018.
 */

public class Verb {
    private String bv;
    private String preterit;
    private String pp;

    public String getBv(){
        return bv;
    }

    public String getEstAnglais(){
        return preterit;
    }
    public String getEstRegulier(){
        return pp;
    }

    public Verb(String bv, String preterit, String pp){
        this.bv=bv;
        this.preterit=preterit;
        this.pp=pp;
    }
    public String toString()
    {
        return "bv:" + " " + bv + "\n" + "preterit:" + " " + preterit + "\n" + "pp:" + " " + pp ;
    }

}
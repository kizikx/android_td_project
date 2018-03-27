package com.example.clementlaselva.irregularverbs;

/**
 * Created by clementlaselva on 27/03/2018.
 */

public class Verb {
    private String bv;
    private boolean preterit;
    private boolean pp;

    public String getBv(){
        return bv;
    }

    public boolean getEstAnglais(){
        return preterit;
    }
    public boolean getEstRegulier(){
        return pp;
    }

    public Verb(String bv, boolean preterit, boolean pp){
        this.bv=bv;
        this.preterit=preterit;
        this.pp=pp;
    }

}

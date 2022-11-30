package com.example.mathworker3;

import java.util.Random;

public class Problem {
    private int result;
    private final Random random = new Random();
    public int getRandom(int min, int max){
        return (int) (Math.random()*(max-min));
    }

    public int getResult() {
        return result;
    }
    public int getNoiseResult(){
        return result + (getRandom(0,2) == 0 ? getRandom(1,15)+1 : -getRandom(1,15)-1);
    }
    private int pow(int a,int b){
        if(b==0){
            return a;
        }
        else{
            return a*pow(a,b-1);
        }
    }
    public String getProblem(){
        int calculationNumber=getRandom(1,6)+1;
        String lastSign="";
        int sleshCheck=0;
        int a = getRandom(-12, 12);
        String calculation="";
        // for(int i=0;i<calculationNumber;i++){
        //     calculation+="(";
        // }
        calculation+=String.valueOf(a);
        result=a;
        for(int i=0;i<calculationNumber;i++) {
            int b=getRandom(0,12)+1;
            String sign = getRandomSign();
            if(sign!="/" && sign!="*"){
                sleshCheck=0;
            }
            if((sign=="/" || sign=="*")&& sleshCheck==1){
                i--;
                continue;
            }
            if(sign=="/"){
                if(lastSign=="-"){
                    result+=a;
                    result-=a/b;
                }
                else{
                    result-=a;
                    result+=a/b;
                }
                sleshCheck=1;
            }
            if(sign=="+"){
                result+=b;
            }
            if (sign == "-") {
                result -= b;
            }
            if(sign=="*"){
                if (lastSign=="-"){
                    result+=a;
                    result-=a*b;
                }
                else{
                    result-=a;
                    result+=a*b;
                }
                sleshCheck=1;
            }
            calculation+=" "+sign+ " " + b;
            a=b;
            lastSign=sign;
        }
        return calculation;
    }
    private String getRandomSign(){
        int a=getRandom(0,4);
        switch (a){
            case 0:
                return "+";
            case 1:
                return "-";
            case 2:
                return "*";
            case 3:
                return "/";
        }
        return "";
    }

}

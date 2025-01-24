char* intToRoman(int num) {
    int n1=num/1000;
        int n2=num/100-10*n1;
        int n3=num/10-100*n1-10*n2;
        int n4=num-1000*n1-100*n2-10*n3;
        char *ar1[]={"","M","MM","MMM"};
        char *ar2[]={"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        char *ar3[]={"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        char *ar4[]={"","I","II","III","IV","V","VI","VII","VIII","IX"};
       static char result[100];
    result[0] = '\0';
    strcat(result, ar1[n1]);
    strcat(result, ar2[n2]);
    strcat(result, ar3[n3]);
    strcat(result, ar4[n4]);

    return result;}
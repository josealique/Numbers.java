import java.util.Arrays;

public class Numbers {

    static String[] hasta19 = {"One", "Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    static String[] minusculas = {"one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
    static String[] de20hasta90 = {"", "Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    static String[] minusculas2 = {"", "twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};

    public static void main(String[] args) {
        System.out.println(say(986_678));
    }
    public static String say(long n) {
        if (n <= 999){
            return hastaMil((int) n);
        } else if (n <= 999_999){
            return hastaMillon((int)n);
        } else if (n <= 999_999_999){
            return hastaBillon((int)n);
        }
        return "";
    }

   static String hastaMil(int n) {
       String vacia = "";
       if (n == 0){
           return "Zero";
       }
        if (n < 20){
           vacia += hasta19[n-1];
       } else if ( n >= 20 && n <= 99){
           if ( n % 10 == 0){
               vacia += de20hasta90[n/10-1];
           } else {
               vacia += de20hasta90[n/10-1]+"-"+minusculas[n % 10-1];
           }
       } else if (n <= 999){
            if (n % 100 == 0){
                vacia += hasta19[n/100-1] + " hundred";
            } else if (n % 100 <= 19) {
                vacia += hasta19[n / 100 - 1] + " hundred and " + minusculas[n % 100 - 1];
            } else {
                if (n % 10 == 0){
                    vacia += hasta19[n/100-1] + " hundred and "+ minusculas2[n % 100-1];
                } else {
                    vacia += hasta19[n / 100-1]+" hundred and "+minusculas2[n % 100 / 10-1]+"-"+minusculas[n % 10-1];
                }
            }
        }
       return vacia;
   }

   static String hastaMilMinus(int n) {
        String vacia = "";
        if (n < 20){
            vacia += minusculas[n-1];
        } else if ( n >= 20 && n <= 99){
            if ( n % 10 == 0){
                vacia += minusculas2[n/10-1];
            } else {
                vacia += minusculas2[n/10-1]+"-"+minusculas[n % 10-1];
            }
        } else if (n <= 999){
            if (n % 100 == 0){
                vacia += minusculas[n/100-1] + " hundred";
            } else if (n % 100 <= 19) {
                vacia += minusculas[n / 100 - 1] + " hundred and " + minusculas[n % 100 - 1];
            } else {
                if (n % 10 == 0){
                    vacia += minusculas[n/100-1] + " hundred and "+ minusculas2[n % 100-1];
                } else {
                    vacia += minusculas[n / 100-1]+" hundred and "+minusculas2[n % 100 / 10-1]+"-"+minusculas[n % 10-1];
                }
            }
        }
        return vacia;
    }

   static String hastaMillon(int n){
       String vacia = "";
       if (n / 1000 <= 19){
           vacia += hasta19[n/1000-1] + " thousand";
       } else if (n / 1000 <= 99){
           if ( n / 1000 % 10 == 0){
               vacia += de20hasta90[n/1000 / 10-1 ]+ " thousand";
           } else {
               vacia += de20hasta90[n/1000 / 10-1]+"-"+minusculas[n/1000 % 10-1]+" thousand";
           }
       } else {
           if ( n / 1000 % 100 == 0){
               vacia += hasta19[n/1000 / 100 -1]+ " hundred thousand";
           } else if (n / 1000 % 100 <= 19){
               vacia += hasta19[n/1000 / 100 -1] + " hundred and "+minusculas[n/1000 % 100-1]+ " thousand";
           } else {
               if (n / 1000 % 10 == 0){
                   vacia += hasta19[n/1000 / 100-1] + " hundred "+minusculas2[n / 1000 % 100 / 10-1]+ " thousand";
               } else {
                   vacia += hasta19[n/1000 / 100-1] + " hundred "+ minusculas2[n / 1000 % 100 / 10-1]+ "-" + minusculas[n / 1000 % 10]+" thousand";
               }
           }
       }
       if (n % 1000 == 0){
           return vacia;
       } else {
           return vacia+" "+hastaMilMinus(n%1000);
       }
    }

    static String hastaMillonMinus(int n){
        String vacia = "";
        if (n / 1000 <= 19){
            vacia += minusculas[n/1000-1] + " thousand";
        } else if (n / 1000 <= 99){
            if ( n / 1000 % 10 == 0){
                vacia += minusculas2[n/1000 / 10-1 ]+ " thousand";
            } else {
                vacia += minusculas2[n/1000 / 10-1]+"-"+minusculas[n/1000 % 10-1]+" thousand";
            }
        } else {
            if ( n / 1000 % 100 == 0){
                vacia += minusculas[n/1000 / 100 -1]+ " hundred thousand";
            } else if (n / 1000 % 100 <= 19){
                vacia += minusculas[n/1000 / 100 -1] + " hundred and "+minusculas[n/1000 % 100-1]+ " thousand";
            } else {
                if (n / 1000 % 10 == 0){
                    vacia += minusculas[n/1000 / 100-1] + " hundred "+minusculas2[n / 1000 % 100 / 10-1]+ " thousand";
                } else {
                    vacia += minusculas[n/1000 / 100-1] + " hundred "+ minusculas2[n / 1000 % 100 / 10-1]+ "-" + minusculas[n / 1000 % 10]+" thousand";
                }
            }
        }
        if (n % 1000 == 0){
            return vacia;
        } else {
            return vacia+" "+hastaMilMinus(n%1000);
        }
    }

    static String hastaBillon(int n){
        String vacia = "";
        int millon = n / 1_000_000;
        if (millon <= 19){
            vacia += hasta19[millon-1] + " million";
        } else if (millon <= 99){
            if (millon % 10 == 0){
                vacia += de20hasta90[millon / 10-1] + " million";
            } else {
                vacia += de20hasta90[millon / 10-1]+"-"+minusculas[millon % 10-1]+" million";
            }
        } else {
            if (millon % 100 == 0){
                vacia += hasta19[millon / 100-1]+" hundred million";
            } else if( millon / 100)
        }
    }


    public static long words(String s) {
        return 0;
    }
}
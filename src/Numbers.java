import java.util.Arrays;

public class Numbers {
    // definimos todas las listas que utilizaremos más adelante
    static String[] hasta19 = {"One", "Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    static String[] minusculas = {"one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
    static String[] de20hasta90 = {"", "Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    static String[] minusculas2 = {"", "twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
    static String[] letras = {"zero","one","two","three","four","five","six","seven","eight","nine",
            "ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen",
            "nineteen","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety", "hundred",
            "thousand","million","billion","trillion","quadrillion","quintillion"};
    public static void main(String[] args) {
        System.out.println(say(179));
    }
    public static String say(long n) {
        // Aqui es donde definiremos las condiciones, indicamos que si n es menor que el numero definido, nos devolvera el valor de la funcion
        if (n <= 999){
            return hastaMil((int) n);
        } else if (n <= 999_999){
            return hastaMillon((int) n);
        } else if (n <= 999_999_999){
            return hastaBillon((int) n);
        } else if (n <= 999_999_999_999L){
            return hastaTrillon(n);
        } else if (n <= 999_999_999_999_999L){
            return hastaQuatrillon(n);
        } else if (n <= 999_999_999_999_999_999L){
            return hastaQuintillon(n);
        } else {
            return Quintillon(n);
        }
    }

   static String hastaMil(int n) {
       String vacia = "";   // Definimos la string vacia
       if (n == 0){         // si n es igual a 0 retornará el valor de "Zero"
           return "Zero";
       }
        if (n < 20){
           vacia += hasta19[n-1];   // Si n es menor que 20, retornará la String vacia con el valor de la lista, le ponemos un -1 porque no esta la palabra "zero"
       } else if ( n >= 20 && n <= 99){
           if ( n % 10 == 0){   // Esta operacion coge las unidades del numero y mira si es igual a cero
               vacia += de20hasta90[n/10-1]; // Coge las decenas del numero
           } else {
               vacia += de20hasta90[n/10-1]+"-"+minusculas[n % 10-1]; // Coge la lista (con las mayusculas de las decenas) y añade un guion y luego coge las unidades
           }
       } else if (n <= 999){
            if (n % 100 == 0){
                vacia += hasta19[n/100-1] + " hundred";
            } else if (n % 100 <= 19) {
                vacia += hasta19[n / 100 - 1] + " hundred and " + minusculas[n % 100 - 1];
            } else {
                if (n % 10 == 0){
                    vacia += hasta19[n / 100-1] + " hundred and "+ minusculas2[n % 100-1];
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
        } else if ( n <= 99){
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
                    vacia += minusculas[n/100-1] + " hundred and "+ minusculas2[n % 100 / 10-1];
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
                   vacia += hasta19[n/1000 / 100-1] + " hundred and "+minusculas2[n / 1000 % 100 / 10-1]+ " thousand";
               } else {
                   vacia += hasta19[n/1000 / 100-1] + " hundred and "+ minusculas2[n / 1000 % 100 / 10-1]+ "-" + minusculas[n / 1000 % 10-1]+" thousand";
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
                    vacia += minusculas[n/1000 / 100-1] + " hundred and "+minusculas2[n / 1000 % 100 / 10-1]+ " thousand";
                } else {
                    vacia += minusculas[n/1000 / 100-1] + " hundred and "+ minusculas2[n / 1000 % 100 / 10-1]+ "-" + minusculas[n / 1000 % 10-1]+" thousand";
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
            } else if( millon / 100 % 100 <= 19){
                vacia += minusculas[millon / 100-1] + " thousand and "+ minusculas[millon % 100-1]+ " million";
            } else {
                if (millon % 10 == 0){
                    vacia += de20hasta90[millon / 100-1] + " hundred "+minusculas2[millon % 100 / 10-1] + " million";
                } else {
                    vacia += minusculas[millon / 100-1]+ " hundred " + minusculas2[millon % 100 / 10-1]+ "-" + minusculas[millon % 10-1]+ " million";
                }
            }
        }
        n %= 1_000_000;
        if (n == 0){
            return vacia;
        } else if (n <= 99){
            return vacia+" and "+hastaMilMinus(n);
        } else {
            return vacia + " "+ hastaMillonMinus(n);
        }
    }

    static String hastaBillonMinus(int n){
        String vacia = "";
        int millon = n / 1_000_000;
        if (millon <= 19){
            vacia += minusculas[millon-1] + " million";
        } else if (millon <= 99){
            if (millon % 10 == 0){
                vacia += minusculas2[millon / 10-1] + " million";
            } else {
                vacia += minusculas2[millon / 10-1]+"-"+minusculas[millon % 10-1]+" million";
            }
        } else {
            if (millon % 100 == 0){
                vacia += minusculas[millon / 100-1]+" hundred million";
            } else if( millon % 100 <= 19){
                vacia += minusculas[millon / 100-1] + " hundred and "+ minusculas[millon / 100 -1]+ " million";
            } else {
                if (millon % 10 == 0){
                    vacia += minusculas2[millon / 100-1] + " hundred and "+minusculas2[millon % 100 / 10-1] + " million";
                } else {
                    vacia += minusculas[millon / 100-1]+ " hundred and " + minusculas2[millon % 100 / 10-1]+ "-" + minusculas[millon % 10-1]+ " million";
                }
            }
        }
        n %= 1_000_000;
        if (n == 0){
            return vacia;
        } else if (n <= 999){
            return vacia+" "+hastaMilMinus(n);
        } else {
            return vacia +" "+ hastaMillonMinus(n);
        }
    }


    static String hastaTrillon(long n){
        String vacia = "";
        long trillon = n / 1_000_000_000L;
        if (trillon <= 19){
            vacia += hasta19[(int)trillon-1] + " billion";
        } else if (trillon <= 99){
            if (trillon % 10 == 0){
                vacia += de20hasta90[(int)trillon / 10-1] + " billion";
            } else {
                vacia += de20hasta90[(int)trillon / 10-1]+"-"+minusculas[(int)trillon % 10-1]+" billion";
            }
        } else {
            if (trillon % 100 == 0){
                vacia += hasta19[(int)trillon / 100-1]+" hundred billion";
            } else if( trillon % 100 <= 19){
                vacia += hasta19[(int)trillon / 100-1] + " hundred and "+ minusculas[(int)trillon % 100-1]+ " billion";
            } else {
                if (trillon % 10 == 0){
                    vacia += de20hasta90[(int)trillon / 100-1] + " hundred and "+minusculas2[(int)trillon % 100 / 10-1] + " billion";
                } else {
                    vacia += hasta19[(int)trillon / 100-1]+ " hundred and " + minusculas2[(int)trillon % 100 / 10-1]+ "-" + minusculas[(int)trillon % 10-1]+ " billion";
                }
            }
        }
        n %= 1_000_000_000L;
        if (n == 0){
            return vacia;
        } else if (n <= 99){
            return vacia+" and "+hastaMilMinus((int)n);
        } else if (n <= 999_999){
            return vacia + " "+ hastaMillonMinus((int)n);
        } else {
            return vacia + " " + hastaBillonMinus((int) n);
        }
    }

    static String hastaTrillonMinus(long n){
        String vacia = "";
        long trillon = n / 1_000_000_000L;
        if (trillon <= 19){
            vacia += minusculas[(int)trillon-1] + " billion";
        } else if (trillon <= 99){
            if (trillon % 10 == 0){
                vacia += minusculas2[(int)trillon / 10-1] + " billion";
            } else {
                vacia += minusculas2[(int)trillon / 10-1]+"-"+minusculas[(int)trillon % 10-1]+" billion";
            }
        } else {
            if (trillon % 100 == 0){
                vacia += minusculas[(int)trillon / 100-1]+" hundred billion";
            } else if( trillon % 100 <= 19){
                vacia += minusculas[(int)trillon / 100-1] + " hundred and "+ minusculas[(int)trillon % 100-1]+ " billion";
            } else {
                if (trillon % 10 == 0){
                    vacia += minusculas2[(int)trillon / 100-1] + " hundred and "+minusculas2[(int)trillon % 100 / 10-1] + " billion";
                } else {
                    vacia += minusculas[(int)trillon / 100-1]+ " hundred and " + minusculas2[(int)trillon % 100 / 10-1]+ "-" + minusculas[(int)trillon % 10-1]+ " billion";
                }
            }
        }
        n %= 1_000_000_000L;
        if (n == 0){
            return vacia;
        } else if (n <= 99){
            return vacia+" and "+hastaMilMinus((int)n);
        } else if (n <= 999_999){
            return vacia + " "+ hastaMillonMinus((int)n);
        } else if(n <= 999_999_999){
            return vacia + " " + hastaBillonMinus((int)n);
        } else {
            return vacia + " " + hastaTrillonMinus((int)n);
        }
    }



    static String hastaQuatrillon(long n){
        String vacia = "";
        long quatrillon = n / 1_000_000_000_000L;
        if (quatrillon <= 19){
            vacia += hasta19[(int)quatrillon-1] + " trillion";
        } else if (quatrillon <= 99){
            if (quatrillon % 10 == 0){
                vacia += de20hasta90[(int)quatrillon / 10-1] + " trillion";
            } else {
                vacia += de20hasta90[(int)quatrillon / 10-1]+"-"+ minusculas[(int)quatrillon % 10-1]+" trillion";
            }
        } else {
            if (quatrillon % 100 == 0){
                vacia += hasta19[(int)quatrillon / 100-1]+" hundred trillion";
            } else if( quatrillon % 100 <= 19){
                vacia += hasta19[(int)quatrillon / 100-1] + " hundred and "+ minusculas[(int)quatrillon % 100-1]+ " trillion";
            } else {
                if (quatrillon % 10 == 0){
                    vacia += de20hasta90[(int)quatrillon / 100-1] + " hundred and "+ minusculas2[(int)quatrillon % 100 / 10-1] + " trillion";
                } else {
                    vacia += hasta19[(int)quatrillon / 100-1]+ " hundred and " + minusculas2[(int)quatrillon % 100 / 10-1]+ "-" + minusculas[(int)quatrillon % 10-1]+ " trillion";
                }
            }
        }
        n %= 1_000_000_000_000L;
        if (n == 0){
            return vacia;
        } else if (n <= 99){
            return vacia+" and "+hastaMilMinus((int)n);
        } else if (n <= 999_999){
            return vacia + " "+ hastaMillonMinus((int)n);
        } else if (n <= 999_999_999) {
            return vacia + " " + hastaBillonMinus((int)n);
        } else {
            return vacia + " " + hastaTrillonMinus(n);
        }
    }

    static String hastaQuatrillonMinus(long n){
        String vacia = "";
        long quatrillon = n / 1_000_000_000_000L;
        if (quatrillon <= 19){
            vacia += minusculas[(int)quatrillon-1] + " trillion";
        } else if (quatrillon <= 99){
            if (quatrillon % 10 == 0){
                vacia += minusculas2[(int)quatrillon / 10-1] + " trillion";
            } else {
                vacia += minusculas2[(int)quatrillon / 10-1]+"-"+ minusculas[(int)quatrillon % 10-1]+" trillion";
            }
        } else {
            if (quatrillon % 100 == 0){
                vacia += minusculas[(int)quatrillon / 100-1]+" hundred trillion";
            } else if( quatrillon % 100 <= 19){
                vacia += minusculas[(int)quatrillon / 100-1] + " hundred and "+ minusculas[(int)quatrillon % 100-1]+ " trillion";
            } else {
                if (quatrillon % 10 == 0){
                    vacia += minusculas2[(int)quatrillon / 100-1] + " hundred and "+ minusculas2[(int)quatrillon % 100 / 10-1] + " trillion";
                } else {
                    vacia += minusculas[(int)quatrillon / 100-1]+ " hundred and " + minusculas2[(int)quatrillon % 100 / 10-1]+ "-" + minusculas[(int)quatrillon % 10-1]+ " trillion";
                }
            }
        }
        n %= 1_000_000_000_000L;
        if (n == 0){
            return vacia;
        } else if (n <= 99){
            return vacia+" and "+hastaMilMinus((int)n);
        } else if (n <= 999_999){
            return vacia + " "+ hastaMillonMinus((int)n);
        } else if (n <= 999_999_999) {
            return vacia + " " + hastaBillonMinus((int)n);
        } else {
            return vacia + " " + hastaTrillonMinus(n);
        }
    }


    static String hastaQuintillon(long n){
        String vacia = "";
        long quintillon = n / 1_000_000_000_000_000L;
        if (quintillon <= 19){
            vacia += hasta19[(int)quintillon-1] + " quadrillion";
        } else if (quintillon <= 99){
            if (quintillon % 10 == 0){
                vacia += de20hasta90[(int)quintillon / 10-1] + " quadrillion";
            } else {
                vacia += de20hasta90[(int)quintillon / 10-1]+"-"+minusculas[(int)quintillon % 10-1]+" quadrillion";
            }
        } else {
            if (quintillon % 100 == 0){
                vacia += hasta19[(int)quintillon / 100-1]+" hundred quadrillion";
            } else if( quintillon % 100 <= 19){
                vacia += hasta19[(int)quintillon / 100-1] + " hundred and "+ minusculas[(int)quintillon % 100-1]+ " quadrillion";
            } else {
                if (quintillon % 10 == 0){
                    vacia += de20hasta90[(int)quintillon / 100-1] + " hundred and "+minusculas2[(int)quintillon % 100 / 10-1] + " quadrillion";
                } else {
                    vacia += hasta19[(int)quintillon / 100-1]+ " hundred and " + minusculas2[(int)quintillon % 100 / 10-1]+ "-" + minusculas[(int)quintillon % 10-1]+ " quadrillion";
                }
            }
        }
        n %= 1_000_000_000_000_000L;
        if (n == 0){
            return vacia;
        } else if (n <= 99){
            return vacia+" and "+hastaMilMinus((int)n);
        } else if (n <= 999_999){
            return vacia + " "+ hastaMillonMinus((int)n);
        } else if (n <= 999_999_999){
            return vacia + " " + hastaBillonMinus((int)n);
        } else if (n <= 999_999_999_999L){
            return vacia + " " + hastaTrillonMinus(n);
        } else {
            return vacia + " " + hastaQuatrillonMinus(n);
        }
    }

    static String hastaQuintillonMinus(long n){
        String vacia = "";
        long quintillon = n / 1_000_000_000_000_000L;
        if (quintillon <= 19){
            vacia += minusculas[(int)quintillon-1] + " quadrillion";
        } else if (quintillon <= 99){
            if (quintillon % 10 == 0){
                vacia += minusculas2[(int)quintillon / 10-1] + " quadrillion";
            } else {
                vacia += minusculas2[(int)quintillon / 10-1]+"-"+minusculas[(int)quintillon % 10-1]+" quadrillion";
            }
        } else {
            if (quintillon % 100 == 0){
                vacia += minusculas[(int)quintillon / 100-1]+" hundred quadrillion";
            } else if( quintillon % 100 <= 19){
                vacia += minusculas[(int)quintillon / 100-1] + " hundred and "+ minusculas[(int)quintillon % 100-1]+ " quadrillion";
            } else {
                if (quintillon % 10 == 0){
                    vacia += minusculas2[(int)quintillon / 100-1] + " hundred and "+minusculas2[(int)quintillon % 100 / 10-1] + " quadrillion";
                } else {
                    vacia += minusculas[(int)quintillon / 100-1]+ " hundred and " + minusculas2[(int)quintillon % 100 / 10-1]+ "-" + minusculas[(int)quintillon % 10-1]+ " quadrillion";
                }
            }
        }
        n %= 1_000_000_000_000_000L;
        if (n == 0){
            return vacia;
        } else if (n <= 99){
            return vacia+" and "+hastaMilMinus((int)n);
        } else if (n <= 999_999){
            return vacia + " "+ hastaMillonMinus((int)n);
        } else if (n <= 999_999_999){
            return vacia + " " + hastaBillonMinus((int)n);
        } else if (n <= 999_999_999_999L){
            return vacia + " " + hastaTrillonMinus(n);
        } else {
            return vacia + " " + hastaQuatrillonMinus(n);
        }
    }


    static String Quintillon(long n){
        String vacia = "";
        long quintillon = n / 1_000_000_000_000_000_000L;
        if (quintillon <= 19){
            vacia += hasta19[(int)quintillon-1] + " quintillion";
        } else if (quintillon <= 99){
            if (quintillon % 10 == 0){
                vacia += de20hasta90[(int)quintillon / 10-1] + " quintillion";
            } else {
                vacia += de20hasta90[(int)quintillon / 10-1]+"-"+minusculas[(int)quintillon % 10-1]+" quintillion";
            }
        } else {
            if (quintillon % 100 == 0){
                vacia += hasta19[(int)quintillon / 100-1]+" hundred quintillion";
            } else if( quintillon % 100 <= 19){
                vacia += hasta19[(int)quintillon / 100-1] + " hundred and "+ minusculas[(int)quintillon % 100-1]+ " quintillion";
            } else {
                if (quintillon % 10 == 0){
                    vacia += de20hasta90[(int)quintillon / 100-1] + " hundred and "+minusculas2[(int)quintillon % 100 / 10-1] + " quintillion";
                } else {
                    vacia += hasta19[(int)quintillon / 100-1]+ " hundred and " + minusculas2[(int)quintillon % 100 / 10-1]+ "-" + minusculas[(int)quintillon % 10-1]+ " quintillion";
                }
            }
        }
        n %= 1_000_000_000_000_000_000L;
        if (n == 0){
            return vacia;
        } else if (n <= 99){
            return vacia+" and "+hastaMilMinus((int)n);
        } else if (n <= 999_999){
            return vacia + " "+ hastaMillonMinus((int)n);
        } else if (n <= 999_999_999){
            return vacia + " " + hastaBillonMinus((int)n);
        } else if (n <= 999_999_999_999L){
            return vacia + " " + hastaTrillonMinus(n);
        } else if (n <= 999_999_999_999_999L){
            return vacia + " " + hastaQuatrillonMinus(n);
        } else {
            return vacia + " " + hastaQuintillonMinus(n);
        }
    }



    public static long words(String s) {
        s = s.toLowerCase(); // convierte la String s en minusculas
        String[] words = s.split("[-\\s]"); // quita los guiones y los espacios y lo mete en la lista
        long numeros = 0;
        long index = 0;
        long total = 0;
        for (int i = 0; i < words.length; i++){ //revisa la cadena
            for (int j = 0; j < letras.length; j++){
                if (words[i].equals(letras[j])){ //especifica qué hacer al encontrar la cadena
                    index = Arrays.asList(letras).indexOf(words[i].toString()); // encuentra la posición del elemento
                    if (index <= 20){   // si el indice del elemento es menor que 20, suma numeros al indice
                        numeros += index;
                    } else {
                        switch ((int)index){
                            case 21:
                                numeros += 30;  // Mira el valor que está en esa posición y le suma
                                break;
                            case 22:
                                numeros += 40;
                                break;
                            case 23:
                                numeros += 50;
                                break;
                            case 24:
                                numeros += 60;
                                break;
                            case 25:
                                numeros += 70;
                                break;
                            case 26:
                                numeros += 80;
                                break;
                            case 27:
                                numeros += 90;
                                break;
                            case 28:
                                numeros *= 100;
                                break;
                            case 29:
                                numeros *= 1_000;   // Numeros lo multiplicas por 1000 y le sumas numeros a total(0), luego se ha de reiniciar numeros
                                total += numeros;
                                numeros = 0;
                                break;
                            case 30:
                                numeros *= 1_000_000;
                                total += numeros;
                                numeros = 0;
                                break;
                            case 31:
                                numeros *= 1_000_000_000;
                                total += numeros;
                                numeros = 0;
                                break;
                            case 32:
                                numeros *= 1_000_000_000_000L;
                                total += numeros;
                                numeros = 0;
                                break;
                            case 33:
                                numeros *= 1_000_000_000_000_000L;
                                total += numeros;
                                numeros = 0;
                                break;
                            case 34:
                                numeros *= 1_000_000_000_000_000_000L;
                                total += numeros;
                                numeros = 0;
                                break;
                        }
                    }
                }
            }
        }
        total += numeros;
        return total;
    }
}
import java.util.regex.Pattern;

public class app{
    public static void main(String args[]){
    Cofre cofre = new Cofre();
    String res = "";
        while(true){

            res = Interface.menu();
            if(Pattern.matches("[0-9][.][0-9]{2}", res))
                if(cofre.insertCoin(Double.parseDouble(res)))
                    res = "C";    
            
            switch(res){
                case "A": res = cofre.toString(); break;
                case "B": res = "" + cofre.stealCoin();
                        if(res.equals("-1.0"))
                            res = "O cofre esta vazio.";
                        else
                            res = "A moeda que saiu do cofre é de " + res + " centavo(s)."; 
                break;
                case "C": res = "Moeda inserida."; break;
                default : res = "O valor inserido é invalido.";
            }

        System.out.println("\n" + res);
        }
    }
}
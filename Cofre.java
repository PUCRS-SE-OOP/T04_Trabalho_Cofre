import java.util.Arrays;
import java.lang.Math;

public class Cofre{
    private final int pesoCofre = 603;
    private final int size = 100;
    private int insertCoin = 0;
    private double[] cofre;

        //Costrutor
    public Cofre(){
        cofre = new double[size];
        Arrays.fill(cofre, 0);
    }

        //Inserir moeda
    public boolean insertCoin(Double value){
        if(insertCoin < size){
            cofre[insertCoin] = value;
            insertCoin++;
            return true;
        }
        return false;
    }

        //Tira uma moeda aleatória do cofre
    public double stealCoin(){
        if(insertCoin > 0){
            Arrays.sort(cofre, 0, insertCoin);
            double coin = cofre[insertCoin - 1];
            removeCoin(insertCoin-1);
        return coin;
        }
    return -1;
    }

        //Pega a soma de valores no cofre
    public double somaMoedas(){
        double soma = 0.0;
        for(int i = 0; i < insertCoin; i++)
            soma += (double) cofre[i];        

    return (double) Math.round(soma*100)/100;
    }

        //Retorna quantas moedas estão dentro do cofre
    public int howMany(){
    return insertCoin;
    }

        //Retorna o peso atual do cofre
    public double getWeigth(boolean withSafe){
        double weigth;
        if(withSafe)
            weigth = pesoCofre;
        else weigth = 0.0;    

            for(int i = 0; i < insertCoin; i++)
            if(cofre[i] == 0.01)
                weigth += 2.43;
                else if(cofre[i] == 0.05)
                    weigth += 4.10;
                    else if(cofre[i] == 0.10)
                        weigth += 4.80;
                        else if(cofre[i] == 0.25)
                            weigth += 7.55;
                            else if(cofre[i] == 0.50)
                                weigth += 6.80;
                                else if(cofre[i] == 1.00)
                                    weigth += 7.0;
            
        return (double) Math.round(weigth*100)/100;
    }

    //Procurar moeda por valor específico
    public int coins(double coinValue){
        int count = 0;
        for(int i = 0; i < insertCoin; i ++)
            if(cofre[i] == coinValue)
                count++;
    return count;
    }

        //Retorna a analise completa do cofre
    public String toString(){
        return "O cofre está pesando: " + getWeigth(true) + "g.\n" +
                "O peso em moedas no cofre é de: " + getWeigth(false) +"g.\n" +
                "Há "+ coins(0.01) + " moeda(s) de 01 centavo;\n"+
                "Há "+ coins(0.05) + " moeda(s) de 05 centavos;\n"+
                "Há "+ coins(0.10) + " moeda(s) de 10 centavos;\n"+
                "Há "+ coins(0.25) + " moeda(s) de 25 centavos;\n"+
                "Há "+ coins(0.50) + " moeda(s) de 50 centavos;\n"+
                "Há "+ coins(1.00) + " moeda(s) de 1 Real;\n"+
                "\n Total de: "+ howMany() + " moeda(s) no cofre."+
                "\n Valor total no cofre: " + somaMoedas() +" Reais.";
        }
        
        //Remover moeda
    private void removeCoin(int index){
        cofre[index] = 0;
        insertCoin--;
    }   
}
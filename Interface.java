import java.util.Scanner;
import java.util.regex.Pattern;

public class Interface{

        //Menu principal
    public static String menu(){
        Scanner in = new Scanner(System.in);
    String menuString = "";
    int menuInt = 0;
        System.out.println("\n_______________________\n"+
                            "1 - Inserir moeda;\n"+
                            "2 - Retirar moeda;\n"+
                            "3 - Analisar cofrinho;\n"+
                            "\n9 - Sair.");
        menuString = in.nextLine();

        menuInt = getValue(menuString);

        switch(menuInt){
            case 1: return insert();
            case 2: return "B";
            case 3: return "A";
            case 9: System.exit(0);
            default: return "valor invalido";
        }
    }

        //Menu de escolha de moeda para inserir no cofre
    public static String insert(){
    Scanner in = new Scanner(System.in);
    String menuString = "";
    int menuInt = 0;

        System.out.println("\n_______________________\n"+
                            "Digite o valor da moeda que voce quer inserir.\n"+
                            "1 - 1 centavo;\n"+
                            "2 - 5 centavos;\n"+
                            "3 - 10 centavos;\n"+
                            "4 - 25 centavos;\n"+
                            "5 - 50 centavos;\n"+
                            "6 - 1 Real;\n"+
                            "7 - Voltar.");
        menuString = in.nextLine();

           menuInt = getValue(menuString);

        switch(menuInt){
            case 1: return "0.01";
            case 2: return "0.05";
            case 3: return "0.10";
            case 4: return "0.25";
            case 5: return "0.50";
            case 6: return "1.00";
            case 7: return menu();
            default: return "Não é um valor valido";
        }
    }

        //Scanner (System.in): String -> Inteiro
    private static int getValue(String menuString){
        int menuInt = 0;
        if(menuString.length() == 1)
            if(Pattern.matches("[0-9]", menuString))
                menuInt = Integer.parseInt(menuString);
            else return -1;
        else return -1;
    return menuInt;
    }
}
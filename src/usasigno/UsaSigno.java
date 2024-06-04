
package Usasigno;

import java.util.Calendar;
import java.util.Scanner;

public class UsaSigno {

    
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Calendar hoje = Calendar.getInstance();
        int diaA = hoje.get(Calendar.DATE);
        int mesA = hoje.get(Calendar.MONTH);
        int anoA = hoje.get(Calendar.YEAR);
        //Coletndo e Validando o Nome;
        System.out.println("Digite seu nome: ");
        String nome = ler.nextLine();
        if(nome.length()<=8){
            nome = "Legal se o seu nome fosse verdadeiro";
            
        }
        //Coletando e Validando o Sexo;
        System.out.println("Digite o seu sexo(1-Feminino, 2-Masculino): ");
        int sexo = ler.nextInt();
        if(sexo != 1 && sexo != 2){
            sexo = 2;
        }
        //Coletando e Validando o Dia de Nascimento;
        System.out.println("Digite o dia do seu Nascimento (1-31: ");
        int diaNascimento = ler.nextInt();
        if (diaNascimento<1 || diaNascimento>31){
            System.out.println("Dia do Nascimento inválido ");
            return;
         
        }
        //Coletando e Validando mês do Nascimento;
        System.out.println("Digite o mês do seu Nascimento (1-12): ");
        int mesNascimento = ler.nextInt();
        if (mesNascimento<1 || mesNascimento>12){
            System.out.println("Mês do Nascimento Inválido ");
            return;
        }
        //Coletando e Validando Ano do Nascimento;
        System.out.println("Digite o Ano do seu Nascimento ");
        int anoNascimento = ler.nextInt();
        if(anoNascimento<1900 || anoNascimento>anoA){
            System.out.println("Ano de Nascimento Inválido ");
            return;
        }
        //Verificando validade do dia do Nascimento no mês fornecido;
        if ((mesNascimento == 4 || mesNascimento == 6 || mesNascimento == 9 || mesNascimento == 11)&& diaNascimento>30){
            System.out.println("Erro: O mês "+mesNascimento+ " só tem 30 dias");
            return;
        }else if ((mesNascimento == 2 && (anoNascimento % 4 == 0 && anoNascimento % 100 != 0)||(anoNascimento % 400 == 0))){//Ano Bissexto
            if(diaNascimento >29){
                System.out.println("Erro: Fevereiro em ano Bissexto só tem 29 dias ");
                return;
            }
        }else if(mesNascimento == 2 && diaNascimento>28){
            System.out.println("Erro: Fevereiro só tem 28 dias ");
            return;
        }
        //Verificando se a data de Nascimento é no futuro 
        if(anoNascimento>anoA || (anoNascimento == anoA && mesNascimento > mesA)||(anoNascimento == anoA && mesNascimento == mesA && diaNascimento>diaA)){
            System.out.println("Erro: Data de nascimento no futuro.");
           return;
        //Calculando a idade;
        int idade = anoA - anoNascimento;
        if (mesA < mesNascimento || (mesA == mesNascimento && diaA < diaNascimento)){
            idade--;
        }
        //Determinando os meses de vida
         int mesesDeVida = (anoA-anoNascimento)*12 + (mesA - mesNascimento);
        if(diaA < diaNascimento){
          mesesDeVida--;
        }
        //Determinando o Signo 
        String signo = determinarSigno(anoNascimento, mesNascimento);
        //Sorteando o Número da Sorte;
        int numSorte = (int)(1+Math.random()*99);
        //Saída Personalizada
        if (sexo == 1){
            System.out.println("Sra. " +nome+ " ,nascida no dia " +diaNascimento+ "/" +mesNascimento+ "/" +anoNascimento+ " é do signo de " +signo+ " você tem " +idade+ "anos - seu número da sorte é" +numSorte+ "e sua cor: violeta");
        }else {
            System.out.println("Sr. " +nome+ " ,nascido no dia " +diaNascimento+ "/" +mesNascimento+ "/" +anoNascimento+ " é do signo de "  +signo+ " você tem " +idade+ " anos - seu número da sorte é " +numSorte+ " e sua cor: verde");
        }
        
    }

    public static String determinarSigno(int dia, int mes) {
        if ((dia >= 21 && mes == 3)||(dia<=19 && mes == 4)){
            return "Àries";
        }else if ((dia>=20 && mes == 4 )||(dia<=20 && mes == 5)){
            return"Touro";
        }else if ((dia>=21 && mes == 5)||(dia<=20 && mes == 6)){
            return "Gêmeos";
        }else if((dia>=21 && mes == 6)||(dia<=22 && mes == 7)){
            return "Câncer";
    }else if((dia>=23 && mes == 7)||(dia<=22 && mes == 8)){
        return "Leão";
    }else if ((dia>=23 && mes == 8)||(dia<=22 && mes == 9)){
        return "Virgem";
    }else if ((dia>=23 && mes == 9)||(dia<=22 && mes == 10)){
        return "Libra";
    }else if ((dia>=23 && mes == 10)||(dia<=21 && mes == 11)){
        return "Escorpião";
    }else if ((dia>=22 && mes == 11)||(dia<=21 && mes == 12)){
        return "Sagítario";
    }else if ((dia>=22 && mes == 12)||(dia<=19 && mes == 1)){
        return "Capricórnio";
    }else if((dia>=20 && mes == 1)||(dia<=18 && mes == 2)){
        return "Aquário";
    }else if ((dia>=19 && mes == 2)||(dia<=20 && mes == 3)){
        return "Peixes";
    }
    return "Erro ao Determinar Signo";
    }
}

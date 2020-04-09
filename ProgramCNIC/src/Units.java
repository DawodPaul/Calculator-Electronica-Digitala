import java.util.Scanner;

public class Units {

    public static double SchimbareUnitate()
    {
        double Valoare;
        Scanner scanner=new Scanner(System.in);
        System.out.print("Valoare=");
        Valoare=scanner.nextInt();
        scanner.nextLine();
        int u1,u2;
        System.out.println("|| -12(p) -9(n) -6(μ) -3(mili) -2(centi) -1(deci) -0(base)");
        System.out.println("|| 1(deka) 2(hecto) 3(kilo) 6(Mega) 9(Giga) 12(Tera)");
        System.out.println("Unitate masura initial:");
        u1=scanner.nextInt();
        scanner.nextLine();
        System.out.print("Unitate masura final:");
        u2=scanner.nextInt();
        return Valoare*Math.pow(10,u1-u2);

    }
    public static double SchimbareUnitate(double Valoare,int u1,int u2)
    {

        return Valoare*Math.pow(10,u1-u2);

    }
}

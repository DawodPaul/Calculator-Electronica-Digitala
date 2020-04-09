import java.util.Scanner;

public class Probleme1P {

    public Probleme1P()
    {
        System.out.println("Grija la unitati de masura si numele variabilelor");
    }
    public static void SPP_Speed_Power_Product()
    {
        double ICCL,ICCH,Vcc,tPLH, tPHL,SPP;
        Scanner scanner=new Scanner(System.in);
        System.out.print("ICCL(mA)=");
        ICCL=scanner.nextDouble();
        scanner.nextLine();
        System.out.print("ICCH(mA)=");
        ICCH=scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Vcc(V)=");
        Vcc=scanner.nextDouble();
        scanner.nextLine();
        System.out.print("tPLH(ns)=");
        tPLH=scanner.nextDouble();
        scanner.nextLine();
        System.out.print("tPHL(ns)=");
        tPHL=scanner.nextDouble();
        scanner.nextLine();
        scanner.close();
        SPP=Vcc*(ICCL+ICCH)/2*(tPLH+tPHL)/2;
        System.out.println("SPP=Vcc*(ICCL+ICCH)/2*(tPLH+tPHL)/2");
        System.out.println("SPP="+SPP+" pJ");
    }


    public static void rMaxstareLogicaLow()
    {
        double VILmax,IIL,Rmax;
        Scanner scanner=new Scanner(System.in);
        System.out.print("VILmax(V)=");
        VILmax=scanner.nextDouble();
        scanner.nextLine();
        System.out.print("IIL(mA)=");
        IIL=scanner.nextDouble();
        IIL=Units.SchimbareUnitate(IIL,-3,0);
        scanner.nextLine();
        scanner.close();
        Rmax=VILmax/IIL;
        System.out.println("Rmax="+Rmax+" Ω");

    }

    public static void rMaxstareLogicaHIGH()
    {
        double Vcc,VIHmin,IIH,Rmax;
        Scanner scanner=new Scanner(System.in);
        System.out.print("+Vcc(V)=");
        Vcc=scanner.nextDouble();
        scanner.nextLine();
        System.out.print("VIHmin(V)=");
        VIHmin=scanner.nextDouble();
        scanner.nextLine();
        System.out.print("IIH(μA)=");
        IIH=scanner.nextDouble();
        IIH=Units.SchimbareUnitate(IIH,-6,0);
        scanner.nextLine();
        scanner.close();
        Rmax=(Vcc-VIHmin)/IIH;
        System.out.println("Rmax="+Rmax+" Ω");
    }

    public static void Fan_Out_Low_High()
    {
        double IOL,IOH,IIL,IIH;
        Scanner scanner=new Scanner(System.in);
        System.out.print("IOL(mA)=");
        IOL=scanner.nextDouble();
        scanner.nextLine();
        System.out.print("IOH(mA)=");
        IOH=scanner.nextDouble();
        scanner.nextLine();
        System.out.print("IIL(yA)=");
        IIL=scanner.nextDouble();
        scanner.nextLine();
        System.out.print("IIH(yA)=");
        IIH=scanner.nextDouble();
        scanner.close();
        IOL=Units.SchimbareUnitate(IOL,-3,0);
        IOH=Units.SchimbareUnitate(IOH,-3,0);
        IIL=Units.SchimbareUnitate(IIL,-6,0);
        IIH=Units.SchimbareUnitate(IIH,-6,0);

        System.out.println("FanOut(Low)="+(IOL/IIL));
        System.out.println("FanOut(Low)="+(IOH/IIH));
    }
}

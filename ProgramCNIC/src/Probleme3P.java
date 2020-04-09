import java.util.Random;
import java.util.Scanner;

public class Probleme3P {

    public static void pbLED()
    {
        double Vcc,InrVcc,R,InrR,TensRez,InrTensRez,TLED,ILED,InrLED,ErRelVLed,ErRelILed,ErRelR,ErRelVr;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Sursa/VCC(V)=");
        Vcc=scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Incertitudine Vcc(numar de zecimale+inca un 0 *5, gen VCC=13->0.5, VCC=13.9->0.05(V)=");
        InrVcc=scanner.nextDouble();
        scanner.nextLine();
        System.out.print("R(kΩ)=");
        R=scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Incertitudine R=");
        InrR=scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Tensiune Rez(V)=");
        TensRez=scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Incertitudine Tens Rezist(V)=");
        InrTensRez=scanner.nextDouble();
        scanner.nextLine();
        TLED=Vcc-TensRez;
        System.out.println();
        System.out.println("Tensiunea pe LED este(Vcc-Vr)=Vled="+TLED+"V");
        ILED=TensRez/R;
        InrLED=(InrTensRez+InrVcc) ;
        ErRelVLed=((InrVcc+InrTensRez)/TLED)*100;
        ErRelILed=InrTensRez/TensRez+InrR/R;
        ErRelR=InrR/R*100;
        ErRelVr=InrTensRez/TensRez*100;
        System.out.println("Curentul prin LED (Iled) este egal cu curentul prin rezistenta (Ir). Adica Ir=Vr/R=Iled="+ILED+"mA");
        System.out.println("Incertitudinea asupra tensiunii de alimentare Vcc este δVcc="+InrVcc+" V");
        System.out.println("Incertitudinea asupra tensiunii masurate pe R este δVr="+InrTensRez+"V");
        System.out.println("Incertitudinea asupra Vled este δVled=(δVr+δVcc)="+InrLED+"V");
        System.out.println("Eroarea relativa asupra Vled este εVled=(δVr+δVcc)/Vled*100="+ErRelVLed+"%");
        System.out.println("Eroarea relativa asupra curentului prin LED este εIled="+ErRelILed);
        System.out.println("Eroarea relativa asupra rezistentei R este δR/R. Adica εR="+ErRelR+"%");
        System.out.println("Eroarea relativa asupra rezistentei R este δVr/Vr="+ErRelVr+"%");
        System.out.println("Eroarea relativa asupra curentului prin Led εIled="+(ErRelVr+ErRelR)+"%");
        System.out.println("Incertitudinea asupra curentului prin led:δIled=εIled*Iled ="+(ErRelR+ErRelVr)*ILED/100+"mA");
    }

    public  static void Monostabil()
    {
        double T,InrT,Tproiectat,ErT,C,InrC,ErC,REstim,RAprop,ErR,IncertR;
        Scanner scanner=new Scanner(System.in);
        System.out.print("Durata monostabil(s):");
        T=scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Codensator(yF)=");
        C=scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Incertitudine Codensator(yF)=");
        InrC=scanner.nextDouble();
        scanner.nextLine();
        REstim=T/1.10/C*1000;
        System.out.println("Rez estim="+REstim);
        System.out.print("Rez cea mai apropiata val=");
        RAprop =scanner.nextDouble();
        scanner.nextLine();System.out.print("Incert R=");
        IncertR =scanner.nextDouble();
        scanner.nextLine();
        ErR=IncertR/RAprop;
        ErC=InrC/C;
        ErT=0.004545+ErR+ErC;
        InrT=ErT*T;
        Tproiectat=1.10*RAprop*C;
        System.out.println("T="+T+" iT="+InrT);
        System.out.println("C="+C+" iC="+InrC);
        System.out.println("Rezistenta estimata (T/1.10/C/1e-3) ="+REstim+"kOHM");
        System.out.println("Rezistenta cea mai apropiata este R="+RAprop+"kΩ");
        System.out.println(" εT=ε(1.10)+ε(76.8)+εC="+ErT);
        System.out.println("δT=εT⋅T="+InrT);
        System.out.println("δR="+IncertR+"kΩ");
        System.out.println("εR=δR/R="+ErR+"kΩ");
        System.out.println("Tproiectat=1.10*R*C="+Tproiectat/1000+"s");
    }

    public static void Astabil()
    {
        //TL = Tdesc  TH = Tinc Ttot=TL+TH
        double RA,inRA,ERA,RB,inRB,ERB,C,inC,EC,TL,inTL,ETL,TH,inTH,ETH,TT,inTT,ETT,ERA_RB,ERA_2RB;
        Scanner scanner=new Scanner(System.in);
        System.out.print("RA(kOhm)=");
        RA=scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Er RA(%)=");
        ERA=scanner.nextDouble();
        ERA=ERA/100;
        scanner.nextLine();
        inRA=ERA*RA;


        System.out.print("RB(kOhm)=");
        RB=scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Eroare RB(%)=");
        ERB=scanner.nextDouble();
        ERB=ERB/100;
        scanner.nextLine();
        inRB=ERB*RB;


        System.out.print("C(yF)=");
        C=scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Eroare C(yF)=");
        EC=scanner.nextDouble();
        EC=EC/100;
        scanner.nextLine();
        inC=EC*C;
        TL=RB*C*0.693;//ln(2)
        ETL=0.0005/0.693+ERB+EC;
        inTL=ETL*TL;

        System.out.println("RA="+RA+" RB="+RB+" C="+C);
        System.out.println("εRA="+ERA+" εRB="+ERB+" εC="+EC);
        System.out.println("=================================");
        System.out.println("εTDesc=ε(0.693)+εRB+εC="+ETL);
        System.out.println("TL=RB⋅C⋅ln(2)=0.693⋅RB⋅C="+TL);
        System.out.println("inTL="+inTL);
        System.out.println();
        System.out.println("TL="+TL+"+/-"+inTL+"ms");
        System.out.println("=================================");
        ERA_RB=(inRA+inRB)/(RA+RB);
        ETH=0.0005/0.693+ERA_RB+EC;
        TH=(RA+RB)*C*0.693;
        inTH=ETH*TH;
        System.out.println("εRA_RB=(εRA*RA+εRB*RB)/(RA+RB)="+ERA_RB);
        System.out.println("εTH=ε(0.693)+ε(RA+RB)+εC="+ETH);
        System.out.println("TH=(RA+RB)⋅C⋅ln(2)=0.693⋅(RA+RB)⋅C="+TH);
        System.out.println("inTH="+inTH);
        System.out.println("TH="+TH+"+/-"+inTH+"ms");
        System.out.println("=====================================");
        TT=(RA+2*RB)*C*0.693;
        ERA_2RB=(inRA+2*inRB)/(RA+2*RB);
        ETT=0.0005/0.693+ERA_2RB+EC;
        inTT=ETT*TT;
        System.out.println("T=TDesc+TInc=TL+TH=(RA+2RB)⋅C⋅ln(2)=0.693⋅(RA+2RB)⋅C="+TT);
        System.out.println("εRA_2RB=(εRA*RA+εRB⋅2⋅RB)/(RA+2RB)="+ERA_2RB);
        System.out.println("εT=ε(0.693)+εRA_2RB+εC="+ETT);
        System.out.println("δT=εT⋅T="+inTT);
        System.out.println("Tt="+TT+"+/-"+inTT+"ms");
    }


}

package triangle;

public class Triangle {

    final int TR_EQUILATERAL = 1; // ðàâíîñòîðîííèé
    final int TR_ISOSCELES = 2;   // ðàâíîáåäðåííûé
    final int TR_ORDYNARY = 4;    // îáû÷íûé
    final int TR_RECTANGULAR = 8; // ïðÿìîóãîëüíûé


    private double a;
    private double b;
    private double c;

    private String message;

    public Triangle(double a, double b, double c)
    {
        this.a=a;
        this.b=b;
        this.c=c;
        this.message = "";
    }

    public String getMessage()
    {
        return this.message;
    }

    public boolean checkTriangle()
    {
        if (a<=0)
        {
            this.message = "a<=0";
            return false;
        }

        if (b<=0)
        {
            this.message = "b<=0";
            return false;
        }

        if (b<=0)
        {
            this.message = "c<=0";
            return false;
        }

        if (a+b<=c)
        {
            this.message = "a+b<=c";
            return false;
        }

        if (a+c<=b)
        {
            this.message = "a+c<=b";
            return false;
        }

        if (b+c<=a)
        {
            this.message = "b+c<=a";
            return false;
        }

        return true;
    }

    public int detectTriangle()
    {
        int final_state = 0;


        if ((a*a+b*b == c*c) || (b*b + c*c == a*a)||(a*a + c*c == b*c))
        {
            final_state = final_state|TR_RECTANGULAR; // ïðÿìîóãîëüíûé
        }


        if (a==b && b==c && a==c)
        {
            final_state = final_state|TR_EQUILATERAL; // ðàâíîñòîðîííèé
        }

        if (a==b || b==c || a==c)
        {
            final_state = final_state|TR_ISOSCELES; // ðàâíîáåäðåííûé
        }

        if (final_state == 0)
        {
            return TR_ORDYNARY; // îáû÷íûé
        }
        else
        {
            return final_state; // êîìáèíàöèÿ ïðèçíàêîâ
        }
    }


    public double getSquare()
    {
        double p;

        p = (a+b+c)/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }

}

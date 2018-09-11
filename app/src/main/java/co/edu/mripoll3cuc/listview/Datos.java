package co.edu.mripoll3cuc.listview;

import java.util.ArrayList;

public class Datos
{

    private static ArrayList <Operaciones> operaciones = new ArrayList<>();

    public static void calcular(Operaciones o)
    {
        operaciones.add(o);
    }

    public static ArrayList<Operaciones> obtener()
    {
        return operaciones;
    }
}

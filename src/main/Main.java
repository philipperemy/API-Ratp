package main;

import constants.Constants.Line;
import constants.Constants.Station;
import constants.Constants.Type;
import codec.objects.Query;

public class Main
{
    /*
     * Main class to launch the application
     */
    public static void main(String[] args) throws Exception
    {
        while (true)
        {
            new Task(Query.createQuery(Type.RER, Line.LINE_B, Station.ARCUEIL_CACHAN, Station.CHARLES_DE_GAULLE_2)).run();
            Thread.sleep(2000);
        }
    }
}

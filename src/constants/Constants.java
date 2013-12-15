package constants;

public class Constants
{

    public enum Type
    {
        RER, METRO
    }

    public enum Station
    {
        HOTEL_DE_VILLE("hotel de Ville"),
        CHATEAU_DE_VINCENNES("Château de Vincennes"),
        CHARLES_DE_GAULLE_MITRY_CLAYE("Charles-de-Gaulle Mitry-Claye"),
        CHARLES_DE_GAULLE_2("Aeroport Ch.De Gaulle 2"),
        MITRY_CLAYE("Mitry-Claye"),
        ARCUEIL_CACHAN("arcueil cachan");

        private String station;

        private Station(String station)
        {
            this.station = station;
        }

        public String getStation()
        {
            return station;
        }

        public static Station fromString(String text)
        {
            if (text != null)
            {
                for (Station b : Station.values())
                {
                    if (text.equalsIgnoreCase(b.getStation()))
                    {
                        return b;
                    }
                }
            }
            return null;
        }
    }

    public enum Line
    {
        LINE_1("1"), LINE_B("b");

        private String line;

        private Line(String line)
        {
            this.line = line;
        }

        public String getLine()
        {
            return line;
        }

        public static Line fromString(String text)
        {
            if (text != null)
            {
                for (Line b : Line.values())
                {
                    if (text.equalsIgnoreCase(b.getLine()))
                    {
                        return b;
                    }
                }
            }
            return null;
        }
    }

    public enum Id
    {
        EFLA("EFLA"), ICAR("ICAR"), EKLI("EKLI");

        private String id;

        private Id(String id)
        {
            this.id = id;
        }

        public String getId()
        {
            return id;
        }

        public static Id fromString(String text)
        {
            if (text != null)
            {
                for (Id b : Id.values())
                {
                    if (text.equalsIgnoreCase(b.getId()))
                    {
                        return b;
                    }
                }
            }
            return null;
        }
    }
}

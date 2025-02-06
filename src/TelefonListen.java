import java.util.HashMap;
import java.util.Map;

public class TelefonListen
{
    private Map<String, String> telefonbog;

    public TelefonListen()
    {
        this.telefonbog = new HashMap<>();
    }

    public TelefonListen(Map<String, String> eksisterendeData)
    {
        this.telefonbog = eksisterendeData;
    }

    public Map<String, String> getTelefonbog()
    {
        return telefonbog;
    }

    public void tilfoejKontakt(String navn, String telefonnummer)
    {
        telefonbog.put(navn, telefonnummer);
    }

    public String hentTelefonnummer(String navn)
    {
        return telefonbog.get(navn);
    }

    public void sletKontakt(String navn)
    {
        telefonbog.remove(navn);
    }

    public void udskrivKunNavne()
    {
        for (String navn : telefonbog.keySet())
        {
            System.out.println(navn);
        }
    }

    public String toString()
    {
        if (telefonbog.isEmpty())
        {
            return "Telefonlisten er tom.";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Telefonliste:\n");
        sb.append("-----------------\n");

        for (Map.Entry<String, String> entry : telefonbog.entrySet())
        {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }
}

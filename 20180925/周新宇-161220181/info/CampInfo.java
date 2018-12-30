package info;

public class CampInfo {
    private Camp camp = Camp.NE;
    private int familyRank = -1;

    public CampInfo(){}
    public CampInfo(Camp c,int fr)
    {
        camp = c;
        familyRank = fr;
    }
    public int GetFamilyRank()
    {
        return familyRank;
    }
    public Camp GetCamp()
    {
        return camp;
    }
}

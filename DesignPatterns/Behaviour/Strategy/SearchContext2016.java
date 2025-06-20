package Behaviour.Strategy;

public class SearchContext2016 implements SearchContext {
    public final String query;
    public final String userInfo;

    public SearchContext2016(String query, String userInfo) {
        this.query = query;
        this.userInfo = userInfo;
    }

    public String getQuery() {
        return query;
    }

    public String getUserInfo() {
        return userInfo;
    }
}

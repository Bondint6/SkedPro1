package pro.sked.skedpro;

/**
 * Created by Bondint on 25.10.2016.
 */
public class InitRetrofit {
    private static InitRetrofit ourInstance = new InitRetrofit();

    public static InitRetrofit getInstance() {
        return ourInstance;
    }

    private InitRetrofit() {
    }
}

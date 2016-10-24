package pro.sked.skedpro;

/**
 * Created by Bondint on 24.10.2016.
 */

public class jsItemLst {

    String user_name, items, created_at;
    int id, counts;

    public jsItemLst(Integer id, String user_name, String items, Integer counts,  String created_at){
        super();
        this.id = id;
        this.user_name = user_name;
        this.items = items;
        this.counts = counts;
        this.created_at = created_at;
    }

    public Integer getId() {
        return id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getItems() {
        return items;
    }
    public Integer getCounts() {
        return counts;
    }
    public String getCreated_at() {
        return created_at;
    }

}

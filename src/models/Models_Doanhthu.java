package models;

public class Models_Doanhthu {
    private int id;
    private String tenkh;
    private String sdtkh;
    private int tongchi;

    public Models_Doanhthu(int id, String tenkh, String sdtkh, int tongchi) {
        this.id = id;
        this.tenkh = tenkh;
        this.sdtkh = sdtkh;
        this.tongchi = tongchi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public String getSdtkh() {
        return sdtkh;
    }

    public void setSdtkh(String sdtkh) {
        this.sdtkh = sdtkh;
    }

    public int getTongchi() {
        return tongchi;
    }

    public void setTongchi(int tongchi) {
        this.tongchi = tongchi;
    }

    @Override
    public String toString() {
        return "Models_Doanhthu{" +
                "id=" + id +
                ", tenkh='" + tenkh + '\'' +
                ", sdtkh='" + sdtkh + '\'' +
                ", tongchi=" + tongchi +
                '}';
    }
}


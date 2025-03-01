package views;

import javax.swing.JPanel;
import java.awt.CardLayout;

import pages.Chon_Monan;
import pages.Chon_Nuocuong;
import pages.QL_monan; // Import lớp QL_monan

public class Food_choice extends JPanel {
    private CardLayout cardLayout;

    public Food_choice(QL_monan ql_monan) {
        cardLayout = new CardLayout();
        setLayout(cardLayout);

        Chon_Monan chonMonan = new Chon_Monan(ql_monan);
        Chon_Nuocuong chonNuocUong = new Chon_Nuocuong(ql_monan);

        add(chonMonan, "Monan");
        add(chonNuocUong, "Nuocuong");
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }
}

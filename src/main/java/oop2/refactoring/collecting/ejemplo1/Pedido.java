package oop2.refactoring.collecting.ejemplo1;

import java.util.List;

public class Pedido {

    private List<ItemMenu> items;

    public Pedido(ItemMenu... items) {
        this.items = List.of(items);
    }

    public float totalBebidas() {
        float total = 0;
        for (ItemMenu itemMenu : items) {
            if (itemMenu instanceof Bebida) {
                total += itemMenu.precio();
            }
        }
        return total;
    }

    public float totalPlatos() {
        float total = 0;
        for (ItemMenu itemMenu : items) {
            if (itemMenu instanceof Plato) {
                total += itemMenu.precio();
            }
        }
        return total;
    }
}

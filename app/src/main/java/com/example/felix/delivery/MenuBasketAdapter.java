package com.example.felix.delivery;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.felix.delivery.Qther.Product;

import java.util.List;

/**
 * Created by rares on 05.06.2017.
 */

class MenuBasketAdapter extends RecyclerView.Adapter<MenuBasketAdapter.ViewHolder> {
    /** Список для хранения данных элементов RecyclerView */
    private final List<Product> items;

    /**
     * Инициализирует адаптер
     * @param addedFoodList Список товаров {@link Product}, на основе которых инициализируется адаптер
     */
    public MenuBasketAdapter(List<Product> addedFoodList) {
        this.items = addedFoodList;
    }

    /**
     * Создание нового элемента списка и его объекта ViewHolder.
     *
     * <p>
     * Компонент RecyclerView вызывает метод onCreateViewHolder
     * своего объекта RecyclerView.Adapter для
     * заполнения макета каждого элемента RecyclerView
     * и упаковки (сохранения) его в объект субкласса RecyclerView.ViewHolder с именем ViewHolder.
     * Новый объект ViewHolder возвращается RecyclerView для отображения.
     * </p>
     *
     * @param parent Объект субкласса {@link RecyclerView.ViewHolder} с представлениями View,
     *               в которых будут отображаться данные.
     * @param viewType Значение int, представляющее позицию элемента в списке {@link RecyclerView}.
     * @return Объект, отображающий данные в виде GUI-элемента списка.
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Заполнение макета list_item
        View view = LayoutInflater.from( parent.getContext() ).inflate(R.layout.row_s_basket_item, parent, false);

        // Создание ViewHolder для текущего элемента
        return (new ViewHolder(view));
    }

    /**
     * RecyclerView вызывает этот метод для отображения данных в элемете списка в указанной позиции.
     * Этот метод должен обновлять содержимое itemView (своей View'хи, которая-то и отображается в
     * списке), чтобы отразить элемент в данной позиции.
     * @param holder ViewHolder, который должен быть обновлен для представления контента элемента
     *               в данной позиции в наборе данных.
     * @param position Позиция элемента в списке элементов (наборе данных) адаптера.
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Получение объекта FoodItem для заданной позиции ListView
        Product product = items.get(position);

        // Присвоении ID к View на основании его порядкого номера в списке
        holder.itemView.setTag(position);

        // Назначения текста элементам GUI
        holder.nameTextView.setText(product.getName());
        holder.descriptionTextView.setText(product.getDom());
        holder.priceTextView.setText( String.valueOf(product.getPrise()) + " \u20BD" );

        //holder.itemView.findViewById(R.id.Image_l).setBit = holder.image;
        //holder.image. = product.getImage()
    }

    /**
     * Обязательный для переопределеия метод
     * @return Длина списка {@link #items}
     */
    @Override
    public int getItemCount() {
        return items.size();
    }

    /**
     * ViewHolder для элементов View'шек элементов {@link Product}
     * @author RareScrap
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        /** Ссылка на элемент GUI, представляющий название блюда */
        public final TextView nameTextView;
        /** Ссылка на элемент GUI, представляющий состав блюда */
        public final TextView descriptionTextView;
        /** Ссылка на элемент GUI, представляющий цену блюда */
        public final TextView priceTextView;

        public final View image;

        /**
         * Конструктор, инициализирующий свои поля.
         * @param itemView Представление одного элемента списка
         */
        public ViewHolder(View itemView) {
            super(itemView);

            // Получение ссылок на элементы GUI в представлении
            nameTextView = (TextView) itemView.findViewById(R.id.Text_name);
            descriptionTextView = (TextView) itemView.findViewById(R.id.Text_description);
            priceTextView = (TextView) itemView.findViewById(R.id.Text_price);

            image = itemView.findViewById(R.id.Image_l);

        }
    }
}

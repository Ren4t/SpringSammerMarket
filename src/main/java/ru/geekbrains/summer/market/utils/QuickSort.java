package ru.geekbrains.summer.market.utils;

import org.springframework.stereotype.Component;
import ru.geekbrains.summer.market.model.Product;

import java.util.List;

@Component
public class QuickSort {

    public void quickSort(List<Product> array){
        quickSort(array,0,array.size()-1);
    }

        private void quickSort(List<Product> array, int low, int high) {
            if (array.size() == 0)
                return;//завершить выполнение если длина массива равна 0

            if (low >= high)
                return;//завершить выполнение если уже нечего делить

            // выбрать опорный элемент
            int middle = low + (high - low) / 2;
            int opora = array.get(middle).getPrice();

            // разделить на подмассивы, который больше и меньше опорного элемента
            int i = low, j = high;
            while (i <= j) {
                while (array.get(i).getPrice() < opora) {
                    i++;
                }

                while (array.get(j).getPrice() > opora) {
                    j--;
                }

                if (i <= j) {//меняем местами
                    Product product = array.get(i);
                    array.set(i,array.get(j));
                    array.set(j,product);
                    i++;
                    j--;
                }
            }

            // вызов рекурсии для сортировки левой и правой части
            if (low < j)
                quickSort(array, low, j);

            if (high > i)
                quickSort(array, i, high);
        }
    }

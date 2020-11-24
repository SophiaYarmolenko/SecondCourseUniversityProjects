package com.company;

import java.util.List;

//Який принцип S.O.L.I.D. порушено? Виправте!
//Порушено принцип єдиного обов'язку
class Item
{

}
class ItemList
{
   private List<Item> itemList;
   List<Item> getItemList() {
      return itemList;
   }

   void setItemList(List<Item> itemList) {
      this.itemList = itemList;
   }

   public void getItems() {/*...*/}


   public void addItem(Item item) {/*...*/}

   public void deleteItem(Item item) {/*...*/}

   public void delete() {/*...*/}

   public void getItemCount() {/*...*/}
}
class Order
 {

    public void showOrder(ItemList itemList) {/*...*/}
    public void update(ItemList itemList) {/*...*/}
}
class ListRepository
{
   public void load(ItemList itemList) {/*...*/}
   public void save(ItemList itemList) {/*...*/}
}
class PrintManager
{
   public void printOrder(ItemList itemList) {/*...*/}
}
class Calculator
{
   public void calculateTotalSum(ItemList itemList) {/*...*/}
}
public class SOLID1 {
}
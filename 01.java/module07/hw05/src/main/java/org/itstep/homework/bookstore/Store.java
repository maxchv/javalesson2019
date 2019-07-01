package org.itstep.homework.bookstore;

/************************************************************************
 *  Интерфейс магазина.
 *************************************************************************/
public interface Store {
    // регистрация клиента
    void register(Customer customer);
    // удаление клиента
    void remove(Customer customer);
    // получить клиента по id
    Customer getCustomer(int id);
}

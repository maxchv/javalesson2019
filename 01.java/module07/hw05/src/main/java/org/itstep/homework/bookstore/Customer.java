package org.itstep.homework.bookstore;

/*************************************************************************
 *  Интерфейс покупателя	    					 *
 ************************************************************************/
public interface Customer extends Person {
    // id клиента
    int getID();
    // кредит клиента
    Credit getCredit();
    // задание пароля
    void setPassword(String passwd);
}

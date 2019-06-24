package org.itstep.homework.bookstore;

/*************************************************************************
 *  Интерфейс адреса			                                 *
 ************************************************************************/
interface Address {
    String getStreetName();
    int getStreetNumber();
    String getCity();
    String getState();
    String getZipCode();
    String toString();
    boolean equals(Address addr);
}

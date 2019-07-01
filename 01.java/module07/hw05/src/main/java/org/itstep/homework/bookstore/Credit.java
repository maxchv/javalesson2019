package org.itstep.homework.bookstore;

/************************************************************************
 *  Абстрактный класс кредита                                           *
 ***********************************************************************/
public abstract class Credit {
    final public static int MAX_AMOUNT = 1000;
    protected int debit;

    //текущий дебет
    public abstract int getDebit();

    // обновить дебет, проверить, что он не превышает лимит
    protected abstract void addDebit(int amount);
}

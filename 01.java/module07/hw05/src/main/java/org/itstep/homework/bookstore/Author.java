package org.itstep.homework.bookstore;

/*************************************************************************
 *  Интерфейс автора		    					 *
 ************************************************************************/
public interface Author extends Person {
    // Книги написанные этим автором
    Book[] getAllWrittenBook();
}

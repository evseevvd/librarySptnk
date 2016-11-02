package co.sptnk.service.test;

import co.sptnk.service.api.dto.criteria.SearchCriteriaBook;
import co.sptnk.service.impl.persistence.model.Book;
import co.sptnk.service.impl.repository.book.BookRepository;
import co.sptnk.service.impl.repository.book.BookRepositoryImpl;
import co.sptnk.service.test.utils.ObjectGenerator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by evseevvd on 02.11.16.
 *
 * Тест для сервиса
 */
@RunWith(MockitoJUnitRunner.class)
public class LibraryServiceTest {

    @Spy
    private EntityManager entityManager = Persistence.createEntityManagerFactory("LibTestPU").createEntityManager();

    @Spy
    @InjectMocks
    private BookRepository repository = new BookRepositoryImpl();

    @Before
    public void beforeEachTest() {
        entityManager.getTransaction().begin();
    }

    /**
     * Тест проверит создание сущности Книга
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    @Test
    public void addBookServiceTest() throws InstantiationException, IllegalAccessException {
        Book book = repository.create(ObjectGenerator.generatedBook());
        flushAndClear();

        Book readBook = repository.read(book.getId());

        Assert.assertEquals("ИД сущностей не совпали!!!", book.getId(), readBook.getId());
    }

    /**
     * Проверит удаление сущности.
     */
    @Test
    public void rmBookServiceTest() {
        Book book = repository.create(ObjectGenerator.generatedBook());
        Assert.assertNotNull("Книга не сохпранилась", book);
        repository.remove(book);
        flushAndClear();

        Book readBook = repository.read(book.getId());

        Assert.assertNull(readBook);
    }

    @Test
    public void searchBookServiceTest(){
        repository.create(ObjectGenerator.generatedBook());
        repository.create(ObjectGenerator.generatedBook());
        repository.create(ObjectGenerator.generatedBook());

        flushAndClear();

        SearchCriteriaBook searchCriteriaBook = new SearchCriteriaBook();
        searchCriteriaBook.setName("Book 1");
        List<Book> books = repository.searchByCriteria(searchCriteriaBook);

        Assert.assertEquals("", books.size(), 3);
    }

    private void flushAndClear() {
        entityManager.flush();
        entityManager.clear();
    }

}

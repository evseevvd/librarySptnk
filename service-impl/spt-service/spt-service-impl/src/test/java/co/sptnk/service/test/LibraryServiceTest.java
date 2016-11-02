package co.sptnk.service.test;

import co.sptnk.service.api.LibraryService;
import co.sptnk.service.api.dto.response.AddOrUpdateResponse;
import co.sptnk.service.impl.LibraryServiceImpl;
import co.sptnk.service.impl.mapper.book.BookDtoToEntity;
import co.sptnk.service.impl.mapper.book.BookEntityToDto;
import co.sptnk.service.impl.mapper.book.BookMapping;
import co.sptnk.service.impl.mapper.book.BookMappingImpl;
import co.sptnk.service.test.utils.ObjectGenerator;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

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
    private BookMapping mapping = new BookMappingImpl();

    @Mock
    private BookDtoToEntity bookDtoToEntity = new BookDtoToEntity();

    @Mock
    private BookEntityToDto bookEntityToDto = new BookEntityToDto();

    @Spy
    @InjectMocks
    private LibraryService libraryService = new LibraryServiceImpl();


    @Test
    public void addBookServiceTest() throws InstantiationException, IllegalAccessException {
        AddOrUpdateResponse addOrUpdateResponse = libraryService.addOrUpdateBook(ObjectGenerator.generatedBookDto());
    }

}

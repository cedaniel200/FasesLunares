package com.cedaniel200.android.faseslunares.main;

import com.cedaniel200.android.faseslunares.BaseTest;

import org.junit.Test;
import org.mockito.Mock;

import java.util.Calendar;

import static org.mockito.Mockito.verify;

/**
 * Created by cedaniel200 on 15/07/2016.
 */
public class MainInteractorImplTest extends BaseTest {

    @Mock
    private MainRepository repository;

    private MainInteractorImpl interactor;

    @Override
    public void setup() throws Exception {
        super.setup();
        interactor = new MainInteractorImpl(repository);
    }

    @Test
    public void testExecute() throws Exception {
        Calendar fecha = Calendar.getInstance();
        interactor.execute(fecha);

        verify(repository).calcularFaseLunar(fecha);
    }
}

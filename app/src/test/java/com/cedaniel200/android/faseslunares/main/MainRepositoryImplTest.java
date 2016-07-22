package com.cedaniel200.android.faseslunares.main;

import com.cedaniel200.android.faseslunares.BaseTest;
import com.cedaniel200.android.faseslunares.lib.Tools;
import com.cedaniel200.android.faseslunares.lib.base.EventBus;

import org.junit.Test;
import org.mockito.Mock;

import java.util.Calendar;

import static org.mockito.Mockito.verify;

/**
 * Created by cedaniel200 on 15/07/2016.
 */
public class MainRepositoryImplTest extends BaseTest {

    @Mock
    private EventBus eventBus;
    @Mock
    private Tools tools;

    private MainRepositoryImpl repository;

    @Override
    public void setup() throws Exception {
        super.setup();
        repository = new MainRepositoryImpl(eventBus, tools);
    }

    @Test
    public void testCalcularFaseLunar() throws Exception {
        Calendar fecha = Calendar.getInstance();
        repository.calcularFaseLunar(fecha);
        verify(tools).obtenerFaseLunar(fecha);
    }

}

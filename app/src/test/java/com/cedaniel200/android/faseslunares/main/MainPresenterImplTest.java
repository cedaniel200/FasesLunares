package com.cedaniel200.android.faseslunares.main;

import com.cedaniel200.android.faseslunares.BaseTest;
import com.cedaniel200.android.faseslunares.entities.FaseLunar;
import com.cedaniel200.android.faseslunares.lib.base.EventBus;
import com.cedaniel200.android.faseslunares.main.events.MainEvent;
import com.cedaniel200.android.faseslunares.main.ui.MainView;

import org.junit.Test;
import org.mockito.Mock;

import java.util.Calendar;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by cedaniel200 on 15/07/2016.
 */
public class MainPresenterImplTest extends BaseTest {

    @Mock
    private EventBus eventBus;
    @Mock
    private FaseLunar faseLunar;
    @Mock
    private MainEvent event;
    @Mock
    private MainView view;
    @Mock
    private MainInteractor mainInteractor;

    private MainPresenterImpl presenter;

    @Override
    public void setup() throws Exception {
        super.setup();
        presenter = new MainPresenterImpl(view, eventBus, mainInteractor);
    }

    @Test
    public void testOnCreate_subscribedToEventBus() throws Exception{
        presenter.onCreate();
        verify(eventBus).register(presenter);
    }

    @Test
    public void testOnDestroy_UnsubscribedToEventBus() throws Exception{
        presenter.onDestroy();
        verify(eventBus).unregister(presenter);
        assertNull(presenter.getView());
    }

    @Test
    public void testCalcularFaseLunar() throws Exception {
        Calendar fecha = Calendar.getInstance();
        presenter.calcularFaseLunar(fecha);
        verify(mainInteractor).execute(fecha);
    }

    @Test
    public void testEventoObtenerFaseLunar() throws Exception {

        when(event.getType()).thenReturn(MainEvent.OBTENER_FASE_LUNAR);
        when(event.getFaseLunar()).thenReturn(faseLunar);

        presenter.onEventMainThread(event);
        verify(view).cambiarFaseLunar(event.getFaseLunar());
        verify(view).actualizarVista();
        assertNotNull(presenter.getView());
    }

    @Test
    public void testEventoConError() throws Exception {
        String error = "error";

        when(event.getError()).thenReturn(error);
        presenter.onEventMainThread(event);

        assertNotNull(presenter.getView());
        verify(view).error(error);
    }

}

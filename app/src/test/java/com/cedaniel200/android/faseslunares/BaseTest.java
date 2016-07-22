package com.cedaniel200.android.faseslunares;

import org.junit.Before;
import org.mockito.MockitoAnnotations;

/**
 * Created by cedaniel200 on 15/07/2016.
 */
public abstract class BaseTest {

    @Before
    public void setup() throws Exception{
        MockitoAnnotations.initMocks(this);
    }
}